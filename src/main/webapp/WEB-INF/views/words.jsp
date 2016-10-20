<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <c:when test="${openedPage == 'optionWeek'}">
                    <c:if test="${!empty listWords}">
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
                                        <span class="glyphicon glyphicon-remove" onclick="deleteWeekWord(${word.id})" title="Remove from learning stack" aria-hidden="true"></span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </c:when>
                <c:when test="${openedPage == 'optionMonth'}">
                    Month words
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

