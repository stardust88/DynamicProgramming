package com.dynaProg.problems;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Robot sitting on the upper left corner of the grid with r rows and c columns.
 * The robot can only move in two directions right and down, but certain cells
 * are off limit such that the robot cannot step on them. Design an algorithm to
 * find a path for the robot from top left to bottom right.
 * 
 * @author deepm
 *
 */
public class RobotInAGrid {

	public static void main(String args[]) {

		List<Point> path = new ArrayList<Point>();
		boolean[][] maze = new boolean[2000][2000];
		// Arrays.fill(maze, true);
		maze[3][4] = true;
		maze[8][8] = true;
		maze[6][9] = true;

		Instant start = Instant.now();
		moveRoboDynamic(1999, 1999, maze, path, new HashMap<Point, Boolean>());

		// System.out.println(path);
		System.out.println(Duration.between(start, Instant.now()).toMillis());

		start = Instant.now();
		moveRobo(1999, 1999, maze, path);

		// System.out.println(path);
		System.out.println(Duration.between(start, Instant.now()).toMillis());

	}

	public static boolean moveRobo(int row, int col, boolean[][] maze, List<Point> path) {

		if (maze.length == 0 || maze[0].length == 0)
			return false;
		if (row < 0 || col < 0 || maze[row][col])
			return false;
		Point p = new Point(row, col);

		if (row == 0 && col == 0) {
			path.add(p);
			return true;
		}

		if (moveRobo(row - 1, col, maze, path) || moveRobo(row, col - 1, maze, path)) {
			path.add(p);
			return true;
		}

		return false;
	}

	public static boolean moveRoboDynamic(int row, int col, boolean[][] maze, List<Point> path,
			Map<Point, Boolean> cache) {

		if (maze.length == 0 || maze[0].length == 0)
			return false;
		if (row < 0 || col < 0 || maze[row][col])
			return false;
		Point p = new Point(row, col);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}

		if (row == 0 && col == 0) {
			path.add(p);
			cache.put(p, true);
			return true;
		}

		if (moveRoboDynamic(row - 1, col, maze, path, cache) || moveRoboDynamic(row, col - 1, maze, path, cache)) {
			path.add(p);
			cache.put(p, true);
			return true;
		}
		cache.put(p, false);
		return false;
	}

}

class Point {
	private int row;
	private int col;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + row + "," + col + "]";
	}

	public Point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
