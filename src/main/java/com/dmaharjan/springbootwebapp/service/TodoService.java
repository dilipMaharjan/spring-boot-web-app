package com.dmaharjan.springbootwebapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.dmaharjan.springbootwebapp.model.Todo;

@Service
public class TodoService
{
    private static List<Todo> todos = new ArrayList<Todo>();

    private static int todoCount = 3;
    static {
        todos.add(new Todo(1, "dilip", "Write a service for user1", LocalDate.of(2020, 03, 20), false));
        todos.add(new Todo(2, "crazdrms", "Write a service for user2", LocalDate.of(2020, 03, 21), true));
        todos.add(new Todo(3, "internetwizard", "Write a service for user3", LocalDate.of(2020, 03, 22), false));
    }

    public List<Todo> getAllTodos()
    {
        return todos;
    }

    public void addTodo(Todo todo)
    {
        todos.add(todo);
    }

    public Optional<Todo> retrieveTodo(String user)
    {
        return todos.stream().filter(todo -> todo.getUser().equalsIgnoreCase(user)).findFirst();
    }

    public Optional<Todo> retrieveTodo(int id)
    {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    public void deleteTodo(int id)
    {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public void updateTodo(Todo todo)
    {
        todos.removeIf(t -> t.getId() == todo.getId());
        todos.add(todo);

    }
}
