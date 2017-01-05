/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import domain.Game;
import static helpers.Artist.*;
import static helpers.Clock.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public class Projectile {
    
    private Texture texture;
    private float x, y, width, height, speed, xVelocity, yVelocity;
    private int damage;
    private Enemy target;
    private boolean alive;
    
    public Projectile(Texture texture, Enemy target, float x, float y, float width, float height, float speed, int damage){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.damage = damage;
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
        
        if(target.getX() < x)
            xVelocity *= -1;
        if(target.getY() < y)
            yVelocity *= -1;
    }
    
    public void update() {
        if(alive){
            x += xVelocity * speed * delta();
            y += yVelocity * speed * delta();
            if(checkCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight())){
                target.damage(damage);
                alive = false;
            }
            draw();
        }
    }
    
    public void draw() {
        drawQuadTex(texture, x, y, 32, 32);
    }
}
