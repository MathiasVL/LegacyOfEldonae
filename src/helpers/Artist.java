/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.IOException;
import java.io.InputStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import static org.newdawn.slick.opengl.renderer.SGL.GL_QUADS;
import org.newdawn.slick.util.ResourceLoader;


/**
 *
 * @author mathi
 */
public class Artist {
    
    public static final int WIDTH = 1280, HEIGHT = 960;

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
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
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
    
    public static void DrawQuadTex(Texture Tex, float x, float y, float Width, float Height)
    {
        Tex.bind();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        glTexCoord2f(1,0);
        glVertex2f(Width,0);
        glTexCoord2f(1,1);
        glVertex2f(Width,Height);
        glTexCoord2f(0,1);
        glVertex2f(0,Height);
        glEnd();
        glLoadIdentity();   
    }
    
    public static Texture LoadTexture(String Path, String FileType)
    {
        Texture Tex = null;
        InputStream In = ResourceLoader.getResourceAsStream(Path);
        try 
        {
            Tex = TextureLoader.getTexture(FileType, In);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        return Tex;
    }
    
    public static Texture QuickLoad(String Name)
    {
        Texture Tex = null;
        Tex = LoadTexture("res/" + Name + ".png","PNG");
        return Tex;
    }
}
