package level1;


import value.Block;
import value.Maze;
import value.Runner;

/**
 * Level I game
 * @author jenniferlikess
 *
 */
public class Game {
	Maze maze;
	Runner runner;
	
	/**
	 * Game constructor
	 * @param mazeRowSize
	 * @param mazeColSize
	 * @param startI
	 * @param startJ
	 */
	public Game(int mazeRowSize, int mazeColSize){
		maze = new Maze(mazeRowSize, mazeColSize);
		runner = new Runner(1, maze.entrance, mazeRowSize, mazeColSize);
		
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
		
		runner.addBlocksToRoute(maze.getNeighbourRooms(runner.i, runner.j));
		
		Block current= null;
		int i, j;
		
		while(!runner.route.isEmpty()){
			current = runner.route.pop();
			i = current.getI();
			j = current.getJ();
			runner.addBlockToPath(current);
			if (maze.isOnEdge(i, j)){
				System.out.println("You got out, nice!");
				runner.printPath();
				return;
			}
			runner.addBlocksToRoute(maze.getNeighbourRooms(i, j));
		}
		
		System.out.println("You didn't make it, sorry.");
		runner.printPath();
		
	}
	
	public static void main(String[] args) {
		
		Game game = new Game(8, 8);
		game.start();
		
	}

}
