<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.*" %>

<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/core/js/menu.js" var="menuJs"/>
<spring:url value="/resources/core/js/jquery.min.js" var="jquery"/>
<spring:url value="/resources/core/css/style.css" var="styleCss"/>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<script src="${menuJs}"/>
<script src="${bootstrapJs}"></script>
<script src="${jquery}"></script>

<link href="${styleCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<head>
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
              <li id="optionWeek"><a id="linkWeek" >Week words</a></li>
              <li id="optionMonth"><a id="linkMonth" >Month words</a></li>
              <li id="optionCategory"><a id="linkCategory" >Categories</a></li>
              <li id="optionAdd"><a id="linkAdd" >Add new</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%-- current date and time --%>
                <li id="dateLabel"><a><% out.print(new Date().toString()); %></a></li>
            </ul>
        </div
    </div>
</nav>