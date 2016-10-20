<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${cssPath}/dataTables.css">
        <script src="${jsPath}/dataTables.js"></script>
        <script src="${jsPath}/bootstrap-datatables.js"></script>
        <script>
            $(document).ready(function() {
                $('#words').dataTable();
            });
        </script>
    </head>
    <body>
        <div id="wrapper">
            <div id="content" class="container jumbotron">
                <c:choose>
                    <c:when test="${openedPage == 'optionWeek' or openedPage == 'optionMonth'}">
                        <div class="page-header">
                            <c:choose>
                                <c:when test="${openedPage == 'optionWeek'}">
                                    <h3> Week words list </h3>
                                </c:when>
                                <c:otherwise>
                                    <h3> Month words list </h3>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <table class="table display dataTable" id="words">
                            <thead>
                                <tr>
                                    <th width="20">#</th>
                                    <th width="350">Word</th>
                                    <th width="350">Translation</th>
                                    <th width="200">Category</th>
                                    <th width="40">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${!empty listWords}">
                                    <c:forEach items="${listWords}" var="word" varStatus="loop">
                                        <c:if test="${word.shouldBeChecked}">
                                            <tr class="danger" title="Word should be checked">
                                        </c:if>
                                            <th>${loop.index +1}</th>
                                            <td>
                                                ${word.word.word}
                                            </td>
                                            <td>
                                                ${word.word.translation}
                                            </td>
                                            <td>
                                                ${word.word.category}
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${openedPage == 'optionWeek'}">
                                                        <span class="glyphicon glyphicon-remove" onclick="deleteWeekWord(${word.id})" title="Remove from the week learning stack" aria-hidden="true"></span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="glyphicon glyphicon-remove" onclick="deleteMonthWord(${word.id})" title="Remove from the month learning stack" aria-hidden="true"></span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody
                        </table>
                    </c:when>
                    <c:otherwise>
                        Error
                    </c:otherwise>
                </c:choose>
            </div>

            <div id="footer" align="center" style="padding:20px">
                <p>PS 2016</p>
            </div>
        </div>

    </body>
</html>

