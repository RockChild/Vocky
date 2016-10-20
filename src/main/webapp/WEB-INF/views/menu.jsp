<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.*" %>

<spring:url value="/resources/core/css" var="cssPath"/>
<spring:url value="/resources/core/js" var="jsPath"/>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">


<head>
    <link href="${cssPath}/style.css" rel="stylesheet" />
    <link href="${cssPath}/bootstrap.min.css" rel="stylesheet" />
    <script src="${jsPath}/jquery.min.js"></script>
    <script src="${jsPath}/bootstrap.min.js"></script>
    <script src="${jsPath}/menu.js"></script>
    <title>Vocky</title>
</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
              <button type="button" id="collapseButton" class="navbar-toggle" data-toggle="collapse" data-target="#menuBar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
            <a class="navbar-brand" id="linkVocky" href="/vocky">Vocky</a>
        </div>
        <div class="collapse navbar-collapse" id="menuBar">
            <ul class="nav navbar-nav">
              <li id="optionHome"><a id="linkHome" >Home</a></li>
              <li id="optionVocabulary"><a id="linkVocabulary" >Vocabulary</a></li>
              <li id="optionWeek"><a id="linkWeek" >Week words</a></li>
              <li id="optionMonth"><a id="linkMonth" >Month words</a></li>
              <li id="optionCategory"><a id="linkCategory" >Categories</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%-- current date and time --%>
                <li id="dateLabel"><a><% out.print(new Date().toString()); %></a></li>
            </ul>
        </div
    </div>
</nav>