package com.capgemini.project.micreservice_train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.capgemini.project.micreservice_train.model.TrainSearch;
import com.capgemini.project.micreservice_train.services.Search1Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// this class will check the methods in the Search1Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchTesting {

    // here we are creating instance to Search1Service
    @Autowired
    private Search1Service ss;

    // here we are checking the output of method ge by passing the obj of TrainSearch
    @Test
	@DisplayName("Search train in Search1Service  1")
	public void getUserTest1(){
        TrainSearch tr = new TrainSearch("S0001","S0003","14-04-2021","sl","s");
		assertEquals(1,ss.ge(tr).size());
	}
}
