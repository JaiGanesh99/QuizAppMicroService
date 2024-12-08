package com.jaiganesh99.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaiganesh99.entity.QuestionEntity;
import com.jaiganesh99.entity.UserAnswerEntity;
import com.jaiganesh99.entity.UserQuizEntity;
import com.jaiganesh99.repository.QuestionRepository;
import com.jaiganesh99.repository.UserAnswerRepository;
import com.jaiganesh99.repository.UserQuizRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	UserAnswerRepository userAnsRepo;

	@Autowired
	UserQuizRepository userQuizRepo;

	public List<QuestionEntity> getAllQuiz() {
		return questionRepository.findAll();
	}

	public Map<String, Object> addQuestions(String Category, QuestionEntity questionEntity) {
		Map<String, Object> responseMap =  new HashMap<>();
		try {
			System.err.println(questionEntity);
			questionEntity.setCategory(Category);
			questionRepository.save(questionEntity);
			responseMap.put("Status", HttpStatus.OK);
			responseMap.put("Message", "Data Inserted Successfully");
			return responseMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int answeringQuestion(UserQuizEntity userQuizEntity) {
		int markScored=0;
		String[] userAnswers =  userQuizEntity.getUsersQuestions().split(",");
		List<QuestionEntity> quizList = questionRepository.findAll();

		for(int i=0;i<userAnswers.length;i++) {
			if(quizList.get(i).getCorrectAnswer().equals(userAnswers[i])) {
				markScored++;
			}
		}

		return markScored;
	}

	public Map<String, Object> createCategory(List<QuestionEntity> questionEntity) {

		Map<String, Object> responseMap =  new HashMap<>();
		try {
			for(QuestionEntity entity : questionEntity) {
				questionRepository.save(entity);
			}
			responseMap.put("Status", HttpStatus.OK);
			responseMap.put("Message", "Data Inserted Successfully");
			return responseMap;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		responseMap.put("Status", HttpStatus.BAD_REQUEST);
		return responseMap;
	}

	public Object setQuestions(UserQuizEntity userQuizEntity) {
		Map<String, Object> responseMap =  new HashMap<>();
		try {
			userQuizRepo.save(userQuizEntity);
			responseMap.put("Status", HttpStatus.OK);
			responseMap.put("Message", "Questions Organized  Successfully");
			return responseMap;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		responseMap.put("Status", HttpStatus.BAD_REQUEST);
		return responseMap;
	}
}
