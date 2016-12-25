/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legacyofeldonae;

import domain.Characters.Enemy;
import domain.Characters.Player;
import domain.Characters.Wave;
import static helpers.Artist.*;
import domain.Map.Map;
import helpers.Clock;
import org.lwjgl.opengl.Display;


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
            {0,0,2,2,0,0,0,1,1,0,1,1,1,0,0,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        
        Map Map = new Map(MapGrid);
        Map.setTile(3, 4, Map.GetTile(5, 7).getType());
        Enemy Enemy = new Enemy(QuickLoad("ufo64"), Map.GetTile(10, 10),Map, 64, 64, 12);
        Wave Wave = new Wave(20,Enemy);
        Player Player = new Player(Map);
        
        while(!Display.isCloseRequested()) 
        {          
            Clock.Update();
            
            Map.Draw();
            Wave.Update();
            Player.Update();
            
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
