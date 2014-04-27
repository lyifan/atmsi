<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="${title}"/>
</jsp:include>

<h3>${title}</h3>

<br/>

<a href='${sessionScope.context}/work'>Work</a>

<jsp:include page="footer.jsp"/>
