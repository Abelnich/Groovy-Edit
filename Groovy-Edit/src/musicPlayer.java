/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Sheku
 */
public class musicPlayer {

    static musicPlayer player = new musicPlayer(); //helo
    static Clip clip;

    public musicPlayer() {}

    public static musicPlayer getInstance() {
        return player;
    }

    public static void loadMusic(String filePath) {
        try {
            File musicPath = new File(filePath);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                System.out.println("Initilized");
            }
        } catch (Exception e) {
            System.out.println(e);
        } // end try
    } // end loadMusic()
} // end class
