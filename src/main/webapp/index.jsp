<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <link href="resources/jsxgraph/jsxgraph.css" rel="stylesheet">
        <script src="resources/jsxgraph/jsxgraphcore.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="resources/js/main.js"></script>
    </head>
    <body>
        <div>
            X:
            <select id="x">
                <c:forEach var="i" begin="0" end="9" step="1">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select><br />
            Y:
            <select id="y">
                <c:forEach var="i" begin="0" end="9" step="1">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select><br />
            <button id="add">Add</button>
            <button id="delete">Delete</button><br />
        </div>
        <div id="box" class="jxgbox" style="width:500px; height:500px;"></div>
    </body>
</html>
