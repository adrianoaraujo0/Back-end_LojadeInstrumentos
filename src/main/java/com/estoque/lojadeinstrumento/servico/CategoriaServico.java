package com.estoque.lojadeinstrumento.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.lojadeinstrumento.entidades.Categoria;
import com.estoque.lojadeinstrumento.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	public List<Categoria> Listar() {
		return categoriaRepositorio.findAll();
	}

	public Categoria Salvar(Categoria categoria) {

		return categoriaRepositorio.save(categoria);

	}

	public Categoria Alterar(Categoria categoria) {
		
		
		return Salvar(categoria);
	}

	public Categoria BuscarPeloId(Long codigo) {

		Optional<Categoria> categoriaSalva = categoriaRepositorio.findById(codigo);
		
		return  categoriaSalva.get();
		
	}

}
