/**
 * 
 */
package com.snake.ladder.model;

import java.util.UUID;

/**
 * @author zequresh Player class for player id and name
 *
 */
public class Player {

	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Player(String name) {

		this.name = name;
		this.id = UUID.randomUUID().toString();
	}

}
