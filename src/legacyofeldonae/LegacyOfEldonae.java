/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legacyofeldonae;

import domain.Characters.Enemy;
import domain.Characters.Player;
import domain.Characters.Wave;
import domain.Game;
import static helpers.Artist.*;
import domain.Map.Map;
import domain.Tower.TowerCannon;
import helpers.Clock;
import helpers.StateManager;
import org.lwjgl.opengl.Display;


/**
 *
 * @author Home
 */
public class LegacyOfEldonae {

    public LegacyOfEldonae() 
    {        
        BeginSession();             
        
        //Game Game = new Game(MapGrid);
        while(!Display.isCloseRequested()) 
        {          
            Clock.Update();
            
            //Game.Update();
            StateManager.Update();
            
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
