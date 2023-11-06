package com.itbulls.ademi.sect5to10.OOP.EXAM.Sweet;

import java.util.Arrays;

public class Present {
	private Sweet[] sweets;
	private int lastindex;
	
	{
		sweets=new Sweet[6];
	}

	public void addSweet(Sweet sweet) {
		if(sweet == null) {
			return;
		}
		if (sweets.length <= lastindex) {
			sweets = Arrays.copyOf(sweets, sweets.length*2);
		}
		sweets[lastindex++]=sweet;
	}
	public double calculateweight() {
		double weight=0;
		for (Sweet sweet:sweets) {
			if(sweet != null) {
				weight += sweet.getWeight();
			}
		}
		return weight;
	}
		
		
		public Sweet[] filterSweetsBySugarRange(double minSugarWeight,
				double maxSugarWeight) {
			int matchSweetsAmount = 0;
			for (Sweet sweet : sweets) {
				if (sweet != null && (sweet.getSugarweight() >= minSugarWeight
						&& sweet.getSugarweight() <= maxSugarWeight)) {
					matchSweetsAmount++;
				}
			}
			
			Sweet[] filteredSweets = new Sweet[matchSweetsAmount];
			int index = 0;
			for (Sweet sweet : sweets) {
				if (sweet != null && (sweet.getSugarweight() >= minSugarWeight
						&& sweet.getSugarweight() <= maxSugarWeight)) {
					filteredSweets[index++] = sweet;
				}
			}

			return filteredSweets;
		}

			
	
	public Sweet[] getSweets() {
		int n=0;
		for (Sweet sweet:sweets) {
			if(sweet != null) {
				n++;
			}
		}
		Sweet[] n1 = new Sweet[n];
		int i =0;
		for(Sweet sweet: this.sweets ) {
			if(sweet != null) {
				n1[i++]=sweet;
			}
		}
		return n1;
	}

}
