package com.capgemini.project.microservice_ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.capgemini.project.microservice_ticket.models.Ac;
import com.capgemini.project.microservice_ticket.models.Food;
import com.capgemini.project.microservice_ticket.models.Price;
import com.capgemini.project.microservice_ticket.models.Sl;
import com.capgemini.project.microservice_ticket.models.Ticket;
import com.capgemini.project.microservice_ticket.services.Ticket1Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MicroserviceTicketApplicationTests {

	@Autowired
	private Ticket1Service ts;

	@Test
	@DisplayName("findall tickets Ticket1Service 1")
	public void getUserTest1() {
		assertEquals(3, ts.findAllTickets().size());
	}

	@Test
	@DisplayName("findByTrainType tickets Ticket1Service 1")
	public void getUserTest2() {
		assertTrue(ts.findByTrainType("express") !=null);
	}

	@Test
	@DisplayName("deleteByTrainType tickets Ticket1Service 1")
	public void getUserTest3() {
		assertTrue("success".equals(ts.deleteTraintype("express")));
	}

	@Test
	@DisplayName("addByTrainType tickets Ticket1Service 1")
	public void getUserTest4() {
		Food f= new Food(100,25);  // changed 50-100
		Ac ac= new Ac(2.0,f,0.25);
		Sl sl= new Sl(2.0,f,0.25);
		Price p = new Price(ac,sl);
		Ticket t = new Ticket("llp","express",p);
		assertTrue("success".equals(ts.addTraintype(t)));
	}

	@Test
	@DisplayName("updateByTrainType tickets Ticket1Service 1")
	public void getUserTest5() {
		Food f= new Food(50,25);  
		Ac ac= new Ac(2.0,f,0.25);
		Sl sl= new Sl(2.0,f,0.25);
		Price p = new Price(ac,sl);
		Ticket t = new Ticket("llp","express",p);
		ts.updateTicket(t,"express");
		assertEquals(t, ts.findByTrainType("express"));
	}

}
