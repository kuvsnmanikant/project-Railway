package com.capgemini.project.micreservice_train.database;

import java.util.List;
import com.capgemini.project.micreservice_train.model.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface StationDatabase extends MongoRepository<Station, String> {

  // this query will return the certain station list by station name
  @Query("{'station_name':?0}")
  Station findByName(String station_name);

  // this will return station details by id
  @Query("{'station_id':?0}")
  Station findByStationId(String station_id);

  // this will delete the station details by station id
  @Query(value = "{'station_id':?0}", delete = true)
  List<Station> deleteByStationId(String station_id);

  // this will return the station details by checking the stationi id and train day 
  @Query(value = "{$and:[{'station_id':?0},{'station_list.train_day':?1}]}")
  Station findByDay(String station_id, String train_day);
}
