/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Projectiles;

import static helpers.Artist.quickLoad;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Mathi
 */
public enum ProjectileType {
    
    CannonBall(quickLoad("bullet"), 10, 500),
    IceBall(quickLoad("iceBall"), 6, 450);
    
    Texture texture;
    int damage;
    float speed;
    
    ProjectileType(Texture texture, int damage, float speed){
        this.texture = texture;
        this.damage = damage;
        this.speed = speed;
    }
    
}
