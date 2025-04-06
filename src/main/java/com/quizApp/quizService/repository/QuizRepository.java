package com.quizApp.quizService.repository;

import com.quizApp.quizService.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}
