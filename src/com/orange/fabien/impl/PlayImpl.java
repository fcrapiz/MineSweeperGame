package com.orange.fabien.impl;

import com.orange.fabien.Play;
import com.orange.fabien.exceptions.MineException;
import com.orange.fabien.res.Resource;

/**
 * Created by fabiencrapiz on 10/02/15.
 */
public class PlayImpl implements Play {

    private GridImpl grid;
    boolean finish = false;

    /**
     * Constructeur PlayImpl()
     */

    public PlayImpl() {
        grid = new GridImpl();
        play(grid);
    }

    /**
     * @param grid
     */

    public void play(GridImpl grid) {
        do {
            try {
                grid.displayGrid();
            } catch (MineException e) {
                System.out.println(e.getMessage());
            }
            finish = grid.setPlayForPosition();
            if (!finish) {
                grid.discoverCases();
                finish = grid.isEveryMinesDiscovered();
            }
        } while (!finish);

        if (grid.isEveryMinesDiscovered()) {
            System.out.println(Resource.DISPLAY_CONGRATULATIONS);
        } else {
            System.out.println(Resource.DISPLAY_LOST);
        }
    }
}
