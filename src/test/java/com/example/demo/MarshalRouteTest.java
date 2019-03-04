package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.example.demo.repository.Address;
import com.example.demo.repository.Person;
import com.example.demo.routes.MarshalRoute;

public class MarshalRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new MarshalRoute();
	}
	
	@Test
	public void unmarshalRoute() throws InterruptedException {
		
		List<Person> persons =  new ArrayList<Person>();
		
		persons.add(new Person("1", "Joao", "Silva", new Address("Canada", "Quebec", "Quebec")));
		persons.add(new Person("2", "Carlos", "Nobrega", new Address("Canada", "Ontario", "Kanata")));
		persons.add(new Person("3", "Danielle", "Felisberto", new Address("Brazil", "Sao Paulo", "Brotas")));
		
		template.sendBody("direct:inputValue",persons);
		
		File f = new File("data/csv/output");
		
		assertTrue(f.isDirectory());
	}

}
