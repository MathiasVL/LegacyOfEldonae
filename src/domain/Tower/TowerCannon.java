/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import domain.Characters.Enemy;
import domain.Game;
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
    
    private float x,y, TimeSinceLastShot, FiringSpeed, Angle;
    private int Width, Height, Damage, Range;
    private Texture BaseTexture, CannonTexture;
    private Tile StartTile;
    private ArrayList<Projectile> Projectiles;
    private ArrayList<Enemy> Enemies;
    private Enemy Target;
    private boolean Targeted;
    
    public TowerCannon(Texture BaseTexture, Tile StartTile, int Damage, int Range, ArrayList<Enemy> Enemies) {
        this.BaseTexture = BaseTexture;
        this.CannonTexture = QuickLoad("cannonGun");
        this.StartTile = StartTile;
        this.x = StartTile.getX();
        this.y = StartTile.getY();
        this.Width = (int) StartTile.getWidth();
        this.Height = (int) StartTile.getHeight();
        this.Damage = Damage;
        this.Range = Range;
        this.FiringSpeed = 3;
        this.TimeSinceLastShot = 0;
        this.Projectiles = new ArrayList<>();
        this.Enemies = Enemies;
        this.Targeted = false;
        //this.Target = AcquireTarget();
        //this.Angle = CalculateAngle();
    }
    
    private Enemy AcquireTarget() {
        Enemy Closest = null;
        
        float ClosestDistance = 10000;
        for(Enemy e : Enemies){
            if(IsInRange(e) && FindDistance(e) < ClosestDistance){
                ClosestDistance = FindDistance(e);
                Closest = e;
            }                
        }
        if(Closest != null)
            Targeted = true;
        return  Closest;
    }
    
    private boolean IsInRange(Enemy e){
        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);
        
        if(xDistance < Range && yDistance < Range)
            return true;
        else
            return false;
    }
    
    private float FindDistance(Enemy e){
        float xDistance = Math.abs(e.getX() - x);
        float yDistance = Math.abs(e.getY() - y);
        
        return xDistance + yDistance;
    }
    
    private float CalculateAngle() {
        double AngleTemp = Math.atan2(Target.getY() - y, Target.getX() - x);
        return (float) Math.toDegrees(AngleTemp) - 90;
    }
    
    private void Shoot() {
        TimeSinceLastShot = 0;
        Projectiles.add(new Projectile(QuickLoad("bullet"), Target, x + Game.TILE_SIZE/2 - (Game.TILE_SIZE/4) , y + Game.TILE_SIZE/2 - (Game.TILE_SIZE/4), Game.PROJECTILE_SIZE, Game.PROJECTILE_SIZE, 900, 10));
    }
    
    public void UpdateEnemyList(ArrayList<Enemy> NewList){
        Enemies = NewList;
    }
    
    public void Update() {
        if(!Targeted){
            Target = AcquireTarget();
        }
        
        if(Target == null || Target.IsAlive() == false)
            Targeted = false;
            
        TimeSinceLastShot += Delta();
        if(TimeSinceLastShot > FiringSpeed)
            Shoot();
        
        for(Projectile P: Projectiles)
            P.Update();
        
        Angle = CalculateAngle();
        Draw();
    }
    
    public void Draw() {
        DrawQuadTex(BaseTexture, x, y, Width, Height);
        DrawQuadTexRot(CannonTexture, x, y, Width, Height, Angle);
    }
}
