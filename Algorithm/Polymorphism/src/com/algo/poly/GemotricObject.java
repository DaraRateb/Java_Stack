package com.algo.poly;
import java.util.Date;

public class GemotricObject {
private String color="white";
private boolean filled=false;
private Date datecreated;



public GemotricObject(String color, boolean filled) {
	this.color=color;
	this.filled=filled;
}
public boolean isFilled() {
	return filled;
}


public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getFilled(){
	if (isFilled()) {
	String s="Filled";
	}
	return s;
}

public void setFilled(boolean filled) {
	this.filled=filled;
}
public Date getDatecreated() {
	return datecreated;
}
@Override
public String toString() {
	String result ="The color is : "+this.color +"Date of creation is: " + this.datecreated +"Object status: "+this.filled;
	return result;
}


}
