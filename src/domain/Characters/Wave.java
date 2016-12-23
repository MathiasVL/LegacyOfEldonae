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
    
    public Wave(float SpawnTime, Enemy EnemyType)
    {
        this.EnemyType = EnemyType;
        this.SpawnTime = SpawnTime;
        TimeSinceLastSpawn = 0;
        EnemyList = new ArrayList<Enemy>();
    }
    
    public void Update()
    {
        TimeSinceLastSpawn += Delta();
        if(TimeSinceLastSpawn > SpawnTime) {
            Spawn();
            TimeSinceLastSpawn = 0;
        }
        
        for(Enemy e : EnemyList)
        {
            e.Update();
            e.Draw();
        }
    }
    
    private void Spawn() {
        EnemyList.add(new Enemy(EnemyType.getTexture(), EnemyType.getStartTile(),EnemyType.getMap(), 64, 64, EnemyType.getSpeed()));
        
    }
}
