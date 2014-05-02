<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="${title}"/>
</jsp:include>
<script type='text/javascript'>
// <!--
// -->
</script>
<h3>${title}</h3>
<br />
<div id='job-list'>
	<c:choose>
	<c:when test="${empty jobs}">
		<p>Your job list is empty.</p>
	</c:when>
	<c:otherwise>
	<p><label for='jobs-filter'>Filter: </label><input id='jobs-filter'/></p>
	<table>
		<thead>
		<tr>
			<th class='entity-id'></th>
			<th>Job Reference</th>
			<th>Start</th>
			<th>End</th>
			<%--
			<th>Status</th>
			 --%>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${jobs}" var="job">
			<tr>
				<td class='entity-id'>${job.id}</td>
				<td><a href='work/edit/${job.id}'>${job.reference}</a></td>
				<td>${job.start}</td>
				<td>${job.end}</td>
				<%--
				<td>${job.status}</td>
				 --%>
				<td><a href='#'>Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:otherwise> <%-- job list not empty --%>
	</c:choose> <%-- if job list is empty --%>
	<br/>
	<a href='work/new'>New</a>
</div> <!-- job-list div -->

<jsp:include page="../footer.jsp"/>
