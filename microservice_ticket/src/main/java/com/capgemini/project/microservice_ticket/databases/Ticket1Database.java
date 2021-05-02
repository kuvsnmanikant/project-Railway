package com.capgemini.project.microservice_ticket.databases;

import java.util.List;
import com.capgemini.project.microservice_ticket.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface Ticket1Database extends MongoRepository<Ticket,String>{

    // it will return the price details by train type
    @Query("{'train_type':?0}")
    Ticket findByTrainType(String train_type);

    // it deleted the priced details by train type
    @Query(value = "{'train_type':?0}", delete = true)
    List<Ticket> deleteByTrainType(String train_type);
}
