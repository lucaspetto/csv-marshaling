package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.example.demo.repository.Person;

public class UnmarshalRoute extends RouteBuilder{

	private DataFormat bindy = new BindyCsvDataFormat(Person.class);
	
	@Override
	public void configure() throws Exception {
		
		from("file:data/csv/input?fileName=example1.txt&noop=true").routeId("unMarshal")
			.unmarshal(bindy)
			.log("Unmarshaled: ${body}")
			.to("direct:endpoint");
	}

}
