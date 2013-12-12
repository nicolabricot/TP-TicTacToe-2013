/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
public class Game {
    
    private Cell[][] cells;
    
    public final static int COLS = 3;
    public final static int ROWS = 3;
    
    public final static String IMAGE_PATH = "assets/img/";
    
    /**
     * Default constructor
     */
    public Game() {
        cells = new Cell[COLS][ROWS];
        int id = 0;
        for (int i=0; i<COLS; i++) {
            for (int j=0; j<ROWS; j++) {
                cells[i][j] = new Cell();
                id++;
            }
        }
    }
    
    /**
     * Return a random position of an available (ie empty) cell
     * @return position of an available cell
     */
    public int getRandomAvailableCell() {
        ArrayList<Integer> availableCells = new ArrayList<>();
        int position = 1;
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (cells[j][i].getPlayer() == Player.NoBody) { availableCells.add(position); }
                position++;
            }
        }
        Collections.shuffle(availableCells);
        position = availableCells.get(0);
        return position;
    }
    
    /**
     * Get if there is still at least one available cell
     * @return if there is still an empty cell
     */
    public boolean hasAvailableCell() {
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (cells[j][i].getPlayer() == Player.NoBody) { return true; }
            }
        }
        return false;
    }
    
    /**
     * Get the given cell with its position
     * @param position
     * @return asked cell
     */
    protected Cell getCell(int position) {
        int p = position - 1;
        return cells[p%COLS][p/ROWS];
    }
    
    /**
     * Get the given cell with its coordinates
     * @param x place in horizontal table
     * @param y place in vertical table
     * @return asked cell
     */
    protected Cell getCell(int x, int y) {
        return cells[x][y];
    }
    
    /**
     * Get the coordinates for a given position of a cell
     * @param position
     * @return x and y coordinates of a cell
     */
    public static int[] getCoordinates(int position) {
        int p = position - 1;
        int[] result = {p%COLS, p/ROWS};
        return result;
    }
    
    /**
     * Play a cell, and update its Player state
     * @param position
     * @param playedByUser
     * @return if action has been executed (to avoid cheat)
     */
    public boolean playCell(int position, boolean playedByUser) {
        Cell c = getCell(position);
        // check that cell is available
        if (! c.isAvailable()) { return false; }
        c.played(playedByUser);
        
        Logger.getLogger(Game.class.getName()).log(Level.FINE, ((playedByUser) ? "User" : "Computer") + " played cell: " + position);
        return true;
    }
    

    
    /**
     * Return the HTML of a cell with link and image based on his state
     * @param position
     * @return partial html string to display a cell
     */
    public String getCellHTML(int position, boolean displayLink) {
        Cell c = getCell(position);
        StringBuilder out = new StringBuilder();
        // check if we need to add a link
        if (c.isAvailable() && displayLink) {
            out.append("<a href=\"")
                    .append("./game?cell=")
                    .append(position)
                     .append("\">");
        }
        // display image based on cell state
        out.append(c.getImageHTML());
        // do we need to close the link?
        if (c.isAvailable() && displayLink) { out.append("</a>"); }
        return out.toString();
    }
        
}
