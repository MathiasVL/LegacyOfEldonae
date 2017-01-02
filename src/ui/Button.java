/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public class Button {
    
    private String Name;
    private Texture Texture;
    private int x, y, Width, Height;
    
    public Button(String Name, Texture Texture, int x, int y, int Width, int Height) {
        this.Name = Name;
        this.Texture = Texture;
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
    }
    
    public Button(String Name, Texture Texture, int x, int y) {
        this.Name = Name;
        this.Texture = Texture;
        this.x = x;
        this.y = y;
        this.Width = Texture.getImageWidth();
        this.Height = Texture.getImageHeight();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Texture getTexture() {
        return Texture;
    }

    public void setTexture(Texture Texture) {
        this.Texture = Texture;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }
    
    
}
