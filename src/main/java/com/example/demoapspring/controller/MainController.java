package com.example.demoapspring.controller;

import com.example.demoapspring.dto.TodoDtoGet;
import com.example.demoapspring.dto.TodoDtoPost;
import com.example.demoapspring.model.Todo;
import com.example.demoapspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todo")
public class MainController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<TodoDtoGet>> getAllTodos() {

        List<Todo> todos = todoService.getAll();

        List<TodoDtoGet> todoDtoGets = todos.stream()
                .map(todo ->
                        TodoDtoGet.builder()
                                .id(todo.getId())
                                .title(todo.getTitle())
                                .description(todo.getDescription())
                                .date(todo.getDate())
                                .isValidate(todo.isValidate())
                                .build()
                )
                .collect(Collectors.toList());

        return new ResponseEntity<>(todoDtoGets, HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<TodoDtoGet> getTodoById(@PathVariable("id") int id) {
        Todo todoFound = todoService.get(id);
        TodoDtoGet todoDtoGet = new TodoDtoGet(todoFound.getId(), todoFound.getTitle(), todoFound.getDescription(), todoFound.getDate(), todoFound.isValidate());
        return new ResponseEntity<>(todoDtoGet, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<TodoDtoGet> addTodo(@RequestBody TodoDtoPost todoDtoPost) {
        Todo todo = Todo.builder()
                .title(todoDtoPost.getTitle())
                .description(todoDtoPost.getDescription())
                .date(LocalDate.now())
                .isValidate(false)
                .build();

        Todo todoCreated = todoService.create(todo);

        TodoDtoGet todoDtoGet = new TodoDtoGet(todoCreated.getId(), todoCreated.getTitle(), todoCreated.getDescription(), todoCreated.getDate(), todoCreated.isValidate());

        return new ResponseEntity<>(todoDtoGet, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<TodoDtoGet> updateTodo (@RequestBody TodoDtoPost todoDtoPost) {
        Todo todo = Todo.builder()
                .title(todoDtoPost.getTitle())
                .description(todoDtoPost.getDescription())
                .date(LocalDate.now())
                .isValidate(false)
                .build();

        Todo todoUpdated = todoService.update(todo);

        TodoDtoGet todoDtoGet = new TodoDtoGet(todoUpdated.getId(), todoUpdated.getTitle(), todoUpdated.getDescription(), todoUpdated.getDate(), todoUpdated.isValidate());

        return new ResponseEntity<>(todoDtoGet, HttpStatus.CREATED);
    }

}
