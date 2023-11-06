package com.itbulls.ademi.sect5to10.OOP.EXAM.Sweet;

import java.util.Arrays;

public class Demo {
	public static void main(String[]args) {
		
		Sweet candy = new Candy();
		candy.setName("Lipisk");
		candy.setSugarweight(13);
		candy.setWeight(5);
		
		Cookie cookie = new Cookie();
		cookie.setName("Gurabija");
		cookie.setSugarweight(4);
		cookie.setWeight(6);
		
		
		Present present= new Present();
		present.addSweet(cookie);
		present.addSweet(candy);
		System.out.println(Arrays.toString(present.getSweets()));
		System.out.println("Weight of cookies is "+ present.calculateweight());
		
		Sweet[] filtered = present.filterSweetsBySugarRange(0, 5);
		System.out.println(Arrays.toString(filtered));


	}

}
