/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import java.util.ArrayList;
import static helpers.Clock.*;
/**
 *
 * @author mathi
 */
public class Wave {
    
    private float TimeSinceLastSpawn, SpawnTime;
    private Enemy EnemyType;
    private ArrayList<Enemy> EnemyList;
    private int EnemiesPerWave;
    private boolean WaveCompleted;
    
    public Wave(Enemy EnemyType, float SpawnTime, int EnemiesPerWave)
    {
        this.EnemyType = EnemyType;
        this.SpawnTime = SpawnTime;
        this.EnemiesPerWave = EnemiesPerWave;
        this.TimeSinceLastSpawn = 0;
        this.EnemyList = new ArrayList<Enemy>();
        this.WaveCompleted = false;
        
        Spawn();
    }
    
    public void Update()
    {
        boolean AllEnemiesDead = true;
        if(EnemyList.size() < EnemiesPerWave) {
            TimeSinceLastSpawn += Delta();
            if(TimeSinceLastSpawn > SpawnTime) {
                Spawn();
                TimeSinceLastSpawn = 0;
            }
        }
        
        for(Enemy e : EnemyList)
        {
            if(e.IsAlive()){
                AllEnemiesDead = false;
                e.Update();
                e.Draw();
            }
        }
        
        if(AllEnemiesDead)
            WaveCompleted = true;
    }
    
    private void Spawn() {
        EnemyList.add(new Enemy(EnemyType.getTexture(), EnemyType.getStartTile(),EnemyType.getMap(), 64, 64, EnemyType.getSpeed()));
        
    }
    
    public boolean IsCompleted() {
        return WaveCompleted;
    }
    
    public ArrayList<Enemy> getEnemyList() {
        return EnemyList;
    }
}
