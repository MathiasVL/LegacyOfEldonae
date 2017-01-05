/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static helpers.Artist.*;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public class UI {
    
    private ArrayList<Button> buttonList;
    
    public UI() {
        this.buttonList = new ArrayList<Button>();
    }
    
    public void addButton(String Name, String TextureName, int x, int y){
        buttonList.add(new Button(Name, quickLoad(TextureName), x, y));
    }
    
    public boolean isButtonClicked(String ButtonName) {
        Button b = this.getButton(ButtonName);
        float mouseY = HEIGHT - Mouse.getY() - 1;
        if(Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() && mouseY > b.getY() && mouseY < b.getY() + b.getHeight()){
            return true;
        }
        return false;
    }
        
    private Button getButton(String ButtonName) {
        for(Button b: buttonList) {
            if(b.getName().equals(ButtonName)) {
                return b;
            }
        }
        return null;
    }
    
    public void draw() {
        for(Button b: buttonList) {
            drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
    }
            
}
