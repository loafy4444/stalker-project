package com.cooksys.stalker.ws.message.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cooksys.stalker.ws.user.entity.User;

@Entity
@Table
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false)
	private User user;
	
	@Column(name="created_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(nullable=false)
	private String content;
	
	@PrePersist
	protected void onCreate() {
	    createdAt = new Date();
	}
	
	public Message() {}
	
	public Message(User user, Date createdAt, String content) {
		this.user = user;
		this.createdAt = createdAt;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
