package com.sampson.applicationjsp.todo;

import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
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

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap){
        String username = (String)modelMap.get("name");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        modelMap.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String)modelMap.get("name");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1),false );
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap){
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo",todo);
        return "todo";
    }

}
