package com.jaiganesh99.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UserQuizEntity")
public class UserQuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for TestId
    private int testId;

    @Column(name = "UserName", nullable = false, length = 255)
    private String userName;

    @Column(name = "UsersQuestions", nullable = false, columnDefinition = "TEXT")
    private String usersQuestions;

    @Column(name = "UsersActualAnswers", nullable = false, columnDefinition = "TEXT")
    private String usersActualAnswers;

    @Column(name = "MarksScored", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int marksScored;

    @Column(name = "Category", nullable = false, length = 100)
    private String category;

    // Getters and Setters
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsersQuestions() {
        return usersQuestions;
    }

    public void setUsersQuestions(String usersQuestions) {
        this.usersQuestions = usersQuestions;
    }

    public String getUsersActualAnswers() {
        return usersActualAnswers;
    }

    public void setUsersActualAnswers(String usersActualAnswers) {
        this.usersActualAnswers = usersActualAnswers;
    }

    public int getMarksScored() {
        return marksScored;
    }

    public void setMarksScored(int marksScored) {
        this.marksScored = marksScored;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "UserQuizEntity{" +
                "testId=" + testId +
                ", userName='" + userName + '\'' +
                ", usersQuestions='" + usersQuestions + '\'' +
                ", usersActualAnswers='" + usersActualAnswers + '\'' +
                ", marksScored=" + marksScored +
                ", category='" + category + '\'' +
                '}';
    }
}

