<%-- 
    Document   : index
    Created on : 11 déc. 2013, 14:15:10
    Author     : Nicolas Devenet <nicolas@devenet.info>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <jsp:include page="/WEB-INF/head.jsp">
            <jsp:param name="title" value="Accueil" />
        </jsp:include>
    </head>
    <jsp:useBean id="game" scope="session" class="game.GameController" />
    <body>
        <jsp:include page="/WEB-INF/menu_header.jsp" />
        <div class="container">

            <div class="page-header">
                <a href="./" class="pull-right"><img src="assets/img/favicon.png" alt="&times" /></a>
                <h1>Tic Tac Toe <small>Bienvenue</small></h1>
            </div>

            <form action="./play" method="post" class="form-inline well well-lg espace-top-lg">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <button type="submit" name="user" class="btn btn-success btn-lg btn-block">Je commence&hellip;</button>
                        <br />
                        <button type="submit" name="computer" class="btn btn-info btn-lg btn-block">L’ordinateur commence&hellip;</button>
                    </div>
                </div>
            </form>
        </div>

        <jsp:include page="/WEB-INF/footer.jsp" />
    </body>
</html>
