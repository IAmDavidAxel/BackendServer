package com.destinationegalite.backendserver.api.dto;

import java.util.List;

public class CharacterDto {
	private String name;
	private String country;
	private int age;
	private List<String> difficulties;
	private List<String> opportunities;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setDifficulties(List<String> difficulties) {
		this.difficulties = difficulties;
	}

	public List<String> getDifficulties() {
		return difficulties;
	}

	public void setOpportunities(List<String> opportunities) {
		this.opportunities = opportunities;
	}

	public List<String> getOpportunities() {
		return opportunities;
	}
}
