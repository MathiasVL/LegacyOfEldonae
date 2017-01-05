/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import domain.Map.*;
import domain.Tower.TowerCannon;
import org.lwjgl.input.Mouse;

import static helpers.Artist.*;
import helpers.Clock;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
/**
 *
 * @author mathi
 */
public class Player {
    
    private Map map;
    private TileType[] types;
    private int index;
    private WaveManager waveManager;
    private ArrayList<TowerCannon> towerList;
    private boolean leftMouseButtonDown;
    
    public Player(Map map, WaveManager waveManager) {
        this.map = map;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
        this.waveManager = waveManager;
        this.towerList = new ArrayList<TowerCannon>();
        this.leftMouseButtonDown = false;
    }  
        
    public void update() {
        
        for(TowerCannon t : towerList){
            t.update();
            t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
        }
        
        //Handle Mouse Input
        if(Mouse.isButtonDown(0) && !leftMouseButtonDown){            
            towerList.add(new TowerCannon(quickLoad("cannonBase"), map.getTile((Mouse.getX() / TILE_SIZE), (((HEIGHT - Mouse.getY() - 1 )) / TILE_SIZE) - 1), 10, 1000, waveManager.getCurrentWave().getEnemyList()));
            //SetTile();
        }
        
        leftMouseButtonDown = Mouse.isButtonDown(0);
        
        //Handle Keyboard Input
        while(Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
                //MoveIndex();
                Clock.changeMultiplier(0.2f);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()){
                //MoveIndex();
                Clock.changeMultiplier(-0.2f);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
                towerList.add(new TowerCannon(quickLoad("cannonBase"), map.getTile(18, 9), 10, 1000, waveManager.getCurrentWave().getEnemyList()));
            }
                
        }
    }
    
    private void moveIndex()
    {
        index++;
        if(index > types.length -1)
        {
            index = 0;
        }
    }
}
