package com.testproject.studentsgroupslist.repository;

import com.testproject.studentsgroupslist.model.entity.StudentsGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsGroupRepository extends JpaRepository<StudentsGroup, Integer> {

    StudentsGroup findByGroupNumber(String groupNumber);

    boolean existsByGroupNumber(String groupNumber);

    void deleteByGroupNumber(String groupNumber);

}
