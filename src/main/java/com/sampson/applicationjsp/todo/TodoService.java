package com.sampson.applicationjsp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1,"flavio","learn AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"flavio","learn Devops", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(3,"flavio","learn Kafka", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(4,"flavio","learn Jenkins", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}
