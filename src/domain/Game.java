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
    public static final int TILE_SIZE = 64;
        
    public Game(int[][] Map) {
        this.Map = new Map(Map);
        this.WaveManager = new WaveManager(new Enemy(QuickLoad("ufo64"), this.Map.GetTile(14, 8), this.Map, 64, 64, 70), 2, 2);
        this.Player = new Player(this.Map, WaveManager);
        
    }
    
    public void Update() {
        Map.Draw();        
        WaveManager.Update();
        Player.Update();
    }
}
