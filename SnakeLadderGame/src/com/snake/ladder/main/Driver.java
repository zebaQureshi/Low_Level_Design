/**
 * 
 */
package com.snake.ladder.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.snake.ladder.model.Ladder;
import com.snake.ladder.model.Player;
import com.snake.ladder.model.Snake;
import com.snake.ladder.service.SnakeLadderService;

/**
 * @author zequresh
 * Actual running class
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of snakes:");
		int numSnakes=sc.nextInt();
		
		List<Snake> snakes= new ArrayList<Snake>();
		
		for(int i=0; i<numSnakes;i++)
		{
			
		System.out.println("enter start and end of snake : "+(i+1));
		int start= sc.nextInt();
		int end=sc.nextInt();
		
			snakes.add(new Snake(start,end));
			
			
		}
		
		
		System.out.println("Enter number of Ladders:");
		int numLadders= sc.nextInt();
		List<Ladder> l= new LinkedList<Ladder>();
		
		for(int i=0;i<numLadders;i++)
		{
			System.out.println("Enter start and end of ladder: "+i+1);
			int start= sc.nextInt();
			int end=sc.nextInt();
			
			l.add(new Ladder(start,end));
			
			
		}
		
		
		System.out.println("Enter number of Players:");
		int numPlayers= sc.nextInt();
		List<Player> players= new LinkedList<Player>();
		
		for(int i=0;i<numPlayers;i++)
		{
			System.out.println("Enter name for player "+i+1);
			String name = sc.next();
			
			players.add(new Player(name));
		}
		
		
		SnakeLadderService snakeLadderService= new SnakeLadderService();
		
		snakeLadderService.setPlayers(players);
		snakeLadderService.setLadders(l);
		snakeLadderService.setSnakes(snakes);
		
		snakeLadderService.startGame();
		

	}

}
