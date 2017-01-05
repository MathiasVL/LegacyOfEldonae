/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Map.Map;
import domain.Map.TileType;
import static helpers.Artist.*;
import static helpers.Leveler.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 *
 * @author Home
 */
public class Editor {
    
    private Map map;
    private int index;
    private TileType[] types;
    
    public Editor(){
        this.map = loadMap("MapName");//new Map();
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
    }
    
    public void update(){
        map.draw();
        
        //Handle Mouse Input
        if(Mouse.isButtonDown(0)){            
            setTile();
        }
                
        //Handle Keyboard Input
        while(Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
                moveIndex();
            }
            if(Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()){
                saveMap("MapTest", map);
            }                    
        }
    }
    
    private void setTile() {
        map.setTile((int)Math.floor(Mouse.getX() / TILE_SIZE), (int) Math.floor(((HEIGHT - Mouse.getY() - 1 )) / TILE_SIZE) - 1, types[index]);
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
