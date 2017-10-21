package br.com.bonfimsoft.nossolar.service;

import org.springframework.stereotype.Service;

import br.com.bonfimsoft.nossolar.model.Livro;

@Service
public interface LivroService {

	public void save(Livro livro);

	public boolean exists(Livro livro);

	public Livro findOne(Long id);

	public Iterable<Livro> findAll();

	public long count();

	public void delete(Livro livro);

	public void delete(Long id);

	public void delete(Iterable<Livro> livros);

	public void deleteAll();

}
