/**
 * 
 */
package com.snake.ladder.model;

/**
 * @author Zeba
 * Snake entity for snake to store snake start and end position
 *
 */
public class Snake {
	
	private int start;
	private int end;
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	  
	
	public Snake(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
	

}
