package com.microservices.elit.messaging;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.microservices.elit.*;
@Component
public class DemandeListener {
private DemandeRepo r; 
@Autowired
public DemandeListener(DemandeRepo rt) {
this.r=rt;
}
@RabbitListener(queues = "Demande.queue")
public void receiveDemande(DemandeCRUD tt) {
try{
Demande test = tt.getDemande();
if(tt.getType().equals(HTTPTYPE.POST)) {
r.save(test);
}
if(tt.getType().equals(HTTPTYPE.PUT)) {
r.save(test);
}
if(tt.getType().equals(HTTPTYPE.DELETE)) {
r.delete(test);
}
if(tt.getType().equals(HTTPTYPE.DELETEBYID)) {
r.deleteById(test.getId());
}
}
catch(Exception e) {
}
}
}
