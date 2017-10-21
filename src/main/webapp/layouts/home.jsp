<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">

<link rel="stylesheet" type="text/css" href="${context}/resources/css/api/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${context}/resources/css/api/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${context}/resources/css/api/jquery-ui.structure.min.css" />
<link rel="stylesheet" type="text/css" href="${context}/resources/css/api/jquery-ui.theme.min.css" />
<link rel="stylesheet" type="text/css" href="${context}/resources/css/style.css" />
<tiles:getAsString name="css-01" ignore="true" />
<tiles:getAsString name="css-02" ignore="true" />
<tiles:getAsString name="css-03" ignore="true" />

<script type="text/javascript" src="${context}/resources/js/api/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/api/jquery-ui.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/api/bootstrap.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/api/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/api/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${context}/resources/js/api/integration_DT_Bootstrap.js"></script>
<script type="text/javascript" src="${context}/resources/js/geral.js"></script>
<tiles:getAsString name="javascript-01" ignore="true" />
<tiles:getAsString name="javascript-02" ignore="true" />
<tiles:getAsString name="javascript-03" ignore="true" />

<title><tiles:getAsString name="titulo" /></title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<!-- div class="navbar navbar-default navbar-fixed-top" role="navigation"-->
		<div class="container">
			<tiles:insertAttribute name="cabecalho" />
		</div>
	</div>

	<div class="container">
		<tiles:insertAttribute name="corpo" />
	</div>
</body>
</html>