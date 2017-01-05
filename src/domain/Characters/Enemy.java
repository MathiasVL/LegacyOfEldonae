/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import domain.Entity;
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
public class Enemy implements Entity {
    private int width, height, health, currentCheckpoint;
    private float speed, x, y;
    private Texture texture;
    private Tile startTile;
    private boolean first = true, alive = true;
    private Map map;
    
    private ArrayList<Checkpoint> checkpoints;
    private int[] directions;
    
    public Enemy(Texture texture, Tile startTile, Map map, int width, int height, float speed, int health)
    {
        this.texture = texture;
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.health = health;
        this.map = map;
        
        this.checkpoints = new ArrayList<Checkpoint>();
        this.directions = new int[2];
        //X direction
        this.directions[0] = 0;
        //Y direction
        this.directions[1] = 0;
        directions = findNextD(startTile);        
        this.currentCheckpoint = 0;
        populateCheckPointList();
    }
    
    public void update()
    {
        if(first)
            first = false;
        else {
            if(checkpointReached())
            {
                if(currentCheckpoint + 1 == checkpoints.size())
                    die();
                else
                    currentCheckpoint++;
            }else {
                x += delta() * checkpoints.get(currentCheckpoint).getxDirection() * speed;
                y += delta() * checkpoints.get(currentCheckpoint).getyDirection() * speed;
            }
        }           
    }
    
    private boolean checkpointReached() {
        boolean reached = false;
        Tile t = checkpoints.get(currentCheckpoint).getTile();
        //Check if position reached tile whithin variance of 3 (arbitrary)
        if(x > t.getX() - 3 && x < t.getX() + 3 && y > t.getY() -3 && y < t.getY() + 3)
        {
            reached = true;
            x = t.getX();
            y = t.getY();
        }
        
        return reached;
    }
    
    private void populateCheckPointList() {
        checkpoints.add(findNextC(startTile, directions = findNextD(startTile)));
        
        int counter = 0;
        boolean cont = true;
        
        while(cont)
        {
            int[] currentD = findNextD(checkpoints.get(counter).getTile());
            //Check if a next direction/checkpoint exists, end after 20 checkpoints (arbitrary)
            if(currentD[0] == 2 || counter == 20){
                cont = false;
            }
            else
            {
                checkpoints.add(findNextC(checkpoints.get(counter).getTile(), directions = findNextD(checkpoints.get(counter).getTile())));
            }
            counter++;
        }                
    }
    
    private Checkpoint findNextC(Tile s, int[] dir) {
        Tile next = null;
        Checkpoint c = null;
        
        //Boolean to declare if next checkpoint is found
        boolean found = false;
        
        //Integer to increment each loop
        int counter = 1;
        
        while(!found)
        {
            if(s.getXPlace() + dir[0] * counter == map.getTilesWide() || s.getYPlace()+ dir[1] * counter == map.getTilesHigh() || s.getType() != map.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace()+ dir[1] * counter).getType())
            {
                found = true;
                //Move counter back 1 to find tile before new tiletype
                counter -= 1 ;
                next = map.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace()+ dir[1] * counter);                
            }
            
            counter++;
        }
        
        c = new Checkpoint(next, dir[0], dir[1]);        
        return c;
    }
    
    private int[] findNextD(Tile s) {
        int[] dir = new int[2];
        
        Tile u = map.getTile(s.getXPlace(), s.getYPlace()-1);
        Tile d = map.getTile(s.getXPlace(), s.getYPlace()+1);
        Tile r = map.getTile(s.getXPlace()+1, s.getYPlace());
        Tile l = map.getTile(s.getXPlace()-1, s.getYPlace());
        
        if(s.getType() == u.getType() && directions[1] != 1)
        {
            dir[0] = 0;
            dir[1] = -1;
        }
        else if(s.getType() == r.getType() && directions[0] != -1)
        {
            dir[0] = 1;
            dir[1] = 0;
        }
        else if(s.getType() == d.getType() && directions[1] != -1)
        {
            dir[0] = 0;
            dir[1] = 1;
        }
        else if(s.getType() == l.getType() && directions[0] != 1)
        {
            dir[0] = -1;
            dir[1] = 0;
        }
        else {
            dir[0] = 2;
            dir[1] = 2;
            //System.out.println("NO DIRECTION FOUND");
        }
        
        return dir;
    }
    
    public void damage(int Amount) {
        health -= Amount;
        if(health <= 0)
            die();
    }
    
    private void die()
    {
        alive = false;
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
    public void draw()
    {
        drawQuadTex(texture, x, y, width, height);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setStartTile(Tile startTile) {
        this.startTile = startTile;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Texture getTexture() {
        return texture;
    }

    public Tile getStartTile() {
        return startTile;
    }

    public boolean isFirst() {
        return first;
    }
    
    public Map getMap()
    {
        return map;
    }
    
    public boolean isAlive()
    {
        return alive;
    }
    
}
