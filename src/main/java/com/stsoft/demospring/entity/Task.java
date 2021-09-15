package com.stsoft.demospring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//import    validation.constraints.NotBlank;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "priorityId name can't be blank")
    @Digits(fraction = 0, integer = Integer.MAX_VALUE)
    private Integer priorityId;

    private String description;

    private String filename;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "Date can't be blank")
    @NotNull(message = "Date can't be null")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(Integer id, Integer priorityId, String description, Date date, User user, String filename) {
        this.id = id;
        this.priorityId = priorityId;
        this.description = description;
        this.date = date;
        this.user = user;
        this.filename = filename;
    }

    public String getUserName() {
        return user != null ? user.getUsername() : "none";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}