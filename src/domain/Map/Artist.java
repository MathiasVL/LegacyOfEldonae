/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Map;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author mathi
 */
public class Artist {
    
    public static final int WIDTH = 600, HEIGHT = 400;

    public static void BeginSession() 
    {
        Display.setTitle("Legacy Of Eldonae");
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
            Display.create();
        } catch(LWJGLException e) {
            e.printStackTrace();
        }
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }
    
    public static void DrawQuad(float x, float y, float Width, float Height)
    {
        glBegin(GL_QUADS);
        glVertex2f(x,y);
        glVertex2f(x+Width,y);
        glVertex2f(x+Width, y+ Height);
        glVertex2f(x,y+Height);
        glEnd();
    }
}
