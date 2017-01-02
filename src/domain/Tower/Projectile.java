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
    private float x, y, Speed, xVelocity, yVelocity;
    private int Damage;
    private Enemy Target;
    
    public Projectile(Texture Texture, Enemy Target, float x, float y, float Speed, int Damage){
        this.Texture = Texture;
        this.x = x;
        this.y = y;
        this.Speed = Speed;
        this.Damage = Damage;
        this.Target = Target;
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
        x += xVelocity * Speed * Delta();
        y += yVelocity * Speed * Delta();
        Draw();
    }
    
    public void Draw() {
        DrawQuadTex(Texture, x, y, 32, 32);
    }
}
