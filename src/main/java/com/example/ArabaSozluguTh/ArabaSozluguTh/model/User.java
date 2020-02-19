package com.example.ArabaSozluguTh.ArabaSozluguTh.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = {"cars","posts"})
@Setter
@Getter
public class User{
	private String id;
	private String name;
	private String user;
	private String  pass;
	private Set<Car> cars = new HashSet<Car>();
	@JsonBackReference
	private Set<Post> posts = new HashSet<Post>();
	
	public void addCar(Car car) {
		car.setUser(this);
		cars.add(car);
	}
	private List<Role> roles;
}
