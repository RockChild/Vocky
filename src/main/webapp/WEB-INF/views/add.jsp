<%@ include file="pageTemplate.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div id="wrapper">
        <div id="content" class="container jumbotron">
            <form action="addWord" method="post">
              <div class="form-group">
                <label for="word">Word/Phrase</label>
                <input type="input" class="form-control" id="word" placeholder="word" name="word">
              </div>
              <div class="form-group">
                <label for="translation">Translation</label>
                <input type="input" class="form-control" id="translation" placeholder="Translation" name="translation">
              </div>
              <div class="form-group">
                <label for="category">Category</label>
                <input type="input" class="form-control" id="category" placeholder="Category" name="category">
              </div>
              <div class="form-group">
                <label for="txtFile">File input</label>
                <input type="file" id="txtFile">
                <p class="help-block">Example block-level help text here.</p>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" id="addNew" name="addNew"> Add new?</input>
                </label>
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" id="addAsWeekWord" name="addAsWeekWord"> Add word to current week stack?</input>
                </label>
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <c:if test="${!empty error}">
                <div class="alert alert-danger  fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Warning!</strong> ${error}
                </div>
              <div class="alert alert-info">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Info!</strong> This alert box could indicate a neutral informative change or action.
              </div>
            </c:if>

        </div>
        <div id="footer" align="center" style="padding:20px">
            <p>PS 2016</p>
        </div>
    </div>

</body>