package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Sound {

    public void playSound(String way, int value) {
        try {
            File soundFile = new File(way);

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();

            clip.open(ais);

            FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            vc.setValue(value);

            clip.setFramePosition(0);

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
//        } catch (InterruptedException exc) {
        }
    }


}
