<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div id="wrapper">
        <div id="content" class="container jumbotron">
            <c:choose>
                <c:when test="${openedPage == 'optionWeek'}">
                    Week words
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

