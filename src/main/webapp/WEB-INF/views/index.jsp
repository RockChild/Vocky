<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<html>
    <head>
        <title>Vocky</title>
    </head>

    <body >
        <div id="wrapper">
            <div id="content" class="container jumbotron" style="padding-left:30%; padding-right:30%" align="center">
                <div class="panel-group" style="padding-top:15%">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3>${title}</h3>
                        </div>
                        <div class="panel-body">
                            <form action="home" method="post">
                                <div class="form-group">
                                <label for="languages">Choose your Destiny:</label>
                                    <select name="languageOption" class="form-control" id="languages">
                                         <c:forEach var="language" items="${languages}">
                                             <option  name="option">
                                                <c:out value="${language}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-primary">To the Dark Side</button>
                             </form>
                         </div>
                     </div>
                 </div>
            </div>
            <div id="footer" align="center" style="padding:20px">
                <p>PS 2016</p>
            </div>
        </div>
    </body>
</html>