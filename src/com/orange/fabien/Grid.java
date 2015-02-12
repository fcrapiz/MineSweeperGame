package com.orange.fabien;

import com.orange.fabien.exceptions.MineException;

/**
 * Created by fabiencrapiz on 11/02/15.
 */
public interface Grid {

    public void askForDisplay();

    public void initializeAndPlaceBombs(int number_mines, int height, int width);

    public boolean setPlayForPosition();

    public int getMinePosition(int raw, int column);

    public void displayGrid() throws MineException;

}
