/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Characters.*;
import domain.Map.*;
import domain.Towers.TowerCannon;
import domain.Towers.TowerCannonBlue;
import domain.Towers.TowerType;
import static helpers.Artist.*;
import static helpers.Artist.drawQuadTex;
import helpers.StateManager;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import ui.UI;
import ui.UI.Menu;

/**
 *
 * @author Home
 */
public class Game {
    
    private Map map;
    private Player player;
    private WaveManager waveManager;
    private UI gameUI;
    private Menu towerPickerMenu;
    private Texture menuBackground;
    private Enemy[] enemyTypes;
    
    public Game(Map map) {
        this.map = map;
        this.enemyTypes = new Enemy[2];
        this.enemyTypes[0] = new EnemyAlien(2, 1, map);
        this.enemyTypes[1] = new EnemyUFO(2, 1, map);
        this.waveManager = new WaveManager(enemyTypes, 3, 3);
        this.player = new Player(this.map, waveManager);
        this.player.setup();
        this.menuBackground = quickLoad("menuBackground2");
        setupUI();
    }
    
    private void setupUI(){
        this.gameUI = new UI();
        gameUI.createMenu("TowerPicker", TILE_SIZE * map.getTilesWide(), 100, TILE_SIZE * 3, TILE_SIZE * map.getTilesHigh(), 2, 0);
        towerPickerMenu = gameUI.getMenu("TowerPicker");
        towerPickerMenu.quickAdd("CannonBlue", "cannonBlueGun");
        towerPickerMenu.quickAdd("CannonRed", "cannonGun");
    }
    
    private void updateUI(){
        gameUI.draw();
        gameUI.drawString(1310, 400, "Lives " + Player.lives);
        gameUI.drawString(1310, 440, "Cash " + Player.cash);
        gameUI.drawString(1310, 360, "Wave " + waveManager.getWaveNumber());
        gameUI.drawString(0, 0, StateManager.framesInLastSecond + " fps");
        
        if(Mouse.next()){
            boolean mouseClicked = Mouse.isButtonDown(0);
            if(mouseClicked){
                if(towerPickerMenu.isButtonClicked("CannonBlue"))
                    player.pickTower(new TowerCannonBlue(TowerType.CannonBlue, map.getTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
                if(towerPickerMenu.isButtonClicked("CannonRed"))
                    player.pickTower(new TowerCannon(TowerType.CannonRed, map.getTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
            }
        }
    }
    
    public void update() {
        drawQuadTex(menuBackground, TILE_SIZE*map.getTilesWide(), 0, TILE_SIZE*3, TILE_SIZE*map.getTilesHigh());
        map.draw();  
        waveManager.update();
        player.update();
        updateUI();
    }
}
