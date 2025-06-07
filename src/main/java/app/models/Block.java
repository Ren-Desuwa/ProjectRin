package main.java.app.models;

public class Block {
	protected long block_id;
	protected String type; // Note, Image, etc.
	protected Long parent_page_id; // Page ID if this block is part of a page
	protected long order_index; // Order index in the page
	protected Long previous_id;
	protected Long next_id;
	
    public Block(long block_id, String type, Long parent_page_id, long order_index, Long previous_id, Long next_id) {
        this.block_id = block_id;
        this.type = type;
        this.parent_page_id = parent_page_id;
        this.order_index = order_index;
        this.previous_id = previous_id;
        this.next_id = next_id;
    }
	
	public void setblockId(long block_id) {				this.block_id = 		block_id;		}
	public void setType(String type) { 					this.type = 			type;			}
	public void setParentPageId(long parent_page_id) { 	this.parent_page_id = 	parent_page_id;	}
	public void setNextId(long next_id) { 				this.next_id = 			next_id;		}
	public void setNextIdNull() { 						this.next_id = 			null;			}
	public void setPreviousId(long previous_id) { 		this.previous_id = 		previous_id;	}
	public void setPreviousIdNull() {					this.previous_id = 		null;			}
	public void setOrderIndex(long order_index) {		this.order_index = 		order_index;	}
	public long getblockId() {							return 					block_id;		}
	public String getType() {							return 					type;			}
	public Long getParentPageId() {						return 					parent_page_id;	}
	public long getOrderIndex() {						return 					order_index;	}
	public Long getNextId() {							return 					next_id;		}
	public Long getPreviousId() {						return 					previous_id;	}
}
