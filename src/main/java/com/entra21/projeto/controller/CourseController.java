package com.entra21.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.projeto.model.Course;
import com.entra21.projeto.repositories.CourseRepository;

/**
 * Classe CourseController
 * Criada em 08/09/2022
 * 
 * @author Ramon Casagrande
 */

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Método para listar Cursos
     * Criada em 08/09/2022
     * 
     * @author Ramon Casagrande
     */
    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    /**
     * Método para buscar Cursos por ID
     * Criada em 08/09/2022
     * 
     * @author Ramon Casagrande
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Course>> setCourse(@PathVariable Long id) {
        Optional<Course> courseOpt = courseRepository.findById(id);
        return ResponseEntity.ok(courseOpt);
    }
}
