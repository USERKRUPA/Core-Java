package com.acts.code;
public class Box{
	private double width;
	private double depth;
	private double height;
	
	public Box(){
		this(-1);
	}
	public Box(double side){
		this(side, side, side);
	}
	public Box(double w , double d , double height){
			width = w;
			depth = d;
			this.height = height;				
	}
	public String getBoxDetails(){
		return "Box details are :"+"\n width = "+ this.width + "\n depth = "+ this.depth + "\nheight = " + this.height;
   	}
	public double getBoxVolume(){
		return width*depth*height;	   
	}	
	public boolean isEqual(Box b){
		/*if(this.width == b.width && this.depth == b.depth && this.height == this.height){
			return true;
		}
		return false;*/
		return (this.width == b.width && this.depth == b.depth && this.height == this.height);
	}
	public Box modifiedBox(double wOff, double dOff, double hOff){
		Box bx = new Box(this.width + wOff, this.depth + dOff, this.height + hOff);
		return bx;
	}
}
