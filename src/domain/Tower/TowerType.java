/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
/**
 *
 * @author mathi
 */
public enum TowerType {
 
    CannonRed(new Texture[]{quickLoad("cannonBase"), quickLoad("cannonGun")}, 10, 1000, 3),
    CannonBlue(new Texture[]{quickLoad("cannonBlueBase"),quickLoad("cannonBlueGun")}, 30, 1000, 3),
    CannonIce(new Texture[]{quickLoad("cannonIceBase"), quickLoad("cannonIceGun")}, 30, 1000, 3);
    
    Texture[] textures;
    int damage, range;
    float firingSpeed;
    
    TowerType(Texture[] textures, int damage, int range, float firingSpeed){
        this.textures = textures;
        this.damage = damage;
        this.range = range;
        this.firingSpeed = firingSpeed;
    }
}
