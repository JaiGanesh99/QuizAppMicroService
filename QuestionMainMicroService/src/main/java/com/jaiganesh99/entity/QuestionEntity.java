package com.jaiganesh99.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "question_table", schema = "world")
public class QuestionEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int quizId;
		
	@Column(name = "question")
	private String question;
	
	@Column(name = "option_a")
	private String optionA;
	
	@Column(name = "option_b")
	private String optionB;
	
	@Column(name = "option_c")
	private String optionC;
	
	@Column(name = "option_d")
	private String optionD;
	
	@Column(name = "correct_answer")
	private String correctAnswer;
	
	@Column(name = "category")
	private String category;
	
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "QuizEntity [quizId=" + quizId + ", question=" + question + ", optionA=" + optionA + ", optionB="
				+ optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", correctAnswer=" + correctAnswer
				+ ", category=" + category + "]";
	}
	
	
	
	
	
	

}
