package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;




public class RabbitMessagingServiceGen {

static String modelName = "Demande mvt";

	
	public static void main(String[] args) {
		
		String[] s=modelName.split(" ");

for(int i=0;i<s.length;i++) {
        try {
        	
        	
        	
        File file = new File("RabbitMessagingService/Rabbit"+s[i]+"MessagingService.java");
		file.createNewFile();
        FileWriter writer1 = new FileWriter(file); 
        writer1.write(
        		
        		
"package com.microservices.elit.messaging;\r\n" + 
"\r\n" + 
"import org.springframework.amqp.AmqpException;\r\n" + 
"import org.springframework.amqp.core.Message;\r\n" + 
"import org.springframework.amqp.core.MessagePostProcessor;\r\n" + 
"import org.springframework.amqp.core.MessageProperties;\r\n" + 
"import org.springframework.amqp.core.Queue;\r\n" + 
"import org.springframework.amqp.rabbit.core.RabbitTemplate;\r\n" + 
"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
"import org.springframework.stereotype.Service;\r\n" + 
"\r\n" + 
"import com.gunner.demo.model."+s[i]+"CRUD;\r\n" + 
"\r\n" + 
"@Service\r\n" + 
"public class Rabbit"+s[i]+"MessagingService\r\n" + 
"        {\r\n" + 
"  \r\n" + 
"  private RabbitTemplate rabbit;\r\n" + 
"  \r\n" + 
"  @Autowired\r\n" + 
"  public Rabbit"+s[i]+"MessagingService(RabbitTemplate rabbit) {\r\n" + 
"    this.rabbit = rabbit;\r\n" + 
"  }\r\n" + 
"  \r\n" + 
"  public void send"+s[i]+"("+s[i]+"CRUD test) {\r\n" + 
"	try {  \r\n" + 
"	new Queue(\""+s[i]+".queue\");}\r\n" + 
"	catch(Exception e) {}\r\n" + 
"    rabbit.convertAndSend(\""+s[i]+".queue\", test);\r\n" + 
"  }\r\n" + 
"  \r\n" + 
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
