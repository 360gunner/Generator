package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;




public class CRUDEntitiesGen {

static String modelName = "Demande mvt";

	
	public static void main(String[] args) {
		
		String[] s=modelName.split(" ");

for(int i=0;i<s.length;i++) {
        try {
        	
        	
        	
        File file = new File("CRUDEntities/"+s[i]+"CRUD.java");
		file.createNewFile();
        FileWriter writer1 = new FileWriter(file); 
        writer1.write(
"package com.microservices.elit.model;\r\n" + 
"\r\n" + 
"public class "+s[i]+"CRUD {\r\n" + 
"	\r\n" + 
"	"+s[i]+" test;\r\n" + 
"	\r\n" + 
"	HTTPTYPE type;\r\n" + 
"	\r\n" + 
"	public "+s[i]+"CRUD() {\r\n" + 
"		super();\r\n" + 
"		// TODO Auto-generated constructor stub\r\n" + 
"	}\r\n" + 
"\r\n" + 
"	public "+s[i]+"CRUD("+s[i]+" test, HTTPTYPE type) {\r\n" + 
"		super();\r\n" + 
"		this.test = test;\r\n" + 
"		this.type = type;\r\n" + 
"	}\r\n" + 
"\r\n" + 
"	public "+s[i]+" get"+s[i]+"() {\r\n" + 
"		return test;\r\n" + 
"	}\r\n" + 
"\r\n" + 
"	public void set"+s[i]+"("+s[i]+" test) {\r\n" + 
"		this.test = test;\r\n" + 
"	}\r\n" + 
"\r\n" + 
"	public HTTPTYPE getType() {\r\n" + 
"		return type;\r\n" + 
"	}\r\n" + 
"\r\n" + 
"	public void setType(HTTPTYPE type) {\r\n" + 
"		this.type = type;\r\n" + 
"	}\r\n" + 
"\r\n" + 
"	@Override\r\n" + 
"	public String toString() {\r\n" + 
"		return \""+s[i]+"CRUD [this=\" + test + \", type=\" + type + \"]\";\r\n" + 
"	}\r\n" + 
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
