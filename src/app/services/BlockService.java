package app.services;
import app.db.BlockRepository;

public class BlockService {
	
	private BlockRepository blockRepository;
	
	public BlockService(BlockRepository blockRepository) {
		this.blockRepository = blockRepository;
	}
}
