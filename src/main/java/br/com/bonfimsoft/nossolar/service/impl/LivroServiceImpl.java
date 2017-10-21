package br.com.bonfimsoft.nossolar.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.com.bonfimsoft.nossolar.model.Livro;
import br.com.bonfimsoft.nossolar.repositories.LivroRepository;
import br.com.bonfimsoft.nossolar.service.LivroService;

@Transactional
public class LivroServiceImpl implements LivroService {

	@Inject
	private LivroRepository livroRepository;

	private static final Logger logger = LoggerFactory.getLogger(LivroServiceImpl.class);

	public void setLivroRepository(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public void save(Livro livro) {
		logger.info("Salvando livro...");
		if (livro.getId() != null) {
			final Livro livroPersistido = this.livroRepository.findOne(livro.getId());
			livro = this.atualizaDadosLivroPersistido(livro, livroPersistido);
		}

		this.livroRepository.save(livro);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exists(Livro livro) {
		return livroRepository.exists(livro.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Livro findOne(Long id) {
		return livroRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Livro> findAll() {
		return livroRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return livroRepository.count();
	}

	@Override
	public void delete(Livro livro) {
		livroRepository.delete(livro);
	}

	@Override
	public void delete(Long id) {
		livroRepository.delete(id);
	}

	@Override
	public void delete(Iterable<Livro> livro) {
		livroRepository.delete(livro);
	}

	@Override
	public void deleteAll() {
		livroRepository.deleteAll();
	}

	private Livro atualizaDadosLivroPersistido(Livro livroNovo, Livro livroPersistido) {

		livroPersistido.setAtivo(livroNovo.isAtivo());
		livroPersistido.setAutor(livroNovo.getAutor());
		livroPersistido.setTitulo(livroNovo.getTitulo());

		return livroPersistido;
	}

}
