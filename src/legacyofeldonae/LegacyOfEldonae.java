/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legacyofeldonae;

import static helpers.Artist.*;
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
        beginSession();             
        
        while(!Display.isCloseRequested()) 
        {          
            Clock.update();
            StateManager.update();
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
        LegacyOfEldonae legacyOfEldonae = new LegacyOfEldonae();
    }
        
}
