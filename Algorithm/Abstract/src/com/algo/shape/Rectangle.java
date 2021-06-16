package com.algo.shape;

public class Rectangle extends Shape {
	private int length;
	private int width;
	
	
	
	
	public Rectangle(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	

	public Rectangle(String color, int length, int width) {
		super(color);
		this.length = length;
		this.width = width;
	}



	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	
	@Override
	public double getArea() {
		double area=this.length*this.width;
		return area;
	}

	@Override
	public String toString(){
	String result ="The area is : "+this.getArea();
	return result;
}
	
}
