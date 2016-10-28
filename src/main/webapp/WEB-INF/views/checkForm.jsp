<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
         <title>Check form</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="content" class="container jumbotron">
                <div class="page-header">
                    <h3>Check Your Vock</h3>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5 class="panel-title">
                            <c:choose>
                                <c:when test="${checking == 'weekWord'}">
                                    Week words learning form.
                                </c:when>
                                <c:otherwise>
                                    Month words learning form.
                                </c:otherwise>
                            </c:choose>
                        </h5>
                    </div>
                    <div class="panel-body">
                        <c:choose>
                            <c:when test="${checking == 'weekWord'}">
                                <form class="form" action="/vocky/validateWeekWord" id="checkForm">
                            </c:when>
                            <c:otherwise>
                                <form class="form" action="/vocky/validateMonthWord" id="checkForm">
                            </c:otherwise>
                        </c:choose>

                            <span id="helpBlock" class="help-block">
                                To check you vocabulary please select correct translation from the list and click <strong>Check</strong> below the form.
                                <br>
                                To skip the word please click <strong>Skip</strong>
                                <br>
                                To stop the process click <strong>Finish</strong>
                            </span>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-3">
                                    <c:if test="${!empty word4Check}">
                                        <div class="form-group">
                                            <div id="wordDiv" class="well">${word4Check}</div>
                                            <input style="display:none;" class="form-control" type="text" name="word" value="${word4Check}"/>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="col-md-7">
                                    <div class="form-group">
                                        <ul class="nav nav-pills nav-stacked">
                                            <c:forEach items="${translationList}" var="word" varStatus="index">
                                                <li role="presentation"><a href="#" onclick="setTranslationSelect('${word}', event);">${word}</a></li>
                                            </c:forEach>
                                        </ul>
                                        <select name="translationSelect" class="form-control invisible" id="translationList">
                                             <c:forEach var="translation" items="${translationList}">
                                                 <option id="${translation}" name="translation">
                                                    ${translation}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${!empty error}">
                                <div class="alert alert-success">
                                    <p>${error}</p>
                                </div>
                            </c:if>
                            <div class="form-group" align="center">
                                <c:if test="${!empty checking}">
                                    <button type="submit" id="submitCheckForm"disabled="disabled" class="btn btn-success">Check</button>
                                    <c:choose>
                                        <c:when test="${checking == 'weekWord'}">
                                            <a href="/vocky/checkWeekWords" class="btn btn-warning" role="button">Skip</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/vocky/checkMonthWords" class="btn btn-warning" role="button">Skip</a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                                <a href="/vocky/checkList" class="btn btn-danger" role="button">Finish</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div id="footer">
                PS 2016
            </div>

        </div>
    </body>
</html>