package com.jaiganesh99.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaiganesh99.entity.UserAnswerEntity;
import com.jaiganesh99.entity.UserQuizEntity;
import com.jaiganesh99.feignconfig.QuestionServiceInterface;
import com.jaiganesh99.repository.UserAnswerRepository;
import com.jaiganesh99.repository.UserQuizRepository;

@Service
public class QuizService {



	@Autowired
	UserQuizRepository repo;
	
	@Autowired
	QuestionServiceInterface questionServiceInterface;


	public int answeringQuestion(UserQuizEntity userQuizEntity) {
//		int markScored=0;
//		System.err.println(userAnswerEntity);
//		String[] userAnswers =  userAnswerEntity.getSelectedAnswer().split(",");
//
//		List<QuestionEntity> quizList = questionRepository.findAll();
//		quizList.stream().map(value->value.getCorrectAnswer()).forEach(System.err::print);
//		System.err.println();
//		Arrays.stream(userAnswers).forEach(System.out::print);
//
//		for(int i=0;i<quizList.size();i++) {
//			if(quizList.get(i).getCorrectAnswer().equals(userAnswers[i])) {
//				System.err.println(quizList.get(i).getCorrectAnswer()+" == "+userAnswers[i]);
//				markScored++;
//			}
//
//		}
//
//
//		System.out.println("  ->"+markScored);

		System.err.println("Enter into Controller "+ questionServiceInterface.answeringQuestion(userQuizEntity));
		int abc = questionServiceInterface.answeringQuestion(userQuizEntity);
		
		return abc;
	}

//	public Map<String, Object> createCategory(List<QuestionEntity> questionEntity) {
//
//		Map<String, Object> responseMap =  new HashMap<>();
//		try {
//			for(QuestionEntity entity : questionEntity) {
//				questionRepository.save(entity);
//			}
//			responseMap.put("Status", HttpStatus.OK);
//			responseMap.put("Message", "Data Inserted Successfully");
//			return responseMap;
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		responseMap.put("Status", HttpStatus.BAD_REQUEST);
//		return responseMap;
//	}
}
