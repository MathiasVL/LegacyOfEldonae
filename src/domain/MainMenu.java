/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
import helpers.StateManager;
import helpers.StateManager.GameStates;
import org.lwjgl.input.Mouse;
import ui.UI;

/**
 *
 * @author Home
 */
public class MainMenu {
    
    private Texture backGround;
    private UI menuUI;
    
    public MainMenu() {
        backGround = quickLoad("mainmenu");
        menuUI = new UI();
        menuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int)(HEIGHT * 0.45f));
        menuUI.addButton("Editor", "editorButton", WIDTH / 2 - 128, (int)(HEIGHT * 0.55f));
        menuUI.addButton("Quit", "quitButton", WIDTH / 2 -128, (int)(HEIGHT * 0.65f));
    }
    
    private void updateButtons(){
        if(Mouse.isButtonDown(0)){
            if(menuUI.isButtonClicked("Play"))
                StateManager.setState(GameStates.GAME);    
            if(menuUI.isButtonClicked("Editor"))
                StateManager.setState(GameStates.EDITOR);            
            if(menuUI.isButtonClicked("Quit"))
                System.exit(0);
        }
    }
    
    public void update() {
        drawQuadTex(backGround, 0, 0, 2048, 1024);
        menuUI.draw();
        updateButtons();
    }
}
