package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.example.demo.repository.Person;

public class MarshalRoute extends RouteBuilder{

	private DataFormat bindy = new BindyCsvDataFormat(Person.class);
	
	@Override
	public void configure() throws Exception {

		from("direct:inputValue")
			.marshal(bindy)
			.to("file:data/csv/output/?fileName=output.txt");
	}

}
