package app.models;

public class Note extends Block {
	private long note_id;
	private String content;
	
	// Constructor when only block_id and page_id are known (e.g. when creating a new note)
    public Note(long block_id, Long page_id, long order_index, Long previous_id, Long next_id) {
        super(block_id, "Note", page_id, order_index, previous_id, next_id);
        this.content = "";
    }

    // Constructor when everything is known (e.g. from database)
    public Note(long note_id, long block_id, Long page_id, long order_index, Long previous_id, Long next_id, String content) {
        super(block_id, "Note", page_id, order_index, previous_id, next_id);
        this.note_id = note_id;
        this.content = content;
    }
	
	public long getNoteId() {
		return note_id;
	}
	
	public void setNoteId(long note_id) {
		this.note_id = note_id;
	}
	
	public String getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
