package level1;

import value.Maze;
import value.Runner;

/**
 * Level I game, 
 * Set up MAZE_ROW_SIZE, MAZE_COL_SIZE, and runner name
 * Program randomly generates maze and place runner at the entrance 
 * Program runs the runner.
 * @author jenniferlikess
 *
 */
public class Game {
	static int MAZE_ROW_SIZE = 8;
	static int MAZE_COL_SIZE = 8;
	static String name = "Jennie Li";
	Maze maze;
	Runner runner;
	
	/**
	 * Game constructor
	 * @param mazeRowSize
	 * @param mazeColSize
	 */
	public Game(int mazeRowSize, int mazeColSize){
		maze = new Maze(mazeRowSize, mazeColSize);
		runner = new Runner(name, maze.entrance, mazeRowSize, mazeColSize);
		
		System.out.println("Maze - W: wall, R: room ");
		
		maze.print();
		
		System.out.println("Runner starts at (" + (runner.i + 1) + " , " + (runner.j + 1)+")");
	}
	
	/**
	 * Start gaming
	 */
	public void start(){
		
		if (maze.isWall(runner.i, runner.j)){
			System.out.println("The runner cannot start on the wall");
			return;
		}
		
		runner.runs(maze);
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(MAZE_ROW_SIZE, MAZE_COL_SIZE);
		game.start();
	}

}
