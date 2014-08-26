package value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum BlockType {
	Room, Wall;
	
	private static final List<BlockType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	  public static BlockType random()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	  }
}
