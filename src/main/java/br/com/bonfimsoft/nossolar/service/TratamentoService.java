package br.com.bonfimsoft.nossolar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Atendimento;
import br.com.bonfimsoft.nossolar.model.Compromisso;
import br.com.bonfimsoft.nossolar.model.Livro;
import br.com.bonfimsoft.nossolar.model.TipoTratamento;
import br.com.bonfimsoft.nossolar.model.Tratamento;

@Service
public interface TratamentoService {

	public void save(Tratamento tratamento);

	public boolean exists(Tratamento tratamento);

	public Tratamento findOne(Long id);

	public Iterable<Tratamento> findByAtendimento(Atendimento atendimento);

	public Iterable<Tratamento> findAll();

	public long count();

	public void delete(Tratamento tratamento);

	public void delete(Long id);

	public void delete(Iterable<Tratamento> tratamento);

	public void deleteAll();

	public Iterable<TipoTratamento> listTiposTratamento();

	public Iterable<Livro> listLivros();

	public Iterable<Compromisso> listCompromissos();

	public List<Tratamento> geraPassesQuantidade(Atendimento atendimento, Tratamento tratamento, int quantidade);

}
