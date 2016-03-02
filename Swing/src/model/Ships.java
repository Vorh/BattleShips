package model;

import java.io.IOException;

public class Ships {
    SizeAndPositionShips posisitonShips = new SizeAndPositionShips();


   public void createShips2D(int[][] shipsField) throws IOException {

        for (int i = 0; i < 4; i++) {
            posisitonShips.shipsPositionOne(shipsField);
        }
        for (int i = 0; i < 3; i++) {
            posisitonShips.shipsPositionTwo(shipsField);
        }


        for (int i = 0; i < 2; i++) {
            posisitonShips.shipsPositionThree(shipsField);
        }


        for (int i = 0; i < 1; i++) {
            posisitonShips.shipsPositionFour(shipsField);
        }

    }

    public  void clearField(int[][] shipsField){
        for (int i = 1; i <11 ; i++) {
            for (int j = 1; j <11 ; j++) {
                shipsField[i][j] = 0;
            }
        }
    }
}
