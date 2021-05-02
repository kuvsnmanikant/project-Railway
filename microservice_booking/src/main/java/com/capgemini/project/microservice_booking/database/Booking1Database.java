package com.capgemini.project.microservice_booking.database;

import com.capgemini.project.microservice_booking.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableMongoRepositories
public interface Booking1Database extends MongoRepository<Booking, String>{

    // this will fetch the data from the data base by using the pnr number
    @Query("{'pnr':?0}")
    public Booking findByPnr(String pnr);    
}
