<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<ol class="breadcrumb">
	<li>Cadastro</li>
	<li class="active">Paciente</li>
</ol>


<h2>Paciente</h2>
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


<button id="btn-novo-paciente" type="button"
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
			<c:forEach items="${pacientes}" var="paciente" varStatus="status">
				<tr id="${paciente.id}">
					<td>${paciente.id}</td>
					<td>${paciente.nome}</td>
					<td><form:form action="${context}/paciente_editar" method="get">
							<input type="hidden" name="id" value="${paciente.id}" />
							<button id="btn_editar_paciente_${paciente.id}" type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="${context}/paciente_excluir" method="post">
							<input type="hidden" name="id" value="${paciente.id}" />
							<button id="btn_excluir_paciente_${paciente.id}" type="submit"
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