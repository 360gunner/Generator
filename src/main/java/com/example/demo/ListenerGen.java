package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;




public class ListenerGen {

static String modelName = "Demande";

	
	public static void main(String[] args) {
		
		String[] s=modelName.split(" ");

		for(int i=0;i<s.length;i++) {


        try {
        	
        	
        	
        File file = new File("Listener/"+s[i]+"Listener.java");
		file.createNewFile();
        FileWriter writer1 = new FileWriter(file); 
        writer1.write(
"package com.microservices.elit.messaging;\n"+


"import org.springframework.amqp.rabbit.annotation.RabbitListener;\n"+
"import org.springframework.beans.factory.annotation.Autowired;\n"+
"import org.springframework.stereotype.Component;\n"+


"import com.microservices.elit.*;\n"+


"@Component\n"+
"public class "+s[i]+"Listener {\n"+

 "private "+s[i]+"Repo r; \n"+
  
  
	
  "@Autowired\n"+
  "public "+s[i]+"Listener("+s[i]+"Repo rt) {\n"+
    "this.r=rt;\n"+
  "}\n"+

  "@RabbitListener(queues = \""+s[i]+".queue\")\n"+
  "public void receive"+s[i]+"("+s[i]+"CRUD tt) {\n"+
  "try{\n"+
  s[i]+" test = tt.get"+s[i]+"();\n"+
	  "if(tt.getType().equals(HTTPTYPE.POST)) {\n"+
		  "r.save(test);\n"+
	  "}\n"+
	  "if(tt.getType().equals(HTTPTYPE.PUT)) {\n"+
		  "r.save(test);\n"+
	  "}\n"+
	  "if(tt.getType().equals(HTTPTYPE.DELETE)) {\n"+
		  "r.delete(test);\n"+
	  "}\n"+
	  "if(tt.getType().equals(HTTPTYPE.DELETEBYID)) {\n"+
		  "r.deleteById(test.getId());\n"+
	  "}\n"+
  "}\n"+
  "catch(Exception e) {\n"+
	  
"}\n"+
"}\n"+

"}\n"
        		
        		
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
