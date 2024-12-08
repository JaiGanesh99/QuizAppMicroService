package com.jaiganesh99.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.jaiganesh99.entity.UserAnswerEntity;
import com.jaiganesh99.entity.UserQuizEntity;
import com.jaiganesh99.service.QuizService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/quiz/api")
public class QuizController {

	// Quiz Addition
	// Quiz Deletion
	// All Quiz
	// User Taking Quiz

	@Autowired
	QuizService quizService;



	@PostMapping("/answeringQuiz")
	public  ResponseEntity<?> answeringQuestion(@RequestBody UserQuizEntity userQuizEntity) {
		try {
			System.err.println("Enter into Controller");
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(quizService.answeringQuestion(userQuizEntity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity
				.status(HttpStatus.BAD_GATEWAY)
				.header("ErrorCode", "Error Acquired")
				.build();
	}

}
