/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Mathi
 */
public class ProjectileIceBall extends Projectile {
    
    public ProjectileIceBall(Texture texture, Enemy target, float x, float y, int width, int height, float speed, int damage) {
        super(texture, target, x, y, width, height, speed, damage);
    }
    
    @Override
    public void doDamage(){
        super.getTarget().setSpeed(4);
        super.doDamage();
    }
    
}
