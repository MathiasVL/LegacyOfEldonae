/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Characters;

import domain.Map.Map;

/**
 *
 * @author Home
 */
public class EnemyUFO extends Enemy {
    
    public EnemyUFO(int tileX, int tileY, Map map) {
        super(tileX, tileY, map);
        this.setSpeed(100);
    }
    
}
