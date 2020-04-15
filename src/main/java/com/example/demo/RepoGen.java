package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;




public class RepoGen {

static String modelName = "Demande mvt";

	
	public static void main(String[] args) {
		
		String[] s=modelName.split(" ");

for(int i=0;i<s.length;i++) {
        try {
        	
        	
        	
        File file = new File("Repo/"+s[i]+"Repo.java");
		file.createNewFile();
        FileWriter writer1 = new FileWriter(file); 
        writer1.write(
"package com.microservices.elit.repo;\n"+


"import org.springframework.data.jpa.repository.JpaRepository;\n"+
"import org.springframework.data.repository.PagingAndSortingRepository;\n"+
"import org.springframework.data.repository.query.Param;\n"+
"import org.springframework.data.rest.core.annotation.RepositoryRestResource;\n"+
"import com.microservices.elit.model."+s[i]+";\n"+


"@RepositoryRestResource(collectionResourceRel = \""+s[i]+"\", path = \""+s[i]+"\")\n"+
"public interface "+s[i]+"Repo  extends JpaRepository<"+s[i]+", Integer> {\r\n" + 
		"\r\n" + 
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
