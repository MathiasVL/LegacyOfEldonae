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
public class Overview {
    
    private final int Height = 9;
    private final int Width = 9;
        
    private final int[][] Overview = new int[Width][Height];

    public Overview() 
    {
        GenerateOverview();
    }  
    
    private int[][] GenerateOverview()
    {
        for(int i=0; i< Width; i++)
        {
            for(int j=0; j<Height; j++)
            {
                Overview[i][j] = 0;                
            }
        }
        
        return Overview;
    }
}
