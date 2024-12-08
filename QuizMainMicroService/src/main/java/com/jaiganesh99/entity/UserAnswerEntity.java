package com.jaiganesh99.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "useranswer")
public class UserAnswerEntity {
	
	@Id
	private int userId;
	private String userName;
	private String selectedAnswer;
	private String markScored;
	private String category;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	public String getMarkScored() {
		return markScored;
	}
	public void setMarkScored(String markScored) {
		this.markScored = markScored;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "UserAnswerEntity [userId=" + userId + ", userName=" + userName + ", selectedAnswer=" + selectedAnswer
				+ ", markScored=" + markScored + ", category=" + category + "]";
	}
	
	
	
	

}
