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
    private int Width, Height, Health, CurrentCheckpoint;
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
        this.CurrentCheckpoint = 0;
        PopulateCheckPointList();
    }
    
    public void Update()
    {
        if(First)
            First = false;
        else {
            if(CheckpointReached())
            {
                CurrentCheckpoint++;
            }else {
                x += Delta() * Checkpoints.get(CurrentCheckpoint).getxDirection();
                y += Delta() * Checkpoints.get(CurrentCheckpoint).getyDirection();
            }
        }           
    }
    
    private boolean CheckpointReached() {
        boolean Reached = false;
        Tile T = Checkpoints.get(CurrentCheckpoint).getTile();
        //Check if position reached tile whithin variance of 3 (arbitrary)
        if(x > T.getX() - 3 && x < T.getX() + 3 && y > T.getY() -3 && y < T.getY() + 3)
        {
            Reached = true;
            x = T.getX();
            y = T.getY();
        }
        
        return Reached;
    }
    
    private void PopulateCheckPointList() {
        Checkpoints.add(FindNextC(StartTile, Directions = FindNextD(StartTile)));
        
        int Counter = 0;
        boolean Cont = true;
        
        while(Cont)
        {
            int[] CurrentD = FindNextD(Checkpoints.get(Counter).getTile());
            //Check if a next direction/checkpoint exists, end after 20 checkpoints (arbitrary)
            if(CurrentD[0] == 2 || Counter == 20){
                Cont = false;
            }
            else
            {
                Checkpoints.add(FindNextC(Checkpoints.get(Counter).getTile(), Directions = FindNextD(Checkpoints.get(Counter).getTile())));
            }
            Counter++;
        }                
    }
    
    private Checkpoint FindNextC(Tile s, int[] dir) {
        Tile next = null;
        Checkpoint c = null;
        
        //Boolean to declare if next checkpoint is found
        boolean found = false;
        
        //Integer to increment each loop
        int Counter = 1;
        
        while(!found)
        {
            if(s.getType() != Map.GetTile(s.getXPlace() + dir[0] * Counter, s.getYPlace()+ dir[1] * Counter).getType())
            {
                found = true;
                //Move counter back 1 to find tile before new tiletype
                Counter -=1 ;
                next = Map.GetTile(s.getXPlace() + dir[0] * Counter, s.getYPlace()+ dir[1] * Counter);                
            }
            
            c = new Checkpoint(next, dir[0], dir[1]);
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
            dir[0] = 2;
            dir[1] = 2;
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
