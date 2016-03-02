package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Sound {

    public void playSound(String way, int value) {
        try {
            File soundFile = new File(way);
//            File soundFile = new File("src/sound/das.wav");

            //�������� AudioInputStream
            //��� ��� ����� �������� IOException � UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            //�������� ���������� ���������� Clip
            //����� �������� LineUnavailableException
            Clip clip = AudioSystem.getClip();

            //��������� ��� �������� ����� � Clip
            //����� �������� IOException � LineUnavailableException
            clip.open(ais);

            //�������� ���������� ���������
            FloatControl vc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            //������������� ��������
            //��� ������ ���� � �������� �� vc.getMinimum() �� vc.getMaximum()

            vc.setValue(value); //������ ��������

            clip.setFramePosition(0); //������������� ��������� �� �����
            clip.start(); //�������!!!

            //���� �� �������� ������ �������, �� ����� ���������, ���� ���� �� ����������
            //� GUI-����������� ��������� 3 ������� �� �����������

//            Thread.sleep(clip.getMicrosecondLength() / 1300);
//            clip.stop(); //�������������
//            clip.close(); //���������

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
//        } catch (InterruptedException exc) {
        }
    }


}
