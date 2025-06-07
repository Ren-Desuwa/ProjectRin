package main.java.app.services;
import main.java.app.db.BlockRepository;

public class BlockService {
	
	private BlockRepository blockRepository;
	
	public BlockService(BlockRepository blockRepository) {
		this.blockRepository = blockRepository;
	}
}
