<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form name='frm_plannedJob' commandName='job' action='work/save'>
	<table>
		<tr><td>Job Ref: </td><td><form:input path="reference"/></td></tr>
		<tr><td>Start: </td><td><form:input path="start"/></td></tr>
		<tr><td>End: </td><td><form:input path="end"/></td></tr>
	</table>
	
	<div><p>Select a place from the following <c:out value="${places.size()}"/> places</p></div>
	<div>
		<select name='place'>
			<c:forEach items="${places}" var="place">
				<option value="${place.id}">${place.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<br/>	
	<input value="Submit" type="submit">
	
</form:form>
