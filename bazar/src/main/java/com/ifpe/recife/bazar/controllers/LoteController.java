package com.ifpe.recife.bazar.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ifpe.recife.bazar.entites.Lote;
import com.ifpe.recife.bazar.repository.Facade;

@RestController
@RequestMapping("lote")
public class LoteController {

	@CrossOrigin("*")
	@PostMapping
	public void create(@RequestBody Lote lote) {
		
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
		lote.setData(dateObj);
		
		try {
			Facade.getCurrentInstance().create(lote);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@PutMapping("/lote")
	public ResponseEntity<?> update(@RequestBody Lote lote){
		
		try {
			Facade.getCurrentInstance().update(lote);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/lote/{id}")
	public Lote read(@PathVariable("id") int id) {
		
		try {
			
			Lote l = Facade.getCurrentInstance().readLote(id);
			if(l != null) {
				return l;
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	@CrossOrigin("*")
	@DeleteMapping("/lote/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		
		try {
			Facade.getCurrentInstance().deleteLote(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@CrossOrigin("*")
	@GetMapping("/lote")
	public ResponseEntity<List<Lote>> readAll(){
		
		try {
			return new ResponseEntity<List<Lote>>(
					Facade.getCurrentInstance().readAllLote(),
					HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
