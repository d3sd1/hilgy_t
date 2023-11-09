package com.agile.agileback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "investment_needed")
    private float investmentNeeded;

    @Column(name = "investment_collected")
    private float investmentCollected;
    @Column(name = "due_date")
    private String dueDate;
    @Column(name = "comment")
    private String comment;
    @Column(name = "rating")
    private String rating;

    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Investor> investors;

}
