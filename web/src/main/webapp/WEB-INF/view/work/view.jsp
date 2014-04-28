<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="${title}"/>
</jsp:include>

<h3>${title}</h3>

<br/>
<p>Detail of job: ${job.reference} </p>
<jsp:include page="job.jsp">
	<jsp:param name="job" value="${job}" />
	<jsp:param name="places" value="${places}" />
</jsp:include>
<jsp:include page="../footer.jsp"/>
