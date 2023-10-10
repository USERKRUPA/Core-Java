package com.app.fruits;

public class Fruit {
		//color : String , weight : double , name:String, fresh : boolean
		private String color;
		private double weight;
		private String name;
		private boolean fresh;
		public Fruit(String col, double w, String nm, boolean fr) {
			color = col;
			weight = w;
			name = nm;
			fresh = fr;
		}
		public String toString() {
			return "Fruit name: " + name + " color: " + color + " weight: " + weight;
		}
		public boolean isFresh() {
			return fresh;
		}
		public void setFresh(boolean fresh) {
			this.fresh = fresh;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String taste() {
			return "no specific tast";
		}
		public String getName() {
			return name;
		}
		public String getColor() {
			return color;
		}
		public double getWeight() {
			return weight;
		}
}
