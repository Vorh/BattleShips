package model;

/**
 * Created by Your Majesty on 02.09.2015.
 */
public class Map {

    public void maps(int[][] shot) {
        for (int i = 0; i < 12; i++) {
            shot[0][i] = 8;
        }
        for (int i = 0; i < 12; i++) {
            shot[11][i] = 8;
        }
        for (int i = 0; i < 12; i++) {
            shot[i][0] = 8;
        }
        for (int i = 0; i < 12; i++) {
            shot[i][11] = 8;
        }
        for (int s = 1; s < 11; s++) {
            for (int j = 1; j < 11; j++) {
                shot[s][j] = 0;

            }
        }
    }

    public void mapsUpdate(int[][] shot) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(shot[i][j] + "\t");
            }
            System.out.println();

        }
    }
}

