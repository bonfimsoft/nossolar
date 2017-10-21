<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<ol class="breadcrumb">
	<li><spring:message code="paciente.breadcrumb.n1" /></li>
	<li><a href="${context}/paciente_listar"><spring:message
				code="paciente.breadcrumb.n2" /></a></li>
	<li class="active"><c:choose>
			<c:when test="${empty paciente.id}">
				<spring:message code="paciente.form.title.new" />
			</c:when>
			<c:otherwise>
				<spring:message code="paciente.form.title.edit" />
			</c:otherwise>
		</c:choose></li>
</ol>


<h2>
	<c:choose>
		<c:when test="${empty paciente.id}">
			<spring:message code="paciente.form.title.new" />
		</c:when>
		<c:otherwise>
			<spring:message code="paciente.form.title.edit" />
		</c:otherwise>
	</c:choose>
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
		<ul>
			<form:errors path="paciente.nome" element="li" />
			<form:errors path="paciente.endereco" element="li" />
			<form:errors path="paciente.bairro" element="li" />
			<form:errors path="paciente.cidade" element="li" />
			<form:errors path="paciente.uf" element="li" />
			<form:errors path="paciente.dataNascimento" element="li" />
			<form:errors path="paciente.sexo" element="li" />
			<form:errors path="paciente.profissao" element="li" />
			<form:errors path="paciente.telefone1" element="li" />
			<form:errors path="paciente.email" element="li" />
		</ul>
	</div>

</c:if>

<c:if test="${not empty mensagemAlerta}">
	<div class="alert alert-warning" role="alert">
		<c:out value="${mensagemAlerta}" />
	</div>
</c:if>

<form:form modelAttribute="paciente" action="paciente_salvar">
	<div class="form-group">
		<div class="row">
			<div class="col-md-1">
				<label for="tb003_id_paciente"><spring:message
						code="paciente.form.label.id" /></label>
				<form:input id="tb003_id_paciente" cssClass="form-control" path="id"
					readonly="true" />
			</div>
			<div class="col-md-5">
				<label for="tb003_no_paciente" class="obrigatorio"><spring:message
						code="paciente.form.label.nome" /></label>
				<form:input id="tb003_no_paciente" cssClass="form-control"
					cssErrorClass="form-control has-error" path="nome" />
			</div>
			<div class="col-md-6">
				<label for="tb003_ed_paciente" class="obrigatorio"><spring:message
						code="paciente.form.label.endereco" /></label>
				<form:input id="tb003_ed_paciente" cssClass="form-control"
					cssErrorClass="form-control has-error" path="endereco" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<label for="tb003_no_bairro" class="obrigatorio"><spring:message
						code="paciente.form.label.bairro" /></label>
				<form:input id="tb003_no_bairro" cssClass="form-control"
					cssErrorClass="form-control has-error" path="bairro" />
			</div>
			<div class="col-md-3">
				<label for="tb003_no_cidade" class="obrigatorio"><spring:message
						code="paciente.form.label.cidade" /></label>
				<form:input id="tb003_no_cidade" cssClass="form-control"
					cssErrorClass="form-control has-error" path="cidade" />
			</div>

			<div class="col-md-1">
				<label for="tb003_sg_uf" class="obrigatorio"><spring:message
						code="paciente.form.label.uf" /></label>
				<form:select id="tb003_sg_uf" cssClass="form-control"
					cssErrorClass="form-control has-error" path="uf">
					<form:option value="-" label="--" />
					<form:options items="${estados}" itemLabel="sigla"
						itemValue="sigla" />
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb003_co_cep"><spring:message
						code="paciente.form.label.cep" /></label>
				<form:input id="tb003_co_cep" cssClass="form-control"
					cssErrorClass="form-control has-error" path="cep" />
			</div>
			<div class="col-md-2">
				<label for="tb003_dt_nascimento" class="obrigatorio"><spring:message
						code="paciente.form.label.datanascimento" /></label>
				<form:input id="tb003_dt_nascimento" cssClass="form-control"
					cssErrorClass="form-control has-error" path="dataNascimento" />
			</div>
		</div>

		<div class="row">

			<div class="col-md-2">
				<label for="tb003_ic_sexo" class="obrigatorio"><spring:message
						code="paciente.form.label.sexo" /></label>
				<form:select id="tb003_ic_sexo" cssClass="form-control"
					cssErrorClass="form-control has-error" path="sexo">
					<form:option value="-" label="--" />
					<form:options items="${sexos}" itemLabel="descricao"
						itemValue="sigla" />
				</form:select>

			</div>
			<div class="col-md-2">
				<label for="tb003_de_religiao"><spring:message
						code="paciente.form.label.religiao" /></label>
				<form:input id="tb003_de_religiao" cssClass="form-control"
					cssErrorClass="form-control has-error" path="religiao" />
			</div>
			<div class="col-md-3">
				<label for="tb003_de_profissao" class="obrigatorio"><spring:message
						code="paciente.form.label.profissao" /></label>
				<form:input id="tb003_de_profissao" cssClass="form-control"
					cssErrorClass="form-control has-error" path="profissao" />
			</div>
			<div class="col-md-5">
				<label for="tb003_de_email"><spring:message
						code="paciente.form.label.email" /></label>
				<form:input id="tb003_de_email" cssClass="form-control"
					cssErrorClass="form-control has-error" path="email" />
			</div>

		</div>
		<div class="row">

			<div class="col-md-2">
				<label for="tb003_de_telefone1" class="obrigatorio"><spring:message
						code="paciente.form.label.telefone1" /></label>
				<form:input id="tb003_de_telefone1" cssClass="form-control"
					cssErrorClass="form-control has-error" path="telefone1" />
			</div>
			<div class="col-md-2">
				<label for="tb003_de_telefone2"><spring:message
						code="paciente.form.label.telefone2" /></label>
				<form:input id="tb003_de_telefone2" cssClass="form-control"
					cssErrorClass="form-control has-error" path="telefone2" />
			</div>
			<div class="col-md-2">
				<label for="tb003_de_telefone3"><spring:message
						code="paciente.form.label.telefone3" /></label>
				<form:input id="tb003_de_telefone3" cssClass="form-control"
					cssErrorClass="form-control has-error" path="telefone3" />
			</div>
		</div>

	</div>

	<button type="submit" class="btn btn-default btn-primary">
		<spring:message code="paciente.form.button.save" />
	</button>
</form:form>


<c:if test="${not empty paciente.id}">
	<h3>
		<spring:message code="atendimento.list.title" />
	</h3>
	<hr>
	<button id="btn-novo-atendimento" type="button"
		class="btn btn-default btn-primary marginBottom">
		<span class="glyphicon  glyphicon-plus"></span>
		<spring:message code="atendimento.list.button.new" />
	</button>

	<div class="table-responsive">
		<table id="full" class=" table table-striped">
			<thead>
				<tr>
					<th width="22%"><spring:message
							code="atendimento.list.table.id" /></th>
					<th width="22%"><spring:message
							code="atendimento.list.table.datainicio" /></th>
					<th width="22%"><spring:message
							code="atendimento.list.table.datafim" /></th>
					<th width="30%"><spring:message
							code="atendimento.list.table.situacao" /></th>
					<th width="2%"></th>
					<th width="2%"></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th colspan="6"></th>

				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${paciente.atendimentos}" var="atendimento"
					varStatus="status">
					<tr>
						<td>${atendimento.id}</td>
						<td><fmt:formatDate value="${atendimento.dataInicio}"
								pattern="dd/MM/yyyy" type="DATE" /></td>
						<td><c:choose>
								<c:when test="${empty atendimento.dataFim}">--</c:when>
								<c:otherwise>
									<fmt:formatDate value="${atendimento.dataFim}"
										pattern="dd/MM/yyyy" type="DATE" />
								</c:otherwise>
							</c:choose></td>
						<td>${atendimento.situacaoAtendimento.descricao}</td>
						<td><form:form action="atendimento_editar" method="get">
								<input type="hidden" name="id" value="${atendimento.id}" />
								<button id="btn_editar_atendimento_${atendimento.id}"
									type="submit"
									class="btn btn-default btn-primary btn-xs btn-warning meuTooltip"
									title="Editar">
									<span class="glyphicon  glyphicon-pencil"></span>
								</button>

							</form:form></td>
						<td><form:form action="atendimento_excluir" method="post">
								<input type="hidden" name="id" value="${atendimento.id}" />
								<c:choose>
									<c:when test="${atendimento.situacaoAtendimento != 'A'}">
										<button id="btn_excluir_atendimento_${atendimento.id}"
											type="submit"
											class="btn btn-default btn-primary btn-xs btn-danger meuTooltip"
											title="Excluir" disabled="disabled">
											<span class="glyphicon  glyphicon-remove"></span>
										</button>
									</c:when>
									<c:otherwise>
										<button id="btn_excluir_atendimento_${atendimento.id}"
											type="submit"
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
</c:if>