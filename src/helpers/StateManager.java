/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import domain.Editor;
import domain.Game;
import domain.MainMenu;

/**
 *
 * @author Home
 */
public class StateManager {
    
    public static enum GameStates {
        MAINMENU, GAME, EDITOR
    }
    
    public static GameStates gameState = GameStates.MAINMENU;
    public static MainMenu mainMenu;
    public static Game game;
    public static Editor editor;
    
    static int[][] mapGrid = {
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,2,2,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,2,2,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,2,2,0,0,0,1,1,0,1,1,1,0,1,0,0,0,0,0},
            {0,0,2,2,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1},
        };
    
    public static void update() {
        switch(gameState){
            case MAINMENU:
                if(mainMenu == null)
                    mainMenu = new MainMenu();
                mainMenu.update();
                break;
            case GAME:
                if(game == null)
                    game = new Game(mapGrid);
                game.update();
                break;
            case EDITOR:
                if(editor == null)
                    editor = new Editor();
                editor.update();
                break;
        }
    }
    
    public static void setState(GameStates newState) {
        gameState = newState;
    }
    
}
