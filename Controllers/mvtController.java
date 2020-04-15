package com.microservices.elit.controler;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.elit.messaging.RabbitmvtMessagingService;
import com.microservices.elit.model.mvt;
import com.microservices.elit.model.mvtCRUD;
import com.microservices.elit.model.HTTPTYPE;
import com.microservices.elit.repo.mvtRepo;

@RestController
public class mvtController {
	
	@Autowired
	mvtRepo tr;
	
	@Autowired
	RabbitmvtMessagingService r;
	
	@GetMapping(path="/mvt",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_get() { 
		
		
		try {
			List<mvt> result = tr.findAll();
			
			return new ResponseEntity<List<mvt>>( result, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<mvt>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/mvt/{id}",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_get_id(@PathVariable int id) { 
		
		
		try {
			mvt result = tr.findById(id).get();
			
			return new ResponseEntity<mvt>( result, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<mvt>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/mvt",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_post(@RequestBody mvt t) { 
		
		
		try {
			mvt result = tr.save(t);
			
			mvtCRUD tt = new mvtCRUD(t,HTTPTYPE.POST);
			
			r.sendmvt(tt);
			
			return new ResponseEntity<mvt>( result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<mvt>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping(path="/mvt",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_put(@RequestBody mvt t) { 
		
		
		try {
			mvt result = tr.save(t);
			
			mvtCRUD tt = new mvtCRUD(t,HTTPTYPE.PUT);
			
			r.sendmvt(tt);
			
			return new ResponseEntity<mvt>( result, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<mvt>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(path="/mvt",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_delete(@RequestBody mvt t) { 
		
		
		try {
			tr.delete(t);
			
			mvtCRUD tt = new mvtCRUD(t,HTTPTYPE.DELETE);
			
			r.sendmvt(tt);
			
			return new ResponseEntity<mvt>( t, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<mvt>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path="/mvt/{id}",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_delete_id(@PathVariable int id) { 
		
		
		try {
			tr.deleteById(id);
			
			mvtCRUD tt = new mvtCRUD(new mvt(id,""),HTTPTYPE.DELETEBYID);
			
			r.sendmvt(tt);
			
			return new ResponseEntity<mvt>( HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<mvt>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}