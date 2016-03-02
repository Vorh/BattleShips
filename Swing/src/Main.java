import model.*;

import java.io.IOException;

/**
 * Created by Your Majesty on 24.09.2015.
 */
public class Main {
    final static int[][] FIELD_PLAYER = new int[12][12];
    final static int[][] FIELD_AI = new int[12][12];

    Window window = new Window();
    Map map = new Map();

    void mainMenu()throws IOException {

        window.sound = new Sound();
        window.aiEpid = new AiEpid();
        window.map = new Map();
        window.player = new Player();
        window.ships = new Ships();

        map.maps(FIELD_PLAYER);
        map.maps(FIELD_AI);

        window.createStartMenu(FIELD_PLAYER, FIELD_AI);

    }

}


