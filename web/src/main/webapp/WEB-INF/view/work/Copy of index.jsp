<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="${title}"/>
</jsp:include>
<script type='text/javascript'>
// <!--
function setup_angular(app) {
	app.controller('jobListController', function($scope) {
	 
        //$scope.jobs = ${jobs}
        $scope.jobs = [{
        	jobId: '1',
        	reference: 'Job 1',
        	start: new Date(),
        	end: new Date(),
        	status: 'In Progress(On Schedual)'
        },{
        	jobId: '2',
        	reference: 'Job 2',
        	start: new Date(),
        	end: new Date(),
        	status: 'In Progress(Running Late)'
        }];
	 
	});
}
// -->
</script>
<h3>${title}</h3>
<br />
<div id='job-list' ng-controller='jobListController'>
	<p><label for='jobs-filter'>Filter: </label><input id='jobs-filter' ng-model='query' /></p>
	<table>
		<thead>
		<tr>
			<th class='entity-id'></th>
			<th>Job Reference</th>
			<th>Start</th>
			<th>End</th>
			<th>Status</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<tr ng-repeat='job in jobs | filter:query'>
			<td class='entity-id'></td>
			<td><a href='work/edit/{{job.jobId}}'>{{job.reference}}</a></td>
			<td>{{job.start}}</td>
			<td>{{job.end}}</td>
			<td>{{job.status}}</td>
			<td><a href='#'>Delete</a></td>
		</tr>
		</tbody>
	</table>
	<br/>
	<a href='work/new'>New</a>
</div> <!-- job-list -->

<jsp:include page="../footer.jsp"/>
