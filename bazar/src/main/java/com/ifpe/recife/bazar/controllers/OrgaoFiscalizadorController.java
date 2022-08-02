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

import com.ifpe.recife.bazar.entites.OrgaoFiscalizador;
import com.ifpe.recife.bazar.repository.Facade;



@RestController
public class OrgaoFiscalizadorController {
	
	@CrossOrigin("*")
	@PostMapping("/fiscalizador")
	public String create(@RequestBody OrgaoFiscalizador fiscalizador) {
		
		try {
			Facade.getCurrentInstance().create(fiscalizador);
			
			return "Orgão fiscalizador cadastrado com sucesso!";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "não foi possível cadastrar o orgão fiscalizador";
		}
		
	}
	
	@CrossOrigin("*")
	@PutMapping("/fiscalizador")
	public ResponseEntity<?> update(@RequestBody OrgaoFiscalizador fiscalizador){
		
		try {
			Facade.getCurrentInstance().update(fiscalizador);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/fiscalizador/{id}")
	public OrgaoFiscalizador read(@PathVariable("id") int id) {
		
		try {
			
			OrgaoFiscalizador f = Facade.getCurrentInstance().readOrgaoFiscalizador(id);
			if(f != null) {
				return f;
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/fiscalizador/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		
		try {
			Facade.getCurrentInstance().deleteOrgaoFiscalizador(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/fiscalizador")
	public ResponseEntity<List<OrgaoFiscalizador>> readAll(){
		
		try {
			return new ResponseEntity<List<OrgaoFiscalizador>>(
					Facade.getCurrentInstance().readAllOrgaoFiscalizador(),
					HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
