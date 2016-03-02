package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Sound {

    public void playSound(String way, int value) {
        try {
            File soundFile = new File(way);
//            File soundFile = new File("src/sound/das.wav");

            //Получаем AudioInputStream
            //Вот тут могут полететь IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            //Получаем реализацию интерфейса Clip
            //Может выкинуть LineUnavailableException
            Clip clip = AudioSystem.getClip();

            //Загружаем наш звуковой поток в Clip
            //Может выкинуть IOException и LineUnavailableException
            clip.open(ais);

            //Получаем контроллер громкости
            FloatControl vc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            //Устанавливаем значение
            //Оно должно быть в пределах от vc.getMinimum() до vc.getMaximum()

            vc.setValue(value); //Громче обычного

            clip.setFramePosition(0); //устанавливаем указатель на старт
            clip.start(); //Поехали!!!

            //Если не запущено других потоков, то стоит подождать, пока клип не закончится
            //В GUI-приложениях следующие 3 строчки не понадобятся

//            Thread.sleep(clip.getMicrosecondLength() / 1300);
//            clip.stop(); //Останавливаем
//            clip.close(); //Закрываем

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
//        } catch (InterruptedException exc) {
        }
    }


}
