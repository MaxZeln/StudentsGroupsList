package com.testproject.studentsgroupslist.controller;

import com.testproject.studentsgroupslist.model.dto.StudentDto;
import com.testproject.studentsgroupslist.model.dto.StudentsGroupDto;
import com.testproject.studentsgroupslist.service.StudentsGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/students_group")
@RequiredArgsConstructor
public class StudentsGroupsController {

    private final StudentsGroupService studentsGroupService;

    @PostMapping("/add_new_students_group")
    public void addStudent(@RequestParam String groupNumber) {
        studentsGroupService.addStudentsGroup(new StudentsGroupDto(groupNumber));
    }

    @GetMapping("/get_students_group_by_group_number")
    public StudentsGroupDto getStudentsGroupByGroupNumber(@RequestParam String groupNumber) {
         return studentsGroupService.findByGroupNumber(groupNumber);
    }

    @GetMapping("/get_all_students_groups")
    public List<StudentsGroupDto> getAllStudentsGroups() {
        return studentsGroupService.getAllStudentsGroups();
    }


}
