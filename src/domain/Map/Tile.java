/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Map;

import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author mathi
 */
public class Tile {
    
    private float x, y;
    private int width, height;
    private Texture texture;
    private TileType type;
    private boolean occupied;
    
    public Tile(float x, float y, int width, int height, TileType type)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoad(type.textureName);
        if(type.buildable)
            this.occupied = false;
        else 
            this.occupied = true;
    }
    
    public void draw() {
        drawQuadTex(this.texture, this.x, this.y, this.width, this.height);
    }

    public float getX() {
        return x;
    }
    
    public int getXPlace() {
        return (int) x / TILE_SIZE;
    }

    public float getY() {
        return y;
    }
    
    public int getYPlace() {
        return (int) y / TILE_SIZE;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Texture getTexture() {
        return texture;
    }

    public TileType getType() {
        return type;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setType(TileType type) {
        this.type = type;
    }
    
    public boolean getOccupied(){
        return occupied;        
    }
    
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
}
