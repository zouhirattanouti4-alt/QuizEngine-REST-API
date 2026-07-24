package com.zouhir.quizapp.repositories;

import com.zouhir.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findQuestionByCategory(String category);
    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :noOfQst", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("category") String category,@Param("noOfQst") int noOfQst);
}
