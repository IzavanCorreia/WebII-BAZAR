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

import com.ifpe.recife.bazar.entites.OrgaoDonatario;
import com.ifpe.recife.bazar.repository.Facade;

@RestController
public class OrgaoDonatarioController {
	
	@CrossOrigin("*")
	@PostMapping("/donatario")
	public String create(@RequestBody OrgaoDonatario donatario) {
		
		try {
			Facade.getCurrentInstance().create(donatario);
			
			return "Orgão donatário cadastrado com sucesso!";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "não foi possível cadastrar o orgão donatário";
		}
		
	}
	
	@CrossOrigin("*")
	@PutMapping("/donatario")
	public String update(@RequestBody OrgaoDonatario donatario){
		
		try {
			Facade.getCurrentInstance().update(donatario);
			
			return "Orgão donatário atualizado com sucesso!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Não foi possível atualizar o orgão donatário";
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/donatario/{id}")
	public OrgaoDonatario read(@PathVariable("id") int id) {
		
		try {
			
			OrgaoDonatario o = Facade.getCurrentInstance().readOrgaoDonatario(id);
			if(o != null) {
				return o;
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/donatario/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		
		try {
			Facade.getCurrentInstance().deleteOrgaoDonatario(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/donatario")
	public ResponseEntity<List<OrgaoDonatario>> readAll(){
		
		try {
			return new ResponseEntity<List<OrgaoDonatario>>(
					Facade.getCurrentInstance().readAllOrgaoDonatario(),
					HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
