/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import static helpers.Artist.TILE_SIZE;
import static helpers.Clock.*;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 *
 * @author mathi
 */
public class Wave {
    
    private float timeSinceLastSpawn, spawnTime;
    private Enemy enemyType;
    private CopyOnWriteArrayList<Enemy> enemyList;
    private int enemiesPerWave, enemiesSpawned;
    private boolean waveCompleted;
    
    public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave)
    {
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        this.enemiesPerWave = enemiesPerWave;
        this.enemiesSpawned = 0;
        this.timeSinceLastSpawn = 0;
        this.enemyList = new CopyOnWriteArrayList<Enemy>();
        this.waveCompleted = false;
        
        spawn();
    }
    
    public void update()
    {
        //assume all enemies are dead until for loop finds one that is alive
        boolean allEnemiesDead = true;
        if(enemiesSpawned < enemiesPerWave) {
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
            else {
                enemyList.remove(e);
            }
        }
        
        if(allEnemiesDead)
            waveCompleted = true;
    }
    
    private void spawn() {
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getMap(), TILE_SIZE, TILE_SIZE, enemyType.getSpeed(), enemyType.getHealth()));
        enemiesSpawned++;
        
    }
    
    public boolean isCompleted() {
        return waveCompleted;
    }
    
    public CopyOnWriteArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
}
