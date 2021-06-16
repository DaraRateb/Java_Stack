package com.algo.shape;

public abstract class Shape {
private String color;


public Shape(String color) {
	super();
	this.color = color;
}



public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}


public abstract double getArea();

@Override
public String toString() {
	String result ="The color is : "+this.color ;
	return result;
}

}
