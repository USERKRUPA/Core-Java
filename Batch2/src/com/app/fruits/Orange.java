package com.app.fruits;

public class Orange extends Fruit{
	public Orange(double w,  boolean fr) {
		super("Orange", w, "Orange", fr);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	public String taste() {
		return "sour";
	}
	public void juice() {
		System.out.println(super.getWeight() + " a extracting juice");
	}
}
