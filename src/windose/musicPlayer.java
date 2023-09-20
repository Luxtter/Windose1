/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windose;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author luxte
 */
public class musicPlayer {
    private boolean isPaused;
    private boolean isLooping = false;
    private Clip clip;
    private String filePath;

    public musicPlayer() {
    }

    public musicPlayer(String filePath) {
        this.filePath = filePath;
    }

    public void playMusic() {
        
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
        }
        
        try 
        {
            File file = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            
            if (isLooping) 
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            clip.start();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    
    public void pauseMusic() 
    {
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
            isPaused = true;
            
        } 
        else if (clip != null && isPaused) 
        {
            clip.start();
            
            if(isLooping)
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            isPaused = false;
            
        }
    }
    public void toggleLoop() 
    {
        isLooping = !isLooping;
        if (isLooping) 
        {
           
            
            if(clip.isRunning())
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } 
        }
        else 
        {
            

            if(clip.isRunning())
            {
                clip.loop(0);
            }
        }
    }
}
