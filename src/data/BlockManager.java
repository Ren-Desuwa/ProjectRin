package data;

import models.Block;

public class BlockManager {
	private static BlockManager instance;
	
	private BlockManager() {
		
	}
	
	public static BlockManager getInstance() {
		if (instance == null) {
			instance = new BlockManager();
		}
		return instance;
	}
	
	public void addBlock(Block block) {
		// Logic to add a block to the database
	}
	
	public void removeBlock(long id) {
		// Logic to remove a block from the database
	}
	
	public Block getBlock(long id) {
		
		return null; // Placeholder return statement
	}
}
