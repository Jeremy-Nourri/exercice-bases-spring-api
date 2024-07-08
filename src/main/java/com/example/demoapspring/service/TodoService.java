package com.example.demoapspring.service;

import com.example.demoapspring.model.Todo;
import com.example.demoapspring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    public boolean delete(int id) {
        try {
            todoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Todo get(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> getAll() {
        return (List<Todo>) todoRepository.findAll();
    }


}
