<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="${context}/principal">NOSSO LAR </a>
</div>
<div class="navbar-collapse collapse">
	<ul class="nav navbar-nav">
		<!-- 
		<li><a href="#">Consulta</a></li>
		 -->
		<li class="Cadastro "><a href="#" class="dropdown-toggle"
			data-toggle="dropdown">Cadastro <span class="caret"></span></a>
			<ul class="dropdown-menu" role="menu">
				<li><a href="${context}/trabalhador_listar">Trabalhador</a></li>
				<li><a href="${context}/paciente_listar">Paciente</a></li>
				<!--
				<li><a href="#">Compromisso</a></li> 
				<li class="divider"></li>
				<li class="dropdown-header">Nav header</li>
				<li><a href="#">Separated link</a></li>
				<li><a href="#">One more separated link</a></li>
				<li class="dropdown-submenu"><a tabindex="-1" href="#">Mais opções -</a>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu">
						<li><a href="#">teste2</a></li>
						<li><a href="#">teste2</a></li>
					</ul>
				</li>
				-->
			</ul></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li class="dropdown"><a href="#" id="drop3" role="button"
			class="dropdown-toggle" data-toggle="dropdown"><span
				class="glyphicon glyphicon-user"></span> ${sessionScope.nomeUsuario} <b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<!-- 
				<li><a href="#perfil"><span
						class="glyphicon glyphicon-user"></span> Perfil</a></li>
						
				<li class="divider"></li>
				 -->
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Sair</a></li>
			</ul></li>
	</ul>

</div>
<!--/.nav-collapse -->
