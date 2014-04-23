<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel='stylesheet' href='contents/styles/main.css' type='text/css'></link>
		<script type='text/javascript' src='contents/scripts/lib/require.js'></script>
		<script type='text/javascript'>
		// <!--
		require.config({
			baseUrl: 'contents/scripts/',
			paths: {
				jquery: 'lib/jquery-2.1.0.min',
				angular: 'lib/angular.min'
			}
		});
		
		require(['jquery', 'angular'], function(jq, ng) {
			angular.module('AtmsiApp', []);
		});
		// -->
		</script>
		<title><%=request.getParameter("title")%></title>
	</head>
	<body>
		<div id='banner'>
		</div>
		<div id='content' ng-app='AtmsiApp'>
