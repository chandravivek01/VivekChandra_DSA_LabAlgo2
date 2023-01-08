package com.vcs_gl.service;

import java.util.HashMap;
import java.util.Map;

public class Display {

	public void displayDenomination(HashMap<Integer, Integer> map) {
		/*
		 * 'comparingByKey() method follows the natural sorting order (ascending) but then in order to 
		 * get the Highest Denomination first - descending order is preferred - which is served by
		 * 'reversed() method after the key the comparison method.
		 */ 
		
		/*
		 * '->' is Lambda operator which is followed by implementation of an abstract method.
		 * 'For-Each-Loop' iterates over the elements of the HashMap one by one.
		 */
		map.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer> comparingByKey().reversed())
        .forEach((transfer)->System.out.println(transfer.getKey() + " : " + transfer.getValue()));
		
		
	}

}
