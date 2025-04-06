package com.quizApp.quizService.controller;


import com.quizApp.quizService.DTO.QuestionDTO;
import com.quizApp.quizService.DTO.QuizDto;
import com.quizApp.quizService.model.Response;
import com.quizApp.quizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        quizService.createQuiz(quizDto.getCategory(),quizDto.getNumofQue(),quizDto.getTitle());
        return new ResponseEntity<>("Created Quiz", HttpStatus.CREATED);
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuiz(@PathVariable Integer id){
 List<QuestionDTO>questions =quizService.getQuizz(id);
        return  new ResponseEntity<>(questions,HttpStatus.OK);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> validateAnswer(@RequestBody List<Response> response, @PathVariable int id){
       Integer score= quizService.validateAnswer(response,id);
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
