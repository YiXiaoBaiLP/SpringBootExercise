package com.yixiaobai.bean;

/**
 * 宠物
 * @author yixiaobai
 *
 */
public class Pet {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}

	public Pet(String name) {
		super();
		this.name = name;
	}
	
	
}
