<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="fooList" type="java.util.List"--%>

<html>
<body>
<form action="fooController">
	<br/>Name: <input type="text" name="n" value=""/>
	<br/>Value: <input type="text" name="v" value=""/>
	<br/><input type="submit"/>
</form>

Foo's:<br/>
<c:forEach items="${fooList}" var="element">
    <c:out value="${element.name}"/> => <c:out value="${element.value}"/><br/>
</c:forEach>
</body>
</html>