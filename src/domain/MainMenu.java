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
import java.util.HashSet;
import org.lwjgl.input.Mouse;
import ui.UI;

/**
 *
 * @author Home
 */
public class MainMenu {
    
    private Texture BackGround;
    private UI MenuUI;
    
    public MainMenu() {
        BackGround = QuickLoad("mainmenu");
        MenuUI = new UI();
        MenuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int)(HEIGHT * 0.45f));
        MenuUI.addButton("Editor", "editorButton", WIDTH / 2 - 128, (int)(HEIGHT * 0.55f));
        MenuUI.addButton("Quit", "quitButton", WIDTH / 2 -128, (int)(HEIGHT * 0.65f));
    }
    
    private void UpdateButtons(){
        if(Mouse.isButtonDown(0)){
            if(MenuUI.IsButtonClicked("Play"))
                StateManager.setState(GameStates.GAME);    
            if(MenuUI.IsButtonClicked("Editor"))
                StateManager.setState(GameStates.EDITOR);            
            if(MenuUI.IsButtonClicked("Quit"))
                System.exit(0);
        }
    }
    
    public void Update() {
        DrawQuadTex(BackGround, 0, 0, 2048, 1024);
        MenuUI.Draw();
        UpdateButtons();
    }
}
