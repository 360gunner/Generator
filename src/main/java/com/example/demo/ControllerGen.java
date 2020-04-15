package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;




public class ControllerGen {

static String modelName = "Demande mvt";

	
	public static void main(String[] args) {
		
		String[] s=modelName.split(" ");

for(int i=0;i<s.length;i++) {
        try {
        	
        	
        	
        File file = new File("Controllers/"+s[i]+"Controller.java");
		file.createNewFile();
        FileWriter writer1 = new FileWriter(file); 
        writer1.write(
        		
        		
        		"package com.microservices.elit.controler;\r\n" + 
        				"\r\n" + 
        				"\r\n" + 
        				"\r\n" + 
        				"import java.util.List;\r\n" + 
        				"\r\n" + 
        				"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
        				"import org.springframework.http.HttpStatus;\r\n" + 
        				"import org.springframework.http.ResponseEntity;\r\n" + 
        				"import org.springframework.web.bind.annotation.DeleteMapping;\r\n" + 
        				"import org.springframework.web.bind.annotation.GetMapping;\r\n" + 
        				"import org.springframework.web.bind.annotation.PathVariable;\r\n" + 
        				"import org.springframework.web.bind.annotation.PostMapping;\r\n" + 
        				"import org.springframework.web.bind.annotation.PutMapping;\r\n" + 
        				"import org.springframework.web.bind.annotation.RequestBody;\r\n" + 
        				"import org.springframework.web.bind.annotation.ResponseBody;\r\n" + 
        				"import org.springframework.web.bind.annotation.RestController;\r\n" + 
        				"\r\n" + 
        				"import com.microservices.elit.messaging.Rabbit"+s[i]+"MessagingService;\r\n" + 
        				"import com.microservices.elit.model."+s[i]+";\r\n" + 
        				"import com.microservices.elit.model."+s[i]+"CRUD;\r\n" + 
        				"import com.microservices.elit.model.HTTPTYPE;\r\n" + 
        				"import com.microservices.elit.repo."+s[i]+"Repo;\r\n" + 
        				"\r\n" + 
        				"@RestController\r\n" + 
        				"public class "+s[i]+"Controller {\r\n" + 
        				"	\r\n" + 
        				"	@Autowired\r\n" + 
        				"	"+s[i]+"Repo tr;\r\n" + 
        				"	\r\n" + 
        				"	@Autowired\r\n" + 
        				"	Rabbit"+s[i]+"MessagingService r;\r\n" + 
        				"	\r\n" + 
        				"	@GetMapping(path=\"/"+s[i]+"\",produces=\"application/json\")\r\n" + 
        				"	public @ResponseBody ResponseEntity<?> hello_get() { \r\n" + 
        				"		\r\n" + 
        				"		\r\n" + 
        				"		try {\r\n" + 
        				"			List<"+s[i]+"> result = tr.findAll();\r\n" + 
        				"			\r\n" + 
        				"			return new ResponseEntity<List<"+s[i]+">>( result, HttpStatus.OK);\r\n" + 
        				"		}\r\n" + 
        				"		catch(Exception e) {\r\n" + 
        				"			return new ResponseEntity<List<"+s[i]+">>(HttpStatus.INTERNAL_SERVER_ERROR);\r\n" + 
        				"		}\r\n" + 
        				"	}\r\n" + 
        				"	\r\n" + 
        				"	@GetMapping(path=\"/"+s[i]+"/{id}\",produces=\"application/json\")\r\n" + 
        				"	public @ResponseBody ResponseEntity<?> hello_get_id(@PathVariable int id) { \r\n" + 
        				"		\r\n" + 
        				"		\r\n" + 
        				"		try {\r\n" + 
        				"			"+s[i]+" result = tr.findById(id).get();\r\n" + 
        				"			\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">( result, HttpStatus.OK);\r\n" + 
        				"		}\r\n" + 
        				"		catch(Exception e) {\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">(HttpStatus.INTERNAL_SERVER_ERROR);\r\n" + 
        				"		}\r\n" + 
        				"	}\r\n" + 
        				"	\r\n" + 
        				"	@PostMapping(path=\"/"+s[i]+"\",produces=\"application/json\")\r\n" + 
        				"	public @ResponseBody ResponseEntity<?> hello_post(@RequestBody "+s[i]+" t) { \r\n" + 
        				"		\r\n" + 
        				"		\r\n" + 
        				"		try {\r\n" + 
        				"			"+s[i]+" result = tr.save(t);\r\n" + 
        				"			\r\n" + 
        				"			"+s[i]+"CRUD tt = new "+s[i]+"CRUD(t,HTTPTYPE.POST);\r\n" + 
        				"			\r\n" + 
        				"			r.send"+s[i]+"(tt);\r\n" + 
        				"			\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">( result, HttpStatus.CREATED);\r\n" + 
        				"		}\r\n" + 
        				"		catch(Exception e) {\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">(HttpStatus.INTERNAL_SERVER_ERROR);\r\n" + 
        				"		}\r\n" + 
        				"	}\r\n" + 
        				"	\r\n" + 
        				"	\r\n" + 
        				"	@PutMapping(path=\"/"+s[i]+"\",produces=\"application/json\")\r\n" + 
        				"	public @ResponseBody ResponseEntity<?> hello_put(@RequestBody "+s[i]+" t) { \r\n" + 
        				"		\r\n" + 
        				"		\r\n" + 
        				"		try {\r\n" + 
        				"			"+s[i]+" result = tr.save(t);\r\n" + 
        				"			\r\n" + 
        				"			"+s[i]+"CRUD tt = new "+s[i]+"CRUD(t,HTTPTYPE.PUT);\r\n" + 
        				"			\r\n" + 
        				"			r.send"+s[i]+"(tt);\r\n" + 
        				"			\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">( result, HttpStatus.OK);\r\n" + 
        				"		}\r\n" + 
        				"		catch(Exception e) {\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">(HttpStatus.INTERNAL_SERVER_ERROR);\r\n" + 
        				"		}\r\n" + 
        				"	}\r\n" + 
        				"	\r\n" + 
        				"	\r\n" + 
        				"	@DeleteMapping(path=\"/"+s[i]+"\",produces=\"application/json\")\r\n" + 
        				"	public @ResponseBody ResponseEntity<?> hello_delete(@RequestBody "+s[i]+" t) { \r\n" + 
        				"		\r\n" + 
        				"		\r\n" + 
        				"		try {\r\n" + 
        				"			tr.delete(t);\r\n" + 
        				"			\r\n" + 
        				"			"+s[i]+"CRUD tt = new "+s[i]+"CRUD(t,HTTPTYPE.DELETE);\r\n" + 
        				"			\r\n" + 
        				"			r.send"+s[i]+"(tt);\r\n" + 
        				"			\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">( t, HttpStatus.OK);\r\n" + 
        				"		}\r\n" + 
        				"		catch(Exception e) {\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">(HttpStatus.INTERNAL_SERVER_ERROR);\r\n" + 
        				"		}\r\n" + 
        				"	}\r\n" + 
        				"	\r\n" + 
        				"	@DeleteMapping(path=\"/"+s[i]+"/{id}\",produces=\"application/json\")\r\n" + 
        				"	public @ResponseBody ResponseEntity<?> hello_delete_id(@PathVariable int id) { \r\n" + 
        				"		\r\n" + 
        				"		\r\n" + 
        				"		try {\r\n" + 
        				"			tr.deleteById(id);\r\n" + 
        				"			\r\n" + 
        				"			"+s[i]+"CRUD tt = new "+s[i]+"CRUD(new "+s[i]+"(id,\"\"),HTTPTYPE.DELETEBYID);\r\n" + 
        				"			\r\n" + 
        				"			r.send"+s[i]+"(tt);\r\n" + 
        				"			\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">( HttpStatus.OK);\r\n" + 
        				"		}\r\n" + 
        				"		catch(Exception e) {\r\n" + 
        				"			return new ResponseEntity<"+s[i]+">(HttpStatus.INTERNAL_SERVER_ERROR);\r\n" + 
        				"		}\r\n" + 
        				"	}\r\n" + 
        				"	\r\n" + 
        				"	\r\n" + 
        				"	\r\n" + 
        				"}"
        		
        		
        		); 
        writer1.flush();
        writer1.close();
        
        
        
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
       
		
		
		
		
		
		
	}
	}
}
