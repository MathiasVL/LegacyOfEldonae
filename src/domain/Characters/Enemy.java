/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import domain.Map.Checkpoint;
import domain.Map.Map;
import static helpers.Artist.*;
import static helpers.Clock.*;

import domain.Map.Tile;
import java.util.ArrayList;
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
    private Map Map;
    
    private ArrayList<Checkpoint> Checkpoints;
    private int[] Directions;
    
    public Enemy(Texture Texture, Tile StartTile, Map Map, int Width, int Height, float Speed)
    {
        this.Texture=Texture;
        this.StartTile = StartTile;
        this.x = StartTile.getX();
        this.y = StartTile.getY();
        this.Width = Width;
        this.Height = Height;
        this.Speed = Speed;
        this.Map = Map;
        
        this.Checkpoints = new ArrayList<Checkpoint>();
        this.Directions = new int[2];
        //X direction
        this.Directions[0] = 0;
        //Y direction
        this.Directions[1] = 0;
        Directions = FindNextD(StartTile);
    }
    
    public void Update()
    {
        if(First)
            First = false;
        else {
            x += Delta() * Directions[0];
            y += Delta() * Directions[1];
        }           
    }
    
    private Checkpoint FindNextC(Tile s, int[] dir) {
        Tile next = null;
        Checkpoint c = null;
        
        boolean found = false;
        int Counter = 1;
        
        while(!found)
        {
            if(s.getType() != Map.GetTile(s.getXPlace() + dir[0] * Counter, s.getYPlace()+ dir[1] * Counter).getType())
            {
                //33:10
            }
            
            Counter++;
        }
        
        return c;
    }
    
    private int[] FindNextD(Tile s) {
        int[] dir = new int[2];
        
        Tile u = Map.GetTile(s.getXPlace(), s.getYPlace()-1);
        Tile d = Map.GetTile(s.getXPlace(), s.getYPlace()+1);
        Tile r = Map.GetTile(s.getXPlace()+1, s.getYPlace());
        Tile l = Map.GetTile(s.getXPlace()-1, s.getYPlace());
        
        if(s.getType() == u.getType())
        {
            dir[0] = 0;
            dir[1] = -1;
        }
        else if(s.getType() == r.getType())
        {
            dir[0] = 1;
            dir[1] = 0;
        }
        else if(s.getType() == d.getType())
        {
            dir[0] = 0;
            dir[1] = 1;
        }
        else if(s.getType() == l.getType())
        {
            dir[0] = -1;
            dir[1] = 0;
        }
        else {
            System.out.println("NO DIRECTION FOUND");
        }
        
        return dir;
    }
    
    /*
    public boolean PathContinues() {
        boolean Answer = true;
        
        Tile MyTile = Map.GetTile((int) (x / 64) , (int) (y / 64));
        Tile NextTile = Map.GetTile((int) (x / 64) +1 , (int) (y / 64));
        
        if(MyTile.getType() != NextTile.getType())
            Answer = false;
        
        return Answer;
    }
    */
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
    
    public Map getMap()
    {
        return Map;
    }
    
    
}
