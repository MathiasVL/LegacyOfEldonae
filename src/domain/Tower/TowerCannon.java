/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import domain.Map.Tile;
import static helpers.Artist.*;
import static helpers.Clock.*;
import java.util.ArrayList;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public class TowerCannon {
    
    private float x,y, timeSinceLastShot, firingSpeed, angle;
    private int width, height, damage, range;
    private Texture baseTexture, cannonTexture;
    private Tile startTile;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Enemy> enemies;
    private Enemy target;
    private boolean targeted;
    
    public TowerCannon(Texture baseTexture, Tile startTile, int damage, int range, ArrayList<Enemy> enemies) {
        this.baseTexture = baseTexture;
        this.cannonTexture = quickLoad("cannonGun");
        this.startTile = startTile;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = (int) startTile.getWidth();
        this.height = (int) startTile.getHeight();
        this.damage = damage;
        this.range = range;
        this.firingSpeed = 3;
        this.timeSinceLastShot = 0;
        this.projectiles = new ArrayList<>();
        this.enemies = enemies;
        this.targeted = false;
        //this.Target = AcquireTarget();
        //this.Angle = CalculateAngle();
    }
    
    private Enemy acquireTarget() {
        Enemy closest = null;
        
        float closestDistance = 10000;
        for(Enemy e : enemies){
            if(isInRange(e) && findDistance(e) < closestDistance){
                closestDistance = findDistance(e);
                closest = e;
            }                
        }
        if(closest != null)
            targeted = true;
        return  closest;
    }
    
    private boolean isInRange(Enemy e){
        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);
        
        if(xDistance < range && yDistance < range)
            return true;
        else
            return false;
    }
    
    private float findDistance(Enemy e){
        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);
        
        return xDistance + yDistance;
    }
    
    private float calculateAngle() {
        double AngleTemp = Math.atan2(target.getY() - y, target.getX() - x);
        return (float) Math.toDegrees(AngleTemp) - 90;
    }
    
    private void shoot() {
        timeSinceLastShot = 0;
        projectiles.add(new Projectile(quickLoad("bullet"), target, x + TILE_SIZE/2 - (TILE_SIZE/4) , y + TILE_SIZE/2 - (TILE_SIZE/4), PROJECTILE_SIZE, PROJECTILE_SIZE, 900, 10));
    }
    
    public void updateEnemyList(ArrayList<Enemy> newList){
        enemies = newList;
    }
    
    public void update() {
        if(!targeted){
            target = acquireTarget();
        }
        
        if(target == null || target.isAlive() == false)
            targeted = false;
            
        timeSinceLastShot += delta();
        if(timeSinceLastShot > firingSpeed)
            shoot();
        
        for(Projectile p: projectiles)
            p.update();
        
        angle = calculateAngle();
        draw();
    }
    
    public void draw() {
        drawQuadTex(baseTexture, x, y, width, height);
        drawQuadTexRot(cannonTexture, x, y, width, height, angle);
    }
}
