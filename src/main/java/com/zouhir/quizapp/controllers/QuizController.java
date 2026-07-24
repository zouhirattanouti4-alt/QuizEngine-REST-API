package com.zouhir.quizapp.controllers;

import com.zouhir.quizapp.models.Question;
import com.zouhir.quizapp.models.QuestionWrapper;
import com.zouhir.quizapp.models.Quiz;
import com.zouhir.quizapp.models.Response;
import com.zouhir.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQst, @RequestParam String title){
        quizService.createQuiz(category,noOfQst,title);
        return new ResponseEntity<>("Created Successefully !", HttpStatus.CREATED);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Long id){
        List<QuestionWrapper> questionsWrapper = quizService.getQuizQuestions(id);
        return new ResponseEntity<>(questionsWrapper,HttpStatus.OK);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){
        int score = quizService.calculateScore(id,responses);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
