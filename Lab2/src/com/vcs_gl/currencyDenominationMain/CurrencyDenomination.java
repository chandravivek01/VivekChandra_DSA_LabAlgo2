package com.vcs_gl.currencyDenominationMain;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import com.vcs_gl.service.Display;
import com.vcs_gl.service.MergeSort;

public class CurrencyDenomination {
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			ArrayList<Integer> transaction = new ArrayList<Integer>();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			System.out.println("Enter size of Currency Denomination: ");
			int size = scanner.nextInt();
			
			System.out.println("\nEnter Currency Denomination Values: ");
			int[] denomination = new int[size];
			for(int i=0;i<size;i++)
				denomination[i] = scanner.nextInt();
			
			System.out.println("Enter the amount to pay: ");
			int amount = scanner.nextInt();
			
			// Sorting the Denomination Array as input denominations can be randomly inserted 
			// Arrays.sort(denomination); can also be used 'O(nlogn)' Time Complexity
			MergeSort mergeSort = new MergeSort();
			mergeSort.sort(denomination, 0, denomination.length -1);
			
			
			/* Greedy-Algorithm Block, pointer began from the last index of the Array as Higher Currency Denomination 
			 * has to be applied first
			 */
			for(int j=size-1;j>=0;j--) {
				while(denomination[j]<=amount) {
					
					// Reducing the Target Amount after every inclusion of Denomination
					amount -= denomination[j];
					// Storing the Dynamically Computed Denomination into a List 
					transaction.add(denomination[j]);
				}
			}
			
			/*
			 *	Block to Calculate the Frequency of all the Denominations by inserting The Currency into a HashMap 
			 *	where each 'Denomination' is stored as a 'Key' and the Frequency of Denomination as 'Value',
			 *	<Key, Value> pair
			 */
			int key;
			for(int i=0;i<transaction.size();i++) {
				key = transaction.get(i);
				// If the Denomination already exists in the HashMap then simply its Frequency is increment by '1'
				if(map.containsKey(key)) 
					map.put(key, map.get(key)+1);
				else
				// If the Denomination has not appeared yet Inserting the Denomination with an initial count of '1'
					map.put(key, 1);	
			}
			
			
			
			// Display the Currency Denominations
			Display display = new Display();
			if(amount==0) {
				System.out.println("Denominations of the Transaction from the Order of Highest Currency: ");
				display.displayDenomination(map);
			}
				
			else
				System.out.println("Transaction cannot be completed !!");
				
			// Closing the Resource prior to Program Termination
			scanner.close();
		}


}
