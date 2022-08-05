package com.ifpe.recife.bazar.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.ifpe.recife.bazar.entites.Produto;
import com.ifpe.recife.bazar.repository.Facade;

@RestController
public class ProdutoController {

	@CrossOrigin("*")
	@PostMapping("/produto")
	public String create(@RequestBody Produto produto) {
		
		try {
			Facade.getCurrentInstance().create(produto);
			
			return "produto cadastrado com sucesso!";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "não foi possível cadastrar o produto";
		}
		
	}
	
	@CrossOrigin("*")
	@PutMapping("/produto")
	public ResponseEntity<?> update(@RequestBody Produto produto){
		
		try {
			Facade.getCurrentInstance().update(produto);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/produto/{codigo}")
	public Produto read(@PathVariable("codigo") int codigo) {
		
		try {
			
			Produto p = Facade.getCurrentInstance().readProduto(codigo);
			if(p != null) {
				return p;
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/produto/{codigo}")
	public ResponseEntity<?> delete(@PathVariable("codigo") int codigo){
		
		try {
			Facade.getCurrentInstance().deleteProduto(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> readAll(){
		
		try {
			return new ResponseEntity<List<Produto>>(
					Facade.getCurrentInstance().readAllProduto(),
					HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
