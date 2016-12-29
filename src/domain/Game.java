/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Characters.*;
import domain.Map.*;
import domain.Tower.TowerCannon;
import static helpers.Artist.*;

/**
 *
 * @author Home
 */
public class Game {
    
    private Map Map;
    private Player Player;
    private WaveManager WaveManager;
    
    //Temp Variables
    TowerCannon Tower;
    
    public Game(int[][] Map) {
        this.Map = new Map(Map);
        this.Player = new Player(this.Map);
        this.WaveManager = new WaveManager(new Enemy(QuickLoad("ufo64"), this.Map.GetTile(14, 8), this.Map, 64, 64, 70), 2, 2);
        this.Tower = new TowerCannon(QuickLoad("cannonBase"), this.Map.GetTile(14, 7), 10);
    }
    
    public void Update() {
        Map.Draw();        
        WaveManager.Update();
        Player.Update();
        
        Tower.Update();
    }
}
