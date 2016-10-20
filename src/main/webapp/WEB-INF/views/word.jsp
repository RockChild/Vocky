<%@ include file="pageTemplate.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Word Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
    <div id="wrapper">
        <div id="content" class="container jumbotron">
            <h1>
                Add a Word
            </h1>

            <c:url var="addAction" value="/word/addd" ></c:url>

            <form:form action="${addAction}" commandName="word">
                <table>
                    <c:if test="${!empty word.word}">
                    <tr>
                        <td colspan="2">
                            <form:hidden path="id" />
                        </td>
                    </tr>
                    </c:if>
                    <tr>
                        <td>
                            <form:label path="word">
                                <spring:message text="Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="word" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="category">
                                <spring:message text="Category"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="category" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <c:choose>
                                <c:when test="${!empty word.word}">
                                    <input type="submit"
                                        value="<spring:message text="Edit Word"/>" />
                                </c:when>
                                <c:otherwise>
                                    <input type="submit"
                                        value="<spring:message text="Add Word"/>" />
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </form:form>
            <br>
            <h3>Words List</h3>
            <c:if test="${!empty listWords}">
                <table class="tg">
                    <tr>
                        <th width="80">Word ID</th>
                        <th width="120">Word</th>
                        <th width="120">Translation</th>
                        <th width="120">Category</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listWords}" var="word">
                        <tr>
                            <td>${word.id}</td>
                            <td>${word.word}</td>
                            <td>${word.translation}</td>
                            <td>${word.category}</td>
                            <td><a href="<c:url value='/edit/${word.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/remove/${word.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:forEach items="${listWeekWords}" var="weekWord">
                        <br>${weekWord.id}
                        <br>${weekWord.word}</td>
                        <br>${weekWord.word.word}</td>
            </c:forEach>
        </div>
        <div id="footer" align="center" style="padding:20px">
                    <p>PS 2016</p>
        </div>
    </div>
</body>
</html>
