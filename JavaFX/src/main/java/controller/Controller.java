package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.*;
import server.Server;

import java.io.IOException;

public class Controller {
    final static int[][] FIELD_PLAYER = new int[12][12];
    final static int[][] FIELD_AI = new int[12][12];

    int ai = 0;
    int check;
    int scorePl = 0;
    int scoreAi = 0;
    boolean game;

    Player player = new Player();
    AiEpid aiEpid = new AiEpid();
    Map map = new Map();
    Ships ships = new Ships();
    Sound sound = new Sound();
    OnlinePart onlinePart = new OnlinePart();

    public void gameSession() throws IOException {
        map.maps(FIELD_PLAYER);
        map.maps(FIELD_AI);
        ships.createShips2D(FIELD_PLAYER);
        ships.createShips2D(FIELD_AI);
        map.mapsUpdate(FIELD_PLAYER);

    }

    // Иницилизация компонентов
    //<editor-fold desc="Меню">
    @FXML
    Button gameSingle = new Button();
    @FXML
    Button gameOnline = new Button();
    @FXML
    Button closeGame = new Button();
    @FXML
    Button gameEasly = new Button();
    @FXML
    Button gameNormal = new Button();
    @FXML
    Button gameHard = new Button();
    @FXML
    Button gameMain = new Button();
    @FXML
    Pane paneMain = new Pane();
    @FXML
    Pane paneGame = new Pane();
    @FXML
    Pane paneOnline = new Pane();
    @FXML
    Button butOnline = new Button();
    @FXML
    TextArea ip = new TextArea();
    @FXML
    TextArea port = new TextArea();
    @FXML
    Pane paneMAIN = new Pane();
    @FXML
    Button createGame = new Button();
    //</editor-fold>

    //<editor-fold desc="Chat">
    @FXML
    public TextArea textChatPlayer = new TextArea();
    @FXML
    public TextArea textChatAI = new TextArea();
    @FXML
    public Button chatEnter = new Button();
    //</editor-fold>

    //<editor-fold desc="Компоненты поля">
    @FXML
    TextField textPlayer = new TextField();
    @FXML
    TextField textAI = new TextField();
    @FXML
    TextField scorePlayer = new TextField();
    @FXML
    TextField scoreAI = new TextField();
    @FXML
    Pane menuGame = new Pane();
    @FXML
    GridPane grid_1;
    @FXML
    GridPane grid_2;
    //</editor-fold>

    //<editor-fold desc="Кнопки Player">
    //<editor-fold desc="0 столбец">
    @FXML
    Button b_1 = new Button();
    @FXML
    Button b_2 = new Button();
    @FXML
    Button b_3 = new Button();
    @FXML
    Button b_4 = new Button();
    @FXML
    Button b_5 = new Button();
    @FXML
    Button b_6 = new Button();
    @FXML
    Button b_7 = new Button();
    @FXML
    Button b_8 = new Button();
    @FXML
    Button b_9 = new Button();
    @FXML
    Button b_10 = new Button();
//</editor-fold>

    //<editor-fold desc="1 столбец">
    @FXML
    Button b_11 = new Button();
    @FXML
    Button b_12 = new Button();
    @FXML
    Button b_13 = new Button();
    @FXML
    Button b_14 = new Button();
    @FXML
    Button b_15 = new Button();
    @FXML
    Button b_16 = new Button();
    @FXML
    Button b_17 = new Button();
    @FXML
    Button b_18 = new Button();
    @FXML
    Button b_19 = new Button();
    @FXML
    Button b_110 = new Button();
//</editor-fold>

    //<editor-fold desc="3 столбец">
    @FXML
    Button b_31 = new Button();
    @FXML
    Button b_32 = new Button();
    @FXML
    Button b_33 = new Button();
    @FXML
    Button b_34 = new Button();
    @FXML
    Button b_35 = new Button();
    @FXML
    Button b_36 = new Button();
    @FXML
    Button b_37 = new Button();
    @FXML
    Button b_38 = new Button();
    @FXML
    Button b_39 = new Button();
    @FXML
    Button b_310 = new Button();
//</editor-fold>

    //<editor-fold desc="4 столбец">
    @FXML
    Button b_41 = new Button();
    @FXML
    Button b_42 = new Button();
    @FXML
    Button b_43 = new Button();
    @FXML
    Button b_44 = new Button();
    @FXML
    Button b_45 = new Button();
    @FXML
    Button b_46 = new Button();
    @FXML
    Button b_47 = new Button();
    @FXML
    Button b_48 = new Button();
    @FXML
    Button b_49 = new Button();
    @FXML
    Button b_410 = new Button();
//</editor-fold>

    //<editor-fold desc="5 столбец">
    @FXML
    Button b_51 = new Button();
    @FXML
    Button b_52 = new Button();
    @FXML
    Button b_53 = new Button();
    @FXML
    Button b_54 = new Button();
    @FXML
    Button b_55 = new Button();
    @FXML
    Button b_56 = new Button();
    @FXML
    Button b_57 = new Button();
    @FXML
    Button b_58 = new Button();
    @FXML
    Button b_59 = new Button();
    @FXML
    Button b_510 = new Button();
//</editor-fold>

    //<editor-fold desc="6 столбец">
    @FXML
    Button b_61 = new Button();
    @FXML
    Button b_62 = new Button();
    @FXML
    Button b_63 = new Button();
    @FXML
    Button b_64 = new Button();
    @FXML
    Button b_65 = new Button();
    @FXML
    Button b_66 = new Button();
    @FXML
    Button b_67 = new Button();
    @FXML
    Button b_68 = new Button();
    @FXML
    Button b_69 = new Button();
    @FXML
    Button b_610 = new Button();
//</editor-fold>

    //<editor-fold desc="7 столбец">
    @FXML
    Button b_71 = new Button();
    @FXML
    Button b_72 = new Button();
    @FXML
    Button b_73 = new Button();
    @FXML
    Button b_74 = new Button();
    @FXML
    Button b_75 = new Button();
    @FXML
    Button b_76 = new Button();
    @FXML
    Button b_77 = new Button();
    @FXML
    Button b_78 = new Button();
    @FXML
    Button b_79 = new Button();
    @FXML
    Button b_710 = new Button();
//</editor-fold>

    //<editor-fold desc="8 столбец">
    @FXML
    Button b_81 = new Button();
    @FXML
    Button b_82 = new Button();
    @FXML
    Button b_83 = new Button();
    @FXML
    Button b_84 = new Button();
    @FXML
    Button b_85 = new Button();
    @FXML
    Button b_86 = new Button();
    @FXML
    Button b_87 = new Button();
    @FXML
    Button b_88 = new Button();
    @FXML
    Button b_89 = new Button();
    @FXML
    Button b_810 = new Button();
//</editor-fold>

    //<editor-fold desc="9 столбец">
    @FXML
    Button b_91 = new Button();
    @FXML
    Button b_92 = new Button();
    @FXML
    Button b_93 = new Button();
    @FXML
    Button b_94 = new Button();
    @FXML
    Button b_95 = new Button();
    @FXML
    Button b_96 = new Button();
    @FXML
    Button b_97 = new Button();
    @FXML
    Button b_98 = new Button();
    @FXML
    Button b_99 = new Button();
    @FXML
    Button b_910 = new Button();
//</editor-fold>

    //<editor-fold desc="10 столбец">
    @FXML
    Button b_101 = new Button();
    @FXML
    Button b_102 = new Button();
    @FXML
    Button b_103 = new Button();
    @FXML
    Button b_104 = new Button();
    @FXML
    Button b_105 = new Button();
    @FXML
    Button b_106 = new Button();
    @FXML
    Button b_107 = new Button();
    @FXML
    Button b_108 = new Button();
    @FXML
    Button b_109 = new Button();
    @FXML
    Button b_1010 = new Button();
//</editor-fold>
//</editor-fold>

    //<editor-fold desc="Кнопки AI">
    //<editor-fold desc="0 столбец">
    @FXML
    Button ai_1 = new Button();
    @FXML
    Button ai_2 = new Button();
    @FXML
    Button ai_3 = new Button();
    @FXML
    Button ai_4 = new Button();
    @FXML
    Button ai_5 = new Button();
    @FXML
    Button ai_6 = new Button();
    @FXML
    Button ai_7 = new Button();
    @FXML
    Button ai_8 = new Button();
    @FXML
    Button ai_9 = new Button();
    @FXML
    Button ai_10 = new Button();
//</editor-fold>

    //<editor-fold desc="1 столбец">
    @FXML
    Button ai_21 = new Button();
    @FXML
    Button ai_22 = new Button();
    @FXML
    Button ai_23 = new Button();
    @FXML
    Button ai_24 = new Button();
    @FXML
    Button ai_25 = new Button();
    @FXML
    Button ai_26 = new Button();
    @FXML
    Button ai_27 = new Button();
    @FXML
    Button ai_28 = new Button();
    @FXML
    Button ai_29 = new Button();
    @FXML
    Button ai_210 = new Button();
//</editor-fold>

    //<editor-fold desc="3 столбец">
    @FXML
    Button ai_31 = new Button();
    @FXML
    Button ai_32 = new Button();
    @FXML
    Button ai_33 = new Button();
    @FXML
    Button ai_34 = new Button();
    @FXML
    Button ai_35 = new Button();
    @FXML
    Button ai_36 = new Button();
    @FXML
    Button ai_37 = new Button();
    @FXML
    Button ai_38 = new Button();
    @FXML
    Button ai_39 = new Button();
    @FXML
    Button ai_310 = new Button();
//</editor-fold>

    //<editor-fold desc="4 столбец">
    @FXML
    Button ai_41 = new Button();
    @FXML
    Button ai_42 = new Button();
    @FXML
    Button ai_43 = new Button();
    @FXML
    Button ai_44 = new Button();
    @FXML
    Button ai_45 = new Button();
    @FXML
    Button ai_46 = new Button();
    @FXML
    Button ai_47 = new Button();
    @FXML
    Button ai_48 = new Button();
    @FXML
    Button ai_49 = new Button();
    @FXML
    Button ai_410 = new Button();
//</editor-fold>

    //<editor-fold desc="5 столбец">
    @FXML
    Button ai_51 = new Button();
    @FXML
    Button ai_52 = new Button();
    @FXML
    Button ai_53 = new Button();
    @FXML
    Button ai_54 = new Button();
    @FXML
    Button ai_55 = new Button();
    @FXML
    Button ai_56 = new Button();
    @FXML
    Button ai_57 = new Button();
    @FXML
    Button ai_58 = new Button();
    @FXML
    Button ai_59 = new Button();
    @FXML
    Button ai_510 = new Button();
//</editor-fold>

    //<editor-fold desc="6 столбец">
    @FXML
    Button ai_61 = new Button();
    @FXML
    Button ai_62 = new Button();
    @FXML
    Button ai_63 = new Button();
    @FXML
    Button ai_64 = new Button();
    @FXML
    Button ai_65 = new Button();
    @FXML
    Button ai_66 = new Button();
    @FXML
    Button ai_67 = new Button();
    @FXML
    Button ai_68 = new Button();
    @FXML
    Button ai_69 = new Button();
    @FXML
    Button ai_610 = new Button();
//</editor-fold>

    //<editor-fold desc="7 столбец">
    @FXML
    Button ai_71 = new Button();
    @FXML
    Button ai_72 = new Button();
    @FXML
    Button ai_73 = new Button();
    @FXML
    Button ai_74 = new Button();
    @FXML
    Button ai_75 = new Button();
    @FXML
    Button ai_76 = new Button();
    @FXML
    Button ai_77 = new Button();
    @FXML
    Button ai_78 = new Button();
    @FXML
    Button ai_79 = new Button();
    @FXML
    Button ai_710 = new Button();
//</editor-fold>

    //<editor-fold desc="8 столбец">
    @FXML
    Button ai_81 = new Button();
    @FXML
    Button ai_82 = new Button();
    @FXML
    Button ai_83 = new Button();
    @FXML
    Button ai_84 = new Button();
    @FXML
    Button ai_85 = new Button();
    @FXML
    Button ai_86 = new Button();
    @FXML
    Button ai_87 = new Button();
    @FXML
    Button ai_88 = new Button();
    @FXML
    Button ai_89 = new Button();
    @FXML
    Button ai_810 = new Button();
//</editor-fold>

    //<editor-fold desc="9 столбец">
    @FXML
    Button ai_91 = new Button();
    @FXML
    Button ai_92 = new Button();
    @FXML
    Button ai_93 = new Button();
    @FXML
    Button ai_94 = new Button();
    @FXML
    Button ai_95 = new Button();
    @FXML
    Button ai_96 = new Button();
    @FXML
    Button ai_97 = new Button();
    @FXML
    Button ai_98 = new Button();
    @FXML
    Button ai_99 = new Button();
    @FXML
    Button ai_910 = new Button();
//</editor-fold>

    //<editor-fold desc="10 столбец">
    @FXML
    Button ai_101 = new Button();
    @FXML
    Button ai_102 = new Button();
    @FXML
    Button ai_103 = new Button();
    @FXML
    Button ai_104 = new Button();
    @FXML
    Button ai_105 = new Button();
    @FXML
    Button ai_106 = new Button();
    @FXML
    Button ai_107 = new Button();
    @FXML
    Button ai_108 = new Button();
    @FXML
    Button ai_109 = new Button();
    @FXML
    Button ai_1010 = new Button();
//</editor-fold>
//</editor-fold>

    // События

    //<editor-fold desc="Меню">

    //<editor-fold desc="Главное меню">
    @FXML
    public void game_Single(){
        paneGame.setVisible(true);
        paneMain.setVisible(false);
    }
    @FXML
    public void game_Online(){
        paneOnline.setVisible(true);
        paneMain.setVisible(false);
        ip.setText("localhost");
        port.setText(String.valueOf(2074));
    }
    @FXML
    public void close_game(){
        System.exit(1);
    }
    //</editor-fold>

    //<editor-fold desc="Выбор сложности">

    public void game_Easly(){
        ai = 1;
        paneGame.setVisible(false);
        paneMAIN.setVisible(false);
        textChatPlayer.setVisible(false);
        textChatAI.setVisible(false);
        chatEnter.setVisible(false);
    }

    public void game_Normal(){
        ai = 2;
        paneGame.setVisible(false);
        paneMAIN.setVisible(false);
        textChatPlayer.setVisible(false);
        textChatAI.setVisible(false);
        chatEnter.setVisible(false);
    }

    public void game_Hard(){
        ai = 3;
        paneGame.setVisible(false);
        paneMAIN.setVisible(false);
        textChatPlayer.setVisible(false);
        textChatAI.setVisible(false);
        chatEnter.setVisible(false);
    }

    public void game_Main(){
        paneMain.setVisible(true);
        paneGame.setVisible(false);
        textChatPlayer.setVisible(false);
        textChatAI.setVisible(false);
        chatEnter.setVisible(false);
    }
    //</editor-fold>

    //<editor-fold desc="Онлайн">
    public void create_Game(){
        ai = 0;
        paneMAIN.setVisible(false);
        try {
            Server server = new Server(2074, textChatAI);
            new Thread(server).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public void but_Online(){
       ai = 0;
       String s = ip.getText();
       String v = port.getText();
       paneMAIN.setVisible(false);
       onlinePart.connection(s,v, textChatAI);
   }
    //</editor-fold>

    //</editor-fold>

    // Нанесение изображения кораблей на поле

    public void drawShipsFieldPlayer() {
        //<editor-fold desc="1 столбец">
        if(FIELD_PLAYER[1][1] == 1){
            b_1.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][1] == 1){
            b_2.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][1] == 1){
            b_3.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][1] == 1){
            b_4.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][1] == 1){
            b_5.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][1] == 1){
            b_6.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][1] == 1){
            b_7.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][1] == 1){
            b_8.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][1] == 1){
            b_9.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][1] == 1){
            b_10.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="2 столбец">
        if(FIELD_PLAYER[1][2] == 1){
            b_11.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][2] == 1){
            b_12.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][2] == 1){
            b_13.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][2] == 1){
            b_14.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][2] == 1){
            b_15.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][2] == 1){
            b_16.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][2] == 1){
            b_17.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][2] == 1){
            b_18.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][2] == 1){
            b_19.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][2] == 1){
            b_110.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="3 столбец">
        if(FIELD_PLAYER[1][3] == 1){
            b_31.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][3] == 1){
            b_32.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][3] == 1){
            b_33.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][3] == 1){
            b_34.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][3] == 1){
            b_35.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][3] == 1){
            b_36.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][3] == 1){
            b_37.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][3] == 1){
            b_38.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][3] == 1){
            b_39.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][3] == 1){
            b_310.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="4 столбец">
        if(FIELD_PLAYER[1][4] == 1){
            b_41.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][4] == 1){
            b_42.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][4] == 1){
            b_43.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][4] == 1){
            b_44.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][4] == 1){
            b_45.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][4] == 1){
            b_46.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][4] == 1){
            b_47.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][4] == 1){
            b_48.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][4] == 1){
            b_49.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][4] == 1){
            b_410.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="5 столбец">
        if(FIELD_PLAYER[1][5] == 1){
            b_51.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][5] == 1){
            b_52.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][5] == 1){
            b_53.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][5] == 1){
            b_54.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][5] == 1){
            b_55.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][5] == 1){
            b_56.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][5] == 1){
            b_57.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][5] == 1){
            b_58.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][5] == 1){
            b_59.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][5] == 1){
            b_510.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="6 столбец">
        if(FIELD_PLAYER[1][6] == 1){
            b_61.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][6] == 1){
            b_62.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][6] == 1){
            b_63.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][6] == 1){
            b_64.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][6] == 1){
            b_65.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][6] == 1){
            b_66.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][6] == 1){
            b_67.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][6] == 1){
            b_68.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][6] == 1){
            b_69.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][6] == 1){
            b_610.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="7 столбец">
        if(FIELD_PLAYER[1][7] == 1){
            b_71.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][7] == 1){
            b_72.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][7] == 1){
            b_73.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][7] == 1){
            b_74.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][7] == 1){
            b_75.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][7] == 1){
            b_76.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][7] == 1){
            b_77.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][7] == 1){
            b_78.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][7] == 1){
            b_79.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][7] == 1){
            b_710.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="8 столбец">
        if(FIELD_PLAYER[1][8] == 1){
            b_81.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][8] == 1){
            b_82.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][8] == 1){
            b_83.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][8] == 1){
            b_84.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][8] == 1){
            b_85.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][8] == 1){
            b_86.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][8] == 1){
            b_87.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][8] == 1){
            b_88.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][8] == 1){
            b_89.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][8] == 1){
            b_810.setStyle("-fx-base: #f0ff00;");

        }
        //</editor-fold>

        //<editor-fold desc="9 столбец">
        if(FIELD_PLAYER[1][9] == 1){
            b_91.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][9] == 1){
            b_92.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][9] == 1){
            b_93.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][9] == 1){
            b_94.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][9] == 1){
            b_95.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][9] == 1){
            b_96.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][9] == 1){
            b_97.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][9] == 1){
            b_98.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][9] == 1){
            b_99.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][9] == 1){
            b_910.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="10 столбец">
        if(FIELD_PLAYER[1][10] == 1){
            b_101.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[2][10] == 1){
            b_102.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[3][10] == 1){
            b_103.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[4][10] == 1){
            b_104.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[5][10] == 1){
            b_105.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[6][10] == 1){
            b_106.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[7][10] == 1){
            b_107.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[8][10] == 1){
            b_108.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[9][10] == 1){
            b_109.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_PLAYER[10][10] == 1){
            b_1010.setStyle("-fx-base: #f0ff00;");

        }
        //</editor-fold>

        map.mapsUpdate(FIELD_PLAYER);
    }

    public void drawShipsFieldAi() {
        //<editor-fold desc="1 столбец">
        if(FIELD_AI[1][1] == 1){
            ai_1.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][1] == 1){
            ai_2.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][1] == 1){
            ai_3.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][1] == 1){
            ai_4.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][1] == 1){
            ai_5.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][1] == 1){
            ai_6.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][1] == 1){
            ai_7.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][1] == 1){
            ai_8.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][1] == 1){
            ai_9.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][1] == 1){
            ai_10.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="2 столбец">
        if(FIELD_AI[1][2] == 1){
            ai_21.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][2] == 1){
            ai_22.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][2] == 1){
            ai_23.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][2] == 1){
            ai_24.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][2] == 1){
            ai_25.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][2] == 1){
            ai_26.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][2] == 1){
            ai_27.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][2] == 1){
            ai_28.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][2] == 1){
            ai_29.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][2] == 1){
            ai_210.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="3 столбец">
        if(FIELD_AI[1][3] == 1){
            ai_31.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][3] == 1){
            ai_32.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][3] == 1){
            ai_33.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][3] == 1){
            ai_34.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][3] == 1){
            ai_35.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][3] == 1){
            ai_36.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][3] == 1){
            ai_37.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][3] == 1){
            ai_38.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][3] == 1){
            ai_39.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][3] == 1){
            ai_310.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="4 столбец">
        if(FIELD_AI[1][4] == 1){
            ai_41.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][4] == 1){
            ai_42.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][4] == 1){
            ai_43.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][4] == 1){
            ai_44.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][4] == 1){
            ai_45.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][4] == 1){
            ai_46.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][4] == 1){
            ai_47.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][4] == 1){
            ai_48.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][4] == 1){
            ai_49.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][4] == 1){
            ai_410.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="5 столбец">
        if(FIELD_AI[1][5] == 1){
            ai_51.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][5] == 1){
            ai_52.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][5] == 1){
            ai_53.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][5] == 1){
            ai_54.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][5] == 1){
            ai_55.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][5] == 1){
            ai_56.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][5] == 1){
            ai_57.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][5] == 1){
            ai_58.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][5] == 1){
            ai_59.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][5] == 1){
            ai_510.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="6 столбец">
        if(FIELD_AI[1][6] == 1){
            ai_61.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][6] == 1){
            ai_62.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][6] == 1){
            ai_63.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][6] == 1){
            ai_64.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][6] == 1){
            ai_65.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][6] == 1){
            ai_66.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][6] == 1){
            ai_67.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][6] == 1){
            ai_68.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][6] == 1){
            ai_69.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][6] == 1){
            ai_610.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="7 столбец">
        if(FIELD_AI[1][7] == 1){
            ai_71.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][7] == 1){
            ai_72.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][7] == 1){
            ai_73.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][7] == 1){
            ai_74.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][7] == 1){
            ai_75.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][7] == 1){
            ai_76.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][7] == 1){
            ai_77.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][7] == 1){
            ai_78.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][7] == 1){
            ai_79.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][7] == 1){
            ai_710.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="8 столбец">
        if(FIELD_AI[1][8] == 1){
            ai_81.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][8] == 1){
            ai_82.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][8] == 1){
            ai_83.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][8] == 1){
            ai_84.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][8] == 1){
            ai_85.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][8] == 1){
            ai_86.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][8] == 1){
            ai_87.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][8] == 1){
            ai_88.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][8] == 1){
            ai_89.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][8] == 1){
            ai_810.setStyle("-fx-base: #f0ff00;");

        }
        //</editor-fold>

        //<editor-fold desc="9 столбец">
        if(FIELD_AI[1][9] == 1){
            ai_91.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][9] == 1){
            ai_92.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][9] == 1){
            ai_93.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][9] == 1){
            ai_94.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][9] == 1){
            ai_95.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][9] == 1){
            ai_96.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][9] == 1){
            ai_97.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][9] == 1){
            ai_98.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][9] == 1){
            ai_99.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][9] == 1){
            ai_910.setStyle("-fx-base: #f0ff00;");
        }
        //</editor-fold>

        //<editor-fold desc="10 столбец">
        if(FIELD_AI[1][10] == 1){
            ai_101.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[2][10] == 1){
            ai_102.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[3][10] == 1){
            ai_103.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[4][10] == 1){
            ai_104.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[5][10] == 1){
            ai_105.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[6][10] == 1){
            ai_106.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[7][10] == 1){
            ai_107.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[8][10] == 1){
            ai_108.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[9][10] == 1){
            ai_109.setStyle("-fx-base: #f0ff00;");
        }
        if(FIELD_AI[10][10] == 1){
            ai_1010.setStyle("-fx-base: #f0ff00;");

        }
        //</editor-fold>

        map.mapsUpdate(FIELD_AI);
    }

    // Обработка действий игрока

    public  void changeField(int check, Button but){
        switch (check){
            case 1:
                sound.playSound("sound/shot.wav",1);
                but.setStyle("-fx-base: #f51111;");
                textPlayer.setText("Попал");
                scorePl++;
                scorePlayer.setText(String.valueOf(scorePl));
                break;
            case 2:
//                sound.playSound("/resources/sound/shot.wav", 1);
                but.setStyle("-fx-base: #000000;");
                textPlayer.setText("Промах");
                scorePlayer.setText(String.valueOf(scorePl));
                break;
            case 3:
                textPlayer.setText("Повтор");
                scorePlayer.setText(String.valueOf(scorePl));
                break;
            case 4:
//                sound.playSound("/resources/sound/boom1.wav", 6);
                but.setStyle("-fx-base: #f51111;");
                textPlayer.setText("Уничтожен");
                scorePl++;
                scorePlayer.setText(String.valueOf(scorePl));
                if (scorePl == 20){
                    System.out.println("Вы победили");
                }
                break;
        }
    }

    //<editor-fold desc="Выстрелы по потенциальному противнику">
    //<editor-fold desc="0 столбец">
    @FXML
    public void ai1(){
        check = player.playerShot2D(1, 1, FIELD_AI);
        changeField(check, ai_1);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai2(){
        check = player.playerShot2D(2, 1, FIELD_AI);
        changeField(check, ai_2);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai3(){
        check = player.playerShot2D(3, 1, FIELD_AI);
        changeField(check, ai_3);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai4(){
        check = player.playerShot2D(4, 1, FIELD_AI);
        changeField(check, ai_4);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai5(){
        check = player.playerShot2D(5, 1, FIELD_AI);
        changeField(check, ai_5);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai6(){
        check = player.playerShot2D(6, 1, FIELD_AI);
        changeField(check, ai_6);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai7(){
        check = player.playerShot2D(7, 1, FIELD_AI);
        changeField(check, ai_7);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai8(){
        check = player.playerShot2D(8, 1, FIELD_AI);
        changeField(check, ai_8);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai9(){
        check = player.playerShot2D(9, 1, FIELD_AI);
        changeField(check, ai_9);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai10(){
        check = player.playerShot2D(10, 1, FIELD_AI);
        changeField(check, ai_10);
        if(check != 3){shotAI();}
    }
    //</editor-fold>

    //<editor-fold desc="1 столбец">
    @FXML
    public void ai21(){
        check = player.playerShot2D(1, 2, FIELD_AI);
        changeField(check, ai_21);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai22(){
        check = player.playerShot2D(2, 2, FIELD_AI);
        changeField(check, ai_22);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai23(){
        check = player.playerShot2D(3, 2, FIELD_AI);
        changeField(check, ai_23);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai24(){
        check = player.playerShot2D(4, 2, FIELD_AI);
        changeField(check, ai_24);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai25(){
        check = player.playerShot2D(5, 2, FIELD_AI);
        changeField(check, ai_25);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai26(){
        check = player.playerShot2D(6, 2, FIELD_AI);
        changeField(check, ai_26);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai27(){
        check = player.playerShot2D(7, 2, FIELD_AI);
        changeField(check, ai_27);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai28(){
        check = player.playerShot2D(8, 2, FIELD_AI);
        changeField(check, ai_28);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai29(){
        check = player.playerShot2D(9, 2, FIELD_AI);
        changeField(check, ai_29);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai210(){
        check = player.playerShot2D(10, 2, FIELD_AI);
        changeField(check, ai_210);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="3 столбец">
    @FXML
    public void ai31(){
        check = player.playerShot2D(1, 3, FIELD_AI);
        changeField(check, ai_31);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai32(){
        check = player.playerShot2D(2, 3, FIELD_AI);
        changeField(check, ai_32);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai33(){
        check = player.playerShot2D(3, 3, FIELD_AI);
        changeField(check, ai_33);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai34(){
        check = player.playerShot2D(4, 3, FIELD_AI);
        changeField(check, ai_34);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai35(){
        check = player.playerShot2D(5, 3, FIELD_AI);
        changeField(check, ai_35);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai36(){
        check = player.playerShot2D(6, 3, FIELD_AI);
        changeField(check, ai_36);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai37(){
        check = player.playerShot2D(7, 3, FIELD_AI);
        changeField(check, ai_37);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai38(){
        check = player.playerShot2D(8, 3, FIELD_AI);
        changeField(check, ai_38);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai39(){
        check = player.playerShot2D(9, 3, FIELD_AI);
        changeField(check, ai_39);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai310(){
        check = player.playerShot2D(10, 3, FIELD_AI);
        changeField(check, ai_310);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="4 столбец">
    @FXML
    public void ai41(){
        check = player.playerShot2D(1, 4, FIELD_AI);
        changeField(check, ai_41);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai42(){
        check = player.playerShot2D(2, 4, FIELD_AI);
        changeField(check, ai_42);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai43(){
        check = player.playerShot2D(3, 4, FIELD_AI);
        changeField(check, ai_43);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai44(){
        check = player.playerShot2D(4, 4, FIELD_AI);
        changeField(check, ai_44);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai45(){
        check = player.playerShot2D(5, 4, FIELD_AI);
        changeField(check, ai_45);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai46(){
        check = player.playerShot2D(6, 4, FIELD_AI);
        changeField(check, ai_46);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai47(){
        check = player.playerShot2D(7, 4, FIELD_AI);
        changeField(check, ai_47);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai48(){
        check = player.playerShot2D(8, 4, FIELD_AI);
        changeField(check, ai_48);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai49(){
        check = player.playerShot2D(9, 4, FIELD_AI);
        changeField(check, ai_49);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai410(){
        check = player.playerShot2D(10, 4, FIELD_AI);
        changeField(check, ai_410);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="5 столбец">
    @FXML
    public void ai51(){
        check = player.playerShot2D(1, 5, FIELD_AI);
        changeField(check, ai_51);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai52(){
        check = player.playerShot2D(2, 5, FIELD_AI);
        changeField(check, ai_52);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai53(){
        check = player.playerShot2D(3, 5, FIELD_AI);
        changeField(check, ai_53);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai54(){
        check = player.playerShot2D(4, 5, FIELD_AI);
        changeField(check, ai_54);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai55(){
        check = player.playerShot2D(5, 5, FIELD_AI);
        changeField(check, ai_55);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai56(){
        check = player.playerShot2D(6, 5, FIELD_AI);
        changeField(check, ai_56);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai57(){
        check = player.playerShot2D(7, 5, FIELD_AI);
        changeField(check, ai_57);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai58(){
        check = player.playerShot2D(8, 5, FIELD_AI);
        changeField(check, ai_58);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai59(){
        check = player.playerShot2D(9, 5, FIELD_AI);
        changeField(check, ai_59);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai510(){
        check = player.playerShot2D(10, 5, FIELD_AI);
        changeField(check, ai_510);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="6 столбец">
    @FXML
    public void ai61(){
        check = player.playerShot2D(1, 6, FIELD_AI);
        changeField(check, ai_61);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai62(){
        check = player.playerShot2D(2, 6, FIELD_AI);
        changeField(check, ai_62);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai63(){
        check = player.playerShot2D(3, 6, FIELD_AI);
        changeField(check, ai_63);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai64(){
        check = player.playerShot2D(4, 6, FIELD_AI);
        changeField(check, ai_64);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai65(){
        check = player.playerShot2D(5, 6, FIELD_AI);
        changeField(check, ai_65);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai66(){
        check = player.playerShot2D(6, 6, FIELD_AI);
        changeField(check, ai_66);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai67(){
        check = player.playerShot2D(7, 6, FIELD_AI);
        changeField(check, ai_67);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai68(){
        check = player.playerShot2D(8, 6, FIELD_AI);
        changeField(check, ai_68);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai69(){
        check = player.playerShot2D(9, 6, FIELD_AI);
        changeField(check, ai_69);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai610(){
        check = player.playerShot2D(10, 6, FIELD_AI);
        changeField(check, ai_610);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="7 столбец">
    @FXML
    public void ai71(){
        check = player.playerShot2D(1, 7, FIELD_AI);
        changeField(check, ai_71);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai72(){
        check = player.playerShot2D(2, 7, FIELD_AI);
        changeField(check, ai_72);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai73(){
        check = player.playerShot2D(3, 7, FIELD_AI);
        changeField(check, ai_73);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai74(){
        check = player.playerShot2D(4, 7, FIELD_AI);
        changeField(check, ai_74);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai75(){
        check = player.playerShot2D(5, 7, FIELD_AI);
        changeField(check, ai_75);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai76(){
        check = player.playerShot2D(6, 7, FIELD_AI);
        changeField(check, ai_76);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai77(){
        check = player.playerShot2D(7, 7, FIELD_AI);
        changeField(check, ai_77);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai78(){
        check = player.playerShot2D(8, 7, FIELD_AI);
        changeField(check, ai_78);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai79(){
        check = player.playerShot2D(9, 7, FIELD_AI);
        changeField(check, ai_79);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai710(){
        check = player.playerShot2D(10, 7, FIELD_AI);
        changeField(check, ai_710);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="8 столбец">
    @FXML
    public void ai81(){
        check = player.playerShot2D(1, 8, FIELD_AI);
        changeField(check, ai_81);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai82(){
        check = player.playerShot2D(2, 8, FIELD_AI);
        changeField(check, ai_82);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai83(){
        check = player.playerShot2D(3, 8, FIELD_AI);
        changeField(check, ai_83);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai84(){
        check = player.playerShot2D(4, 8, FIELD_AI);
        changeField(check, ai_84);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai85(){
        check = player.playerShot2D(5, 8, FIELD_AI);
        changeField(check, ai_85);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai86(){
        check = player.playerShot2D(6, 8, FIELD_AI);
        changeField(check, ai_86);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai87(){
        check = player.playerShot2D(7, 8, FIELD_AI);
        changeField(check, ai_87);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai88(){
        check = player.playerShot2D(8, 8, FIELD_AI);
        changeField(check, ai_88);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai89(){
        check = player.playerShot2D(9, 8, FIELD_AI);
        changeField(check, ai_89);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai810(){
        check = player.playerShot2D(10, 8, FIELD_AI);
        changeField(check, ai_810);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="9 столбец">
    @FXML
    public void ai91(){
        check = player.playerShot2D(1, 9, FIELD_AI);
        changeField(check, ai_91);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai92(){
        check = player.playerShot2D(2, 9, FIELD_AI);
        changeField(check, ai_92);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai93(){
        check = player.playerShot2D(3, 9, FIELD_AI);
        changeField(check, ai_93);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai94(){
        check = player.playerShot2D(4, 9, FIELD_AI);
        changeField(check, ai_94);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai95(){
        check = player.playerShot2D(5, 9, FIELD_AI);
        changeField(check, ai_95);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai96(){
        check = player.playerShot2D(6, 9, FIELD_AI);
        changeField(check, ai_96);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai97(){
        check = player.playerShot2D(7, 9, FIELD_AI);
        changeField(check, ai_97);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai98(){
        check = player.playerShot2D(8, 9, FIELD_AI);
        changeField(check, ai_98);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai99(){
        check = player.playerShot2D(9, 9, FIELD_AI);
        changeField(check, ai_99);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai910(){
        check = player.playerShot2D(10, 9, FIELD_AI);
        changeField(check, ai_910);
        if(check != 3){shotAI();}
    }
//</editor-fold>

    //<editor-fold desc="10 столбец">
    @FXML
    public void ai101(){
        check = player.playerShot2D(1, 10, FIELD_AI);
        changeField(check, ai_101);
        if(check != 3){shotAI();}
    }

    @FXML
    public void ai102(){
        check = player.playerShot2D(2, 10, FIELD_AI);
        changeField(check, ai_102);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai103(){
        check = player.playerShot2D(3, 10, FIELD_AI);
        changeField(check, ai_103);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai104(){
        check = player.playerShot2D(4, 10, FIELD_AI);
        changeField(check, ai_104);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai105(){
        check = player.playerShot2D(5, 10, FIELD_AI);
        changeField(check, ai_105);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai106(){
        check = player.playerShot2D(6, 10, FIELD_AI);
        changeField(check, ai_106);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai107(){
        check = player.playerShot2D(7, 10, FIELD_AI);
        changeField(check, ai_107);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai108(){
        check = player.playerShot2D(8, 10, FIELD_AI);
        changeField(check, ai_108);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai109(){
        check = player.playerShot2D(9, 10, FIELD_AI);
        changeField(check, ai_109);
        if(check != 3){shotAI();}
    }
    @FXML
    public void ai1010(){
        check = player.playerShot2D(10, 10, FIELD_AI);
        changeField(check, ai_1010);
        if(check != 3){shotAI();}
    }
//</editor-fold>
    //</editor-fold>

    // Выбор ИИ и его интеллект

    public void shotAiEasily(int[][] fieldPlayer) {
        while (true) {
            int shotAIx = aiEpid.randomNumber(1, 11);
            int shotAIy = aiEpid.randomNumber(1, 11);
            int check = player.playerShot2D(shotAIx, shotAIy, fieldPlayer);
            if(check == 1 || check == 4 || check == 2) {
                drawAI(shotAIx, shotAIy, check);
                switch (check){
                    case 1:
                        textAI.setText("Попал");
                        scoreAi++;
                        scoreAI.setText(String.valueOf(scoreAi));
                        break;
                    case 2:
                        textAI.setText("Промах");
                        scoreAI.setText(String.valueOf(scoreAi));
                        break;
                    case 4:
                        textAI.setText("Уничтожен");
                        scoreAi++;
                        scoreAI.setText(String.valueOf(scoreAi));
                        if (scoreAi == 20){
                            System.out.println("Вы проиграли");
                        }
                }
                return;
            }
        }
    }

    public void shotAiNormal(int[][] fieldPlayer) {
        while (true) {
            int a = aiEpid.randomNumber(1, 2);
            switch (a){
                case 1:
                    while (true) {
                        int shotAIx = aiEpid.randomNumber(1, 11);
                        int shotAIy = aiEpid.randomNumber(1, 11);
                        int check = player.playerShot2D(shotAIx, shotAIy, fieldPlayer);
                        if (check == 1 || check == 4 || check == 2) {
                            drawAI(shotAIx, shotAIy, check);
                            switch (check) {
                                case 1:
                                    textAI.setText("Попал");
                                    scoreAi++;
                                    scoreAI.setText(String.valueOf(scoreAi));
                                    return;
                                case 2:
                                    textAI.setText("Промах");
                                    scoreAI.setText(String.valueOf(scoreAi));
                                    return;
                                case 4:
                                    textAI.setText("Уничтожен");
                                    scoreAi++;
                                    scoreAI.setText(String.valueOf(scoreAi));
                                    if (scoreAi == 20) {
                                        System.out.println("Вы проиграли");
                                    }
                                    return;

                            }
                            return;

                        }
                    }

                case 2:
                    for (int i = 1; i < 11; i++) {
                        for (int j = 1; j < 11; j++) {
                            int check = fieldPlayer[i][j];
                            if (check == 1) {
                                int s = player.playerShot2D(i, j, fieldPlayer);
                                drawAI(i, j, check);
                                switch (s) {
                                    case 1:
                                        textAI.setText("Попал");
                                        scoreAi++;
                                        scoreAI.setText(String.valueOf(scoreAi));
                                        return;
                                    case 4:
                                        textAI.setText("Уничтожен");
                                        scoreAi++;
                                        scoreAI.setText(String.valueOf(scoreAi));
                                        if (scoreAi == 20) {
                                            System.out.println("Вы проиграли");
                                        }
                                        return;
                                }
                            }
                        }
                    }
            }
        }
    }

    public void shotAiHard(int[][] fieldPlayer) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                check = player.playerShot2D(i, j, fieldPlayer);
                if (check == 1 || check == 4) {
                    drawAI(i, j, check);
                    switch (check) {
                        case 1:
                            textAI.setText("Попал");
                            scoreAi++;
                            scoreAI.setText(String.valueOf(scoreAi));
                            return;
                        case 4:
                            textAI.setText("Уничтожен");
                            scoreAi++;
                            scoreAI.setText(String.valueOf(scoreAi));
                            if (scoreAi == 20) {
                                System.out.println("Вы проиграли");
                            }
                            return;
                    }
                }
            }
        }
    }

    public void shotAI(){
        switch (ai){
            case 1:
                shotAiEasily(FIELD_PLAYER);
                break;
            case 2:
                shotAiNormal(FIELD_PLAYER);
                break;
            case 3:
                shotAiHard(FIELD_PLAYER);
                break;
        }
    }

    public void drawAI(int x , int y, int check) {
        switch (y) {
            case 1:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_1.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_1.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_1.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_2.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_2.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_2.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_3.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_3.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_3.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_4.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_4.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_4.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_5.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_5.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_5.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_6.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_6.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_6.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_7.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_7.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_7.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_8.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_8.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_8.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_9.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_9.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_9.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_10.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_10.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_10.setStyle("-fx-base: #f51111;");
                                return;
                        }
                }
            case 2:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_11.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_11.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_11.setStyle("-fx-base: #f51111;");
                                return;
                        }

                    case 2:
                        switch (check) {
                            case 1:
                                b_12.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_12.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_12.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_13.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_13.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_13.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_14.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_14.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_14.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_15.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_15.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_15.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_16.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_16.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_16.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_17.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_17.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_17.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_18.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_18.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_18.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_19.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_19.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_19.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_110.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_110.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_110.setStyle("-fx-base: #f51111;");
                                return;
                        }

                }
            case 3:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_31.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_31.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_31.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_32.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_32.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_32.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_33.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_33.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_33.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_34.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_34.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_34.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_35.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_35.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_35.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_36.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_36.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_36.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_37.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_37.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_37.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_38.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_38.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_38.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_39.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_39.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_39.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_310.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_310.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_310.setStyle("-fx-base: #f51111;");
                                return;
                        }


                }
            case 4:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_41.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_41.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_41.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_42.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_42.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_42.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_43.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_43.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_43.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_44.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_44.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_44.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_45.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_45.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_45.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_46.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_46.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_46.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_47.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_47.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_47.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_48.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_48.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_48.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_49.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_49.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_49.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_410.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_410.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_410.setStyle("-fx-base: #f51111;");
                                return;
                        }


                }
            case 5:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_51.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_51.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_51.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_52.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_52.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_52.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_53.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_53.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_53.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_54.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_54.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_54.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_55.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_55.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_55.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_56.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_56.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_56.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_57.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_57.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_57.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_58.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_58.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_58.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_59.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_59.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_59.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_510.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_510.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_510.setStyle("-fx-base: #f51111;");
                                return;
                        }


                }
            case 6:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_61.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_61.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_61.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_62.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_62.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_62.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_63.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_63.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_63.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_64.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_64.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_64.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_65.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_65.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_65.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_66.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_66.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_66.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_67.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_67.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_67.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_68.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_68.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_68.setStyle("-fx-base: #f51111;");
                                return;
                        }

                    case 9:
                        switch (check) {
                            case 1:
                                b_69.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_69.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_69.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_610.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_610.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_610.setStyle("-fx-base: #f51111;");
                                return;
                        }

                }
            case 7:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_71.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_71.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_71.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_72.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_72.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_72.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_73.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_73.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_73.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_74.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_74.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_74.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_75.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_75.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_75.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_76.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_76.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_76.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_77.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_77.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_77.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_78.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_78.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_78.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_79.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_79.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_79.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_710.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_710.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_710.setStyle("-fx-base: #f51111;");
                                return;
                        }
                }
            case 8:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_81.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_81.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_81.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_82.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_82.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_82.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_83.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_83.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_83.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_84.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_84.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_84.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_85.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_85.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_85.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_86.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_86.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_86.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_87.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_87.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_87.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_88.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_88.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_88.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_89.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_89.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_89.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_810.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_810.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_810.setStyle("-fx-base: #f51111;");
                                return;
                        }

                }
            case 9:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_91.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_91.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_91.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_92.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_92.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_92.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_93.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_93.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_93.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_94.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_94.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_94.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_95.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_95.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_95.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_96.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_96.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_96.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_97.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_97.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_97.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_98.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_98.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_98.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_99.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_99.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_99.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_910.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_910.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_910.setStyle("-fx-base: #f51111;");
                                return;
                        }


                }
            case 10:
                switch (x) {
                    case 1:
                        switch (check) {
                            case 1:
                                b_101.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_101.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_101.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 2:
                        switch (check) {
                            case 1:
                                b_102.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_102.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_102.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 3:
                        switch (check) {
                            case 1:
                                b_103.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_103.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_103.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 4:
                        switch (check) {
                            case 1:
                                b_104.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_104.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_104.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 5:
                        switch (check) {
                            case 1:
                                b_105.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_105.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_105.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 6:
                        switch (check) {
                            case 1:
                                b_106.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_106.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_106.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 7:
                        switch (check) {
                            case 1:
                                b_107.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_107.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_107.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 8:
                        switch (check) {
                            case 1:
                                b_108.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_108.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_108.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 9:
                        switch (check) {
                            case 1:
                                b_109.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_109.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_109.setStyle("-fx-base: #f51111;");
                                return;
                        }
                    case 10:
                        switch (check) {
                            case 1:
                                b_1010.setStyle("-fx-base: #f51111;");
                                return;
                            case 2:
                                b_1010.setStyle("-fx-base: #000000;");
                                return;
                            case 4:
                                b_1010.setStyle("-fx-base: #f51111;");
                                return;
                        }
                }

        }

    }

    public void chat_Enter(){
        String s = "Chat:" + textChatPlayer.getText();
        onlinePart.enter(s);
        textChatPlayer.setText("");
    }

    public void shotOnline(int x , int y){
        String s = "";
        s = "PlayerShot:";
        s = s + String.valueOf(x)+String.valueOf(y);
        onlinePart.enter(s);
    }

}
