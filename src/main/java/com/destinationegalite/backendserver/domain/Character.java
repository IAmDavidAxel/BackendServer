package com.destinationegalite.backendserver.domain;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name ="characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "country")
	private String country;
	@Column(name ="age")
	private int age;
	@ElementCollection
	@CollectionTable(name = "difficulty_list", joinColumns = @JoinColumn(name = "id"))
	@Column (name = "difficulties")
	private List<String> difficulties;

	@ElementCollection
	@CollectionTable(name = "opporunity_list", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "opportunities")
	private List<String> opportunities;

	public Character(String name, String country, int age, List<String> difficulties, List<String> opportunities) {
		this.name = name;
		this.country = country;
		this.age = age;
		this.difficulties = difficulties;
		this.opportunities = opportunities;
	}

	public Character() {

	}


	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getAge() {
		return age;
	}

	public List<String> getDifficulties() {
		return difficulties;
	}

	public List<String> getOpportunities() {
		return opportunities;
	}


}
