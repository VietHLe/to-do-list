package com.example.todolist.service;

import com.example.todolist.model.ToDoItem;
import com.example.todolist.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PreDestroy;
import javax.persistence.PrePersist;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;
    private ToDoItem toDoItem;

    public List<ToDoItem> getAll(){
       return toDoItemRepository.findAll();
    }
    public ToDoItem getOne(Long id){
        return toDoItemRepository.findById(id).orElse(null);
    }
    public ToDoItem create(ToDoItem toDoItem){
        return toDoItemRepository.save(toDoItem);
    }
    public void delete(Long id){
        toDoItemRepository.deleteById(id);
    }
    public ToDoItem update(Long id,ToDoItem newToDoItem){

        //update string
        ToDoItem oldToDoItem = toDoItemRepository.findById(id).orElse(null);
        String newTodoString = newToDoItem.getToDo();
        oldToDoItem.setToDo(newTodoString);

        return toDoItemRepository.save(oldToDoItem);

    }
    public ToDoItem done(Long id,ToDoItem finish){
        //update whether its completed
        ToDoItem nonComplete = toDoItemRepository.findById(id).orElse(null);
        nonComplete.setFinish(true);
        return toDoItemRepository.save(nonComplete);
    }
    public ToDoItem due(Long id, ToDoItem newDate){

        ToDoItem stringNewDate = toDoItemRepository.findById(id).orElse(null);
        String newDateString = newDate.getDueDate();
        stringNewDate.setDueDate(newDateString);
        return toDoItemRepository.save(stringNewDate);
    }


}
