<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div id="wrapper">
        <div id="content" class="container jumbotron">
            <c:choose>
                <c:when test="${openedPage == 'optionWeek'}">
                    <c:if test="${!empty listWords}">
                        <div class="row">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-8">
                                <table class="table table-inverse table-stripped table-hover table-responsive">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Word</th>
                                            <th>Translation</th>
                                            <th>Category</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${listWords}" var="weekWord" varStatus="loop">
                                        <c:choose>
                                            <c:when test="${weekWord.shouldBeChecked}">
                                                <tr class="danger" title="Word should be checked">
                                            </c:when>
                                            <c:otherwise>
                                                <tr class="info">
                                            </c:otherwise>
                                        </c:choose>
                                            <th>${loop.index +1}</th>
                                            <td>
                                                ${weekWord.word.word}
                                            </td>
                                            <td>
                                                ${weekWord.word.translation}
                                            </td>
                                            <td>
                                                ${weekWord.word.category}
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <div class="col-sm-3"/>
                        </div>
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

