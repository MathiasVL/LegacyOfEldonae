/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static helpers.Artist.*;
import java.awt.Font;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author Home
 */
public class UI {
    
    private ArrayList<Button> buttonList;
    private ArrayList<Menu> menuList;
    private TrueTypeFont font;
    private Font awtFont;
    
    public UI() {
        this.buttonList = new ArrayList<Button>();
        this.menuList = new ArrayList<Menu>();
        this.awtFont = new Font("Times New Roman", Font.BOLD, 24);
        this.font = new TrueTypeFont(awtFont, false);
    }
    
    public void drawString(int x, int y, String text){
        font.drawString(x, y, text);
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
    
    public void createMenu(String name, int x, int y, int width, int height, int optionsWidth, int optionsHeight){
        menuList.add(new Menu(name, x, y, width, height, optionsWidth, optionsHeight));
    }
    
    public Menu getMenu(String name){
        for(Menu m: menuList){
            if(name.equals(m.getName())) 
                return m;
        }
        return null;
    }
    
    public void draw() {
        for(Button b: buttonList)
            drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        for(Menu m: menuList)
            m.draw();        
    }
    
    public class Menu {
        
        String name;
        private ArrayList<Button> menuButtons;
        private int x, y, width, height, buttonAmount, optionsWidth, optionsHeight, padding;
        
        public Menu(String name, int x, int y, int width, int height, int optionsWidth, int optionHeight){
            this.name = name;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.optionsWidth = optionsWidth;
            this.optionsHeight = optionHeight;
            this.padding = (width - (optionsWidth * TILE_SIZE)) / (optionsWidth + 1);
            this.buttonAmount = 0;
            this.menuButtons = new ArrayList<Button>();
        }
        
        public void addButton(Button b){
            setButton(b);
        }
        
        public void quickAdd(String name, String buttonTextureName){
            Button b = new Button(name, quickLoad(buttonTextureName), 0, 0);
            setButton(b);
        }
        
        private void setButton(Button b){
            if(optionsWidth != 0)
                b.setY(y + (buttonAmount / optionsWidth) * TILE_SIZE);
            b.setX(x + (buttonAmount % 2) * (padding + TILE_SIZE) + padding);
            buttonAmount++;
            menuButtons.add(b);
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
            for(Button b: menuButtons) {
                if(b.getName().equals(ButtonName)) {
                    return b;
                }
            }
            return null;
        }
        
        public void draw(){
            for(Button b: menuButtons)
                drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
        
        public String getName(){
            return name;
        }
    }            
}
