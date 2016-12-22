/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import static helpers.Artist.*;
import static helpers.Clock.*;

import domain.Map.Tile;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author mathi
 */
public class Enemy {
    private int Width, Height, Health;
    private float Speed, x, y;
    private Texture Texture;
    private Tile StartTile;
    private boolean First = true;
    
    public Enemy(Texture Texture, Tile StartTile, int Width, int Height, float Speed)
    {
        this.Texture=Texture;
        this.StartTile = StartTile;
        this.x = StartTile.getX();
        this.y = StartTile.getY();
        this.Width = Width;
        this.Height = Height;
        this.Speed = Speed;
    }
    
    public void Update()
    {
        if(First)
            First = false;
        else
            x += Delta() * Speed;
    }
    
    public void Draw()
    {
        DrawQuadTex(Texture, x, y, Width, Height);
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public void setSpeed(float Speed) {
        this.Speed = Speed;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setTexture(Texture Texture) {
        this.Texture = Texture;
    }

    public void setStartTile(Tile StartTile) {
        this.StartTile = StartTile;
    }

    public void setFirst(boolean First) {
        this.First = First;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public int getHealth() {
        return Health;
    }

    public float getSpeed() {
        return Speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Texture getTexture() {
        return Texture;
    }

    public Tile getStartTile() {
        return StartTile;
    }

    public boolean isFirst() {
        return First;
    }
    
    
}
