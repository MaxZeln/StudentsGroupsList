package com.testproject.studentsgroupslist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int id;
    private String groupNumber;
    private String name;
    private String enrollmentDate;

    public StudentDto(String groupNumber, String name) {
        this.groupNumber = groupNumber;
        this.name = name;
        this.enrollmentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date().getTime());
    }

    public String toString() {
        return "StudentDto(id=" + this.getId() + ", groupNumber="
                + this.getGroupNumber() + ", name=" + this.getName() + ")";
    }

}
