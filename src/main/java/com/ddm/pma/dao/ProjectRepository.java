package com.ddm.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ddm.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
