/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import domain.Map.Map;
import domain.Map.Tile;
import domain.Map.TileType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author mathi
 */
public class Leveler {
    
    public static void SaveMap(String MapName, Map MapGrid){
        String MapData = "";
        for(int i = 0; i < MapGrid.getTilesWide(); i++){
            for(int j = 0; j < MapGrid.getTilesHigh(); j++) {
                MapData += GetTileID(MapGrid.GetTile(i, j));
            }
        }
        
        try{
        File file = new File("MapName");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(MapData);
        bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Map LoadMap(String MapName){
        Map Map = new Map();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(MapName));
            String Data = br.readLine();
            
            for(int i = 0; i<Map.getTilesWide(); i++){
                for(int j = 0; j< Map.getTilesHigh(); j++){
                    Map.setTile(i, j, GetTileType(Data.substring(i * Map.getTilesHigh() + j , i * Map.getTilesHigh() + j + 1)));
                }
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
                
        return Map;
    }
    
    public static TileType GetTileType(String ID){
        TileType Type = TileType.NULL;
        
        switch(ID){
            case "0" : 
                Type = TileType.Grass;
                break;                
            case "1" : 
                Type = TileType.Dirt;
                break;                
            case "2" : 
                Type = TileType.Water;
                break;                
            case "3" : 
                Type = TileType.NULL;
                break;
        }
        
        return Type;
    }
    
    public static String GetTileID(Tile T){
        String ID = "E";
        
        switch(T.getType()){
            case Grass:
                ID="0";
                break;
            case Dirt:
                ID="1";
                break;
            case Water:
                ID="2";
                break;
            case NULL:
                ID="3";
                break;
        }
        
        return ID;
    }
    
}
