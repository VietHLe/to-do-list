package com.example.todolist.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated value to ID
    private Long id; // id increment by generated value

    private String toDo;

    @Temporal(TemporalType.DATE)
    private Date date = new Date(System.currentTimeMillis());

    private String dueDate = "Empty";

    private boolean finish = false;

}
