package com.estoque.lojadeinstrumento.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public Categoria Alterar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = validarCategoriaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		
		
		return categoriaRepositorio.save(categoriaSalva);
	}

	public Categoria validarCategoriaPeloCodigo(Long codigo) {
		Optional<Categoria> categoria = BuscarPeloId(codigo);
		if(categoria.isEmpty()) {
			
			throw new EmptyResultDataAccessException(1);
			
		}
		
		return categoria.get();
		
	}

	public Optional<Categoria> BuscarPeloId(Long codigo) {

		Optional<Categoria> categoriaSalva = categoriaRepositorio.findById(codigo);
		
		return  categoriaSalva;
		
	}
	
	

	
	

}
