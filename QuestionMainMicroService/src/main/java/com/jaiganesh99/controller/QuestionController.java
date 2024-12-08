package com.jaiganesh99.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import com.jaiganesh99.entity.QuestionEntity;
import com.jaiganesh99.entity.UserAnswerEntity;
import com.jaiganesh99.entity.UserQuizEntity;
import com.jaiganesh99.service.QuestionService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/question/api")
public class QuestionController {

	// Quiz Addition
	// Quiz Deletion
	// All Quiz
	// User Taking Quiz

	@Autowired
	QuestionService questionService;
	
	@Autowired
	Environment environment;

	@GetMapping("/getQuiz")
	public ResponseEntity<List<?>> getAllQuiz() {
		try {
			return new ResponseEntity<List<?>>(questionService.getAllQuiz(), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<?>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/addQuestion/{category}")
	public ResponseEntity<?> addQuestions(@PathVariable String category, @RequestBody QuestionEntity questionEntity) {
		HttpHeaders headers = new HttpHeaders();
		try {
			return ResponseEntity.status(HttpStatus.OK).headers(headers)
					.body(questionService.addQuestions(category, questionEntity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).header("ErrorCode", "Error Acquired").body(null);
	}

	@PostMapping("/createCategory")
	public ResponseEntity<?> createCategory(@RequestBody List<QuestionEntity> questionEntity) {
		HttpHeaders headers = new HttpHeaders();
		try {
			return new ResponseEntity<>(questionService.createCategory(questionEntity), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/setQuestions")
	public ResponseEntity<?> setQuestions(@RequestBody UserQuizEntity userQuizEntity) {
		try {
			return new ResponseEntity<>(questionService.setQuestions(userQuizEntity), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/answeringQuiz")
	public ResponseEntity<?> answeringQuestion(@RequestBody UserQuizEntity userQuizEntity) {
		try {
			System.err.println("Server Port Number -->"+environment.getProperty("local.server.port"));
			return ResponseEntity.status(HttpStatus.OK).body(questionService.answeringQuestion(userQuizEntity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).header("ErrorCode", "Error Acquired").build();
	}

}
