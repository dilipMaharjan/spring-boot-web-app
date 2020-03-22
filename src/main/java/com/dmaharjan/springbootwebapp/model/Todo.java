package com.dmaharjan.springbootwebapp.model;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo
{
    private int id;

    private String user;

    @Size(min = 5, message = "Please enter atleast 5 character.")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;

    private boolean isDone;

}
