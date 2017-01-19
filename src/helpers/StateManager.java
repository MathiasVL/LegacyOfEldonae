/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import domain.Editor;
import domain.Game;
import domain.MainMenu;
import domain.Map.Map;

import static helpers.Leveler.loadMap;
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
    
    public static long nextSecond = System.currentTimeMillis() + 1000;
    public static int framesInLastSecond = 0;
    public static int framesInCurrentSecond = 0;
    
    
    static Map mapGrid = loadMap("MapName");
    
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
        
        long currentTime = System.currentTimeMillis();
        if(currentTime > nextSecond){
            nextSecond += 1000;
            framesInLastSecond = framesInCurrentSecond;
            framesInCurrentSecond = 0;
        }
        
        framesInCurrentSecond++;
    }
    
    public static void setState(GameStates newState) {
        gameState = newState;
    }
    
}
