/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

/**
 *
 * @author Home
 */
public class WaveManager {
    
    private float TimeSinceLastWave, TimeBetweenEnemies;
    private int WaveNumber, EnemiesPerWave;
    private Enemy EnemyType;
    private Wave CurrentWave;
    
    public WaveManager(Enemy EnemyType, float TimeBetweenEnemies, int EnemiesPerWave) {
        this.EnemyType = EnemyType;
        this.TimeBetweenEnemies = TimeBetweenEnemies;
        this.EnemiesPerWave = EnemiesPerWave;
        this.TimeSinceLastWave = 0;
        this.WaveNumber = 0;
        
        this.CurrentWave = null;
        
        NewWave();
    }
    
    public void Update() {
        if(!CurrentWave.IsCompleted())
            CurrentWave.Update();
        else
            NewWave();
    }
    
    private void NewWave() {
        CurrentWave = new Wave(EnemyType, TimeBetweenEnemies, EnemiesPerWave);
        WaveNumber++;
        System.out.println("Beginning Wave " + WaveNumber);
    }
    
    public Wave getCurrentWave(){
        return CurrentWave;
    }
}
