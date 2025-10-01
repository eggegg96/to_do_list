package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
    public Todo update(Long id, Todo updatedTodo) {
      Todo todo = todoRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("할 일 없음"));
  
      todo.setContent(updatedTodo.getContent());
      todo.setCompleted(updatedTodo.isCompleted());
  
      return todoRepository.save(todo);
  }
  public Todo findById(Long id) {
    return todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("해당 ID의 할 일이 없습니다."));
  }
  public Todo toggleCompleted(Long id) {
    Todo todo = todoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다: " + id));
    todo.setCompleted(!todo.isCompleted()); // true → false / false → true
    return todoRepository.save(todo);
}

}
