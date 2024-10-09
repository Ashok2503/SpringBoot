package com.learning.todo.repo;

import com.learning.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo  extends JpaRepository<Task, String> {



    @Query("SELECT t FROM Task t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%',:name, '%'))")
    List<Task> findByName(@Param("name") String name);
}


