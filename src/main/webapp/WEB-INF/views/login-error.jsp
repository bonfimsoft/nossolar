<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">

<link rel="stylesheet" type="text/css"
	href="resources/css/api/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script type="text/javascript"
	src="resources/js/api/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="resources/js/api/bootstrap.min.js"></script>

<title>Nosso Lar - Login</title>
</head>
<body>
	<div class="container">
		<div class="alert alert-danger text-center" role="alert">Usuário e/ou Senha
			Invalido(s)!</div>
		<form action="/nossolar/j_spring_security_check" class="form-signin"
			role="form" method="post">
			<h2 class="form-signin-heading">Nosso Lar</h2>
			<div class="form-group">
				<input name="j_username" type="text" class="form-control"
					placeholder="Login" required autofocus/>
			</div>
			<input name="j_password" type="password" class="form-control"
				placeholder="Senha" required/>
			<div class="checkbox"></div>	
			<!-- 
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">Lembrar-me
				</label>
			</div>
			 -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>
