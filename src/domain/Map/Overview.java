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
    
    private final int height = 9;
    private final int width = 9;
        
    private final int[][] overview = new int[width][height];

    public Overview() 
    {
        generateOverview();
    }  
    
    private int[][] generateOverview()
    {
        for(int i=0; i< width; i++)
        {
            for(int j=0; j<height; j++)
            {
                overview[i][j] = 0;                
            }
        }
        
        return overview;
    }
}
