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
public class HiloMusica extends Thread {

    private String filepath;
    private boolean active;
    private Clip clip;

    public HiloMusica(String filepath,boolean active) {
        this.filepath = filepath;
        this.active = active;
    }

    @Override
    public void run() {
        if (active) {
            clip.stop();
            clip.close();
            active=false;
        } else {
            try {
                File musicPath = new File(filepath);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    active = true;
                } else {
                    System.out.println("Cant find file");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
