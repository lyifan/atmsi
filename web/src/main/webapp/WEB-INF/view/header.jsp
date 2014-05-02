<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="context" value="${pageContext.request.contextPath}" scope="session"/>
<html>
	<head>
		<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />	
		<link rel='stylesheet' href='contents/styles/main.css' type='text/css'/>
		<script type='text/javascript' src='contents/scripts/lib/require.js'></script>
		<script type='text/javascript' defer='defer'>
		// <!--
		require.config({
			baseUrl: 'contents/scripts/',
			paths: {
				jquery: 'lib/jquery-2.1.0.min',
				angular: 'lib/angular.min'
			}
		});
		
		require(['jquery', 'angular'], function(jq, ng) {
			var app = angular.module('AtmsiApp', [])
				.directive('atmsiBody', function() {
					return {
					
					};
				});

			
			if( typeof setup_angular === 'function') {
				setup_angular(app);
			}
		});
		// -->
		</script>
		<title><%=request.getParameter("title")%></title>
	</head>
	<body ng-app="AtmsiApp">
		<div id='banner'>
		</div> <!-- banner -->
		<div id='content' atmsi-body>
