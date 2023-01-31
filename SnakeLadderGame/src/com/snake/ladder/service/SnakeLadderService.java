/**
 * 
 */
package com.snake.ladder.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.snake.ladder.model.Ladder;
import com.snake.ladder.model.Player;
import com.snake.ladder.model.Snake;
import com.snake.ladder.model.SnakeAndLadderBoard;

/**
 * @author zequresh
 *
 *         for playing the entire game
 */
public class SnakeLadderService {

	private SnakeAndLadderBoard board;
	private int initialNumberOfPlayers;
	Queue<Player> players;
	private boolean isGameCompleted;
	private int numOfDices;
	private static final int DEFAULT_BOARD_SIZE = 100;
	private static final int DEFAULT_NUMBER_OF_DICES = 1;

	public SnakeLadderService(int boardsize) {
		this.board = new SnakeAndLadderBoard(boardsize);
		this.players = new LinkedList<Player>();
		this.numOfDices = SnakeLadderService.DEFAULT_NUMBER_OF_DICES;

	}

	public SnakeLadderService() {
		this(SnakeLadderService.DEFAULT_BOARD_SIZE);

	}

	public SnakeAndLadderBoard getBoard() {
		return board;
	}

	public void setBoard(SnakeAndLadderBoard board) {
		this.board = board;
	}

	public int getInitialNumberOfPlayers() {
		return initialNumberOfPlayers;
	}

	public Queue<Player> getPlayers() {
		return players;
	}
	
	public void setSnakes(List<Snake> snakes)
	{
		board.setSnakes(snakes);
	}
	
	public void setLadders(List<Ladder> ladders)
	{
		board.setLadders(ladders);
	}
	
	

	public void setPlayers(List<Player> players2) {
		this.players = new LinkedList<Player>();
		this.initialNumberOfPlayers = players2.size();
		Map<String, Integer> pieces = new HashMap<String, Integer>();

		for (Player p : players2) {

			this.players.add(p);
			pieces.put(p.getId(), 0);

		}

		this.board.setPlayers(pieces);

		
	}

	public void setGameCompleted(boolean isGameCompleted) {
		this.isGameCompleted = isGameCompleted;
	}

	public int getNumOfDices() {
		return numOfDices;
	}

	public void setNumOfDices(int numOfDices) {
		this.numOfDices = numOfDices;
	}

	private int getNewPosition(int position) {
		int prevPosition;

		do {

			prevPosition = position;

			for (Snake s : board.getSnakes()) {

				if (s.getStart() == position)
					position = s.getEnd();
			}

			for (Ladder l : board.getLadders()) {
				if (l.getStart() == position)
					position = l.getEnd();

			}

		} while (position != prevPosition);
		return position;

	}

	private void movePlayer(Player p, int positions) {

		int oldPosition = board.getPlayers().get(p.getId());
		int newPosition = oldPosition + positions;
		int boardSize = board.getSize();

		if (newPosition > boardSize)
			newPosition = oldPosition;
		else {
			newPosition = getNewPosition(newPosition);
		}

		board.getPlayers().put(p.getId(), newPosition);

		System.out.println(
				p.getName() + " rolled a " + positions + " and moved from " + oldPosition + " to " + newPosition);

	}

	private boolean hasPlayerWon(Player p) {
		int playerPosition = board.getPlayers().get(p.getId());

		int winningPosition = board.getSize();

		return winningPosition == playerPosition;

	}

	private boolean isGameCompleted() {
		int currNumOfPlayers = players.size();
		return currNumOfPlayers < initialNumberOfPlayers;

	}

	public void startGame() {

		while (!isGameCompleted()) {

			int diceValue = DiceService.roll();
			Player currPlayer = players.poll();
			movePlayer(currPlayer, diceValue);

			if (hasPlayerWon(currPlayer)) {
				System.out.println(currPlayer.getName() + " has won the game");
				board.getPlayers().remove(currPlayer.getId());
			} else {
				players.add(currPlayer);

			}

		}

	}

}
