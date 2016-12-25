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
    private int TilesWide, TilesHigh;    

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
        this.TilesWide = NewMap[0].length;
        this.TilesHigh = NewMap.length;
   
        Map = new Tile[TilesWide][TilesHigh];
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
    
    public void setTile(int xCoord, int yCoord, TileType Type)
    {
        Map[xCoord][yCoord] = new Tile(xCoord*64, yCoord*64, 64, 64, Type);        
    }
    
    public Tile GetTile(int xPlace, int yPlace)
    {        
        if(xPlace < TilesWide && yPlace < TilesHigh && xPlace > -1 && yPlace > -1)
            return Map[xPlace][yPlace];
        else
            return new Tile(0,0,0,0,TileType.NULL);
    }
    
    public void Draw()            
    {
        for(int i = 0; i < Map.length; i++)
        {
            for(int j = 0; j < Map[i].length; j++)
            {
                Map[i][j].Draw();
            }
        }
    }

    public int getTilesWide() {
        return TilesWide;
    }

    public void setTilesWide(int TilesWide) {
        this.TilesWide = TilesWide;
    }

    public int getTilesHigh() {
        return TilesHigh;
    }

    public void setTilesHigh(int TilesHigh) {
        this.TilesHigh = TilesHigh;
    }
    
    
}
