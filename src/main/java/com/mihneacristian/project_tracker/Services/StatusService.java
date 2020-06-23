package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.Entities.Status;
import com.mihneacristian.project_tracker.Repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Transactional
    public Optional<Status> getStatusById(Integer id) {

        return statusRepository.findById(id);
    }

    @Transactional
    public List<Status> getAllStatus() {

        return statusRepository.findAll();
    }

    @Transactional
    public void saveNewStatus(Status statusName) {

        statusRepository.save(statusName);
    }

    @Transactional
    public void deleteStatusById(Integer id) {

        statusRepository.deleteById(id);
    }
}
