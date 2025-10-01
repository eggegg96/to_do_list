package com.example.todolist.controller;

import com.example.todolist.domain.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 전체 목록 조회
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    // 새 할 일 추가
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    // 할 일 삭제
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Todo todo = todoService.update(id, updatedTodo);
        return todo;
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
    return todoService.findById(id);
    }
    @PatchMapping("/{id}/toggle")
    public Todo toggleTodo(@PathVariable Long id) {
        return todoService.toggleCompleted(id);
    }

}
