package com.dynaProg.problems;

import java.time.Duration;
import java.time.Instant;

/**
 * A child is running up a staircase with n steps and can hope either 1 step, 2
 * step or 3 steps at a time. Implement a method to count how many possible ways
 * the child can run up the stairs.
 * 
 * @author deepm
 *
 */
public class TripleStep {

	public static void main(String args[]) {

		Instant start = Instant.now();

		System.out.println(countWays(30));

		System.out.println(Duration.between(start, Instant.now()).toMillis());

		start = Instant.now();

		System.out.println(countWaysDynamic(30, new int[31]));

		System.out.println(Duration.between(start, Instant.now()).toMillis());

	}

	public static int countWays(int n) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);

	}

	public static int countWaysDynamic(int n, int[] memo) {
		if (n < 0)
			return 0;
		if (n == 0) {
			memo[n] = 1;
			return 1;
		}
		if (memo[n] == 0) {
			memo[n] = countWaysDynamic(n - 1,memo) + countWaysDynamic(n - 2,memo) + countWaysDynamic(n - 3,memo);
		}

		return memo[n];
	}

}
