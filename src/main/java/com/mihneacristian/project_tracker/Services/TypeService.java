package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.Entities.Type;
import com.mihneacristian.project_tracker.Repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Transactional
    public Optional<Type> getTypeById(Integer id) {

        return typeRepository.findById(id);
    }

    @Transactional
    public void saveNewType(Type commentText) {

        typeRepository.save(commentText);
    }

    @Transactional
    public List<Type> getAllTypes() {

        return typeRepository.findAll();
    }

    @Transactional
    public void deleteTypeById(Integer id) {

        typeRepository.deleteById(id);
    }
}
