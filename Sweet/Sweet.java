package com.itbulls.ademi.sect5to10.OOP.EXAM.Sweet;

public abstract class Sweet {
	private String name;
	private double weight;
	private double sugarweight;
	
	
	
	@Override
	public String toString() {
		return "Sweet [name=" + name + ", weight=" + weight + ", sugarweight=" + sugarweight + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getSugarweight() {
		return sugarweight;
	}
	public void setSugarweight(double sugarweight) {
		this.sugarweight = sugarweight;
	}


}
