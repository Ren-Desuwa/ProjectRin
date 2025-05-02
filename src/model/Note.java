package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Note {
	private LocalDate date;
	private LocalDateTime time;
	private String title;
	private String note;
	
	public Note(String title,String note) {
		this.time = LocalDateTime.now();
		this.date = LocalDate.now();
		this.title = title;
		this.note = note;
	}
	public LocalDate getDate() {return date;}
	public LocalDateTime getTime() {return time;}
	public String getTitle() {return title;}
	public String getNote() {return note;}
	
	public void setDate(LocalDate date) {this.date = date;}
	public void setTime(LocalDateTime time) {this.time = time;}
	public void setTitle(String title) {this.title = title;}
	public void setNote(String note) {this.note = note;}
}
