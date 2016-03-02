package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Astra on 29.08.2015.
 */
public class Player {
    boolean check;

   public int playerShot2D (int shotX,int shotY,int[][] shot) {
       int x = 0;
        switch (shot[shotX][shotY]) {
            case 1:
                shot[shotX][shotY] = 3;  // Для учитывания промахов
                check = checkShipsSize(shot, shotX, shotY, check);
                if (check == true) {
//                    System.out.println("Попал");
                    x = 1;
                    break;
                } else {
//                    System.out.println("Корабль потоплен");
                    x = 4;
                    break;
                }
            case 3: {
//                System.out.println("Вы уже сюда стреляли");
                x = 3;
                break;
            }
            case 0: {
                shot[shotX][shotY] = 3;
//                System.out.println("Мимо");
                x = 2;
                break;
            }
        }
       return x;
    }

    // Проверка размера корабля (информация нужна что того чтобы узнать потоплен корабль или нет)
    boolean checkShipsSize(int[][] shot, int shotX, int shotY, boolean check) {
        int x = shotX;
        int y = shotY;

        shotY++;
        if (shot[shotX][shotY] == 1){
            return true;
        }else if ( shot[shotX][shotY] == 3){
            shotY++;
            if (shot[shotX][shotY] == 1){
                return true;
            }else if ( shot[shotX][shotY] == 3){
                shotY++;
                if (shot[shotX][shotY] == 1){
                    return true;
                }
            }
        }

        shotY = y;
        shotY--;
        if (shot[shotX][shotY] == 1){
            return true;
        }else if ( shot[shotX][shotY] == 3){
            shotY--;
            if (shot[shotX][shotY] == 1){
                return true;
            }else if ( shot[shotX][shotY] == 3){
                shotY--;
                if (shot[shotX][shotY] == 1){
                    return true;
                }
            }
        }

        shotY = y;
        shotX--;
        if (shot[shotX][shotY] == 1){
            return true;
        }else if ( shot[shotX][shotY] == 3){
            shotX--;
            if (shot[shotX][shotY] == 1){
                return true;
            }else if ( shot[shotX][shotY] == 3){
                shotX--;
                if (shot[shotX][shotY] == 1){
                    return true;
                }
            }
        }

        shotX = x;
        shotX++;
        if (shot[shotX][shotY] == 1){
            return true;
        }else if ( shot[shotX][shotY] == 3){
            shotX++;
            if (shot[shotX][shotY] == 1){
                return true;
            }else if ( shot[shotX][shotY] == 3){
                shotX++;
                if (shot[shotX][shotY] == 1){
                    return true;
                }
            }
        }
        return false;
    }

}


