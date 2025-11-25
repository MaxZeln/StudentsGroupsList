package com.testproject.studentsgroupslist.mapper;

import com.testproject.studentsgroupslist.model.dto.StudentDto;
import com.testproject.studentsgroupslist.model.entity.Student;
import com.testproject.studentsgroupslist.service.StudentsGroupService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    private StudentsGroupService studentGroupService;
    private StudentsGroupMapper studentGroupMapper;

    @Autowired
    public void setStudentGroupService(StudentsGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @Autowired
    public void setStudentGroupMapper(StudentsGroupMapper studentGroupMapper) {
        this.studentGroupMapper = studentGroupMapper;
    }

    @Mapping(target = "groupNumber", expression = "java(student.getStudentsGroup().getGroupNumber())")
    public abstract StudentDto toDto(Student student);

    @BeforeMapping
    protected void validate(@MappingTarget Student student, StudentDto studentDto) {
        if (studentGroupService.isGroupExist(studentDto.getGroupNumber())) {
            student.setStudentsGroup(
                    studentGroupMapper.toEntity(studentGroupService.findByGroupNumber(studentDto.getGroupNumber())));
        } else {
            throw new RuntimeException(
                    String.format("group number [%s] does not exist", studentDto.getGroupNumber()));
        }
    }

    @Mapping(target = "studentsGroup", ignore = true)
    public abstract Student toEntity(StudentDto studentDto);

    public abstract List<StudentDto> toDtos(List<Student> studentList);

    public abstract List<Student> toEntitys(List<StudentDto> studentDtoList);

}
