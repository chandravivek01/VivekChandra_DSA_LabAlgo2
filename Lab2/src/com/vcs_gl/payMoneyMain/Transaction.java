package com.vcs_gl.payMoneyMain;

import java.util.Scanner;

public class Transaction {
	
	// To index the Reference number of Every Target
	static int count=0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the size of Transaction Array: ");
		int size = scanner.nextInt();
		
		System.out.println("Enter the values of the array: ");
		int[] arr = new int[size];
		for(int i=0;i<size;i++)
			arr[i] = scanner.nextInt();
		
		System.out.println("Enter the Total Numer of Targets needed to be achieved: ");
		int targetNo = scanner.nextInt();
		
		while(targetNo>0) {
			count++;
			int flag = 0;
			long target, sum = 0;
			
			System.out.println("\nEnter the value of Target " + count + ": ");
			target = scanner.nextLong();
			
			for(int i=0; i<size; i++) {
				sum += arr[i];
				if(sum>=target) {
					flag = 1;
					System.out.println("Target achieved after "+(i+1)+" Transactions");
					break;
				}
			}
			if(flag==0)
				System.out.println("Target could not be achieved !!");
			targetNo--;
		}
		
		// Closing the Resource prior to Program Termination
		scanner.close();
	}	
}
