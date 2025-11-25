package com.testproject.studentsgroupslist.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentsGroupDto {
    private String groupNumber;
    private int studentsCount;

    public StudentsGroupDto(String groupNumber) {
        this.groupNumber = groupNumber;
    }

}
