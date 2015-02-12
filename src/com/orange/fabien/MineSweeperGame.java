package com.orange.fabien;

import com.orange.fabien.impl.PlayImpl;
import com.orange.fabien.res.Resource;

/**
 * Created by fabiencrapiz on 10/02/15.
 */
public class MineSweeperGame {

    public static void main(String[] args) {

        if (args != null) {
            for (String arg : args) {
                switch (arg) {
                    case "--help":
                        displayMineSweeperHelp();
                        break;
                    default:
                        System.err.println(Resource.DISPLAY_BAD_ARGUMENT);
                }
            }
        }

        displayMineSweeperWelcome();
        PlayImpl play = new PlayImpl();
    }

    private static void displayMineSweeperWelcome() {

        System.out.println(Resource.DISPLAY_STAR);
        System.out.println(Resource.DISPLAY_WELCOME);
        System.out.println(Resource.DISPLAY_STAR);
    }

    private static void displayMineSweeperHelp() {

        System.out.println(Resource.DISPLAY_HELP_APPLICATION);
    }
}
