/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import domain.Map.Tile;
import java.util.ArrayList;

/**
 *
 * @author Mathi
 */
public class TowerIce extends Tower{
    
    public TowerIce(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {
        super(type, startTile, enemies);
    }
    
}