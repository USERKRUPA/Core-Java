/*
1. Create Cubes
2. Add a method to Box class to compare equality of 2 boxes & test it
3. Add a method to Box class to return a new Box with modified offset dims & test it with the tester.
*/
class Box{
	private double width;
	private double depth;
	private double height;
	Box(double w){
		width = depth = height = w;
	}
	Box(double w , double d , double height){
			width = w;
			depth = d;
			this.height = height;				
	}
	String getBoxDetails(){
			return "Box details are :"+"\n width = "+ this.width + "\n depth = "+ this.depth + "\nheight = " + this.height;
   }
	double getBoxVolume(){
		return width*depth*height;	   
    }	
	boolean isEqual(Box b){
		if(this.width == b.width && this.depth == b.depth && this.height == this.height){
			return true;
		}
		return false;
	}
	Box modifiedBox(){
		Box bx = this;
		bx.width += 2;
		bx.height += 2;
		bx.depth += 2;
		return bx;
	}
}
