package com.testproject.studentsgroupslist.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_generator")
    private long id;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_number", nullable = false)
    private StudentsGroup studentsGroup;

    @Column
    private String name;

    @Column
    private String enrollmentDate;

    public Student(StudentsGroup studentsGroup, String name) {
        this.studentsGroup = studentsGroup;
        this.name = name;
        this.enrollmentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date().getTime());
    }

    public Student() {

    }

}
