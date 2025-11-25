package com.testproject.studentsgroupslist.service;

import com.testproject.studentsgroupslist.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UtilService {

    private final StudentRepository studentRepository;

    public int countStudentsByGroupNumber(String GroupNumber) {
        return studentRepository.countAllByStudentsGroup_GroupNumber(GroupNumber);
    }

}
