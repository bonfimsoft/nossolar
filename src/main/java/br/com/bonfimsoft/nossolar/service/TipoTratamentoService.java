package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.TipoTratamento;

@Service
public interface TipoTratamentoService {

	public void save(TipoTratamento tipoTratamento);

	public boolean exists(TipoTratamento tipoTratamento);

	public TipoTratamento findOne(Long id);

	public Iterable<TipoTratamento> findAll();

	public long count();

	public void delete(TipoTratamento tipoTratamento);

	public void delete(Long id);

	public void delete(Iterable<TipoTratamento> tiposTratamento);

	public void deleteAll();

}
