package com.quizApp.quizService.feign;

import com.quizApp.quizService.DTO.QuestionDTO;
import com.quizApp.quizService.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {

    @GetMapping("question/generte")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numofQue);

    @PostMapping("question/getQuestion")
    public ResponseEntity<List<QuestionDTO>> getQuestionFromId(@RequestBody List<Integer>id);

    @PostMapping("question/score")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> responses);
}
