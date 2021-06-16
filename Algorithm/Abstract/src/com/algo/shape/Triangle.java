package com.algo.shape;

public class Triangle extends Shape {
private int base;
private int height;


public Triangle(String color) {
	super(color);
}



public Triangle(String color, int base, int height) {
	super(color);
	this.base = base;
	this.height = height;
}




public int getBase() {
	return base;
}

public void setBase(int base) {
	this.base = base;
}

@Override
public double getArea() {
	double area=0.5*base*height;
	return area;
}

@Override
public String toString(){
String result ="The area is : "+this.getArea();
return result;
}

}