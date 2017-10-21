package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Atendimento;

@Service
public interface AtendimentoService {

	public void save(Atendimento atendimento);

	public boolean exists(Atendimento atendimento);

	public Atendimento findOne(Long id);

	public Iterable<Atendimento> findAll();

	public long count();

	public void delete(Atendimento atendimento);

	public void delete(Long id);

	public void delete(Iterable<Atendimento> atendimentos);

	public void deleteAll();

}
