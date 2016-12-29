/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

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
    
    private float x,y, TimeSinceLastShot, FiringSpeed;
    private int Width, Height, Damage;
    private Texture BaseTexture, CannonTexture;
    private Tile StartTile;
    private ArrayList<Projectile> Projectiles;
    
    public TowerCannon(Texture BaseTexture, Tile StartTile, int Damage) {
        this.BaseTexture = BaseTexture;
        this.CannonTexture = QuickLoad("cannonGun");
        this.StartTile = StartTile;
        this.x = StartTile.getX();
        this.y = StartTile.getY();
        this.Width = (int) StartTile.getWidth();
        this.Height = (int) StartTile.getHeight();
        this.Damage = Damage;
        this.FiringSpeed = 3;
        this.TimeSinceLastShot = 0;
        this.Projectiles = new ArrayList<>();
    }
    
    private void Shoot() {
        TimeSinceLastShot = 0;
        Projectiles.add(new Projectile(QuickLoad("bullet"), x + 32, y + 32, 50, 10));
    }
    
    public void Update() {
        TimeSinceLastShot += Delta();
        if(TimeSinceLastShot > FiringSpeed)
            Shoot();
        
        for(Projectile P: Projectiles)
            P.Update();
        
        Draw();
    }
    
    public void Draw() {
        DrawQuadTex(BaseTexture, x, y, Width, Height);
        DrawQuadTexRot(CannonTexture, x, y, Width, Height, 45);
    }
}
