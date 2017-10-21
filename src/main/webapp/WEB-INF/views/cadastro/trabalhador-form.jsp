<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ol class="breadcrumb">
	<li><spring:message code="trabalhador.breadcrumb.n1" /></li>
	<li><a href="trabalhador_listar"><spring:message
				code="trabalhador.breadcrumb.n2" /></a></li>
	<li class="active"><c:choose>
			<c:when test="${empty trabalhador.id}">
				<spring:message code="trabalhador.form.label.new" />
			</c:when>
			<c:otherwise>
				<spring:message code="trabalhador.form.label.edit" />
			</c:otherwise>
		</c:choose></li>
</ol>


<h2>
	<c:choose>
		<c:when test="${empty paciente.id}">
			<spring:message code="trabalhador.form.label.new" />
		</c:when>
		<c:otherwise>
			<spring:message code="trabalhador.form.label.edit" />
		</c:otherwise>
	</c:choose>
</h2>
<hr>

<c:if test="${not empty mensagemErro}">
	<div class="alert alert-danger" role="alert">
		<ul>
			<form:errors path="trabalhador.matricula" element="li" />
			<form:errors path="trabalhador.senha" element="li" />
			<form:errors path="trabalhador.nome" element="li" />
			<form:errors path="trabalhador.cracha" element="li" />
			<form:errors path="trabalhador.endereco" element="li" />
			<form:errors path="trabalhador.bairro" element="li" />
			<form:errors path="trabalhador.cidade" element="li" />
			<form:errors path="trabalhador.uf" element="li" />
			<form:errors path="trabalhador.dataNascimento" element="li" />
			<form:errors path="trabalhador.cpf" element="li" />
			<form:errors path="trabalhador.rg" element="li" />
			<form:errors path="trabalhador.sexo" element="li" />
			<form:errors path="trabalhador.profissao" element="li" />
			<form:errors path="trabalhador.telefone1" element="li" />
			<form:errors path="trabalhador.email1" element="li" />
		</ul>
	</div>
</c:if>

<form:form modelAttribute="trabalhador" action="trabalhador_salvar">
	<div class="form-group">
		<div class="row">
			<div class="col-md-2">
				<label for="tb002-id-trabalhador"><spring:message
						code="trabalhador.form.label.id" /></label>
				<form:input id="tb002_id_trabalhador"
					cssClass="form-control ng-pristine ng-invalid ng-invalid-required"
					path="id" readonly="true" />
			</div>
			<div class="col-md-2">
				<label for="tb002-co-matricula" class="obrigatorio control-label"><spring:message
						code="trabalhador.form.label.matricula" /></label>
				<form:input id="tb002_co_matricula" cssClass="form-control"
					cssErrorClass="form-control has-error" path="matricula" />
			</div>
			<div class="col-md-2">
				<label for="tb002-co-senha" class="control-label"><spring:message
						code="trabalhador.form.label.senha" /></label>
				<form:password id="tb002-co-senha" cssClass="form-control"
					cssErrorClass="form-control has-error" path="senha" />
			</div>
			<div class="col-md-6">
				<label for="tb002-no-trabalhador" class="obrigatorio"><spring:message
						code="trabalhador.form.label.nome" /></label>
				<form:input id="tb002-no-trabalhador" cssClass="form-control"
					cssErrorClass="form-control has-error" path="nome" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-3" class="obrigatorio">
				<label for="tb002-no-cracha"><spring:message
						code="trabalhador.form.label.cracha" /></label>
				<form:input id="tb002-no-cracha" cssClass="form-control"
					cssErrorClass="form-control has-error" path="cracha" />
			</div>
			<div class="col-md-6">
				<label for="tb002-ed-trabalhador" class="obrigatorio"><spring:message
						code="trabalhador.form.label.endereco" /></label>
				<form:input id="tb002-ed-trabalhador" cssClass="form-control"
					cssErrorClass="form-control has-error" path="endereco" />
			</div>
			<div class="col-md-3">
				<label for="tb002-no-bairro" class="obrigatorio"><spring:message
						code="trabalhador.form.label.bairro" /></label>
				<form:input id="tb002-no-bairro" cssClass="form-control"
					cssErrorClass="form-control has-error" path="bairro" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<label for="tb002-no-cidade" class="obrigatorio"><spring:message
						code="trabalhador.form.label.cidade" /></label>
				<form:input id="tb002-no-cidade" cssClass="form-control"
					cssErrorClass="form-control has-error" path="cidade" />
			</div>

			<div class="col-md-1">
				<label for="tb002-sg-uf" class="obrigatorio"><spring:message
						code="trabalhador.form.label.uf" /></label>
				<form:select id="tb002_sg_uf" cssClass="form-control"
					cssErrorClass="form-control has-error" path="uf">
					<form:option value="-" label="--" />
					<form:options items="${estados}" itemLabel="sigla"
						itemValue="sigla" />
				</form:select>
			</div>
			<div class="col-md-2">
				<label for="tb002-co-cep"><spring:message
						code="trabalhador.form.label.cep" /></label>
				<form:input id="tb002-co-cep" cssClass="form-control"
					cssErrorClass="form-control has-error" path="cep" />
			</div>
			<div class="col-md-2">
				<label for="tb002-dt-nascimento" class="obrigatorio"><spring:message
						code="trabalhador.form.label.datanascimento" /></label>
				<form:input id="tb002-dt-nascimento" cssClass="form-control"
					cssErrorClass="form-control has-error" path="dataNascimento" />

			</div>
			<div class="col-md-2">
				<label for="tb002-co-cpf" class="obrigatorio"><spring:message
						code="trabalhador.form.label.cpf" /></label>
				<form:input id="tb002-co-cpf" cssClass="form-control"
					cssErrorClass="form-control has-error" path="cpf" />
			</div>
			<div class="col-md-2">
				<label for="tb002-co-rg"><spring:message
						code="trabalhador.form.label.rg" /></label>
				<form:input id="tb002-co-rg" cssClass="form-control"
					cssErrorClass="form-control has-error" path="rg" />
			</div>

		</div>

		<div class="row">
			<div class="col-md-2">
				<label for="tb002-ic-sexo" class="obrigatorio"><spring:message
						code="trabalhador.form.label.sexo" /></label>
				<form:select id="tb002_ic_sexo" cssClass="form-control"
					cssErrorClass="form-control has-error" path="sexo">
					<form:option value="-" label="--" />
					<form:options items="${sexos}" itemLabel="descricao"
						itemValue="sigla" />
				</form:select>
			</div>
			<div class="col-md-4">
				<label for="tb002-de-profissao" class="obrigatorio"><spring:message
						code="trabalhador.form.label.profissao" /></label>
				<form:input id="tb002-de-profissao" cssClass="form-control"
					cssErrorClass="form-control has-error" path="profissao" />
			</div>
			<div class="col-md-2">
				<label for="tb002-de-telefone1" class="obrigatorio"><spring:message
						code="trabalhador.form.label.telefone1" /></label>
				<form:input id="tb002-de-telefone1" cssClass="form-control"
					cssErrorClass="form-control has-error" path="telefone1" />
			</div>
			<div class="col-md-2">
				<label for="tb002-de-telefone2"><spring:message
						code="trabalhador.form.label.telefone2" /></label>
				<form:input id="tb002-de-telefone2" cssClass="form-control"
					path="telefone2" />
			</div>
			<div class="col-md-2">
				<label for="tb002-de-telefone3"><spring:message
						code="trabalhador.form.label.telefone3" /></label>
				<form:input id="tb002-de-telefone3" cssClass="form-control"
					path="telefone3" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<label for="tb002-de-email1" class="obrigatorio"><spring:message
						code="trabalhador.form.label.email1" /></label>
				<form:input id="tb002-de-email1" cssClass="form-control"
					cssErrorClass="form-control has-error" path="email1" />
			</div>
			<div class="col-md-6">
				<label for="tb002-de-email2"><spring:message
						code="trabalhador.form.label.email2" /></label>
				<form:input id="tb002-de-email2" cssClass="form-control"
					path="email2" />
			</div>
		</div>
	</div>
	<!-- 
	<div class="form-group">
		<label for="tb002-im-foto">Foto</label> <input type="file"
			id="tb002-im-foto">
	</div>
	 -->
	<button type="submit" class="btn btn-default btn-primary">
		<spring:message code="trabalhador.form.button.save" />
	</button>
</form:form>
