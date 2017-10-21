<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="atendimento.breadcrumb.n1" /></li>
	<li><a href="paciente_listar"><spring:message
				code="atendimento.breadcrumb.n2" /></a></li>
	<li><a href="paciente_editar?id=${paciente.id}"><spring:message
				code="atendimento.breadcrumb.n3" /></a></li>
	<li class="active"><c:choose>
			<c:when test="${empty atendimento.id}">
				<spring:message code="atendimento.form.label.new" />
			</c:when>
			<c:otherwise>
				<spring:message code="atendimento.form.label.edit" />
			</c:otherwise>
		</c:choose></li>
</ol>

<div class="row">
	<div class="col-md-9">
		<h2>
			<c:choose>
				<c:when test="${empty atendimento.id}">
					<spring:message code="atendimento.form.label.new" />
				</c:when>
				<c:otherwise>
					<spring:message code="atendimento.form.label.edit" />
				</c:otherwise>
			</c:choose>
		</h2>
	</div>
	<div class="col-md-3">
		<c:if test="${empty atendimento.id}">
			<h2>
				<span style="text-decoration: underline;">P1</span> - P2 - P3 - P4
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

<input type="hidden" id="id_paciente" value="${paciente.id}" />
<c:if
	test="${(((atendimento.situacaoAtendimento eq 'A') && (not empty atendimento.id)) || (empty atendimento.id))}"
	var="atendimentoAberto" />

<form:form modelAttribute="atendimento" action="atendimento_salvar"
	method="post">
	<div class="form-group">
		<div class="row">
			<div class="col-md-1">
				<label for="tb008_id_atendimento"><spring:message
						code="atendimento.form.label.id" /></label>
				<form:input id="tb008_id_atendimento" cssClass="form-control"
					path="id" readonly="true" />
			</div>
			<div class="col-md-4">
				<label for="tb008_no_paciente"><spring:message
						code="atendimento.form.label.nomepaciente" /></label> <input type="text"
					id="tb008_no_paciente" class="form-control" disabled="disabled"
					value="${paciente.nome}">
			</div>
			<div class="col-md-2">
				<label for="tb008_dt_inicio"> <spring:message
						code="atendimento.form.label.datainicio" />
				</label>
				<form:input id="tb008_dt_inicio" cssClass="form-control"
					path="dataInicio" readonly="true" />
			</div>
			<div class="col-md-2">
				<label for="tb008_dt_fim"><spring:message
						code="atendimento.form.label.datafim" /></label>
				<form:input id="tb003_dt_fim" cssClass="form-control" path="dataFim"
					readonly="true" />
			</div>
			<div class="col-md-2">
				<label for="tb008_ic_situacao"><spring:message
						code="atendimento.form.label.situacao" /></label>
				<c:if test="${(not atendimentoAberto) || (empty atendimento.id)}">
					<form:hidden path="situacaoAtendimento" />
				</c:if>
				<form:select id="tb008_ic_situacao" cssClass="form-control"
					path="situacaoAtendimento"
					disabled="${(not atendimentoAberto) || (empty atendimento.id)}">
					<form:options items="${situacoesAtendimento}" itemLabel="descricao" />
				</form:select>
			</div>
			<div class="col-md-1">
				<label for="tb008_ic_proprio"><spring:message
						code="atendimento.form.label.proprio" /> </label>
				<form:select id="tb010_ic_proprio" cssClass="form-control"
					path="proprio" disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
		</div>

		<div id="div_responsavel" class="row">
			<div class="col-md-4">
				<label for="tb008_no_responsavel"><spring:message
						code="atendimento.form.label.nomeresponsavel" /></label>
				<form:input id="tb008_no_responsavel" class="form-control"
					path="responsavel" readonly="${not atendimentoAberto}" />
			</div>
			<div class="col-md-3">
				<label for="tb008_de_relacionamento"><spring:message
						code="atendimento.form.label.relacionamentoresponsavel" /></label>
				<form:input id="tb008_de_relacionamento" class="form-control"
					path="relacionamento" readonly="${not atendimentoAberto}" />
			</div>
			<div class="col-md-2">
				<label for="tb008_de_telefone"><spring:message
						code="atendimento.form.label.telefoneresponsavel" /></label>
				<form:input id="tb008_de_telefone" class="form-control"
					path="telefone" readonly="${not atendimentoAberto}" />
			</div>
			<div class="col-md-3">
				<label for="tb008_de_email"><spring:message
						code="atendimento.form.label.emailresponsavel" /></label>
				<form:input id="tb008_de_email" class="form-control" path="email"
					readonly="${not atendimentoAberto}" />
			</div>

		</div>
		<div class="row">
			<div class="col-md-7">
				<label class="obrigatorio"><spring:message
						code="atendimento.form.label.diasatendimento" /></label>
				<div class="form-control">

					<label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="sunday" value="1"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.sunday" />
					</label> <label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="monday" value="2"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.monday" />
					</label> <label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="tuesday" value="4"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.tuesday" />
					</label> <label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="wednesday" value="8"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.wednesday" />
					</label> <label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="thursday" value="16"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.thursday" />
					</label> <label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="friday" value="32"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.friday" />
					</label> <label class="checkbox-inline"> <form:checkbox
							path="diasSemana" id="saturday" value="64"
							disabled="${not atendimentoAberto}" /> <spring:message
							code="general.options.day.short.saturday" />
					</label>
				</div>
			</div>

		</div>
		<hr>
		<div class="row">
			<div class="col-md-2">
				<label for="tb010_ic_tratamento_medico"><spring:message
						code="atendimento.form.label.tratamentomedico" /></label>
				<form:select id="tb010_ic_tratamento_medico" cssClass="form-control"
					path="tratamentoMedico" disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb010_ic_tratamento_psiquiatrico"> <spring:message
						code="atendimento.form.label.tratamentopsiquiatrico" />
				</label>
				<form:select id="tb010_ic_tratamento_psiquiatrico"
					cssClass="form-control" path="tratamentoPsiquiatrico"
					disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb010_ic_tratamento_psicologico"> <spring:message
						code="atendimento.form.label.tratamentopsicologico" />
				</label>
				<form:select id="tb010_ic_tratamento_psicologico"
					cssClass="form-control" path="tratamentoPsicologico"
					disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb010_ic_evangelho_lar"> <spring:message
						code="atendimento.form.label.evangelholar" />
				</label>
				<form:select id="tb010_ic_evangelho_lar" cssClass="form-control"
					path="evangelhoLar" disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb010_ic_leitura_livros"> <spring:message
						code="atendimento.form.label.leituralivros" />
				</label>
				<form:select id="tb010_ic_leitura_livros" cssClass="form-control"
					path="leituraLivros" disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb010_ic_tratamento_espiritual"> <spring:message
						code="atendimento.form.label.tratamentoespiritual" />
				</label>
				<form:select id="tb010_ic_tratamento_espiritual"
					cssClass="form-control" path="tratamentoEspiritual"
					disabled="${not atendimentoAberto}">
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
			<div class="col-md-3">
				<label for="tb010_ic_uso_medicamentos"><spring:message
						code="atendimento.form.label.usomedicamentos" /></label>
				<form:select id="tb010_ic_uso_medicamentos" cssClass="form-control"
					path="usoMedicamentos" disabled="${not atendimentoAberto}">
					<form:option value="false">
						<spring:message code="general.options.no" />
					</form:option>
					<form:option value="true">
						<spring:message code="general.options.yes" />
					</form:option>
				</form:select>
			</div>
			<div class="col-md-9">
				<label for="tb010_de_medicamentos"><spring:message
						code="atendimento.form.label.descricaomedicamentos" /></label>
				<form:textarea id="tb010_de_medicamentos" class="form-control"
					path="descricaoMedicamentos" rows="2"
					readonly="${(not atendimentoAberto) || (not atendimento.usoMedicamentos)}" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<c:choose>
				<c:when test="${empty atendimento.id}">
					<button type="submit" class="btn btn-default btn-primary">Proximo</button>
				</c:when>
				<c:otherwise>
					<c:if test="${atendimento.situacaoAtendimento == 'A'}">
						<button type="submit" class="btn btn-default btn-primary">Salvar</button>
					</c:if>
					<button id="tb010_btn_entrevista" type="button"
						class="btn btn-default btn-primary">Entrevistas</button>
					<button id="tb010_btn_problemas" type="button"
						class="btn btn-default btn-primary">Problemas</button>
					<button id="tb010_btn_tratamento" type="button"
						class="btn btn-default btn-primary">Tratamentos</button>
					<button id="tb010_btn_voltar" type="button" class="btn btn-default">Voltar</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</form:form>


