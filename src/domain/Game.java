/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Characters.*;
import domain.Map.*;
import static helpers.Artist.*;

/**
 *
 * @author Home
 */
public class Game {
    
    private Map map;
    private Player player;
    private WaveManager waveManager;
        
    public Game(int[][] map) {
        this.map = new Map(map);
        this.waveManager = new WaveManager(new Enemy(quickLoad("ufo64"), this.map.getTile(14, 8), this.map, TILE_SIZE, TILE_SIZE, 70, 25), 2, 2);
        this.player = new Player(this.map, waveManager);
        
    }
    
    public void update() {
        map.draw();        
        waveManager.update();
        player.update();
    }
}
