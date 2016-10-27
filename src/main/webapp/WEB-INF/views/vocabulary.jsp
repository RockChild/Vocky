<%@ include file="pageTemplate.jsp" %>
<%@ include file="modal.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>


<html>
    <head>
        <title>Vocabulary</title>
        <link rel="stylesheet" type="text/css" href="${cssPath}/dataTables.css">

        <script src="${jsPath}/dataTables.js"></script>
        <script src="${jsPath}/bootstrap-datatables.js"></script>
        <script>
            $(document).ready(function() {
                dataTable("vocabulary");
            });
        </script>
    </head>
    <body>
        <div id="wrapper">
            <div id="content" class="container jumbotron">
                <div class="page-header">
                    <div class="row">
                        <div class="col-md-10">
                            <h3>Words List</h3>
                        </div>
                        <div class="col-md-2">
                            <!-- Button trigger modal -->
                            <button type="button" id="openModalButton" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addWordModal">
                                Add word
                            </button>
                        </div>
                    </div>
                </div>
                <c:if test="${!empty error}">
                    <div class="alert alert-danger  fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Warning!</strong> ${error}
                    </div>
                </c:if>
                <c:if test="${!empty listWords}">
                    <table id="vocabulary" class="table display dataTable">
                        <thead>
                            <tr>
                                <th  width="20">#</th>
                                <th  width="350">Word / Phrase</th>
                                <th  width="350">Translation</th>
                                <th  title="Category" align="center" width="175">
                                    <span class="glyphicon glyphicon-tasks"/>
                                </th>
                                <th title="In progress" width="30">
                                    <span class="glyphicon glyphicon-time"/>
                                </th>
                                <th title="Learned" width="30">
                                    <span class="glyphicon glyphicon-book"/>
                                </th>
                                <th title="Action" width="40">
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listWords}" var="word" varStatus="index">
                                <tr>
                                    <td align="center">
                                        ${index.index +1}
                                    </td>
                                    <td>
                                        <div class="divWord">${word.word}</div>
                                        <div class="divId" style="display:none;">${word.id}</div>
                                    </td>
                                    <td>${word.translation}</td>
                                    <td>${word.category}</td>
                                    <td align="center">
                                        <c:if test="${word.inProgress == true}">
                                            <span class="glyphicon glyphicon-ok"></span>
                                        </c:if>
                                    </td>
                                    <td align="center">
                                        <c:if test="${word.learned == true}">
                                            <span class="glyphicon glyphicon-ok"></span>
                                        </c:if>
                                    </td>
                                    <td align="center">
                                        <span class="glyphicon glyphicon-pencil" onclick="openAndFill(event)" aria-hidden="true"></span>
                                        <span class="glyphicon glyphicon-remove" onclick="deleteRegularWord(${word.id})" aria-hidden="true"></span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <div id="footer" align="center" style="padding:20px">
                PS 2016
                 <!-- ====A little of shit that could be valuable later===== -->
                                <input type="text" id="testAjaxInput">
                                <a href="#" onclick="doGetAjax()" class="btn btn-info" role="button">Test</a>
                                <span id="testSpan"></span>
                                <script>
                                    function doGetAjax() {
                                        var data = $("#testAjaxInput").val();

                                        $.ajax({
                                            type : "GET",
                                            url : "test?text="+data,
                                            success : function(data) {
                                                console.log(data);
                                                alert(data);
                                            },
                                            error : function(xhr, status, errorThrown){
                                                    alert('shit!');
                                                    console.log(xhr);
                                                    console.log(status);
                                                    console.log(errorThrown);
                                                }
                                        });
                                    }
                                </script>
                                <hr>
                                <!-- ==========================shit ends================= -->
            </div>
        </div>
    </body>
</html>
