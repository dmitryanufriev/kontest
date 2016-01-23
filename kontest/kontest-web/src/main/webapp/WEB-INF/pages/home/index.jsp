<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ru" ng-app="autocomplete">
	<head>
		<script src="http://code.angularjs.org/1.2.9/angular.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="<spring:url value="/resources/js/app.js" />"></script>
		<title>II часть тестового задания</title>
	</head>
	<body>
		<div ng-controller="AutocompleteCtrl">
            <input type="text" ng-model="prefix" ng-change="onedit('<spring:url value="/api/autocomplete/" />')">
            <br/> 
			<div ng-hide="!words.length">
				<div ng-repeat="word in words">
					<p>{{word}}</p>
				</div>
			</div>
   		</div>
	</body>
</html>