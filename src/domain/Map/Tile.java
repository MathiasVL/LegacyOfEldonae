/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Map;

import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import static org.newdawn.slick.opengl.renderer.SGL.GL_QUADS;
import org.newdawn.slick.util.ResourceLoader;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author mathi
 */
public class Tile {
    private float x, y, Width, Height;
    private Texture Texture;
    private TileType Type;
    
    public Tile(float x, float y, float Width, float Height, TileType Type)
    {
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
        this.Type = Type;
        this.Texture = QuickLoad(Type.TextureName);
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
        Tex = LoadTexture("res" + Name + ".png","PNG");
        return Tex;
    }
    
    public static void DrawQuadText(Texture Tex, float x, float y, float Width, float Height)
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
        glLoadIdentity();
        glEnd();
    }
}
