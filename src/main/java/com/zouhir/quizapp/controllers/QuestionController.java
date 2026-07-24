package com.zouhir.quizapp.controllers;


import com.zouhir.quizapp.models.Question;
import com.zouhir.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionSevice){
        this.questionService = questionSevice;
    }
    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> response = questionService.getAllQuestions();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        List<Question> response = questionService.getQuestionsByCategory(category);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return new ResponseEntity<>("Success !", HttpStatus.CREATED);
    }
}
