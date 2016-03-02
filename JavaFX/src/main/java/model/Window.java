package model;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;


public class Window extends JFrame {

//    ButtonCells[][] buttonsPlayer = new ButtonCells[12][12];
//    ButtonCells[][] buttonsAI = new ButtonCells[12][12];

    int optionAI;
    int miss;
    int scorePlayer;
    int scoreAi;

    public Player player;
    public Ships ships;
    public Map map;
    public AiEpid aiEpid;
    public Sound sound;


    public void createGameField(final int[][] fieldPlayer, final int[][] fieldAI) throws IOException {
        ships.createShips2D(fieldPlayer);
        ships.createShips2D(fieldAI);



        int x = 1;
        int y = 1;
        for (int i = 1; i < 11; i++) {
            x++;
            y = 1;
            for (int j = 1; j < 11; j++) {
                y++;
//                button1 = new ButtonCells(x, y);
//                button2 = new ButtonCells(i, j);

//                buttonsPlayer[i][j] = button1;
//                buttonsAI[i][j] = button2;

//                panel1.add(buttonsPlayer[i][j]);
//                panel2.add(buttonsAI[i][j]);

                //<editor-fold desc="Выстрел по полю">
//                final ButtonCells finalButton = button2;
//                finalButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                        int x = finalButton.getX();
//                        int y = finalButton.getY();
//
//                        int check = player.playerShot2D(x, y, fieldAI);
//                        sound.playSound("src/sound/shot.wav", 2);
//                        switch (check) {
//                            case 1:
//                                finalButton.setBackground(Color.RED);
//                                resultShot.setText("Попал");
//                                scorePlayer++;
//                                break;
//                            case 2:
//                                finalButton.setBackground(Color.BLACK);
//                                resultShot.setText("Мимо");
//                                break;
//                            case 3:
//                                resultShot.setText("Было");
//                                miss = optionAI;
//                                optionAI = 4;
//                                break;
//                            case 4:
//                                finalButton.setBackground(Color.RED);
//                                sound.playSound("src/sound/boom1.wav", 6);
//                                scorePlayer++;
//                                resultShot.setText("Уничтожен");
//
//                        }
//                        switch (optionAI) {
//                            case 1:
//                                boolean s = shotAiEasily(fieldPlayer);
//                                if (s == true) {
//                                    scoreAi++;
//                                }
//                                break;
//                            case 2:
//                                shotAiNormal(fieldPlayer);
//                                break;
//                            case 3:
//                                shotAiHard(fieldPlayer);
//                                scoreAi++;
//                                break;
//                            case 4:
//                                optionAI = miss;
//                        }
//
//                        if (scorePlayer == 20) {
//                            System.out.println("Your WIn");
//                        }
//                        if (scoreAi == 20) {
//                            System.out.println("Вы проиграли");
//                        }
//
//                    }
//                });
                //</editor-fold>
            }
        }


//        drawingShipsField(fieldPlayer, buttonsPlayer);
//        drawingShipsField(fieldAI, buttonsAI);
    }


    // Покраска поля
//    public void drawingShipsField(int[][] shotFieldPlayer, ButtonCells[][] fieldPlayer) {
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 12; j++) {
//                int x = shotFieldPlayer[i][j];
//                switch (x) {
//                    case 1:
////                        ButtonCells but = fieldPlayer[i][j];
////                        but.setBackground(Color.ORANGE);
////                        fieldPlayer[i][j] = but;
//                }
//            }
//        }
//    }

////    public boolean paintingButtons(int x, int y, int check) {
//        ButtonCells button = buttonsPlayer[x][y];
//        switch (check) {
//            case 1:
//                button.setBackground(Color.RED);
//                return true;
//            case 2:
//                button.setBackground(Color.BLACK);
//        }
//        return false;
//    }

//     Выстрелы ИИ
    public boolean shotAiEasily(int[][] fieldPlayer) {
        while (true) {
            int shotAIx = aiEpid.randomNumber(1, 11);
            int shotAIy = aiEpid.randomNumber(1, 11);
            int check = player.playerShot2D(shotAIx, shotAIy, fieldPlayer);
            if (check == 1 || check == 2) {
//                paintingButtons(shotAIx, shotAIy, check);
                return true;
            }
        }
    }

    public void shotAiNormal(int[][] fieldPlayer) {

        while (true) {
            int a = aiEpid.randomNumber(1, 2);
            if (a == 1) {
                while (true) {
                    int shotAIx = aiEpid.randomNumber(1, 11);
                    int shotAIy = aiEpid.randomNumber(1, 11);
                    int check = player.playerShot2D(shotAIx, shotAIy, fieldPlayer);
                    if (check == 1 || check == 2) {
//                        paintingButtons(shotAIx, shotAIy, check);
                        return;
                    }
                }
            }

            if (a == 3 || a == 2) {
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        int check = fieldPlayer[i][j];
                        if (check == 1) {
//                            paintingButtons(i, j, check);
                            fieldPlayer[i][j] = 3;
                            return;
                        }
                    }
                }
            }
        }
    }

    public void shotAiHard(int[][] fieldPlayer) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                int check = fieldPlayer[i][j];
                if (check == 1) {
//                    paintingButtons(i, j, check);
                    fieldPlayer[i][j] = 3;
                    return;
                }
            }
        }
    }

    public void buttonVisible(JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }
}



