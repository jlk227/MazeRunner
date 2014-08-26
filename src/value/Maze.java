package value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Entity represents the maze
 * @author jenniferlikess
 *
 */
public class Maze {

	public Block[][] blocks;
	public Block entrance;
	
	private final int ROW_SIZE;
	private final int COL_SIZE;
	private final int[][] neighbors = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
	private static final Random rand = new Random();

	/** member getter method **/
	public int getRowSize() {
		return ROW_SIZE;
	}
	/** member getter method **/
	public int getColSize() {
		return COL_SIZE;
	}
	
	/** Constructor **/
	public Maze(int row_size, int col_size){
		this.ROW_SIZE = row_size;
		this.COL_SIZE = col_size;
		build();
	}
	
	/**
	 * Get currect Block by index i and j
	 * @param i
	 * @param j
	 * @return block
	 */
	public Block getBlock(int i, int j){
		return blocks[i][j];
	}
	
	/**
	 * Check if current index i and j maps to a room
	 * @param i
	 * @param j
	 * @return true or false
	 */
	public boolean isRoom(int i, int j){
		return BlockType.Room == blocks[i][j].getType();
	}
	
	/**
	 * Check if current index i and j maps to a wall
	 * @param i
	 * @param j
	 * @return true or false
	 */
	public boolean isWall(int i, int j){
		return BlockType.Wall == blocks[i][j].getType();
	}
	
	/**
	 * Check if current index i and j maps to edge
	 * @param i
	 * @param j
	 * @return true or false
	 */
	public boolean isOnEdge(int i, int j){
		return (j == COL_SIZE -1) || (j == 0) || (i == 0) || (i == ROW_SIZE-1);
	}
	
	/**
	 * Check if current index i and j maps to edge
	 * @param i
	 * @param j
	 * @return true or false
	 */
	public boolean isOutside(int i, int j){
		return (j >= COL_SIZE) || (j < 0) || (i < 0) || (i >= ROW_SIZE);
	}
	
	/**
	 * Print out Maze
	 */
	public void print(){
		for (int i = 0; i< ROW_SIZE; i++){
			for (int j = 0; j< COL_SIZE; j++){
				if (BlockType.Wall == blocks[i][j].getType()){
					System.out.print("W");
				}else {
					System.out.print("R");
				}
			}
			System.out.println();
		}
	}
	/**
	 * Get a list of neighbour rooms for position(i, j)
	 * @param i
	 * @param j
	 * @return 
	 */
	public List<Block> getNeighbourRooms(int i, int j){
		List<Block> rooms = new ArrayList<>();
		int moveToI, moveToJ;
		for (int pace = 0; pace< neighbors.length; pace++){
			moveToI = i+neighbors[pace][0];
			moveToJ = j+neighbors[pace][1];
			if (!isOutside(moveToI, moveToJ)){
				if (isRoom(moveToI, moveToJ)){
					rooms.add(getBlock(moveToI, moveToJ));
				}
			}
		}
		return rooms;
	}
	
	//Helper build the maze 
	private void build(){
		blocks = new Block[ROW_SIZE][COL_SIZE];
		int randomI = rand.nextInt(COL_SIZE-1);
		int randomII = rand.nextInt(ROW_SIZE-1);
		blocks[randomI][0] = new Block(randomI, 0, BlockType.Room); // set up a room on the left edge
		blocks[randomII][COL_SIZE-1] = new Block(randomII, 0, BlockType.Room);// set up a room on the right edge
		entrance = blocks[randomI][0];
	
		for (int i = 0; i<ROW_SIZE; i++){
			for (int j = 0; j<COL_SIZE; j++){
				if(blocks[i][j] == null){
					if(isOnEdge(i, j)) {
						blocks[i][j] = new Block(i, j, BlockType.Wall);
					}else {
						blocks[i][j] = new Block(i, j, BlockType.random());
					}
				}
			}
		}
	}

}
