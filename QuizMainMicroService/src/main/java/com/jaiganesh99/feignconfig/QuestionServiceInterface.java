package com.jaiganesh99.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jaiganesh99.entity.UserQuizEntity;

@FeignClient("QuestionMainMicroService")
public interface QuestionServiceInterface {
	
	@PostMapping("/quiz/api/answeringQuiz")
	public int answeringQuestion(@RequestBody UserQuizEntity userQuizEntity);

}
