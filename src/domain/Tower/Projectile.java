/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Tower;

import static helpers.Clock.*;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Home
 */
public class Projectile {
    
    private Texture Texture;
    private float x, y, Speed;
    private int Damage;
    
    public Projectile(Texture Texture, float x, float y, float Speed, int Damage){
        this.Texture = Texture;
        this.x = x;
        this.y = y;
        this.Speed = Speed;
        this.Damage = Damage;
    }
    
    public void Update() {
        x += Delta() * Speed;
        Draw();
    }
    
    public void Draw() {
        DrawQuadTex(Texture, x, y, 32, 32);
    }
}
