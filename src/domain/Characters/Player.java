/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import domain.Map.*;
import domain.Towers.Tower;
import domain.Towers.TowerCannonBlue;
import domain.Towers.TowerIce;
import domain.Towers.TowerType;
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
    private ArrayList<Tower> towerList;
    private boolean leftMouseButtonDown, rightMouseButtonDown;
    public static int cash, lives;
    
    public Player(Map map, WaveManager waveManager) {
        this.map = map;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
        this.waveManager = waveManager;
        this.towerList = new ArrayList<Tower>();
        this.leftMouseButtonDown = false;
        this.rightMouseButtonDown = false;
        cash = 0;
        lives = 0;
    }  
    
    //initialize cash and live values for player
    public void setup() {
        cash = 50;
        lives = 10;
    }
    
    public static boolean modifyCash(int amount) {
        if( cash + amount >= 0) {
            cash += amount;
            return true;
        }
        return false;
    }
    
    public static void modifyLive(int amount){
        lives += amount;
    }
        
    public void update() {
        
        //update all towers in the game
        for(Tower t : towerList){
            t.update();
            //t.draw();
            t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
        }
        
        //Handle Mouse Input
        //Left
        if(Mouse.isButtonDown(0) && !leftMouseButtonDown){     
            if(modifyCash(-20))
                towerList.add(new TowerCannonBlue(TowerType.CannonBlue, map.getTile((Mouse.getX() / TILE_SIZE), (((HEIGHT - Mouse.getY() - 1 )) / TILE_SIZE) - 1), waveManager.getCurrentWave().getEnemyList()));
        }
        
        leftMouseButtonDown = Mouse.isButtonDown(0);
        
        //right
        if(Mouse.isButtonDown(1) && !rightMouseButtonDown){   
            if(modifyCash(-55))
                towerList.add(new TowerIce(TowerType.CannonIce, map.getTile((Mouse.getX() / TILE_SIZE), (((HEIGHT - Mouse.getY() - 1 )) / TILE_SIZE) - 1), waveManager.getCurrentWave().getEnemyList()));
        }
        
        rightMouseButtonDown = Mouse.isButtonDown(1);
        
        
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
