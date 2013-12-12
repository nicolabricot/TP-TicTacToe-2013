<%-- 
    Document   : index
    Created on : 12 dÃ©c. 2013, 14:15:10
    Author     : Nicolas Devenet <nicolas@devenet.info>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String title = "Tic Tac Toe";
    if (request.getParameter("title") != null)
        title = request.getParameter("title") + " &middot; " + title;
%>
<meta charset="UTF-8" />
<title><%= title %></title>
<meta name="author" content="Nicolas Devenet" />
<meta name="description" content="Tic Tac Toe" />
<meta name="robots" content="noindex, nofollow, noarchive" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon"    type="image/x-icon" href="assets/img/favicon.ico" />
<link rel="icon"             type="image/png"    href="assets/img/favicon.png" />
<!--[if lt IE 9]><script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" href="assets/css/tictactoe.css" media="screen" />
