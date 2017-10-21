/* Generating data for Database: Nossolar  */

/* Table public.tb012_feriado cleared */
DELETE FROM "public"."tb012_feriado";

/*********/

/* Table public.tr001_trabalhador_perfil cleared */
DELETE FROM "public"."tr001_trabalhador_perfil";

/* Table public.tb002_trabalhador cleared */
DELETE FROM "public"."tb002_trabalhador";

/* Table public.tb001_perfil cleared */
DELETE FROM "public"."tb001_perfil";

/*********/

/* Table public.tb009_tratamento cleared */
DELETE FROM "public"."tb009_tratamento";

/* Table public.tb006_tipo_tratamento cleared */
DELETE FROM "public"."tb006_tipo_tratamento";

/* Table public.tb005_livro cleared */
DELETE FROM "public"."tb005_livro";

/* Table public.tb004_compromisso cleared */
DELETE FROM "public"."tb004_compromisso";

/* Table public.tb011_problema cleared */
DELETE FROM "public"."tb011_problema";

/* Table public.tb007_tipo_problema cleared */
DELETE FROM "public"."tb007_tipo_problema";

/* Table public.tb010_entrevista cleared */
DELETE FROM "public"."tb010_entrevista";

/* Table public.tb008_atendimento cleared */
DELETE FROM "public"."tb008_atendimento";

/* Table public.tb003_paciente cleared */
DELETE FROM "public"."tb003_paciente";

/* Generating data for table public.tb001_perfil... */

INSERT INTO tb001_perfil (id_perfil, nu_versao, no_perfil) VALUES (1, 0, 'Administrador');
INSERT INTO tb001_perfil (id_perfil, nu_versao, no_perfil) VALUES (2, 0, 'Gerente');
INSERT INTO tb001_perfil (id_perfil, nu_versao, no_perfil) VALUES (3, 0, 'Geral');

ALTER SEQUENCE tb001_perfil_id_perfil_seq RESTART WITH 3;

/* Generating data for table public.tb002_trabalhador... */

INSERT INTO tb002_trabalhador (id_trabalhador, nu_versao, co_matricula, co_senha, no_trabalhador, no_cracha, ed_trabalhador, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, co_cpf, co_rg, de_profissao, ic_sexo, de_email1, de_email2, de_telefone1, de_telefone2, de_telefone3, im_foto) VALUES (1, 0, 'geral', '1234', 'Usuario Geral', 'Geral', 'Endereço XYZ', 'Bairro X', 'Cidade X', 'AP', '40000000', '1953-10-10', '12345678900', '3456789', 'Profissão X', 'M', 'geral@email.com', 'geral2@email.com', '7112345678', '7111112222', '7188989079', NULL);
INSERT INTO tb002_trabalhador (id_trabalhador, nu_versao, co_matricula, co_senha, no_trabalhador, no_cracha, ed_trabalhador, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, co_cpf, co_rg, de_profissao, ic_sexo, de_email1, de_email2, de_telefone1, de_telefone2, de_telefone3, im_foto) VALUES (2, 0, 'gerente', '1234', 'Usuario Gerente', 'Gerente', 'Endereço XYZ', 'Bairro X', 'Cidade X', 'AP', '40000000', '1953-10-10', '12345678900', '3456789', 'Profissão X', 'F', 'gerente@email.com', 'gerente2@email.com', '7112345678', '7111112222', '7188989079', NULL);
INSERT INTO tb002_trabalhador (id_trabalhador, nu_versao, co_matricula, co_senha, no_trabalhador, no_cracha, ed_trabalhador, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, co_cpf, co_rg, de_profissao, ic_sexo, de_email1, de_email2, de_telefone1, de_telefone2, de_telefone3, im_foto) VALUES (3, 0, 'administrador', '1234', 'Usuario Administrador', 'Administrador', 'Endereço XYZ', 'Bairro X', 'Cidade X', 'AP', '40000000', '1953-10-10', '12345678900', '3456789', 'Profissão X', 'M', 'admin@email.com', 'admin2@email.com', '7112345678', '7111112222', '7188989079', NULL);
INSERT INTO tb002_trabalhador (id_trabalhador, nu_versao, co_matricula, co_senha, no_trabalhador, no_cracha, ed_trabalhador, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, co_cpf, co_rg, de_profissao, ic_sexo, de_email1, de_email2, de_telefone1, de_telefone2, de_telefone3, im_foto) VALUES (4, 0, 'multiplo', '1234', 'Usuario Multiplo', 'Multiplo', 'Endereço XYZ', 'Bairro X', 'Cidade X', 'AP', '40000000', '1953-10-10', '12345678900', '3456789', 'Profissão X', 'F', 'multiplo@email.com', 'multiplo2@email.com', '7112345678', '7111112222', '7188989079', NULL);

ALTER SEQUENCE tb002_trabalhador_id_trabalhador_seq RESTART WITH 4;

/* Generating data for table public.tr003_trabalhador_perfil... */

INSERT INTO tr001_trabalhador_perfil(id_perfil, id_trabalhador) VALUES (3, 1);
INSERT INTO tr001_trabalhador_perfil(id_perfil, id_trabalhador) VALUES (2, 2);
INSERT INTO tr001_trabalhador_perfil(id_perfil, id_trabalhador) VALUES (1, 3);
INSERT INTO tr001_trabalhador_perfil(id_perfil, id_trabalhador) VALUES (1, 4);
INSERT INTO tr001_trabalhador_perfil(id_perfil, id_trabalhador) VALUES (2, 4);
INSERT INTO tr001_trabalhador_perfil(id_perfil, id_trabalhador) VALUES (3, 4);

/* Generating data for table public.tb003_paciente... */

INSERT INTO tb003_paciente (id_paciente, nu_versao, no_paciente, ed_paciente, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, ic_sexo, de_religiao, de_profissao, de_email, de_telefone1, de_telefone2, de_telefone3) VALUES (1, 0, 'Paciente 01', 'Endereço A, 123 complemento X', 'Bairro Z', 'Cidade J', 'BA', '40000000', '1980-01-01', 'M', 'Religião A', 'Profissão A', 'paciente01@email.com', '7122223333', NULL, NULL);
INSERT INTO tb003_paciente (id_paciente, nu_versao, no_paciente, ed_paciente, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, ic_sexo, de_religiao, de_profissao, de_email, de_telefone1, de_telefone2, de_telefone3) VALUES (2, 0, 'Paciente 02', 'Endereço B, 123 complemento X', 'Bairro W', 'Cidade K', 'BA', '40000000', '1980-01-01', 'M', 'Religião A', 'Profissão B', 'paciente02@email.com', '7122223333', '7144445555', NULL);
INSERT INTO tb003_paciente (id_paciente, nu_versao, no_paciente, ed_paciente, no_bairro, no_cidade, sg_uf, co_cep, dt_nascimento, ic_sexo, de_religiao, de_profissao, de_email, de_telefone1, de_telefone2, de_telefone3) VALUES (3, 0, 'Paciente 03', 'Endereço C, 123 complemento X', 'Bairro Y', 'Cidade L', 'BA', '40000000', '1980-01-01', 'M', 'Religião A', 'Profissão C', 'paciente03@email.com', '7122223333', '7166667777', '7188889999');

ALTER SEQUENCE tb003_paciente_id_paciente_seq RESTART WITH 3;

/* Generating data for table public.tb004_compromisso... */

INSERT INTO tb004_compromisso(id_compromisso, nu_versao, no_compromisso) VALUES (1, 0, 'Compromisso 01');
INSERT INTO tb004_compromisso(id_compromisso, nu_versao, no_compromisso) VALUES (2, 0, 'Compromisso 02');
INSERT INTO tb004_compromisso(id_compromisso, nu_versao, no_compromisso) VALUES (3, 0, 'Compromisso 03');
INSERT INTO tb004_compromisso(id_compromisso, nu_versao, no_compromisso) VALUES (4, 0, 'Compromisso 04');

ALTER SEQUENCE tb004_compromisso_id_compromisso_seq RESTART WITH 4;

/* Generating data for table public.tb005_livro... */

INSERT INTO tb005_livro(id_livro, nu_versao, no_titulo, no_autor, ic_ativo) VALUES (1, 0, 'Livro 01', 'Autor 01', true);
INSERT INTO tb005_livro(id_livro, nu_versao, no_titulo, no_autor, ic_ativo) VALUES (2, 0, 'Livro 02', 'Autor 02', true);
INSERT INTO tb005_livro(id_livro, nu_versao, no_titulo, no_autor, ic_ativo) VALUES (3, 0, 'Livro 03', 'Autor 03', false);
INSERT INTO tb005_livro(id_livro, nu_versao, no_titulo, no_autor, ic_ativo) VALUES (4, 0, 'Livro 04', 'Autor 04', true);
INSERT INTO tb005_livro(id_livro, nu_versao, no_titulo, no_autor, ic_ativo) VALUES (5, 0, 'Livro 05', 'Autor 05', false);

ALTER SEQUENCE tb005_livro_id_livro_seq RESTART WITH 5;

/* Generating data for table public.tb006_tipo_tratamento... */
INSERT INTO tb006_tipo_tratamento(id_tipo_tratamento, nu_versao, no_tipo_tratamento, ic_formato) VALUES (1, 0, 'Tratamento de Passe', 'P');
INSERT INTO tb006_tipo_tratamento(id_tipo_tratamento, nu_versao, no_tipo_tratamento, ic_formato) VALUES (2, 0, 'Tratamento de Leitura', 'L');
INSERT INTO tb006_tipo_tratamento(id_tipo_tratamento, nu_versao, no_tipo_tratamento, ic_formato) VALUES (3, 0, 'Tratamento de Compromisso', 'C');

ALTER SEQUENCE tb006_tipo_tratamento_id_tratamento_seq RESTART WITH 3;

/* Generating data for table public.tb007_tipo_problema... */
INSERT INTO tb007_tipo_problema(id_tipo_problema, nu_versao, no_tipo_problema, ic_aberto) VALUES (1, 0, 'Tipo de Problema Aberto', true);
INSERT INTO tb007_tipo_problema(id_tipo_problema, nu_versao, no_tipo_problema, ic_aberto) VALUES (2, 0, 'Tipo de Problema Especifico', false);

ALTER SEQUENCE tb007_tipo_problema_id_tipo_problema_seq RESTART WITH 2;

/* Generating data for table public.tb008_atendimento... */
INSERT INTO tb008_atendimento(id_atendimento, nu_versao, id_paciente, dt_inicio, dt_fim, ic_situacao, ic_dias, ic_tratamento_medico, ic_tratamento_psicologico, ic_tratamento_psiquiatrico, ic_tratamento_espiritual, ic_evangelho_lar, ic_leitura_livros, ic_uso_medicamento, de_medicamentos, ic_proprio, no_responsavel, no_relacionamento, de_telefone, de_email) VALUES (1, 0, 1, '2014-01-01', '2014-04-30', 'C', 3, false, false, false, true, false, true, false, null, false, 'Responsavel pelo Atendimento', 'Amigo do Paciente', '7155556666', 'amigo@email.com');
INSERT INTO tb008_atendimento(id_atendimento, nu_versao, id_paciente, dt_inicio, dt_fim, ic_situacao, ic_dias, ic_tratamento_medico, ic_tratamento_psicologico, ic_tratamento_psiquiatrico, ic_tratamento_espiritual, ic_evangelho_lar, ic_leitura_livros, ic_uso_medicamento, de_medicamentos, ic_proprio, no_responsavel, no_relacionamento, de_telefone, de_email) VALUES (2, 0, 1, '2014-05-01', null, 'A', 8, false, true, false, false, true, false, true, 'Medicamento A, Medicamento B, Medicamento C', true, null, null, null, null);
INSERT INTO tb008_atendimento(id_atendimento, nu_versao, id_paciente, dt_inicio, dt_fim, ic_situacao, ic_dias, ic_tratamento_medico, ic_tratamento_psicologico, ic_tratamento_psiquiatrico, ic_tratamento_espiritual, ic_evangelho_lar, ic_leitura_livros, ic_uso_medicamento, de_medicamentos, ic_proprio, no_responsavel, no_relacionamento, de_telefone, de_email) VALUES (3, 0, 2, '2014-01-10', '2014-01-30', 'I', 40, true, false, true, false, true, false, false, null, false, 'Responsavel pelo Atendimento', 'Primo do Paciente', '7133338888', 'primo@email.com');
INSERT INTO tb008_atendimento(id_atendimento, nu_versao, id_paciente, dt_inicio, dt_fim, ic_situacao, ic_dias, ic_tratamento_medico, ic_tratamento_psicologico, ic_tratamento_psiquiatrico, ic_tratamento_espiritual, ic_evangelho_lar, ic_leitura_livros, ic_uso_medicamento, de_medicamentos, ic_proprio, no_responsavel, no_relacionamento, de_telefone, de_email) VALUES (4, 0, 3, '2014-01-10', '2014-05-15', 'C', 1, false, false, true, false, true, true, false, null, true, null, null, null, null);
INSERT INTO tb008_atendimento(id_atendimento, nu_versao, id_paciente, dt_inicio, dt_fim, ic_situacao, ic_dias, ic_tratamento_medico, ic_tratamento_psicologico, ic_tratamento_psiquiatrico, ic_tratamento_espiritual, ic_evangelho_lar, ic_leitura_livros, ic_uso_medicamento, de_medicamentos, ic_proprio, no_responsavel, no_relacionamento, de_telefone, de_email) VALUES (5, 0, 3, '2014-02-01', null, 'A', 8, false, true, true, true, false, false, true, 'Medicamento D, Medicamento E, Medicamento F', false, 'Responsavel pelo Atendimento', 'Conjuge do Paciente', '7144449999', 'conjuge@email.com');

ALTER SEQUENCE tb008_atendimento_id_atendimento_seq RESTART WITH 5;

/* Generating data for table public.tb009_tratamento... */
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (1, 0, 1, 2, 1, null, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (2, 0, 1, 2, 2, null, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (3, 0, 2, 2, 1, null, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (4, 0, 2, 3, null, 1, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (5, 0, 2, 3, null, 2, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (6, 0, 3, 3, null, 3, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (7, 0, 3, 2, null, 4, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (8, 0, 4, 2, null, 4, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (9, 0, 4, 3, null, 1, null, null, null);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (10, 0, 5, 1, null, null, '2014-01-08', false, true);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (11, 0, 5, 1, null, null, '2014-01-15', false, false);
INSERT INTO tb009_tratamento(id_tratamento, nu_versao, id_atendimento, id_tipo_tratamento, id_livro, id_compromisso, dt_passe, ic_remarcado, ic_realizado) VALUES (12, 0, 5, 1, null, null, '2014-01-22', true, null);

ALTER SEQUENCE tb009_tratamento_id_tratamento_seq RESTART WITH 12;

/* Generating data for table public.tb010_entrevista... */
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (1, 0, 1, '2014-01-01', 'Trabalhador A', 'I', null, false);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (2, 0, 1, '2014-04-30', 'Trabalhador A', 'F', null, true);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (3, 0, 2, '2014-05-01', 'Trabalhador B', 'I', 'Observação XPTO', false);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (4, 0, 2, '2014-01-10', 'Trabalhador A', 'I', 'Observação XPTO', false);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (5, 0, 3, '2014-01-10', 'Trabalhador C', 'I', null, false);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (6, 0, 4, '2014-01-10', 'Trabalhador C', 'I', null, false);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (7, 0, 4, '2014-03-15', 'Trabalhador B', 'C', null, false);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (8, 0, 4, '2014-05-15', 'Trabalhador C', 'F', null, true);
INSERT INTO tb010_entrevista(id_entrevista, nu_versao, id_atendimento, dt_entrevista, no_entrevistador, ic_tipo_entrevista, de_observacao, ic_apresenta_melhoras) VALUES (9, 0, 5, '2014-02-01', 'Trabalhador D', 'I', null, false);

ALTER SEQUENCE tb010_entrevista_id_entrevista_seq RESTART WITH 9;

/* Generating data for table public.tb011_problema... */
INSERT INTO tb011_problema(id_problema, nu_versao, id_entrevista, id_tipo_problema, de_problema, de_observacao, vr_escala) VALUES (1, 0, 1, 2, null, null, 3);
INSERT INTO tb011_problema(id_problema, nu_versao, id_entrevista, id_tipo_problema, de_problema, de_observacao, vr_escala) VALUES (2, 0, 3, 1, 'Problema X', null, 6);
INSERT INTO tb011_problema(id_problema, nu_versao, id_entrevista, id_tipo_problema, de_problema, de_observacao, vr_escala) VALUES (3, 0, 5, 2, null, null, 9);
INSERT INTO tb011_problema(id_problema, nu_versao, id_entrevista, id_tipo_problema, de_problema, de_observacao, vr_escala) VALUES (4, 0, 6, 2, null, null, 5);
INSERT INTO tb011_problema(id_problema, nu_versao, id_entrevista, id_tipo_problema, de_problema, de_observacao, vr_escala) VALUES (5, 0, 7, 1, 'Problema Y', null, 3);
INSERT INTO tb011_problema(id_problema, nu_versao, id_entrevista, id_tipo_problema, de_problema, de_observacao, vr_escala) VALUES (6, 0, 9, 2, null, null, 8);

ALTER SEQUENCE tb011_problema_id_problema_seq RESTART WITH 6;

/* Generating data for table public.tb012_feriado... */
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (1, 0, 'Confraternização Universal', '2014-01-01');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (2, 0, 'Carnaval', '2014-03-03');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (3, 0, 'Carnaval', '2014-03-04');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (4, 0, 'Paixão de Cristo', '2014-04-18');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (5, 0, 'Tiradentes', '2014-04-21');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (6, 0, 'Dia do Trabalho', '2014-05-01');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (7, 0, 'Corpus Christi', '2014-06-19');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (8, 0, 'Independência do Brasil', '2014-09-07');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (9, 0, 'Nossa Sr.a Aparecida - Padroeira do Brasil', '2014-10-12');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (10, 0, 'Finados', '2014-11-02');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (11, 0, 'Proclamação da República', '2014-11-15');
INSERT INTO tb012_feriado(id_feriado, nu_versao, no_feriado, dt_feriado) VALUES (12, 0, 'Natal', '2014-12-25');

ALTER SEQUENCE tb012_feriado_id_feriado_seq RESTART WITH 12;

