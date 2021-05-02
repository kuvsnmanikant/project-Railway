package com.capgemini.project.micreservice_train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import com.capgemini.project.micreservice_train.model.Ac;
import com.capgemini.project.micreservice_train.model.Details;
import com.capgemini.project.micreservice_train.model.Noseat;
import com.capgemini.project.micreservice_train.model.Sl;
import com.capgemini.project.micreservice_train.model.Train;
import com.capgemini.project.micreservice_train.services.Train1services;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// this cllass will test the methods in the Train1Services class
@RunWith(SpringRunner.class)
@SpringBootTest
class MicreserviceTrainApplicationTests {

	@Autowired
    private Train1services ts;

	// this will check weadhter the data is retreaving is correct or not
	@Test
	@DisplayName("fidall in Train1Service  1")
	public void getUserTest1(){
		assertEquals(10, ts.getAllTrains().size());
	}

	// this will check the data is false when we are giving the wrong out put
	@Test
	@DisplayName("findall in Train1Service  2")
	public void getUserTest2(){
		assertNotEquals(9, ts.getAllTrains().size());
	}

	// checking wether  the getallT is returning expeted output or not
	@Test
	@DisplayName("getAllT in Train1Service 1")
	public void getUserTest3(){
		List<Integer> c1=Arrays.asList(10,20,25);
		Ac ac=new Ac(c1);
		List<Integer> c2=Arrays.asList(50,25,33);
		Sl sl= new Sl(c2);
		Noseat n =new Noseat(ac,sl);
		List<Integer> i=Arrays.asList(0,1000,1450,1950);
		Details d= new Details("HUMSAFAR EXPRESS","express","ALL",i,n);
		List<String> s=Arrays.asList("S0007","S0005","S0003","S0004");
		Train t= new Train("102010","102010","monday","wednesday","06:20:00","15:22:00",s,d);
		assertTrue(t.equals(ts.getAllT("102010")));
	}

	// this will check wethere it is showing wrong output or not
	@Test
	@DisplayName("findByNoType in Train1Service 1")
	public void getUserTest4(){
		List<Integer> c1=Arrays.asList(10,20,25);
		Ac ac=new Ac(c1);
		List<Integer> c2=Arrays.asList(50,25,33);
		Sl sl= new Sl(c2);
		Noseat n =new Noseat(ac,sl);
		List<Integer> i=Arrays.asList(0,1000,1450,1950);
		Details d= new Details("HUMSAFAR EXPRESS","express","Ac",i,n); // changed data ALL to Ac
		List<String> s=Arrays.asList("S0007","S0005","S0003","S0004");
		Train t= new Train("102010","102010","monday","wednesday","06:20:00","15:22:00",s,d);
		assertFalse(t.equals(ts.findByNoType("102010", "SL")));
	}

	// it will check wethere the train is deleted successful or not
	@Test
	@DisplayName("deleteTrain in Train1Service 1")
	public void getUserTest5(){
	assertTrue("deleted".equals(ts.deleteTrain("102010")));
	}

	// it will check wethere new train is added or not
	@Test
	@DisplayName("addTrain in Train1Service 1")
	public void getUserTest6(){
		List<Integer> c1=Arrays.asList(10,20,25);
		Ac ac=new Ac(c1);
		List<Integer> c2=Arrays.asList(50,25,33);
		Sl sl= new Sl(c2);
		Noseat n =new Noseat(ac,sl);
		List<Integer> i=Arrays.asList(0,1000,1450,1950);
		Details d= new Details("HUMSAFAR EXPRESS","express","Ac",i,n);
		List<String> s=Arrays.asList("S0007","S0005","S0003","S0004");
		Train t= new Train("102010","102010","monday","wednesday","06:20:00","15:22:00",s,d);
		assertTrue("Success".equals(ts.addTrain(t)));
	}

	// it will check wethere new train is added or not
	@Test
	@DisplayName("updateTrain in Train1Service 1")
	public void getUserTest7(){
		List<Integer> c1=Arrays.asList(10,20,25);
		Ac ac=new Ac(c1);
		List<Integer> c2=Arrays.asList(50,25,33);
		Sl sl= new Sl(c2);
		Noseat n =new Noseat(ac,sl);
		List<Integer> i=Arrays.asList(0,1000,1450,1950);
		Details d= new Details("HUMSAFAR EXPRESS","express","ALL",i,n);
		List<String> s=Arrays.asList("S0007","S0005","S0003","S0004");
		Train t= new Train("102010","102010","monday","wednesday","06:20:00","15:22:00",s,d);
		ts.updateTrain(t,"102010");
		assertTrue(t.equals(ts.getAllT("102010")));
	}
}


