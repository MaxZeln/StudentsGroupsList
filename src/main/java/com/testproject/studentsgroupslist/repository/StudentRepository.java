package com.testproject.studentsgroupslist.repository;

import com.testproject.studentsgroupslist.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByStudentsGroup_GroupNumber(String GroupNumber);

    int countAllByStudentsGroup_GroupNumber(String GroupNumber);

}
