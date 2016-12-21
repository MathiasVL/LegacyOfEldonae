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
public class Map {
      
    private Tile[][] Map;

    public Map() 
    {
        Map = new Tile[20][15];
        for(int i = 0; i<Map.length; i++)
        {
            for(int j = 0; j<Map[i].length; j++)
            {
                Map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Grass);
            }
        }
    }  
    
    public Map(int[][] NewMap) 
    {
        Map = new Tile[20][15];
        for(int i = 0; i<Map.length; i++)
        {
            for(int j = 0; j<Map[i].length; j++)
            {
                switch(NewMap[j][i])
                {
                    case 0 : Map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Grass);
                             break;
                             
                    case 1 : Map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Dirt);
                             break;
                             
                    case 2 : Map[i][j] = new Tile(i*64, j*64, 64, 64, TileType.Water);
                             break;
                }                
            }
        }
    } 
    
    public void Draw()            
    {
        for(int i = 0; i < Map.length; i++)
        {
            for(int j = 0; j < Map[i].length; j++)
            {
                Tile t = Map[i][j];
                t.Draw();
            }
        }
    }
}
