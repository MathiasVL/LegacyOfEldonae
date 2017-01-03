/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import domain.Game;
import static helpers.Clock.*;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public class Projectile {
    
    private Texture Texture;
    private float x, y, Width, Height, Speed, xVelocity, yVelocity;
    private int Damage;
    private Enemy Target;
    private boolean Alive;
    
    public Projectile(Texture Texture, Enemy Target, float x, float y, float Width, float Height, float Speed, int Damage){
        this.Texture = Texture;
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
        this.Speed = Speed;
        this.Damage = Damage;
        this.Target = Target;
        this.Alive = true;
        this.xVelocity = 0f;
        this.yVelocity = 0f;
        CalculateDirection();
    }
    
    private void CalculateDirection() {
        float TotalAllowedMovement = 1.0f;
        float xDistanceFromTarget = Math.abs(Target.getX() - x - Game.TILE_SIZE/4 + Game.TILE_SIZE/2);
        float yDistanceFromTarget = Math.abs(Target.getY() - y - Game.TILE_SIZE/4 + Game.TILE_SIZE/2);
        float TotalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
        float xPercentofMovement = xDistanceFromTarget / TotalDistanceFromTarget;        
        xVelocity = xPercentofMovement;
        yVelocity = TotalAllowedMovement - xPercentofMovement;
        
        if(Target.getX() < x)
            xVelocity *= -1;
        if(Target.getY() < y)
            yVelocity *= -1;
    }
    
    public void Update() {
        if(Alive){
            x += xVelocity * Speed * Delta();
            y += yVelocity * Speed * Delta();
            if(CheckCollision(x, y, Width, Height, Target.getX(), Target.getY(), Target.getWidth(), Target.getHeight())){
                Target.Damage(Damage);
                Alive = false;
            }
            Draw();
        }
    }
    
    public void Draw() {
        DrawQuadTex(Texture, x, y, 32, 32);
    }
}
