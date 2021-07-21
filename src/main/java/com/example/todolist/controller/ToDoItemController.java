package com.example.todolist.controller;


import com.example.todolist.model.ToDoItem;
import com.example.todolist.service.ToDoItemService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoItemController {
   @Autowired
  private ToDoItemService toDoItemService;

   @GetMapping("todo-items")
    public List<ToDoItem> getAllToDoItems(){
        return toDoItemService.getAll();

    }
    @GetMapping("todo-items/{id}")
    public ToDoItem getTodoItem(@PathVariable Long id){

       return toDoItemService.getOne(id);
    }

    @PostMapping("todo-items")
    public ToDoItem createTodoItem(@RequestBody ToDoItem todoItem){

       return toDoItemService.create(todoItem);
    }

    @DeleteMapping("todo-items/{id}")
    public void deleteItem(@PathVariable Long id){
       toDoItemService.delete(id);
    }

    @PutMapping("todo-items/{id}")
    public ToDoItem updateItem(@PathVariable Long id, @RequestBody ToDoItem toDoItem){
       return toDoItemService.update(id,toDoItem);

    }
    @PutMapping("todo-items/{id}/{finish}")
    public ToDoItem complete(@PathVariable Long id, @RequestBody ToDoItem finish){
       return toDoItemService.done(id,finish);
    }

    @PutMapping("todo-items/{id}/{finish}/{dueDate}")
    public ToDoItem due(@PathVariable Long id,@RequestBody ToDoItem dueDate){
        return toDoItemService.due(id,dueDate);
    }

}
