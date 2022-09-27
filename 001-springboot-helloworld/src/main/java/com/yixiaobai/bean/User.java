package com.yixiaobai.bean;

/**
 * 用户
 * @author yixiaobai
 *
 */
public class User {

	private String name;
	private int age;
	private Pet pet;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public User(String name, int age, Pet pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}
	
	
}
