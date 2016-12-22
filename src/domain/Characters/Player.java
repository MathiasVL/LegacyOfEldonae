/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import domain.Map.*;
import org.lwjgl.input.Mouse;

import static helpers.Artist.*;
import org.lwjgl.input.Keyboard;
/**
 *
 * @author mathi
 */
public class Player {
    
    private Map Map;
    private TileType[] Types;
    private int Index;
    
    public Player(Map Map) {
        this.Map = Map;
        this.Types = new TileType[3];
        this.Types[0] = TileType.Grass;
        this.Types[1] = TileType.Dirt;
        this.Types[2] = TileType.Water;
        this.Index = 0;
    }
    
    public void SetTile() {
        //Map.setTile((int)Math.floor(Mouse.getX() / 64), (int) Math.floor(((HEIGHT - Mouse.getY()-0.5 )) / 64), TileType.Water);
        Map.setTile((int)Math.floor(Mouse.getX() / 64), (int) Math.floor(((HEIGHT - Mouse.getY() - 1 )) / 64) - 1, Types[Index]);
    }
    
    public void Update() {
        if(Mouse.isButtonDown(0))
        {
            SetTile();
        }
        while(Keyboard.next())
        {
            if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
                MoveIndex();
            }
        }
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
