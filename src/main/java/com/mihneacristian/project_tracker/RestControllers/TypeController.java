package com.mihneacristian.project_tracker.RestControllers;

import com.mihneacristian.project_tracker.DTO.TypeDTO;
import com.mihneacristian.project_tracker.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TypeController {

    @Autowired
    TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(value = "/types", produces = "application/json")
    public ResponseEntity<List<TypeDTO>> getAllTypes() {

        List<TypeDTO> allTypesDTO = typeService.getAllTypes();
        return new ResponseEntity<List<TypeDTO>>(allTypesDTO, HttpStatus.OK);
    }
}
