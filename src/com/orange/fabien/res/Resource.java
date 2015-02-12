package com.orange.fabien.res;

/**
 * Created by fabiencrapiz on 10/02/15.
 */
public class Resource {

    public static final String DISPLAY_TOO_MANY_MINES = "Number of mines too high for this grid ! :(";
    public static final String DISPLAY_GRID_SIZE = "\n What's the grid size ? \n";

    public static final String DISPLAY_STAR = "*********************************";
    public static final String DISPLAY_WELCOME = "Welcome to the MineSweeper Game !";
    public static final String DISPLAY_GRID_WIDTH = "Please type the width (x) of your grid :";
    public static final String DISPLAY_GRID_HEIGHT = "Type the height (y) of your grid :";
    public static final String DISPLAY_GRID_MINE_NUMBER = "Type the number of mines :";
    public static final String DISPLAY_BAD_ARGUMENT = "Incorrect Arguments";
    public static final String DISPLAY_LINE = "\n   Line ? ";
    public static final String DISPLAY_COLUMN = "   Column ? ";

    public static final String DISPLAY_HELP_APPLICATION = "Game steps:\n" +
            "* When the game starts, the player gets prompted for the grid size (width x height) and the number of mines.\n" +
            "* The grid is generated according to these requirements.\n" +
            "* The games starts, the user is prompted for the coordinates (x, y) of the first cell to uncover.\n" +
            "* The game shows the resulting grid and prompts for new coordinates.\n" +
            "* And so on ...\n" +
            "The game ends when there is no more non-mined cell to uncover or the player uncovers a mine.\n" +
            "Rules:\n" +
            "* Uncover a mine, and the game ends.\n" +
            "* Uncover an empty cell, and the player keeps playing.\n" +
            "* In each empty uncovered cell the number of adjacent cells holding mines is displayed.\n" +
            "* Uncovering a cell holding the number '0' (=no adjacent mined cells) uncovers all adjacent cells, and so on.\n";

    public static final String DISPLAY_ALREADY_SHOWN = "Case already displayed";
    public static final String DISPLAY_CONGRATULATIONS = "Congratulations, you win !!!";
    public static final String DISPLAY_LOST = "You've lost ! This is a mine !";

    public static final String ERROR_INPUT_MISMATCH = "Bad String input. Exit";
    public static final String ERROR_VALUE_NOT_VALID = "Value(s) not valid. Exit";
}
