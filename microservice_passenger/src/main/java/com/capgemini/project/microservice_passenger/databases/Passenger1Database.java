package com.capgemini.project.microservice_passenger.databases;

import java.util.List;
import com.capgemini.project.microservice_passenger.models.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface Passenger1Database extends MongoRepository<Passenger,String>{

    // this will query the database by pnr no
    @Query("{'pnr_no':?0}")
    List<Passenger> findByPnr(String pnr_no);

    // this will return the passengeres list by user id
    @Query("{'booked_by':?0}")
    List<Passenger> findBybooked_by(String booked_by);

    //this will delete the passengers by pnr number
    @Query(value="{'pnr_no':?0}",delete = true)
    List<Passenger> deleteByPnr(String pnr_no);

     // @Query(value ="{$and:[{'p_trainno':?0},{'ts_date':?1},{'r_status':{$ne:?2}},{$or:[{start_index:{$lt:?3}},{destination_index:{$gt:?4}}]}]}")
    // List<Passenger> findBytrainnoDate(String p_trainno,String ts_date,String r_status, String start_index, String destination_index);

    // this will query the passengers details based on train no , train date, starting and destination
    @Query(value ="{$and:[{'p_trainno':?0},{'ts_date':?1}]}")
    List<Passenger> findBytrainnoDate1(String p_trainno,String ts_date);
    
}