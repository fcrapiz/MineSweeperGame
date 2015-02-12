package com.orange.fabien.impl;

import com.orange.fabien.Grid;
import com.orange.fabien.exceptions.MineException;
import com.orange.fabien.res.Resource;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by fabiencrapiz on 10/02/15.
 */
public class GridImpl implements Grid {

    // grids for Play and Grid of Mines
    private int[][] gridMines;
    private char[][] gridPlay;

    // raws and columns entered by player
    private int raw, column;

    // parameters entered by player
    public int width, height, n_mines;

    // utils
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    /**
     * Constructeur GridImpl()
     */

    public GridImpl() {

        //Questions for beginning, initializing grids
        askForDisplay();
        initializeAndPlaceBombs(n_mines, height, width);
        addItemOnGridToPlay(height, width);
    }

    /**
     *
     */

    public void askForDisplay() {

        System.out.println(Resource.DISPLAY_GRID_SIZE);

        try {
            System.out.println(Resource.DISPLAY_GRID_HEIGHT);
            height = input.nextInt();
            System.out.println(Resource.DISPLAY_GRID_WIDTH);
            width = input.nextInt();
            System.out.println(Resource.DISPLAY_GRID_MINE_NUMBER);
            n_mines = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(Resource.ERROR_INPUT_MISMATCH);
            System.exit(0);
        }

        gridMines = new int[height][width];
        gridPlay = new char[height][width];
    }

    /**
     * @param number_mines
     * @param x
     * @param y
     */

    public void initializeAndPlaceBombs(int number_mines, int x, int y) {

        boolean alreadyPlaced;
        int line, column;

        if (number_mines > x * y) {
            System.out.println(Resource.DISPLAY_TOO_MANY_MINES);
            System.exit(0);
        }

        // initialize the Grid of Mines
        for (int mineLine = 0; mineLine < x; mineLine++) {
            for (int mineColumn = 0; mineColumn < y; mineColumn++) {
                gridMines[mineLine][mineColumn] = 0;
            }
        }

        // Placement of the bombs in the Grid of Mines
        for (int mines = 0; mines < number_mines; mines++) {
            do {
                // Random for Bomb placements
                line = random.nextInt(x - 1);
                column = random.nextInt(y - 1);

                if (gridMines[line][column] == -1) {  //Check if bomb already placed there
                    alreadyPlaced = true;
                } else {
                    alreadyPlaced = false;
                }
            } while (alreadyPlaced);

            // -1 is a Bomb case
            gridMines[line][column] = -1;
        }

        // then call function for adding numbers in cases around
        numberInCases();
    }

    /**
     *  Number of bombs around
     */

    public void numberInCases() {
        for (int line = 1; line < height; line++) {
            for (int column = 1; column < width; column++) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (gridMines[line][column] != -1) {
                            if ((line + i < height) && (column + j < width)) {
                                if (gridMines[line + i][column + j] == -1) {
                                    gridMines[line][column]++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @return
     */

    public boolean isEveryMinesDiscovered() {
        // Check if all the bombs were discovered in the Grid of Play
        int bombCounter = 0;
        for (int line = 0; line < height; line++)
            for (int column = 0; column < width; column++) {
                if (gridPlay[line][column] == '')
                    bombCounter++;
            }
        if (bombCounter == n_mines) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */

    public void discoverCases() {
        // indices around our case
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++) {
                //if that is not a mine and data entries are OK then discover cases around
                if ((column + j <= width - 1) && (raw + i <= height - 1)
                        && (column + j) != -1 && (raw + i) != -1) {
                    if ((gridMines[raw + i][column + j] != -1)
                            && (raw != -1 && raw != (height + 1)
                            && column != -1
                            && column != (width + 1))) {
                        gridPlay[raw + i][column + j] = Character.forDigit(gridMines[raw + i][column + j], n_mines);
                    }
                }
            }
    }

    /**
     * return the integer of the position
     * @param raw
     * @param column
     * @return
     */

    public int getMinePosition(int raw, int column) {
        return gridMines[raw][column];
    }

    /**
     * @return
     */

    public boolean setPlayForPosition() {

        askForLineAndColumn();

        try {
            if (gridPlay[raw][column] != '') {
                System.out.println(Resource.DISPLAY_ALREADY_SHOWN);
            }
        } catch (Exception e) {
            System.out.println(Resource.ERROR_VALUE_NOT_VALID);
            input.next();
        }

        if (getMinePosition(raw, column) == -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Display the Grid to play
     * @throws MineException
     */

    public void displayGrid() throws MineException {

        int w_width = getWidth();
        int h_height = getHeight();
        int mines = getN_mines();

        if (w_width * h_height < mines) {
            throw new MineException(Resource.DISPLAY_TOO_MANY_MINES);
        } else {
            for (int line = h_height; line > 0; line--) {
                for (int column = 0; column < w_width; column++) {
                    System.out.print("   " + gridPlay[line - 1][column]);
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    /**
     * @param x
     * @param y
     */

    public void addItemOnGridToPlay(int x, int y) {
        // add  to identify cases before launching
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                gridPlay[i][j] = '';
    }


    /**
     *
     */

    public void askForLineAndColumn() {
        // Scanner
        System.out.print(Resource.DISPLAY_LINE);
        raw = input.nextInt();
        System.out.print(Resource.DISPLAY_COLUMN);
        column = input.nextInt();
    }

    /**
     * @return
     */

    public int getWidth() {
        return width;
    }

    /**
     * @return
     */

    public int getHeight() {
        return height;
    }

    /**
     * @return
     */

    public int getN_mines() {
        return n_mines;
    }
}
