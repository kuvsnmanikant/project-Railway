package com.capgemini.project.micreservice_train.database;

import com.capgemini.project.micreservice_train.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface Traindatabase extends MongoRepository<Train,String>{

   // this will return the train details by train id
   @Query("{'train_id':?0}")
   Train findByName(String train_id);

   // this will delete the train details by train id
   @Query(value="{'train_id':?0}", delete=true)
   Train deleteByName(String train_id);

   // this will return the train details by checking the train id and coach type
   @Query(value="{$and:[{'train_id':?0},{'details.coach_type':{$ne:?1}}]}")
   Train findByNoType(String train_id, String coach_type); 
}
