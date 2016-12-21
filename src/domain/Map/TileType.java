/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.Map;

/**
 *
 * @author mathi
 */
public enum TileType {
    
    Grass("grass64", true), Dirt("dirt64", false), Water("water64", false);
    
    String TextureName;
    boolean Buildable;
    
    TileType(String TextureName, boolean Buildable)
    {
        this.TextureName = TextureName;
        this.Buildable = Buildable;
    }
}
