package com.testproject.studentsgroupslist.mapper;

import com.testproject.studentsgroupslist.model.dto.StudentsGroupDto;
import com.testproject.studentsgroupslist.model.entity.StudentsGroup;
import com.testproject.studentsgroupslist.service.UtilService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StudentsGroupMapper {

    private UtilService utilService;

    @Autowired
    protected void setUtilService(UtilService utilService) {
        this.utilService = utilService;
    }

    @Mapping(target = "studentsCount", ignore = true)
    public abstract StudentsGroupDto toDto(StudentsGroup studentsGroup);

    @AfterMapping
    protected void setStudentsCount(@MappingTarget StudentsGroupDto studentsGroupDto, StudentsGroup studentsGroup) {
        studentsGroupDto.setStudentsCount(utilService.countStudentsByGroupNumber(studentsGroup.getGroupNumber()));
    }

    public abstract StudentsGroup toEntity(StudentsGroupDto studentsGroupDto);

    public abstract List<StudentsGroupDto> toDtos(List<StudentsGroup> studentsGroups);

    public abstract List<StudentsGroup> toEntitys(List<StudentsGroupDto> studentsGroupDtos);

}


