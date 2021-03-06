<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="entrevista.breadcrumb.n1" /></li>
	<li><a href="paciente_lista"><spring:message
				code="entrevista.breadcrumb.n2" /></a></li>
	<li><a href="paciente_editar?id=${paciente.id}"><spring:message
				code="entrevista.breadcrumb.n3" /></a></li>
	<c:choose>
		<c:when test="${empty atendimento.id}">
			<li class="active"><spring:message
					code="atendimento.form.label.new" /></li>
		</c:when>
		<c:otherwise>
			<li><a href="atendimento_editar?id=${atendimento.id}"> <spring:message
						code="entrevista.breadcrumb.n4" /></a></li>
			<c:choose>
				<c:when test="${empty entrevista.id}">
					<li class="active"><spring:message
							code="entrevista.form.label.new" /></li>
				</c:when>
				<c:otherwise>
					<li class="active"><spring:message
							code="entrevista.form.label.edit" /></li>
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
				<c:when test="${empty entrevista.id}">
					<spring:message code="entrevista.form.label.new" />
				</c:when>
				<c:otherwise>
					<spring:message code="entrevista.form.label.edit" />
				</c:otherwise>
			</c:choose>
		</h2>
	</div>
	<div class="col-md-3">
		<c:if test="${empty atendimento.id}">
			<h2>
				P1 - <span style="text-decoration: underline;">P2</span> - P3 - P4
			</h2>
		</c:if>
	</div>
</div>

<hr>

<input type="hidden" id="id_atendimento" value="${atendimento.id}" />

<form:form modelAttribute="entrevista" action="entrevista_salvar"
	method="post">
	<div class="form-group">
		<div class="row">
			<div class="col-md-1">
				<label for="tb010_id_entrevista"><spring:message
						code="entrevista.form.label.id" /></label>
				<form:input id="tb010_id_entrevista" cssClass="form-control"
					path="id" readonly="true" />
			</div>
			<div class="col-md-2">
				<label for="tb010_dt_entrevista"><spring:message
						code="entrevista.form.label.dataentrevista" /></label>
				<form:input id="tb010_dt_entrevista"
					cssClass="form-control placeholder datepicker"
					path="dataEntrevista" />
			</div>


			<div class="col-md-5">
				<label for="tb010_no_entrevistador"><spring:message
						code="entrevista.form.label.entrevistador" /></label>
				<form:input id="tb010_no_entrevistador" cssClass="form-control"
					path="entrevistador" />

			</div>
			<div class="col-md-2">
				<label for="tb010_ic_tipo_entrevista"><spring:message
						code="entrevista.form.label.tipoentrevista" /></label>
				<c:choose>
					<c:when test="${not empty atendimento.id}">
						<form:select id="tb010_ic_tipo_entrevista" cssClass="form-control"
							path="tipoEntrevista" disabled="${empty atendimento.id}">
							<form:option value="" label="Selecione" />
							<c:forEach items="${tiposEntrevista}" var="tipoEntrevista">
								<form:option value="${tipoEntrevista}"
									label="${tipoEntrevista.descricao}" />
							</c:forEach>
						</form:select>
					</c:when>
					<c:otherwise>
						<form:hidden path="tipoEntrevista" />
						<form:select id="tb010_ic_tipo_entrevista" cssClass="form-control"
							path="tipoEntrevista" disabled="${empty atendimento.id}">
							<form:options items="${tiposEntrevista}" itemLabel="descricao" />
						</form:select>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-2">
				<label for="tb010_ic_apresenta_melhoras"><spring:message
						code="entrevista.form.label.apresentamelhoras" /></label>
				<c:if test="${empty atendimento.id}">
					<form:hidden path="apresentaMelhoras" />
				</c:if>
				<form:select id="tb010_ic_apresenta_melhoras"
					cssClass="form-control" path="apresentaMelhoras"
					disabled="${empty atendimento.id}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<label for="tb010_observacao"><spring:message
						code="entrevista.form.label.observacao" /></label>
				<form:textarea path="observacao" rows="4" cssClass="form-control" />
			</div>

		</div>
	</div>

	<c:choose>
		<c:when test="${empty atendimento.id}">
			<button type="submit" class="btn btn-default btn-primary">Proximo</button>
		</c:when>
		<c:otherwise>
			<c:if test="${atendimento.situacaoAtendimento == 'A'}">
				<button type="submit" class="btn btn-default btn-primary">Salvar</button>
			</c:if>
			<button id="btn_entrevista_cadastro_voltar" type="button"
				class="btn btn-default">Voltar</button>
		</c:otherwise>
	</c:choose>

</form:form>