package com.sampson.applicationjsp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap){
        List<Todo> todos = todoService.findByUsername("flavio");
        modelMap.addAttribute("todos",todos);
        return "listTodos";
    }
}
