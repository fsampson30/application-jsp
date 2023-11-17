package com.sampson.applicationjsp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount,"flavio","learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"flavio","learn Devops", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"flavio","learn Kafka", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"flavio","learn Jenkins", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);


    }
}
