package com.testproject.studentsgroupslist.service;

import com.testproject.studentsgroupslist.mapper.StudentMapper;
import com.testproject.studentsgroupslist.model.dto.StudentDto;
import com.testproject.studentsgroupslist.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDto> findStudentsByGroupNumber(String GroupNumber) {
        return studentMapper.toDtos(studentRepository.findAllByStudentsGroup_GroupNumber(GroupNumber));
    }

    public int countStudentsByGroupNumber(String GroupNumber) {
        return studentRepository.countAllByStudentsGroup_GroupNumber(GroupNumber);
    }

    public void addStudent(StudentDto studentDto) {
        log.info("Added student: {}", studentDto.toString());
        studentRepository.save(studentMapper.toEntity(studentDto));
        log.info("Added student with name: {}", studentDto.getName());
    }

    public void deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
        log.info("Deleting student with id: {}", studentId);
    }

}
