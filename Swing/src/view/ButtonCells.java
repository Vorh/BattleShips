package view;

import javax.swing.*;
import java.awt.*;

public class ButtonCells extends Button {
    private int x;
    private int y;

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }


    public ButtonCells(int x, int y) {
        this.x = x;
        this.y = y;
    }


}


