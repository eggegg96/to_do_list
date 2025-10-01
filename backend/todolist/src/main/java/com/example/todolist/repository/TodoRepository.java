package com.example.todolist.repository;

import com.example.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // 기본적인 CRUD 메서드는 자동 제공됨
}
