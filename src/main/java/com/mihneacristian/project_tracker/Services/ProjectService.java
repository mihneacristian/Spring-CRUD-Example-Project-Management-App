package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.Entities.Project;
import com.mihneacristian.project_tracker.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public Optional<Project> getProjectById (Integer id) {

        return projectRepository.findById(id);
    }
}