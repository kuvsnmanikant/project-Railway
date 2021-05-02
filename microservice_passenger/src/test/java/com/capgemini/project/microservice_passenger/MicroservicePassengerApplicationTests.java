package com.capgemini.project.microservice_passenger;

import com.capgemini.project.microservice_passenger.models.Passenger;
import com.capgemini.project.microservice_passenger.services.Passenger1Service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// this cllass will test the methods in the Train1Services class
@RunWith(SpringRunner.class)
@SpringBootTest
class MicroservicePassengerApplicationTests {
	@Autowired
	private Passenger1Service ps;

	@Test
	@DisplayName("getAllPassengers in Passenger1Service  1")
	public void getUserTest1(){
	// assertNotEquals(6, ps.getAllPassengers().size());
		assertNotEquals(6, ps.getAllPassengers().size());
	}

	@Test
	@DisplayName("findByPnr in Passenger1Service  1")
	public void getUserTest2(){
		assertEquals(1, ps.findByPnr("PNR123455455").size());
	}

	@Test
	@DisplayName("deletePassenger in Passenger1Service  1")
	public void getUserTest3(){
		assertTrue("success".equals(ps.deletePassenger("PNR123455455")));
	}

	@Test
	@DisplayName("addPassenger in Passenger1Service  1")
	public void getUserTest4(){
		Passenger p =new Passenger("l","Naga Manikant","M",26,"G","PNR123455455","102030","ASR NGP SUPERFAST","22-04-2021","22-04-2021","21-04-2021","22-04-2021","nv","Amritsar","Bhopal",2,3,"A3-9","manikant","confirmed");  // changed 22-26
		assertTrue("success".equals(ps.addPassenge(p)));
	}

	@Test
	@DisplayName("updatePassenger in Passenger1Service  1")
	public void getUserTest5(){
		Passenger p =new Passenger("l","Naga Manikant","M",22,"G","PNR123455455","102030","ASR NGP SUPERFAST","22-04-2021","22-04-2021","21-04-2021","22-04-2021","nv","Amritsar","Bhopal",2,3,"A3-9","manikant","confirmed");  // changed 22-26
		assertTrue("success".equals(ps.updatePassenger(p,"PNR123455455")));
	}

	@Test
	@DisplayName("find the passengesrs in a train who will journey in between two given stations in Passenger1Service  1")
	public void getUserTest6(){
		assertEquals(0,ps.findBytrainnoDate("102040","20-05-2021",0,1).size());
	}

}
