package com.quizApp.quizService.service;


import com.quizApp.quizService.DTO.QuestionDTO;
import com.quizApp.quizService.feign.QuizInterface;
import com.quizApp.quizService.model.Quiz;
import com.quizApp.quizService.model.Response;
import com.quizApp.quizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuizInterface quizInterface;

    public void createQuiz(String category, int numofQue, String title) {

       List<Integer>questions= quizInterface.getQuestionForQuiz(category,numofQue).getBody();
//        List<Questions> questions=questionRepository.findRandomQuestionByCategory(category, PageRequest.of(0,numofQue));
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepository.save(quiz);
    }

    public List<QuestionDTO> getQuizz(Integer id) {
      Optional<Quiz> quiz = quizRepository.findById(id);
//      List<Questions>questionOfQuiz=quiz.get().getQuestions();
      List<QuestionDTO>selectedQuestion = new ArrayList<>();
//      for(Questions q :questionOfQuiz){
//          QuestionDTO qdto =new QuestionDTO(q.getId(),q.getLevel(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//
//          selectedQuestion.add(qdto);
//      }
      return selectedQuestion;
    }

    public Integer validateAnswer(List<Response> response , int id) {
//        Optional<Quiz> quiz = quizRepository.findById(id);
//        List<Questions>questionOfQuiz=quiz.get().getQuestions();
int score =0;
//int i=0;
//for(Response responses:response){
//if(responses.getAnswer().equals(questionOfQuiz.get(i).getAnswer()))
//    score++;
//i++;
//}
        return  score;
    }
}
