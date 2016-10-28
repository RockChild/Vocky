<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
    <div id="wrapper">
        <div id="content" class="jumbotron">
            <div class="container">
                <div class="page-header">
                    <h2>Check your vocabulary: </h2>
                </div>
                <div class="row">
                    <c:if test="${!empty weekWordsList}">
                        <div class="col-md-6">
                            <a class="btn btn-primary btn-lg" href="/vocky/checkWeekWords" role="button">Check week words >> </a>
                            <hr>
                            <div class="panel panel-default">
                                <div class="panel-heading">Words that should be checked</div>
                                <ul class="list-group">
                                <c:forEach items="${weekWordsList}" var="weekWord">
                                    <li class="list-group-item">
                                        ${weekWord.word.word}
                                    </li>
                                </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty monthWordsList}">
                        <div class="col-md-6">
                            <a class="btn btn-primary btn-lg" href="/vocky/checkMonthWords" role="button">Check month words >> </a>
                            <hr>
                            <div class="panel panel-default">
                                <div class="panel-heading">Words that should be checked</div>
                                <ul class="list-group">
                                    <c:forEach items="${monthWordsList}" var="monthWord">
                                        <li class="list-group-item">
                                            ${monthWord.word.word}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${empty weekWordsList and empty monthWordsList}">
                        <div class="alert alert-info">
                           Sorry, but You don't have any words to check. Come back in a while.
                        </div>
                    </c:if>
                </div>
            </div>
        <div id="footer" align="center" style="padding:20px">
            <p>PS 2016</p>
        </div>
    </div>

</body>

