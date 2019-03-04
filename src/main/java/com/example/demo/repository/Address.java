package com.example.demo.repository;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class Address {

	@DataField(pos = 4)
	private String country;
	@DataField(pos = 5)
	private String province;
	@DataField(pos = 6)
	private String city;

	public Address() {
		super();
	}

	public Address(String country, String province, String city) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", province=" + province + ", city=" + city + "]";
	}

}
