package com.example.demo;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.example.demo.repository.Person;
import com.example.demo.routes.UnmarshalRoute;

public class UnmarshalRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new UnmarshalRoute();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void unmarshalRoute() throws InterruptedException {
		
		Exchange exchange = consumer.receive("direct:endpoint");
		
		Thread.sleep(5000);
		
		List<Person> persons = (List<Person>) exchange.getIn().getBody();
		
		assertEquals("1", persons.get(0).getId());
		assertEquals("Brazil", persons.get(0).getAddress().getCountry());
		
		assertEquals("Ana", persons.get(1).getFirstName());
		assertEquals("Quebec", persons.get(1).getAddress().getProvince());
		
		assertEquals("Perez", persons.get(2).getLastName());
		assertEquals("Ottawa", persons.get(2).getAddress().getCity());
	}

}
