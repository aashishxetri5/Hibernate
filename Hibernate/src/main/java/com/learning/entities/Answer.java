package com.learning.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@Column(name = "aid")
	private int aid;
	
//	@OneToOne
	@OneToOne(mappedBy = "answer")
	// Field name on other class which tells hibernate that only that field will be
	// mapping. This doesn't create additional column in answer table.
	private Question question; // Creates bidirectional mapping
	private String answer;

	public Answer() {
		super();
	}

	public Answer(int aid, String answer) {
		super();
		this.aid = aid;
		this.answer = answer;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", answer=" + answer + "]";
	}

}
