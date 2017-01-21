/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import static helpers.Artist.TILE_SIZE;
import static helpers.Clock.*;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 *
 * @author mathi
 */
public class Wave {
    
    private float timeSinceLastSpawn, spawnTime;
    private Enemy[] enemyTypes;
    private CopyOnWriteArrayList<Enemy> enemyList;
    private int enemiesPerWave, enemiesSpawned;
    private boolean waveCompleted;
    
    public Wave(Enemy[] enemyTypes, float spawnTime, int enemiesPerWave)
    {
        this.enemyTypes = enemyTypes;
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
        int enemyChosen = 0;
        Random random = new Random();
        enemyChosen = random.nextInt(enemyTypes.length);
        
        enemyList.add(new Enemy(enemyTypes[enemyChosen].getTexture(), enemyTypes[enemyChosen].getStartTile(), enemyTypes[enemyChosen].getMap(), TILE_SIZE, TILE_SIZE, enemyTypes[enemyChosen].getSpeed(), enemyTypes[enemyChosen].getHealth()));
        enemiesSpawned++;
        
    }
    
    public boolean isCompleted() {
        return waveCompleted;
    }
    
    public CopyOnWriteArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
}
