<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="menu.jsp" %>

<script>
    window.onload = function() {
        correctMenu('${openedPage}');
        setWordsIndexes('${weekNum4Check}', '${monthNum4Check}');
    };
</script>
