package com.learnprojects.learnspringboot.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todoList.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isItDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, true);

        todoList.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todoList.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todoList.stream().filter(predicate).findFirst().get();

        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todoList.add(todo);
    }
}
