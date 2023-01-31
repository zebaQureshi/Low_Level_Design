/**
 * 
 */
package com.snake.ladder.service;

import java.util.Random;

/**
 * @author zequresh
 * 
 * random number between 1 and 6
 *
 */
public class DiceService {

	public static int roll() {
		return new Random().nextInt(6) + 1;
	}

}
