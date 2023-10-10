package com.app.fruits;

public class Mango extends Fruit{
	public Mango(double w, boolean fr) {
		super("Yellow", w, "Mango", fr);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	public String taste() {
		return "sweet";
	}
	public void pulp() {
		System.out.println(super.getColor() + " a creating pulp");
	}
}
