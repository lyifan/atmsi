<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="${title}"/>
</jsp:include>

<h3>${title}</h3>

<br/>
<form name='frm_plannedJob'>
	<div><p>Select a place from the following <c:out value="${places.size()}"/> places</p></div>
	<div>
		<select name='place'>
			<c:forEach items="${places}" var="place">
				<option value="${place.id}">${place.name}</option>
			</c:forEach>
		</select>
	</div>
</form>
<jsp:include page="footer.jsp"/>
