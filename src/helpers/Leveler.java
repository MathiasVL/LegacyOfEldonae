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
    
    public static void saveMap(String mapName, Map mapGrid){
        String mapData = "";
        for(int i = 0; i < mapGrid.getTilesWide(); i++){
            for(int j = 0; j < mapGrid.getTilesHigh(); j++) {
                mapData += getTileID(mapGrid.getTile(i, j));
            }
        }
        
        try{
        File file = new File("MapName");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(mapData);
        bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Map loadMap(String mapName){
        Map map = new Map();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(mapName));
            String Data = br.readLine();
            
            for(int i = 0; i<map.getTilesWide(); i++){
                for(int j = 0; j< map.getTilesHigh(); j++){
                    map.setTile(i, j, getTileType(Data.substring(i * map.getTilesHigh() + j , i * map.getTilesHigh() + j + 1)));
                }
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
                
        return map;
    }
    
    public static TileType getTileType(String ID){
        TileType type = TileType.NULL;
        
        switch(ID){
            case "0" : 
                type = TileType.Grass;
                break;                
            case "1" : 
                type = TileType.Dirt;
                break;                
            case "2" : 
                type = TileType.Water;
                break;                
            case "3" : 
                type = TileType.NULL;
                break;
        }
        
        return type;
    }
    
    public static String getTileID(Tile t){
        String ID = "E";
        
        switch(t.getType()){
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
