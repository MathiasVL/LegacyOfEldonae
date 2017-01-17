/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Towers;

import domain.Projectiles.ProjectileType;
import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
/**
 *
 * @author mathi
 */
public enum TowerType {
 
    CannonRed(new Texture[]{quickLoad("cannonBase"), quickLoad("cannonGun")}, ProjectileType.CannonBall, 10, 1000, 3, 0),
    CannonBlue(new Texture[]{quickLoad("cannonBlueBase"),quickLoad("cannonBlueGun")}, ProjectileType.CannonBall, 30, 1000, 3, 15),
    CannonIce(new Texture[]{quickLoad("cannonIceBase"), quickLoad("cannonIceGun")}, ProjectileType.IceBall, 30, 1000, 3, 20);
    
    Texture[] textures;
    ProjectileType projectileType;
    int damage, range, cost;
    float firingSpeed;
    
    TowerType(Texture[] textures, ProjectileType projectileType, int damage, int range, float firingSpeed, int cost){
        this.textures = textures;
        this.projectileType = projectileType;
        this.damage = damage;
        this.range = range;
        this.firingSpeed = firingSpeed;
        this.cost = cost;
    }
}
