package com.heroku.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="username",unique = true)
	private String userName;
	
	@Column(name="createTime")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime createTime;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String username, LocalDateTime createTime) {
		super();
		this.id = id;
		this.name = name;
		this.userName = username;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + userName + ", createTime=" + createTime + "]";
	}
	
	
}
