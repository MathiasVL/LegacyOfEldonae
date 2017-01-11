/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Projectiles;

import domain.Characters.Enemy;

/**
 *
 * @author Mathi
 */
public class ProjectileIceBall extends Projectile {
    
    public ProjectileIceBall(ProjectileType projectileType, Enemy target, float x, float y, int width, int height) {
        super(projectileType, target, x, y, width, height);
    }
    
    @Override
    public void doDamage(){
        super.getTarget().setSpeed(4);
        super.doDamage();
    }
    
}
