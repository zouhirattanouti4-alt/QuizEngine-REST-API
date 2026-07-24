package com.zouhir.quizapp.services;

import com.zouhir.quizapp.models.Question;
import com.zouhir.quizapp.models.QuestionWrapper;
import com.zouhir.quizapp.models.Quiz;
import com.zouhir.quizapp.models.Response;
import com.zouhir.quizapp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionService questionService;
    @Autowired
    public QuizService(QuizRepository quizRepository, QuestionService questionService){
        this.quizRepository = quizRepository;
        this.questionService = questionService;

    }

    public void createQuiz(String category, int noOfQst, String title){
        Quiz quiz = new Quiz();
        List<Question> questions = questionService.getRandomQuestions(category,noOfQst);
        System.out.println("No qsts : -------!!!"+questions.size());

        quiz.setTitle(title);
        quiz.setCategory(category);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuizQuestions(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questions = new ArrayList<>();
        if(quiz.isPresent()){
            questions = quiz.get().getQuestions();
        }
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        for(Question q : questions){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionWrappers.add(qw);
        }
        return questionWrappers;
    }

    public int calculateScore(Long id, List<Response> responses) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questions = new ArrayList<>();
        if(quiz.isPresent()){
            questions = quiz.get().getQuestions();
        }
        int score = 0;
        int iter = 0;
        for (Response response : responses) {
            if(response.getResponse().equals(questions.get(iter).getRightAnswer())){
                score++;
            }
            iter++;
        }
        return score;
    }
}
