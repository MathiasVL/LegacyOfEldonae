/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Projectiles;

import domain.Characters.Enemy;
import domain.Entity;
import static helpers.Artist.*;
import static helpers.Clock.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public abstract class Projectile implements Entity {
    
    private Texture texture;
    private float x, y, speed, xVelocity, yVelocity;
    private int width, height;
    private int damage;
    private Enemy target;
    private boolean alive;
    
    public Projectile(ProjectileType projectileType, Enemy target, float x, float y, int width, int height){
        this.texture = projectileType.texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = projectileType.speed;
        this.damage = projectileType.damage;
        this.target = target;
        this.alive = true;
        this.xVelocity = 0f;
        this.yVelocity = 0f;
        calculateDirection();
    }
    
    private void calculateDirection() {
        float totalAllowedMovement = 1.0f;
        float xDistanceFromTarget = Math.abs(target.getX() - x - TILE_SIZE/4 + TILE_SIZE/2);
        float yDistanceFromTarget = Math.abs(target.getY() - y - TILE_SIZE/4 + TILE_SIZE/2);
        float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
        float xPercentofMovement = xDistanceFromTarget / totalDistanceFromTarget;        
        xVelocity = xPercentofMovement;
        yVelocity = totalAllowedMovement - xPercentofMovement;
        
        //set direction based on position of target relative to tower
        if(target.getX() < x)
            xVelocity *= -1;
        if(target.getY() < y)
            yVelocity *= -1;
    }
    
    //deal damage to enemy
    public void doDamage() {
        target.damage(damage);
        alive = false;
    }
    
    public void update() {
        if(alive){
            calculateDirection();
            x += xVelocity * speed * delta();
            y += yVelocity * speed * delta();
            if(checkCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight())){
                doDamage();
            }
            draw();
        }
    }
    
    public void draw() {
        drawQuadTex(texture, x, y, 32, 32);
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
    
    public void setAlive(boolean status){
        alive = status;
    }
}
