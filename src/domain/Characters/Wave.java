/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import static helpers.Artist.TILE_SIZE;
import java.util.ArrayList;
import static helpers.Clock.*;
/**
 *
 * @author mathi
 */
public class Wave {
    
    private float timeSinceLastSpawn, spawnTime;
    private Enemy enemyType;
    private ArrayList<Enemy> enemyList;
    private int enemiesPerWave;
    private boolean waveCompleted;
    
    public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave)
    {
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        this.enemiesPerWave = enemiesPerWave;
        this.timeSinceLastSpawn = 0;
        this.enemyList = new ArrayList<Enemy>();
        this.waveCompleted = false;
        
        spawn();
    }
    
    public void update()
    {
        boolean allEnemiesDead = true;
        if(enemyList.size() < enemiesPerWave) {
            timeSinceLastSpawn += delta();
            if(timeSinceLastSpawn > spawnTime) {
                spawn();
                timeSinceLastSpawn = 0;
            }
        }
        
        for(Enemy e : enemyList)
        {
            if(e.isAlive()){
                allEnemiesDead = false;
                e.update();
                e.draw();
            }
        }
        
        if(allEnemiesDead)
            waveCompleted = true;
    }
    
    private void spawn() {
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getMap(), TILE_SIZE, TILE_SIZE, enemyType.getSpeed(), enemyType.getHealth()));
        
    }
    
    public boolean isCompleted() {
        return waveCompleted;
    }
    
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
}
