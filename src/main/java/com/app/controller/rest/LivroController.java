package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Livro;
import com.app.repository.LivroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Scope("request")
@RequestMapping("/livro")
@Api(value = "livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;

	@ApiOperation(value = "Listar livros")
	@GetMapping("/")
	public List<Livro> list() {
		return this.livroRepository.findAll();
	}
	
	@ApiOperation(value = "Get livro por identificador")
	@GetMapping("/{id}")
	public Livro getById(@PathVariable("id") Long id) {
		return this.livroRepository.getOne(id);
	}
	
	@ApiOperation(value = "Salvar livro na biblioteca")
	@PostMapping("/")
	public void add(Livro livro) {
		this.livroRepository.save(livro);
	}
}