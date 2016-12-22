/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import org.lwjgl.Sys;

/**
 *
 * @author mathi
 */
public class Clock {
    
    private static boolean Paused = false;
    public static long LastFrame, TotalTime;
    public static float d=0, Multiplier = 1;
    
    public static long getTime() {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
    
    public static float getDelta() {
        long CurrentTime = getTime();
        int Delta = (int) (CurrentTime - LastFrame);
        LastFrame = getTime();
        return Delta *0.01f;
    }
    
    public static float Delta()
    {
        if(Paused)
            return 0;
        else
            return d * Multiplier;        
    }
    
    public static float TotalTime()
    {
        return TotalTime;
    }
    
    public static float Multiplier()
    {
        return Multiplier;
    }
    
    public static void Update(){
        d = getDelta();
        TotalTime += d;
    }
    
    public static void ChangeMultiplier(int Change)
    {
        if(Multiplier + Change < -1 && Multiplier + Change > 7)
        {            
        }else {
            Multiplier += Change;
        }
    }
    
    public static void Pause()
    {
        if(Paused)
            Paused = false;
        else
            Paused = true;
    }
}
