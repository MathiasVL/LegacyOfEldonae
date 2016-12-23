/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Map;

/**
 *
 * @author Home
 */
public class Checkpoint {
    
    private Tile Tile;
    private int xDirection, yDirection;
    
    public Checkpoint(Tile Tile,int xDirection, int yDirection)
    {
        this.Tile = Tile;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public Tile getTile() {
        return Tile;
    }

    public int getxDirection() {
        return xDirection;
    }    

    public int getyDirection() {
        return yDirection;
    }   
    
}
