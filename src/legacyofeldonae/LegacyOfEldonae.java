/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legacyofeldonae;

import static domain.Map.Artist.*;
import domain.Map.Map;
import domain.Map.Tile;
import domain.Map.TileType;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import sun.java2d.loops.DrawRect;

/**
 *
 * @author Home
 */
public class LegacyOfEldonae {

    public LegacyOfEldonae() 
    {        
        BeginSession();
        
        int[][] MapGrid = {
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,2,2,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0},
            {0,0,2,2,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        
        Map Map = new Map(MapGrid);
        
        while(!Display.isCloseRequested()) 
        {            
            Map.Draw();
            
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new LegacyOfEldonae();
    }
        
}
