package value;

/**
 * Entity represents the block in maze
 * @author jennielikess
 *
 */
public class Block {
	private int i;
	private int j;
	private final BlockType type;
	
	public Block(int i, int j, BlockType type){
		this.setI(i);
		this.setJ(j);
		this.type = type;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public BlockType getType() {
		return type;
	}
	
}
