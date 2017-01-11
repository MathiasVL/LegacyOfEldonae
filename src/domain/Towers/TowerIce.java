/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Towers;

import domain.Projectiles.ProjectileIceBall;
import domain.Characters.Enemy;
import domain.Map.Tile;
import static helpers.Artist.PROJECTILE_SIZE;
import static helpers.Artist.TILE_SIZE;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Mathi
 */
public class TowerIce extends Tower{
    
    public TowerIce(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
        super(type, startTile, enemies);
    }

    @Override
    public void shoot(Enemy target) {
        super.projectiles.add(new ProjectileIceBall(super.type.projectileType, super.target, super.getX() + TILE_SIZE/2 - (TILE_SIZE/4) , super.getY() + TILE_SIZE/2 - (TILE_SIZE/4), PROJECTILE_SIZE, PROJECTILE_SIZE));
    }    
}
