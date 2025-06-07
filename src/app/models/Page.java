package app.models;

import java.util.List;

public class Page extends Block {
	private long page_id;
	private String title;
	private List<Block> content;
	
    // Constructor for new pages (not yet saved in DB)
    public Page(String title, List<Block> content, long block_id, Long parent_page_id, long order_index, Long previous_id, Long next_id) {
        super(block_id, "Page", parent_page_id, order_index, previous_id, next_id);
        this.title = title;
        this.content = content;
    }

    // Constructor for pages retrieved from the DB (with real page_id)
    public Page(long page_id, String title, List<Block> content, long block_id, Long parent_page_id, long order_index, Long previous_id, Long next_id) {
        super(block_id, "Page", parent_page_id, order_index, previous_id, next_id);
        this.page_id = page_id;
        this.title = title;
        this.content = content;
    }
	
	public long getPageId() {
		return this.page_id;
	}
	
	public void setPageId(long page_id) {
		this.page_id = page_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Block> getContent() {
		return content; 
	}
	
	public void setContent(List<Block> content) {
		this.content = content;
	}
}
