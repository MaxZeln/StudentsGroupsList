package com.testproject.studentsgroupslist.controller;

import com.testproject.studentsgroupslist.model.dto.StudentDto;
import com.testproject.studentsgroupslist.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@ResponseBody
@RestController()
@RequestMapping("/student")
public class StudentsController {

    private final StudentService studentService;

    @PostMapping("/add_new_student")
    public ResponseEntity<String> addStudent(@RequestParam String groupNumber, @RequestParam String name) {
        StudentDto studentDto = new StudentDto(groupNumber, name);
        try {
            studentService.addStudent(studentDto);
            return new ResponseEntity<>("Added student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get_students_by_group_number")
    public List<StudentDto> getStudentsByGroupNumber(@RequestParam String groupNumber) {
        return studentService.findStudentsByGroupNumber(groupNumber);
    }

}
