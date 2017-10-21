<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="problema.breadcrumb.n1" /></li>
	<li><a href="paciente_lista"><spring:message
				code="problema.breadcrumb.n2" /></a></li>
	<li><a href="paciente_editar?id=${paciente.id}"><spring:message
				code="problema.breadcrumb.n3" /></a></li>
	<c:choose>
		<c:when test="${empty atendimento.id}">
			<li class="active"><spring:message
					code="atendimento.form.label.new" /></li>
		</c:when>
		<c:otherwise>
			<li><a href="atendimento_editar?id=${atendimento.id}"> <spring:message
						code="problema.breadcrumb.n4" /></a></li>
			<c:choose>
				<c:when test="${empty problema.id}">
					<li class="active"><spring:message
							code="problema.form.label.new" /></li>
				</c:when>
				<c:otherwise>
					<li class="active"><spring:message
							code="problema.form.label.edit" /></li>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
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
			<c:choose>
				<c:when test="${empty problema.id}">
					<spring:message code="problema.form.label.new" />
				</c:when>
				<c:otherwise>
					<spring:message code="problema.form.label.edit" />
				</c:otherwise>
			</c:choose>
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

<form:form modelAttribute="problema" action="problema_salvar"
	method="post">

	<form:hidden id="tb011_id_problema" path="id" />
	<div class="form-group">
		<div class="row">
			<div class="col-md-10">
				<label for="tb011_tipo_problema" class="obrigatorio">Tipo de
					Problema</label>
				<form:select id="tb011_tipo_problema" cssClass="form-control"
					path="idTipoProblema">
					<form:option value="0" cssClass="close" label="Selecione" />
					<c:forEach items="${tiposProblema}" var="tp">
						<c:choose>
							<c:when test="${tp.aberto}">
								<form:option value="${tp.id}" cssClass="open" label="${tp.nome}" />
							</c:when>
							<c:otherwise>
								<form:option value="${tp.id}" cssClass="close"
									label="${tp.nome}" />
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb011_vr_escala" class="obrigatorio">Escala</label>
				<form:select id="tb011_vr_escala" cssClass="form-control"
					path="escala">
					<c:if test="${not (empty problema.id || empty atendimento.id)}">
						<form:option value="0" label="0" />
					</c:if>
					<form:option value="1" label="1" />
					<form:option value="2" label="2" />
					<form:option value="3" label="3" />
					<form:option value="4" label="4" />
					<form:option value="5" label="5" />
					<form:option value="6" label="6" />
					<form:option value="7" label="7" />
					<form:option value="8" label="8" />
					<form:option value="9" label="9" />
					<form:option value="10" label="10" />
				</form:select>
			</div>
		</div>
		<div id="descricao_problema" class="row">
			<div class="col-md-12">
				<label for="tb011_de_problema">Descrição do Problema</label>
				<form:input id="tb011_de_problema" cssClass="form-control"
					path="detalheProblema" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<label for="tb011_de_observacao">Observação</label>
				<form:textarea id="tb011_de_observacao"
					cssClass="form-control marginBottom" rows="3" path="observacao" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<c:if test="${atendimento.situacaoAtendimento == 'A'}">
					<button type="submit" class="btn btn-default btn-primary">Salvar</button>
				</c:if>
				<c:if test="${not empty atendimento.id}">
					<button id="btn_problema_cadastro_voltar" type="button"
						class="btn btn-default">Voltar</button>
				</c:if>
			</div>
		</div>
	</div>
</form:form>