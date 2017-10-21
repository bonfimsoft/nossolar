<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="problema.breadcrumb.n1" /></li>
	<li><a href="paciente_listar"> <spring:message
				code="problema.breadcrumb.n2" />
	</a></li>
	<li><a href="paciente_editar?id=${paciente.id}"> <spring:message
				code="problema.breadcrumb.n3" />
	</a></li>
	<li><a href="atendimento_editar?id=${atendimento.id}"> <spring:message
				code="problema.breadcrumb.n4" />
	</a></li>
	<li class="active"><spring:message code="problema.breadcrumb.n5" />
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
			<spring:message code="problema.list.title" />
		</h2>
	</div>
	<div class="col-md-3">
		<c:if test="${empty atendimento.id}">
			<h2>
				P1 - P2 - <span style="text-decoration: underline;">P3</span> - P4
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
			<button id="btn-novo-problema" type="button"
				class="btn btn-default btn-primary marginBottom">
				<span class="glyphicon  glyphicon-plus"></span>
				<spring:message code="problema.list.button.new" />
			</button>
		</c:if>
		<c:if test="${not empty atendimento.id}">
			<button id="btn_problema_lista_voltar" type="button"
				class="btn btn-default marginBottom">Voltar</button>
		</c:if>
	</div>
</div>

<input type="hidden" id="id_atendimento" value="${atendimento.id}" />

<div class="table-responsive">
	<table id="full" class=" table table-striped">
		<thead>
			<tr>
				<th width="30%"><spring:message code="problema.list.table.tipo" /></th>
				<th width="50%"><spring:message
						code="problema.list.table.escala" /></th>
				<th width="16%"><spring:message
						code="problema.list.table.registro" /></th>
				<th width="2%"></th>
				<th width="2%"></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th colspan="5"></th>

			</tr>
		</tfoot>
		<tbody>
			<c:forEach items="${problemasPersistidos}" var="problema"
				varStatus="status">
				<tr>
					<td>${problema.tipoProblema.nome}</td>
					<td>${problema.escala}</td>
					<td><fmt:formatDate value="${problema.dataRegistro}" pattern="dd/MM/yyyy" type="DATE" /></td>
					<td><form:form action="problema_editar" method="get">
							<input type="hidden" name="id" value="${problema.id}" />
							<button id="btn_editar_problema_${problema.id}" type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="problema_excluir" method="post">
							<input type="hidden" name="id" value="${problema.id}" />
							<c:choose>
								<c:when test="${atendimento.situacaoAtendimento != 'A'}">
									<button id="btn_excluir_problema_${problema.id}" type="submit"
										class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
										title="Excluir" disabled="disabled">
										<span class="glyphicon  glyphicon-remove"></span>
									</button>
								</c:when>
								<c:otherwise>
									<button id="btn_excluir_problema_${problema.id}" type="submit"
										class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
										title="Excluir">
										<span class="glyphicon  glyphicon-remove"></span>
									</button>
								</c:otherwise>
							</c:choose>
						</form:form></td>
				</tr>
			</c:forEach>
			<c:forEach items="${problemasNovosIterator}" var="problema"
				varStatus="status">
				<tr>
					<td><b>${problema.tipoProblema.nome}</b></td>
					<td>${problema.escala}</td>
					<td><fmt:formatDate value="${problema.dataRegistro}" pattern="dd/MM/yyyy" type="DATE" /></td>
					<td><form:form action="problema_editar" method="get">
							<input type="hidden" name="id" value="${problema.id}" />
							<button id="btn_editar_problema_${problema.id}" type="submit"
								class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
								title="Editar">
								<span class="glyphicon  glyphicon-pencil"></span>
							</button>
						</form:form></td>
					<td><form:form action="problema_excluir" method="post">
							<input type="hidden" name="id" value="${problema.id}" />
							<c:choose>
								<c:when test="${atendimento.situacaoAtendimento != 'A'}">
									<button id="btn_excluir_problema_${problema.id}" type="submit"
										class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
										title="Excluir" disabled="disabled">
										<span class="glyphicon  glyphicon-remove"></span>
									</button>
								</c:when>
								<c:otherwise>
									<button id="btn_excluir_problema_${problema.id}" type="submit"
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
			<c:when test="${empty atendimento.id && problemasNovosMap.size() > 0}">
				<form action="tratamento_listar" method="get">
					<button id="btn_problemas_proximo" type="submit"
						class="btn btn-default btn-primary marginBottom">Proximo</button>
				</form>
			</c:when>
		</c:choose>
	</div>
</div>