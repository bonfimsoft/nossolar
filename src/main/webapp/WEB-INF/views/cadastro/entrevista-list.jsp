<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="entrevista.breadcrumb.n1" /></li>
	<li><a href="paciente_listar"> <spring:message
				code="entrevista.breadcrumb.n2" />
	</a></li>
	<li><a href="paciente_editar?id=${paciente.id}"> <spring:message
				code="entrevista.breadcrumb.n3" />
	</a></li>
	<li><a href="atendimento_editar?id=${atendimento.id}"> <spring:message
				code="entrevista.breadcrumb.n4" />
	</a></li>
	<li class="active"><spring:message code="entrevista.breadcrumb.n5" />
	</li>
</ol>

<div class="row">
	<div class="col-md-2">
		<label for="tb008_id_atendimento"><spring:message
				code="atendimento.form.label.id" /></label>
		 <form:input id="tb008_id_atendimento" path="paciente.id"
			cssClass="form-control" disabled="true" />
	</div>
	<div class="col-md-4">
		<label for="tb003_no_paciente"><spring:message
				code="atendimento.form.label.nomepaciente" /></label>
		<form:input id="tb003_no_paciente" path="paciente.nome"
			cssClass="form-control" disabled="true" />
	</div>
	<div class="col-md-2">
		<label for="tb008_dt_inicio"><spring:message
				code="atendimento.form.label.datainicio" /></label>
		<form:input id="tb008_dt_inicio" path="atendimento.dataInicio"
			cssClass="form-control" disabled="true" />
	</div>
	<div class="col-md-2">
		<label for="tb008_dt_fim"><spring:message
				code="atendimento.form.label.datafim" /></label>
		<form:input id="tb008_dt_fim" path="atendimento.dataFim"
			cssClass="form-control" disabled="true" />
	</div>
	<div class="col-md-2">
		<label for="tb008_ic_situacao"><spring:message
				code="atendimento.form.label.situacao" /></label>
		<form:input id="tb008_ic_situacao"
			path="atendimento.situacaoAtendimento.descricao"
			cssClass="form-control" disabled="true" />
	</div>
</div>

<h2>
	<spring:message code="entrevista.breadcrumb.n5" />
</h2>
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

<div class="row">
	<div class="col-md-12">
		<c:if test="${atendimento.situacaoAtendimento == 'A'}">
			<button id="btn-novo-entrevista"
				class="btn btn-default btn-primary marginBottom">
				<span class="glyphicon  glyphicon-plus"></span> Novo
			</button>
		</c:if>
		<button id="btn_entrevista_lista_voltar" type="button"
			class="btn btn-default marginBottom">Voltar</button>
	</div>
</div>

<input type="hidden" id="id_atendimento" value="${atendimento.id}" />

<div class="table-responsive">
	<table id="full" class=" table table-striped">
		<thead>
			<tr>
				<th width="5%">ID</th>
				<th width="20%">Data</th>
				<th width="51%">Entrevistador</th>
				<th width="20%">Tipo</th>
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
			<c:forEach items="${entrevistas}" var="entrevista" varStatus="status">
				<tr id="${entrevista.id}">
					<td>${entrevista.id}</td>
					<td><fmt:formatDate value="${entrevista.dataEntrevista}"
							pattern="dd/MM/yyyy" type="DATE" /></td>
					<td>${entrevista.entrevistador}</td>
					<td>${entrevista.tipoEntrevista.descricao}</td>
					<td><form:form action="entrevista_editar" method="post">
							<input type="hidden" name="id" value="${entrevista.id}" />
							<button type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="entrevista_excluir" method="post">
							<input type="hidden" name="id" value="${entrevista.id}" />
							<c:choose>
								<c:when test="${atendimento.situacaoAtendimento != 'A'}">
									<button type="submit"
										class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
										title="Excluir" disabled="disabled">
										<span class="glyphicon  glyphicon-remove"></span>
									</button>
								</c:when>
								<c:otherwise>
									<button type="submit"
										class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
										title="Excluir">
										<span class="glyphicon  glyphicon-remove"></span>
									</button>
								</c:otherwise>
							</c:choose>
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
