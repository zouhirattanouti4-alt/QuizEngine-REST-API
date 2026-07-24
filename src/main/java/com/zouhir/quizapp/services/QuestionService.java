package com.zouhir.quizapp.services;

import com.zouhir.quizapp.models.Question;
import com.zouhir.quizapp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findQuestionByCategory(category);
    }

    public List<Question> getRandomQuestions(String category, int noOfQst) {
        return questionRepository.findRandomQuestions(category,noOfQst);
    }
}
