/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import game.GameController;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
public abstract class ServletHelper {
    
    /**
     * Get the current Game Controller of the session
     * @param request
     * @return game controller of the current session
     */
    public static GameController getGameController(HttpServletRequest request) {
        return (GameController) request.getSession(true).getAttribute("game");
    }
    
}
