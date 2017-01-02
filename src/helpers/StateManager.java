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
    
    public static GameStates GameState = GameStates.MAINMENU;
    public static MainMenu MainMenu;
    public static Game Game;
    public static Editor Editor;
    
    static int[][] MapGrid = {
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
    
    public static void Update() {
        switch(GameState){
            case MAINMENU:
                if(MainMenu == null)
                    MainMenu = new MainMenu();
                MainMenu.Update();
                break;
            case GAME:
                if(Game == null)
                    Game = new Game(MapGrid);
                Game.Update();
                break;
            case EDITOR:
                if(Editor == null)
                    Editor = new Editor();
                Editor.Update();
                break;
        }
    }
    
    public static void setState(GameStates NewState) {
        GameState = NewState;
    }
    
}
