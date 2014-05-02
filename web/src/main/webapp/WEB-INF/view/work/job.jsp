<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script type='text/javascript'>
// <!--
function abc() {
	
}
// -->
</script>
<form:form name='frm_plannedJob' commandName='job' action='work/save'>
	<table>
		<tr class="entity-id"><th>ID: </th><td><form:hidden path="id"/></td></tr>
		<tr><th>Job Ref: </th><td><form:input path="reference"/></td></tr>
		<tr><th>Start: </th><td><form:input path="start"/></td></tr>
		<tr><th>End: </th><td><form:input path="end"/></td></tr>
	</table>

	<table ng-controller='visitListController'>
		<caption>Visits: </caption>
		<thead>
			<tr>
				<th class="entity-id">Visit ID</th>
				<th>Place</th>
				<th>Start</th>
				<th>End</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${not empty job.visits}">
		<c:forEach items="${job.visits}" varStatus="loop">
			<tr>
				<td class="entity-id">
					<form:hidden path="visits[${loop.index}].id"/>
				</td>
				<td>
					<form:select path="visits[${loop.index}].place.id" id="place" items="${places}" itemValue="id" itemLabel="name" />
				</td>
				<td>
					<form:input path='visits[${loop.index}].start'/>
				</td>
				<td>
					<form:input path='visits[${loop.index}].end'/>
				</td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td>
					<form:select path="visits[0].place.id" id="place" items="${places}" itemValue="id" itemLabel="name" />					
				</td>
				<td>
					<input id="visits0.start" name="visits[0].start" type="text" value="2014-04-28 09:30:00"/>
				</td>
				<td>
					<input id="visits0.end" name="visits[0].end" type="text" value="2014-04-28 09:50:00"/>
				</td>
			</tr>		
			<tr>
				<td>
					<form:select path="visits[1].place.id" id="place" items="${places}" itemValue="id" itemLabel="name" />
				</td>
				<td>
					<input id='visits1.start' name='visits[1].start' value='2014-04-28 10:00:00' />
				</td>
				<td>
					<input id='visits1.start' name='visits[1].end' value='2014-04-28 10:30:00'/>
				</td>
			</tr>
			<tr>
				<td>
					<form:select path="visits[2].place.id" id="place" items="${places}" itemValue="id" itemLabel="name" />
				</td>
				<td>
					<input id='visits2.start' name='visits[2].start' value='2014-04-28 10:40:00' />
				</td>
				<td>
					<input id='visits2.start' name='visits[2].end' value='2014-04-28 11:00:00'/>
				</td>
			</tr>
			 </c:otherwise>
			 </c:choose>
		</tbody>
	</table>
	
	<br/>	
	<input value="Submit" type="submit">
	
</form:form>
