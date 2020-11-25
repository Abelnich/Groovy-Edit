/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Music;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Sheku
 */
public class MusicPlayer {
    static MusicPlayer player = new MusicPlayer();
    static Clip clip;
    
    
    private MusicPlayer()
    {
        
    }
    
    
    public static MusicPlayer getInstance()
    {
        return player;
    }
    
        public static void loadMusic(String filePath)
    {
        try
        {
            File musicPath = new File(filePath);
            
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                System.out.println("Initilized");
            }
        } 
        catch (Exception e)
        {
            System.out.println(e);
        } 
    }
}
