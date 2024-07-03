package edu.com.les19_java_hw_notebook.entity;

import java.util.Date;
import java.util.Objects;

public class Note {

	private String content;
	private Date creationDate;
	
	public Note() {
		
	}
	
	public Note(String content) {
		this.content = content;
		this.creationDate = new Date();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, creationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(content, other.content) && Objects.equals(creationDate, other.creationDate);
	}

	@Override
	public String toString() {
		return "Note [content = " + content + ", creationDate = " + creationDate + "]";
	}

}
