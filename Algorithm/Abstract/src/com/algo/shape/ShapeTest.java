package com.algo.shape;

public class ShapeTest {

	public static void main(String[] args) {
		Shape first=new Triangle("red",3,4);
		System.out.println(first.getArea());
		Shape second=new Rectangle("green",3,4);
		System.out.println(second.getArea());
		System.out.println(first.toString());
		
	}


}
