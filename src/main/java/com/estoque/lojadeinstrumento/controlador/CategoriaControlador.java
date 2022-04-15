package com.estoque.lojadeinstrumento.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.lojadeinstrumento.entidades.Categoria;
import com.estoque.lojadeinstrumento.servico.CategoriaServico;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaControlador {

	@Autowired
	CategoriaServico categoriaServico;
	
	@GetMapping
	public List<Categoria> Listar(){
		
		return categoriaServico.Listar();
		
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Categoria>> BuscarPeloId(@PathVariable Long codigo){
		
		Optional<Categoria> categoria = categoriaServico.BuscarPeloId(codigo);
		
		return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<Categoria> Salvar(@Valid @RequestBody Categoria categoria) {

		Categoria salvarCategoria = categoriaServico.Salvar(categoria);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvarCategoria);

	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> Alterar(@PathVariable Long codigo,@Valid @RequestBody Categoria categoria){
		
		return ResponseEntity.ok(categoriaServico.Alterar(codigo ,categoria));
	}
}
