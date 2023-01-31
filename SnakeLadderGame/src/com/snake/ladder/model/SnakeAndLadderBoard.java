/**
 * 
 */
package com.snake.ladder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zequresh
 *
 */
public class SnakeAndLadderBoard {

	private int size; // 1 to 100 size
	private List<Snake> snakes;
	private List<Ladder> ladders;
	Map<String, Integer> players;  // to store player id and his position

	public SnakeAndLadderBoard(int size)
	{
		this.size=size;
		this.snakes=new ArrayList<Snake>();
		this.ladders= new ArrayList<Ladder>();
		this.players= new HashMap<String,Integer>();
			
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public Map<String, Integer> getPlayers() {
		return players;
	}

	public void setPlayers(Map<String, Integer> players) {
		this.players = players;
	}

}
