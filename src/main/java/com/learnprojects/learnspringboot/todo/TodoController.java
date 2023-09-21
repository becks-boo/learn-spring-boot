package com.learnprojects.learnspringboot.todo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public  List<Todo> listAllTodos() {
        List<Todo> todoList = todoService.findByUsername("in28minutes");
        return todoList;
    }
}
