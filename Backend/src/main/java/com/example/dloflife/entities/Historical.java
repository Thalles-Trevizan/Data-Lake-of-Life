package com.example.dloflife.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_historical")
public class Historical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant date;
	private Long userId;
	private String nameTopic;
	private Integer pointsTopic;
	private Boolean done;
	private Long categoryId;

	public Historical() {
		super();
	}

	public Historical(Instant date, Long userId, String nameTopic, Integer pointsTopic, Boolean done, Long categoryId) {
		super();
		this.date = date;
		this.userId = userId;
		this.nameTopic = nameTopic;
		this.pointsTopic = pointsTopic;
		this.done = done;
		this.categoryId = categoryId;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNameTopic() {
		return nameTopic;
	}

	public void setNameTopic(String nameTopic) {
		this.nameTopic = nameTopic;
	}

	public Integer getPointsTopic() {
		return pointsTopic;
	}

	public void setPointsTopic(Integer pointsTopic) {
		this.pointsTopic = pointsTopic;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
