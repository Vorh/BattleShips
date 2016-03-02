package model;

import model.*;
import view.ButtonCells;
import view.JPanelImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;


public class Window extends JFrame {

    ButtonCells[][] buttonsPlayer = new ButtonCells[12][12];
    ButtonCells[][] buttonsAI = new ButtonCells[12][12];

    int optionAI;
    int miss;
    int scorePlayer;
    int scoreAi;

    public Player player;
    public Ships ships;
    public Map map;
    public AiEpid aiEpid;
    public Sound sound;

    final JFrame jFrameStartMenu = new JFrame();
    JFrame jFrameGameField = new JFrame();
    JDialog jFrameGameMenuPause = new JDialog();

    JTextField resultShot = new JTextField();

    // Меню
    public void createStartMenu(final int[][] fieldPlayer, final int[][] fieldAI) {

        //<editor-fold desc="Frame">
        jFrameStartMenu.setSize(300, 300);
        jFrameStartMenu.setUndecorated(true);
        jFrameStartMenu.setVisible(true);
        jFrameStartMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrameStartMenu.setTitle("Ocean Battles");
        jFrameStartMenu.setLayout(new BorderLayout());
        jFrameStartMenu.setResizable(false);
        jFrameStartMenu.setLocationRelativeTo(null);
        //</editor-fold>

        JPanelImage jPanelImage = new JPanelImage();
        jPanelImage.setImageFile(new File("src/img/bagMenu1.jpg"));
        JPanel panelBut = new JPanel(new GridBagLayout());
        panelBut.setOpaque(false);
        panelBut.setSize(300, 250);

        GridBagConstraints s = new GridBagConstraints();

        sound.playSound("src/sound/menu.wav", 6);

        //<editor-fold desc="Main menu">
        s.fill = GridBagConstraints.BOTH;
        s.gridy = 1;
        s.gridx = 1;
        s.insets = new Insets(10, 0, 0, 0);

        final JButton button1 = new JButton();

        button1.setIcon(new ImageIcon("src/img/start.jpg"));
        buttonVisible(button1);
        panelBut.add(button1, s);


        final JButton button2 = new JButton();
        s.gridy = 2;
        button2.setIcon(new ImageIcon("src/img/regBut.jpg"));
        buttonVisible(button2);
        panelBut.add(button2, s);

        final JButton button3 = new JButton();
        s.gridy = 3;
        button3.setIcon(new ImageIcon("src/img/exitBut.jpg"));
        buttonVisible(button3);
        panelBut.add(button3, s);
        //</editor-fold>

        //<editor-fold desc="Mode Game">
        s.fill = GridBagConstraints.BOTH;
        s.gridy = 1;
        s.gridx = 1;
        s.insets = new Insets(15, 0, 0, 0);

        final JButton button4 = new JButton();
        button4.setIcon((new ImageIcon("src/img/single.jpg")));
        button4.setVisible(false);
        buttonVisible(button4);
        panelBut.add(button4, s);

        final JButton button5 = new JButton();
        s.gridy = 2;
        button5.setIcon((new ImageIcon("src/img/only.jpg")));
        button5.setVisible(false);
        buttonVisible(button5);
        panelBut.add(button5, s);

        final JButton button6 = new JButton();
        s.gridy = 3;
        button6.setVisible(false);
        button6.setIcon((new ImageIcon("src/img/back.jpg")));
        buttonVisible(button6);
        panelBut.add(button6, s);
        //</editor-fold>

        //<editor-fold desc="Choice of Difficulty">
        s.fill = GridBagConstraints.BOTH;
        s.gridy = 1;
        s.gridx = 1;
        s.insets = new Insets(15, 0, 0, 0);

        final JButton easily = new JButton();

        easily.setVisible(false);
        easily.setIcon((new ImageIcon("src/img/easily.jpg")));
        buttonVisible(easily);
        panelBut.add(easily, s);

        final JButton normal = new JButton();
        s.gridy = 2;
        panelBut.add(normal, s);
        normal.setVisible(false);
        normal.setIcon((new ImageIcon("src/img/normal.jpg")));
        buttonVisible(normal);

        final JButton cheater = new JButton();
        s.gridy = 3;
        cheater.setVisible(false);
        cheater.setIcon((new ImageIcon("src/img/cheater.jpg")));
        buttonVisible(cheater);
        panelBut.add(cheater, s);

        final JButton back = new JButton();
        s.gridy = 4;
        back.setVisible(false);
        back.setIcon((new ImageIcon("src/img/backMenu.jpg")));
        buttonVisible(back);
        panelBut.add(back, s);
        //</editor-fold>

        //<editor-fold desc="AC Main Menu">
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                button1.setVisible(false);
                button2.setVisible(false);
                button3.setVisible(false);
                button4.setVisible(true);
                button5.setVisible(true);
                button6.setVisible(true);
                easily.setVisible(false);
                normal.setVisible(false);
                cheater.setVisible(false);
                back.setVisible(false);

            }
        });
        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                regulations();
            }
        });

        button3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                System.exit(0);
            }
        });
        //</editor-fold>

        //<editor-fold desc="AC Mode Game">
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                button4.setVisible(false);
                button5.setVisible(false);
                button6.setVisible(false);
                button1.setVisible(false);
                button2.setVisible(false);
                button3.setVisible(false);
                normal.setVisible(true);
                easily.setVisible(true);
                cheater.setVisible(true);
                back.setVisible(true);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                button4.setVisible(false);
                button5.setVisible(false);
                button6.setVisible(false);
                button1.setVisible(true);
                button2.setVisible(true);
                button3.setVisible(true);
                normal.setVisible(false);
                easily.setVisible(false);
                cheater.setVisible(false);
                back.setVisible(false);

            }
        });
        //</editor-fold>

        //<editor-fold desc="AC Choice of Difficulty">
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                button1.setVisible(false);
                button2.setVisible(false);
                button3.setVisible(false);
                button4.setVisible(true);
                button5.setVisible(true);
                button6.setVisible(true);
                easily.setVisible(false);
                normal.setVisible(false);
                cheater.setVisible(false);
                back.setVisible(false);
            }
        });
        easily.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                jFrameStartMenu.setVisible(false);
                optionAI = 1;
                try {
                    createGameField(fieldPlayer, fieldAI);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                jFrameStartMenu.setVisible(false);
                optionAI = 2;
                try {
                    createGameField(fieldPlayer, fieldAI);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        cheater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                jFrameStartMenu.setVisible(false);
                optionAI = 3;
                try {
                    createGameField(fieldPlayer, fieldAI);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
            }
        });
        //</editor-fold>


        // Ворх не зыбывай про баг с размером окна (если повторно не изменить размер, элменты не отобразятся)
        panelBut.setSize(300, 250);

        jPanelImage.add(panelBut, BorderLayout.CENTER);
        jFrameStartMenu.getContentPane().add(jPanelImage, BorderLayout.CENTER);
        jFrameStartMenu.setSize(301, 271);
    }

    public void createGameMenuPause() {
        //<editor-fold desc="Frame">
        jFrameGameMenuPause.setSize(300, 300);
        jFrameGameMenuPause.setUndecorated(true);
        jFrameGameMenuPause.setLocationRelativeTo(null);
        jFrameGameMenuPause.setLocation(590, 200);
        jFrameGameMenuPause.setVisible(true);
        jFrameGameMenuPause.setResizable(true);
        jFrameGameMenuPause.setTitle("Ocean Battles");
        jFrameGameMenuPause.setLayout(new BorderLayout());
        jFrameGameMenuPause.setResizable(false);
        //</editor-fold>

        JPanelImage jPanelImage = new JPanelImage();
        jPanelImage.setImageFile(new File("src/img/bagMenu1.jpg"));
        JPanel panelBut = new JPanel(new GridBagLayout());
        panelBut.setOpaque(false);
        panelBut.setSize(300, 250);

        //<editor-fold desc="Button setting">
        GridBagConstraints s = new GridBagConstraints();

        s.fill = GridBagConstraints.BOTH;
        s.gridy = 1;
        s.gridx = 1;
        s.insets = new Insets(10, 0, 0, 0);

        final JButton pause = new JButton();
        pause.setIcon(new ImageIcon("src/img/pause.jpg"));
        buttonVisible(pause);
        panelBut.add(pause, s);

        final JButton musicOF = new JButton();
        s.gridy = 2;
        musicOF.setIcon(new ImageIcon("src/img/sound.jpg"));
        buttonVisible(musicOF);
        panelBut.add(musicOF, s);

        final JButton exitMainMenu = new JButton();
        s.gridy = 3;
        exitMainMenu.setIcon(new ImageIcon("src/img/exitGame.jpg"));
        buttonVisible(exitMainMenu);
        panelBut.add(exitMainMenu, s);
        //</editor-fold>


        //<editor-fold desc="Action Listener">
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                jFrameGameMenuPause.setVisible(false);
                jFrameGameField.setEnabled(true);

            }
        });

        musicOF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
            }
        });

        exitMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
                sound.playSound("src/sound/click.wav", 6);
            }
        });
        //</editor-fold>

        panelBut.setSize(300, 250);
        jPanelImage.add(panelBut, BorderLayout.CENTER);
        jFrameGameMenuPause.getContentPane().add(jPanelImage, BorderLayout.CENTER);
        jFrameGameMenuPause.setSize(300, 271);
        //</editor-fold>
    }

    public void createGameField(final int[][] fieldPlayer, final int[][] fieldAI) throws IOException {
        createGameMenuPause();
        ships.createShips2D(fieldPlayer);
        ships.createShips2D(fieldAI);

        //<editor-fold desc="Frame">
        jFrameGameField.setSize(900, 500);
        jFrameGameField.setUndecorated(true);
        jFrameGameField.setVisible(true);
        jFrameGameField.setResizable(false);
        jFrameGameField.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrameGameField.setTitle("GameField");
        jFrameGameField.setLocationRelativeTo(null);

        JPanelImage panel1 = new JPanelImage();
        JPanelImage panel2 = new JPanelImage();
        JPanelImage panel3 = new JPanelImage();

        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel1.setSize(401, 500);
        panel2.setSize(401, 500);
        panel3.setSize(101, 500);

        JPanelImage jPanelImage = new JPanelImage();
        jPanelImage.setLayout(new BorderLayout());
//        jPanelImage.setImageFile(new File("src/img/fieldBag.jpg"));

        jPanelImage.add(panel1, BorderLayout.WEST);
        jPanelImage.add(panel2, BorderLayout.EAST);
        jPanelImage.add(panel3, BorderLayout.CENTER);

        ButtonCells button1;
        ButtonCells button2;

        panel1.setLayout(new GridLayout(10, 10, 7, 7));
        panel2.setLayout(new GridLayout(10, 10, 7, 7));
        panel3.setLayout(new GridBagLayout());
        //</editor-fold>

        //<editor-fold desc="Buttons and Text Field">

        JButton menu = new JButton("Меню");

        GridBagConstraints s = new GridBagConstraints();
        resultShot.setEnabled(false);
        resultShot.setBackground(Color.white);
        resultShot.setForeground(Color.RED);
        resultShot.setHorizontalAlignment(JTextField.CENTER);
        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridx = 0;
        s.gridy = 0;
        s.ipadx = 0;
        s.ipady = 10;
        s.insets = new Insets(10, 0, 130, 0);
        panel3.add(menu, s);
        s.gridx = 0;
        s.gridy = 1;
        s.insets = new Insets(0, 0, 180, 0);
        panel3.add(resultShot, s);


        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound.playSound("src/sound/click.wav", 6);
                jFrameGameMenuPause.setVisible(true);
                jFrameGameField.setEnabled(false);
            }
        });
        //</editor-fold>


        int x = 1;
        int y = 1;
        for (int i = 1; i < 11; i++) {
            x++;
            y = 1;
            for (int j = 1; j < 11; j++) {
                y++;
                button1 = new ButtonCells(x, y);
                button2 = new ButtonCells(i, j);

                button1.setPreferredSize(new Dimension(35, 20));
                button2.setPreferredSize(new Dimension(35, 20));
                buttonsPlayer[i][j] = button1;
                buttonsAI[i][j] = button2;

                panel1.add(buttonsPlayer[i][j]);
                panel2.add(buttonsAI[i][j]);

                //<editor-fold desc="Выстрел по полю">
                final ButtonCells finalButton = button2;
                finalButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int x = finalButton.getX();
                        int y = finalButton.getY();

                        int check = player.playerShot2D(x, y, fieldAI);
                        sound.playSound("src/sound/shot.wav", 2);
                        switch (check) {
                            case 1:
                                finalButton.setBackground(Color.RED);
                                resultShot.setText("Попал");
                                scorePlayer++;
                                break;
                            case 2:
                                finalButton.setBackground(Color.BLACK);
                                resultShot.setText("Мимо");
                                break;
                            case 3:
                                resultShot.setText("Было");
                                miss = optionAI;
                                optionAI = 4;
                                break;
                            case 4:
                                finalButton.setBackground(Color.RED);
                                sound.playSound("src/sound/boom1.wav", 6);
                                scorePlayer++;
                                resultShot.setText("Уничтожен");

                        }
                        switch (optionAI) {
                            case 1:
                                boolean s = shotAiEasily(fieldPlayer);
                                if (s == true) {
                                    scoreAi++;
                                }
                                break;
                            case 2:
                                shotAiNormal(fieldPlayer);
                                break;
                            case 3:
                                shotAiHard(fieldPlayer);
                                scoreAi++;
                                break;
                            case 4:
                                optionAI = miss;
                        }

                        if (scorePlayer == 20) {
                            System.out.println("Your WIn");
                        }
                        if (scoreAi == 20) {
                            System.out.println("Вы проиграли");
                        }

                    }
                });
                //</editor-fold>
            }
        }


        jFrameGameField.getContentPane().add(jPanelImage, BorderLayout.CENTER);
        drawingShipsField(fieldPlayer, buttonsPlayer);
//        drawingShipsField(fieldAI, buttonsAI);
        jFrameGameField.setSize(1000, 501);
    }

    public void regulations() {
        JPanelImage jPanelImage = new JPanelImage();
        JFrame reg = new JFrame();
        reg.setName("Правила");
        reg.setVisible(true);
        reg.setResizable(false);
        reg.setSize(400, 400);
        reg.setLocationRelativeTo(null);

        jPanelImage.setLayout(new BorderLayout());
        jPanelImage.setImageFile(new File("src/img/reg.jpg"));

        reg.getContentPane().add(jPanelImage, BorderLayout.CENTER);

    }

    // Покраска поля
    public void drawingShipsField(int[][] shotFieldPlayer, ButtonCells[][] fieldPlayer) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                int x = shotFieldPlayer[i][j];
                switch (x) {
                    case 1:
                        ButtonCells but = fieldPlayer[i][j];
                        but.setBackground(Color.ORANGE);
                        fieldPlayer[i][j] = but;
                }
            }
        }
    }

    public boolean paintingButtons(int x, int y, int check) {
        ButtonCells button = buttonsPlayer[x][y];
        switch (check) {
            case 1:
                button.setBackground(Color.RED);
                return true;
            case 2:
                button.setBackground(Color.BLACK);
        }
        return false;
    }

    // Выстрелы ИИ
    public boolean shotAiEasily(int[][] fieldPlayer) {
        while (true) {
            int shotAIx = aiEpid.randomNumber(1, 11);
            int shotAIy = aiEpid.randomNumber(1, 11);
            int check = player.playerShot2D(shotAIx, shotAIy, fieldPlayer);
            if (check == 1 || check == 2) {
                paintingButtons(shotAIx, shotAIy, check);
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
                        paintingButtons(shotAIx, shotAIy, check);
                        return;
                    }
                }
            }

            if (a == 3 || a == 2) {
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 12; j++) {
                        int check = fieldPlayer[i][j];
                        if (check == 1) {
                            paintingButtons(i, j, check);
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
                    paintingButtons(i, j, check);
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



