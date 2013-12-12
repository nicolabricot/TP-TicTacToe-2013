/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Game.COLS;
import static game.Game.ROWS;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
public class LineFinder {

    private Game game;
    private Player winner;
    
    private static final int MAX = 3;

    public LineFinder(Game game) {
        this.game = game;
    }

    public boolean lineFound(int position) {

        int coordinates[] = Game.getCoordinates(position);
        int x = coordinates[0], y = coordinates[1];
        
        Player player = game.getCell(position).getPlayer();
        int sameCells = 0, i = 0, j = 0;
        
        // in the current line, how many of the same given cell do we have?
        while (i < COLS) {
            if (game.getCell(i, y).getPlayer() == player) { sameCells++; }
            i++;
        }
        if (sameCells == MAX) {
            winner = player;
            return true;
        } 
        
        sameCells = 0;
        i = 0;
        // in the current row, how many of the same given cell do we have?
        while (i < ROWS) {
            if (game.getCell(x, i).getPlayer() == player) { sameCells++; }
            i++;
        }
        if (sameCells == MAX) {
            winner = player;
            return true;
        } 
        
        sameCells = 0;
        i = 0; j = 0;
        // top left to bottom right diagonal
        while (i < COLS) {
            if (game.getCell(i, j).getPlayer() == player) { sameCells++; }
            i++; j++;
        }
        if (sameCells == MAX) {
            winner = player;
            return true;
        }
        
        sameCells = 0;
        i = 0; j = ROWS-1;
        // top left to bottom right diagonal
        while (i < COLS) {
            if (game.getCell(i, j).getPlayer() == player) { sameCells++; }
            i++; j--;
        }
        if (sameCells == MAX) {
            winner = player;
            return true;
        }
        
        return false;
    }
    
    public Player getWinner() {
        return winner;
    }
    

}
