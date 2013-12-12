<%-- 
    Document   : game
    Created on : 11 déc. 2013, 15:01:34
    Author     : Nicolas Devenet <nicolas@devenet.info>
--%>
<%@page import="game.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <jsp:include page="/WEB-INF/head.jsp">
            <jsp:param name="title" value="Jeu" />
        </jsp:include>
    </head>
    <jsp:useBean id="game" scope="session" class="game.GameController" />
    <body>
        <jsp:include page="/WEB-INF/menu_header.jsp" />
        <div class="container">
            
            <div class="page-header">
                <a href="./" class="pull-right"><img src="assets/img/favicon.png" alt="&times" /></a>
                <h1>Tic Tac Toe <small>Le jeu</small></h1>
            </div>
        
        <%
            if (game.isGameEnded()) {
                out.println("<div class=\"row\"><div class=\"col-md-6 col-md-offset-3 text-center\">");
                switch (game.getWinner()) {
                    case User:
                        out.println("<div class=\"alert alert-success\"><p><span class=\"glyphicon glyphicon-thumbs-up text-lg\"></span></p>Vous avez gagné !</div>");
                        break;
                    case Computer:
                        out.println("<div class=\"alert alert-danger\"><p><span class=\"glyphicon glyphicon-thumbs-down text-lg\"></span></p>Vous avez perdu !</div>");
                        break;
                    case NoBody:
                    default:
                        out.println("<div class=\"alert alert-warning\">Match nul !</div>");
                }
                out.println("</div></div>");
            }
        %>

        <table class="ttt-table">
            <%
                int position = 1;
                for (int i = 0; i < Game.ROWS; i++) {
                    out.println("<tr>");
                    for (int j = 0; j < Game.COLS; j++) {
                        out.print(game.getCellHTML(position++));
                    }
                    out.println("</tr>");
                }
            %>
        </table>

        <%
            if (game.isGameEnded()) {
                out.println("<div class=\"espace-top-lg row\"><div class=\"col-md-6 col-md-offset-3\"><a href=\"./\" class=\"btn btn-default btn-lg btn-block\">Rejouer !</a></div></div>");
            }
        %>
        
        </div>
        
        
    <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
