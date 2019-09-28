package com.dynaProg.problems;

import java.time.Duration;
import java.time.Instant;

public class Fibbonacci{
	
	
	public static long getNthFibbonacciRecursive(long n) {
		if(n<=0)
			return 0;
		
		if(n==1 || n==2)
			return 1; 
		
		return getNthFibbonacciRecursive(n-1)+getNthFibbonacciRecursive(n-2);
	}
	
	public static long getNthFibbonacciIteration(long n) {
		if(n<=0)
			return 0;
		
		if(n==1 || n==2)
			return 1; 
		long fibbomnacciValue = 0;
		long prev =1;
		long prevPrev = 1;
		for(int i=3;i<=n;i++)
		{
			fibbomnacciValue = prev+ prevPrev;
			prevPrev = prev;
			prev = fibbomnacciValue;
			
		}
		
		return fibbomnacciValue;
	}
	
	public static long getNthFibbonacciDynamic(int n, long[] memo) {
		if(n<=0)
			return 0;
		
		if(n==1 || n==2) {
			memo[(n-1)] = 1;
			return 1; 
		}
			
		if(memo[n-1]==0) {
			memo[n-1] = getNthFibbonacciDynamic(n-1, memo) + getNthFibbonacciDynamic(n-2, memo);
		}
		
		return memo[n-1];
	}
	
	
	public static void main(String args[]) {
		Instant start = Instant.now();
		System.out.println(getNthFibbonacciRecursive(50));
		System.out.println(Duration.between(start, Instant.now()).toMillis());
		
		start = Instant.now();
		System.out.println(getNthFibbonacciIteration(50));
		System.out.println(Duration.between(start, Instant.now()).toMillis());
		
		
		start = Instant.now();
		System.out.println(getNthFibbonacciDynamic(50, new long[50]));
		System.out.println(Duration.between(start, Instant.now()).toMillis());
		
		
		
	}

}
