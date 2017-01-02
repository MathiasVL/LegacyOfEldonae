/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Map.Map;
import domain.Map.TileType;
import domain.Tower.TowerCannon;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import helpers.Clock;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Home
 */
public class Editor {
    
    private Map Map;
    private int Index;
    private TileType[] Types;
    
    public Editor(){
        this.Map = new Map();
        this.Types = new TileType[3];
        this.Types[0] = TileType.Grass;
        this.Types[1] = TileType.Dirt;
        this.Types[2] = TileType.Water;
        this.Index = 0;
    }
    
    public void Update(){
        Map.Draw();
        
        //Handle Mouse Input
        if(Mouse.isButtonDown(0)){            
            SetTile();
        }
                
        //Handle Keyboard Input
        while(Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
                MoveIndex();
                //Clock.ChangeMultiplier(0.2f);
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()){
                MoveIndex();
                //Clock.ChangeMultiplier(-0.2f);
            }                    
        }
    }
    
    private void SetTile() {
        Map.setTile((int)Math.floor(Mouse.getX() / 64), (int) Math.floor(((HEIGHT - Mouse.getY() - 1 )) / 64) - 1, Types[Index]);
    }
        
    private void MoveIndex()
    {
        Index++;
        if(Index > Types.length -1)
        {
            Index = 0;
        }
    }
}
