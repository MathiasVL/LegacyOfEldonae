/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import domain.Entity;
import domain.Map.Tile;
import static helpers.Artist.*;
import static helpers.Clock.delta;
import java.util.ArrayList;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public abstract class Tower implements Entity{

    private float x, y, timeSinceLastShot, firingSpeed, angle;
    private int width, height, damage, range;
    private Enemy target;
    private Texture[] textures;
    private ArrayList<Enemy> enemies;
    private boolean targeted;
    private ArrayList<Projectile> projectiles;
    
    public Tower(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {
        this.textures = type.textures;
        this.damage = type.damage;
        this.range = type.range;
        this.firingSpeed = type.firingSpeed;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = startTile.getWidth();
        this.height = startTile.getHeight();
        this.enemies = enemies;
        this.targeted = false;
        this.timeSinceLastShot = 0f;
        this.projectiles = new ArrayList<Projectile>();
        this.angle = 0f;
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
        double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
        return (float) Math.toDegrees(angleTemp) - 90;
    }
    
    public void shoot() {
        timeSinceLastShot = 0;
        projectiles.add(new ProjectileIceBall(quickLoad("bullet"), target, x + TILE_SIZE/2 - (TILE_SIZE/4) , y + TILE_SIZE/2 - (TILE_SIZE/4), PROJECTILE_SIZE, PROJECTILE_SIZE, 900, 10));
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
        drawQuadTex(textures[0], x, y, width, height);
        if(textures.length > 1)
            for(int i = 1; i < textures.length; i++)
                drawQuadTexRot(textures[i], x, y, width, height, angle);
    }
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public Enemy getTarget(){
        return target;
    }
}
