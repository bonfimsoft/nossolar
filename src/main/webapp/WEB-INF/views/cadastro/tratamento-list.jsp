<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="tratamento.breadcrumb.n1" /></li>
	<li><a href="paciente_listar"> <spring:message
				code="tratamento.breadcrumb.n2" />
	</a></li>
	<li><a href="paciente_editar?id=${paciente.id}"> <spring:message
				code="tratamento.breadcrumb.n3" />
	</a></li>
	<li><a href="atendimento_editar?id=${atendimento.id}"> <spring:message
				code="tratamento.breadcrumb.n4" />
	</a></li>
	<li class="active"><spring:message code="tratamento.breadcrumb.n5" />
	</li>
</ol>

<div class="row">
	<div class="col-md-2">
		<label for="tb008_id_atendimento"><spring:message
				code="atendimento.form.label.id" /></label> <input type="text"
			id="tb008_id_atendimento" class="form-control" readonly="readonly"
			value="${atendimento.id}" />
	</div>
	<div class="col-md-4">
		<label for="tb008_no_paciente"><spring:message
				code="atendimento.form.label.nomepaciente" /></label> <input type="text"
			id="tb008_no_paciente" class="form-control" disabled="disabled"
			value="${paciente.nome}" />
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
		<form:input id="tb008_dt_inicio" path="atendimento.dataFim"
			cssClass="form-control" disabled="true" />
	</div>
	<div class="col-md-2">
		<label for="tb008_ic_situacao"><spring:message
				code="atendimento.form.label.situacao" /></label> <input type="text"
			id="tb008_ic_situacao" class="form-control" disabled="disabled"
			value="${atendimento.situacaoAtendimento.descricao}">
	</div>
</div>

<div class="row">
	<div class="col-md-9">
		<h2>
			<spring:message code="tratamento.breadcrumb.n5" />
		</h2>
	</div>
	<div class="col-md-3">
		<c:if test="${empty atendimento.id}">
			<h2>
				P1 - P2 - P3 - <span style="text-decoration: underline;">P4</span>
			</h2>
		</c:if>
	</div>
</div>

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
			<button id="btn-novo-tratamento"
				class="btn btn-default btn-primary marginBottom">
				<span class="glyphicon  glyphicon-plus"></span> Novo
			</button>
		</c:if>
		<c:if test="${not empty atendimento.id}">
			<button id="btn_tratamento_lista_voltar" type="button"
				class="btn btn-default marginBottom">Voltar</button>
		</c:if>
	</div>
</div>

<input type="hidden" id="id_atendimento" value="${atendimento.id}" />

<div class="table-responsive">
	<table id="full" class=" table table-striped">
		<thead>
			<tr>
				<th width="25%">Tipo</th>
				<th width="40%">Livro/Compromisso/Data</th>
				<th width="15%">Registro</th>
				<th width="8%">Remarcado</th>
				<th width="8%">Realizado</th>
				<th width="2%"></th>
				<th width="2%"></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th colspan="7"></th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach items="${tratamentosPersistidos}" var="tratamento"
				varStatus="status">
				<tr id="${tratamento.id}">
					<td>${tratamento.tipoTratamento.nome}</td>
					<td><c:choose>
							<c:when
								test="${tratamento.tipoTratamento.formatoTratamento == 'L'}">${tratamento.livro.titulo}</c:when>
							<c:when
								test="${tratamento.tipoTratamento.formatoTratamento == 'C'}">${tratamento.compromisso.nome}</c:when>
							<c:when
								test="${tratamento.tipoTratamento.formatoTratamento == 'P'}">
								<fmt:formatDate value="${tratamento.dataPasse}"
									pattern="dd/MM/yyyy" type="DATE" />
							</c:when>
							<c:otherwise>--</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${tratamento.dataRegistro}" pattern="dd/MM/yyyy" type="DATE" /></td>
					<td>${tratamento.remarcado}</td>
					<td>${tratamento.realizado}</td>
					<td><form:form action="tratamento_editar" method="get">
							<input type="hidden" name="id" value="${tratamento.id}" />
							<button type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="tratamento_excluir" method="post">
							<input type="hidden" name="id" value="${tratamento.id}" />
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
			<c:forEach items="${tratamentosNovosIterator}" var="tratamento"
				varStatus="status">
				<tr id="${tratamento.id}">
					<td>${tratamento.tipoTratamento.nome}</td>
					<td><c:choose>
							<c:when
								test="${tratamento.tipoTratamento.formatoTratamento == 'L'}">${tratamento.livro.titulo}</c:when>
							<c:when
								test="${tratamento.tipoTratamento.formatoTratamento == 'C'}">${tratamento.compromisso.nome}</c:when>
							<c:when
								test="${tratamento.tipoTratamento.formatoTratamento == 'P'}">
								<fmt:formatDate value="${tratamento.dataPasse}"
									pattern="dd/MM/yyyy" type="DATE" />
							</c:when>
							<c:otherwise>-----</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${tratamento.dataRegistro}" pattern="dd/MM/yyyy" type="DATE" /></td>
					<td>${tratamento.remarcado}</td>
					<td>${tratamento.realizado}</td>
					<td><form:form action="tratamento_editar" method="get">
							<input type="hidden" name="id" value="${tratamento.id}" />
							<button type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="tratamento_excluir" method="post">
							<input type="hidden" name="id" value="${tratamento.id}" />
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
<div class="row">
	<div class="col-md-12">
		<c:choose>
			<c:when
				test="${empty atendimento.id && tratamentosNovosMap.size() > 0}">
				<form action="atendimento_novo_finalizar" method="post">
					<button id="btn_tratamento_finalziar" type="submit"
						class="btn btn-default btn-primary marginBottom">Finalizar</button>
				</form>
			</c:when>
		</c:choose>
	</div>
</div>
