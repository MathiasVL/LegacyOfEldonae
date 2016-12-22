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
    private float x, y, Width, Height;
    private Texture Texture;
    private TileType Type;
    
    public Tile(float x, float y, float Width, float Height, TileType Type)
    {
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
        this.Type = Type;
        this.Texture = QuickLoad(Type.TextureName);
    }
    
    public void Draw() {
        DrawQuadTex(this.Texture, this.x, this.y, this.Width, this.Height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return Width;
    }

    public float getHeight() {
        return Height;
    }

    public Texture getTexture() {
        return Texture;
    }

    public TileType getType() {
        return Type;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float Width) {
        this.Width = Width;
    }

    public void setHeight(float Height) {
        this.Height = Height;
    }

    public void setTexture(Texture Texture) {
        this.Texture = Texture;
    }

    public void setType(TileType Type) {
        this.Type = Type;
    }
    
    
}
