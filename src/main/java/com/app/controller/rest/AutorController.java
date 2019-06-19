package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Autor;
import com.app.repository.AutorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Scope("request")
@RequestMapping("/autor")
@Api(value = "autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping("/")
	@ApiOperation(value = "Listar autores")
	public List<Autor> list() {
		return this.autorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get autor por id")
	public Autor get(@PathVariable("id") Long id) {
		return this.autorRepository.getOne(id);
	}
}
