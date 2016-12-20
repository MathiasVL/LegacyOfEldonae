/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legacyofeldonae;

import static domain.Map.Artist.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Home
 */
public class LegacyOfEldonae {

    public LegacyOfEldonae() {
        BeginSession();
        
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0,WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        
        while(!Display.isCloseRequested()) {
            
            DrawQuad(50, 50, 100, 100);
            DrawQuad(150, 150, 100, 100);
            
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
