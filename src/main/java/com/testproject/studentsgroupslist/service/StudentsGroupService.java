package com.testproject.studentsgroupslist.service;

import com.testproject.studentsgroupslist.mapper.StudentMapper;
import com.testproject.studentsgroupslist.mapper.StudentsGroupMapper;
import com.testproject.studentsgroupslist.model.dto.StudentDto;
import com.testproject.studentsgroupslist.model.dto.StudentsGroupDto;
import com.testproject.studentsgroupslist.repository.StudentRepository;
import com.testproject.studentsgroupslist.repository.StudentsGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor()
public class StudentsGroupService {

    private final StudentsGroupRepository studentsGroupRepository;
    private final StudentsGroupMapper studentsGroupMapper;

    public List<StudentsGroupDto> getAllStudentsGroups() {
        List<StudentsGroupDto> dtos = studentsGroupMapper.toDtos( studentsGroupRepository.findAll());
        log.debug("Found student group: {}", dtos);
        return dtos;
    }

    public boolean isGroupExist(String groupName) {
        return studentsGroupRepository.existsByGroupNumber(groupName);
    }

    public StudentsGroupDto findByGroupNumber(String groupNumber) {
        StudentsGroupDto studentsGroupDto =
                studentsGroupMapper.toDto(studentsGroupRepository.findByGroupNumber(groupNumber));
        log.info("Found student group: {}", studentsGroupDto.toString());
        return studentsGroupDto;
    }

    public void addStudentsGroup(StudentsGroupDto studentsGroupDto) {
        studentsGroupRepository.save(studentsGroupMapper.toEntity(studentsGroupDto));
        log.info("Added students group: {}", studentsGroupDto.toString());
    }

    public void deleteGroupByNumber(String groupNumber) {
        studentsGroupRepository.deleteByGroupNumber(groupNumber);
        log.info("Deleting student with id: {}", groupNumber);
    }

}
