package value;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Runner {
	
	public int i, j, id;
	public boolean[][] seen;
	public Stack<Block> route;
	public List<Block> path;
	
	public Runner(int id, Block start, int maze_row_size, int maze_col_size){
		i = start.getI();
		j = start.getJ();
		this.id = id;
		
		seen = new boolean[maze_row_size][maze_col_size];
		seen[i][j] = true;
		
		path = new LinkedList<>();
		path.add(start);
		
		route = new Stack<>();
	}
	
	public void addBlocksToRoute(List<Block> blocks){
		if (blocks.isEmpty()) return;
		
		for (Block block: blocks){
			if (!seen[block.getI()][block.getJ()])
				route.push(block);
		}
	}
	
	public void addBlockToPath(Block block){
		seen[block.getI()][block.getJ()] = true;
		path.add(block);
	}
	
	public void printPath(){
		int itemPerLine = 3;
		System.out.println("Path: ");
		for (Block block: path){
			System.out.print(" (" + ( block.getI() + 1 ) + " , " + ( block.getJ() + 1 ) + ") ");
			itemPerLine++;
			if (itemPerLine%3 == 0){
				System.out.println();
			}
		}
	}
}
