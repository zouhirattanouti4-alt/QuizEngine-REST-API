package com.zouhir.quizapp.repositories;

import com.zouhir.quizapp.models.Question;
import com.zouhir.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
