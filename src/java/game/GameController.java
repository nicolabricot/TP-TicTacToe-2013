/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
public class GameController {

    private boolean beginWithUser;
    private boolean isGameEnded;
    private Game game;
    private LineFinder lineFinder;
    private Player winner;
    private int lastCellPlayedByComputer;

    public GameController() {
        beginWithUser = false;
        isGameEnded = false;
    }

    /**
     * Set if player user should to begin. Default if false.
     *
     * @param player
     */
    public void beginWithUser(boolean player) {
        beginWithUser = player;
    }

    /**
     * Start a new game
     */
    public void startGame() {
        game = new Game();
        isGameEnded = false;
        lineFinder = new LineFinder(game);
        lastCellPlayedByComputer = -1;
        if (!beginWithUser) {
            playCellByComputer();
        }
    }

    /**
     * Say if the game is at end: someone won or the game is blocked
     *
     * @return if game is ended
     */
    public boolean isGameEnded() {
        return isGameEnded;
    }

    /**
     * Play a cell by an user
     *
     * @param position
     * @return if user could played this cell
     */
    public boolean playCellByUser(int position) {
        // check that given position is in allowed range
        if (position <= 0 && position > Game.COLS * Game.ROWS) {
            return false;
        }
        // please Game, do the job!
        boolean result = game.playCell(position, true);
        updateStateGameEnd(position);
        lastCellPlayedByComputer = -1;
        return result;
    }

    /**
     * Play a cell by the computer
     */
    public void playCellByComputer() {
        // please Game, do the job!
        int position = game.getRandomAvailableCell();
        game.playCell(position, false);
        updateStateGameEnd(position);
        lastCellPlayedByComputer = position;
    }

    /**
     * Return the HTML to display a game cell cell, based on its state
     *
     * @param position
     * @return an html string to content a cell
     */
    public String getCellHTML(int position) {
        StringBuilder out = new StringBuilder();
        out.append("<td");
        if (position == lastCellPlayedByComputer) {
            out.append(" class=\"ttt-computer-cell-played\"");
        }
        out.append(">");
        out.append(game.getCellHTML(position, !isGameEnded));
        out.append("</td>");
        return out.toString();
    }

    public Player getWinner() {
        return winner;
    }

    /**
     * Check if game is ended by searching a line or if cell are anymore available
     *
     * @param position
     */
    private void updateStateGameEnd(int position) {
        if (lineFinder.lineFound(position)) {
            Logger.getLogger(GameController.class.getName()).log(Level.FINE, "A line is found");
            isGameEnded = true;
            winner = lineFinder.getWinner();
        }

        if (!isGameEnded && !game.hasAvailableCell()) {
            Logger.getLogger(GameController.class.getName()).log(Level.FINE, "No cell available anymore");
            isGameEnded = true;
            winner = Player.NoBody;
        }
    }
}
