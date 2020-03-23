package com.dmaharjan.springbootwebapp.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dmaharjan.springbootwebapp.model.Todo;
import com.dmaharjan.springbootwebapp.service.TodoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes("username")
public class TodoController
{
    TodoService todoService;

    @GetMapping("todo-list")
    public String manageTodosPage(ModelMap model)
    {
        model.put("username", getUsername(model));
        model.put("todos", todoService.getAllTodos());

        return "todo-list";
    }

   

    private String getUsername(ModelMap model)
    {
        return (String) model.get("username");
    }

    @GetMapping("add-todo")
    public String showTodo(ModelMap model)
    {
        model.put("todo", new Todo(0, getUsername(model), "", LocalDate.now(), false));
        return "add-todo";
    }

    @PostMapping("add-todo")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if (result.hasErrors()) {
            return "add-todo";
        }
        todoService.addTodo(new Todo(todoService.getAllTodos().size() + 1, getUsername(model), todo.getDescription(),
            todo.getTargetDate(), false));
        return "redirect:todo-list";
    }

    @GetMapping("update-todo")
    public String showUpdateTodo(ModelMap model, Todo todo)
    {
        model.put("todo", todoService.retrieveTodo(todo.getId()).get());
        return "add-todo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if (result.hasErrors()) {
            return "add-todo";
        }
        todo.setUser(getUsername(model));
        todoService.updateTodo(todo);
        return "redirect:todo-list";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:todo-list";
    }
}
