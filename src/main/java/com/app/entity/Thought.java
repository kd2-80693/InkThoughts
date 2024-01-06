package com.app.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "thoughts")

public class Thought extends BaseEntity {
	private String title;
	@Lob
	private String content;
	private LocalDateTime timestamp;
	public Thought() {
		super();
	}
	public Thought(String title, String content, LocalDateTime timestamp) {
		super();
		this.title = title;
		this.content = content;
		this.timestamp = timestamp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
