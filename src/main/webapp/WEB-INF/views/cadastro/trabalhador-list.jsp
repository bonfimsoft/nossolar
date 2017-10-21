<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<ol class="breadcrumb">
	<li>Cadastro</li>
	<li class="active">Trabalhador</li>
</ol>


<h2>Trabalhador</h2>
<hr>
<!-----------------------------------------------------------
class= alert-success alert-info alert-warning alert-danger
------------------------------------------------------------>
<c:if test="${not empty mensagemSucesso}">
	<div class="alert alert-success" role="alert">
		<c:out value="${mensagemSucesso}" />
	</div>
</c:if>

<c:if test="${not empty mensagemErro}">
	<div class="alert alert-danger" role="alert">
		<c:out value="${mensagemErro}" />
	</div>
</c:if>

<c:if test="${not empty mensagemAlerta}">
	<div class="alert alert-warning" role="alert">
		<c:out value="${mensagemAlerta}" />
	</div>
</c:if>

<button id="btn-novo-trabalhador"
	class="btn btn-default btn-primary marginBottom">
	<span class="glyphicon  glyphicon-plus"></span> Novo
</button>

<div class="table-responsive">
	<table id="full" class=" table table-striped">
		<thead>
			<tr>
				<th width="5%">ID</th>
				<th width="79%">Nome</th>

				<th width="2%"></th>
				<th width="2%"></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th colspan="4"></th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach items="${trabalhadores}" var="trabalhador"
				varStatus="status">
				<tr id="${trabalhador.id}">
					<td>${trabalhador.id}</td>
					<td>${trabalhador.nome}</td>
					<td><form:form action="trabalhador_editar" method="post">
							<input type="hidden" name="id" value="${trabalhador.id}" />
							<button type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="trabalhador_excluir" method="post">
							<input type="hidden" name="id" value="${trabalhador.id}" />
							<button type="submit"
								class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
								title="Excluir">
								<span class="glyphicon  glyphicon-remove"></span>
							</button>
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
