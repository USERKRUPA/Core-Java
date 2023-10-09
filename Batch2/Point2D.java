/*
Create a  class Point2D   for representing a point in x-y co-ordinate system.
4.1 Create a parameterized constructor to accept x & y co-ords.
4.2 Add  show() method  --to return point's x & y co-ords
eg : public String show() {.....}
4.3 (Optional work)
Add a non static  , isEqual method to Point2D class : boolean returning method :
must return true if both points are having same x,y co-ords or false otherwise.
4.4 (Optional work)
Add a non static method , calculateDistance , to calc distance between 2 points
*/
import java.lang.Math;
class Point2D{
	double x;
	double y;
	
	Point2D(double x , double y){
		this.x =x;
		this.y =y;
	}
	public String show(){
		return "Co-ordinates are : x = "+ this.x + " y = "+ this.y; 
	}
	public boolean isEqual(Point2D point){
		if(this.x == point.x && this.y == point.y){
			return true;
		}
		return false;
	}
	public double calculateDistance(Point2D point){
		return Math.sqrt((point.x - this.x)*(point.x - this.x) + (point.y - this.y)*(point.y - this.y));
	}
}