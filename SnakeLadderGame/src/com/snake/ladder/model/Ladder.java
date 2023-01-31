/**
 * 
 */
package com.snake.ladder.model;

/**
 * @author zequresh Ladder class for storing ladder start and end position
 *
 */
public class Ladder {

	private int start;
	private int end;

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public Ladder(int start, int end) {
		this.start = start;

		this.end = end;

	}

}
