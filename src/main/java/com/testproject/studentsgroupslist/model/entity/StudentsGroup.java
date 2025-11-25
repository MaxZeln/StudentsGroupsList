package com.testproject.studentsgroupslist.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students_group")
public class StudentsGroup {

    @Id
    @Column(length = 10)
    private String groupNumber;

    public StudentsGroup(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public StudentsGroup() {
    }

}
