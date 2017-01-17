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
    
    public static final int WIDTH = 1472, HEIGHT = 960;
    public static final int TILE_SIZE = 64, HALFTILE_SIZE = 32;
    public static final int PROJECTILE_SIZE = 32;

    
    public static void beginSession() 
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
    
    public static boolean checkCollision(float x1, float y1, float width1, float height1, float x2, float y2, float width2, float height2){
        if(x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2 && y1 < y2 + height2)
            return true;
        else
            return false;
    }
    
    public static void drawQuad(float x, float y, float width, float height)
    {
        glBegin(GL_QUADS);
        glVertex2f(x,y);
        glVertex2f(x+width,y);
        glVertex2f(x+width, y+ height);
        glVertex2f(x,y+height);
        glEnd();
    }
    
    public static void drawQuadTex(Texture tex, float x, float y, float width, float height)
    {
        tex.bind();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        glTexCoord2f(1,0);
        glVertex2f(width,0);
        glTexCoord2f(1,1);
        glVertex2f(width,height);
        glTexCoord2f(0,1);
        glVertex2f(0,height);
        glEnd();
        glLoadIdentity();   
    }
    
    public static void drawQuadTexRot(Texture tex, float x, float y, float width, float height, float angle)
    {
        tex.bind();
        glTranslatef(x + (width/2) , y + (height/2),  0);
        glRotatef(angle, 0, 0, 1);
        glTranslatef(-width / 2, - height /2, 0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        glTexCoord2f(1,0);
        glVertex2f(width,0);
        glTexCoord2f(1,1);
        glVertex2f(width,height);
        glTexCoord2f(0,1);
        glVertex2f(0,height);
        glEnd();
        glLoadIdentity();   
    }
    
    public static Texture loadTexture(String path, String fileType)
    {
        Texture Tex = null;
        InputStream In = ResourceLoader.getResourceAsStream(path);
        try 
        {
            Tex = TextureLoader.getTexture(fileType, In);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        return Tex;
    }
    
    public static Texture quickLoad(String name)
    {
        Texture Tex = null;
        Tex = loadTexture("res/" + name + ".png","PNG");
        return Tex;
    }
}
