<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
${exceptionObj }<br/>
<c:forEach items="${exceptionObj.stackTrace}" var="element">
    <c:out value="${element}"/><br/>
</c:forEach>
</body>
</html>