/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Map.Map;
import domain.Map.TileType;
import domain.Towers.TowerCannon;
import domain.Towers.TowerCannonBlue;
import domain.Towers.TowerType;
import static helpers.Artist.*;
import static helpers.Leveler.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import ui.UI;
import ui.UI.Menu;

/**
 *
 * @author Home
 */
public class Editor {
    
    private Map map;
    private int index;
    private TileType[] types;
    private UI editorUI;
    private Menu tilePickerMenu;
    
    public Editor(){
        this.map = loadMap("MapName");
        this.index = 0;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        setupUI();
    }
    
    private void setupUI(){
        editorUI = new UI();
        editorUI.createMenu("TilePicker", TILE_SIZE * map.getTilesWide(), 100, TILE_SIZE * 3, TILE_SIZE * map.getTilesHigh(), 2, 0);
        tilePickerMenu = editorUI.getMenu("TilePicker");
        tilePickerMenu.quickAdd("Grass", "grass64");
        tilePickerMenu.quickAdd("Dirt", "dirt64");
        tilePickerMenu.quickAdd("Water", "water64");
    }
    
    public void update(){
        draw();
        
        //Handle Mouse Input
        if(Mouse.next()){
            boolean mouseClicked = Mouse.isButtonDown(0);
            if(mouseClicked){
                if(tilePickerMenu.isButtonClicked("Grass")){
                    index = 0;
                } else if(tilePickerMenu.isButtonClicked("Dirt")){
                    index = 1;
                } else if(tilePickerMenu.isButtonClicked("Water")){
                    index = 2;
                } else {
                    setTile();
                }
            }
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
    
    private void draw(){
        drawQuadTex(quickLoad("menuBackground"), TILE_SIZE*map.getTilesWide(), 0, TILE_SIZE*3, TILE_SIZE*map.getTilesHigh());
        map.draw();
        editorUI.draw();
    }
    
    private void setTile() {
        map.setTile((int)Math.floor(Mouse.getX() / TILE_SIZE), (int) Math.floor(((HEIGHT - Mouse.getY())) / TILE_SIZE), types[index]);
    }
        
    //allows editor to change which tiletype is selected
    private void moveIndex()
    {
        index++;
        if(index > types.length -1)
        {
            index = 0;
        }
    }
}
