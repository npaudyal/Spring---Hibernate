package com.paudyal.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	//define fields
	
	
	//define constructors
	
	
	//setters/getters
	
	
	//toString
	
	
	
	//annotate
	
	@Column(name="comment")
	private String comment;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	public Review() {
		
	}

	public Review(String comment) {
		
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Review [comment=" + comment + ", id=" + id + "]";
	}
	
	
	
	

}
