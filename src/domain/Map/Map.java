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
    
    private final int Height = 99;
    private final int Width = 99;
    
    private final int[][] Map = new int[Width][Height];

    public Map() 
    {
        GenerateMap();
    }  
    
    public int[][] getMap() 
    {
        return Map;
    }
        
    private int[][] GenerateMap()
    {
        for(int i=0; i< Width; i++)
        {
            for(int j=0; j<Height; j++)
            {
                Map[i][j] = 0;                
            }
        }
        
        return Map;
    }
}
