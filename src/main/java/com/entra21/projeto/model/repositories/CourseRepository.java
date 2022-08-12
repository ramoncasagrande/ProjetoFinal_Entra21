package com.entra21.projeto.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entra21.projeto.model.Course;

/**
 * Repositório de Cursos
 * Criado em 11/08/2022
 * 
 * @author Ramon Casagrande
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
