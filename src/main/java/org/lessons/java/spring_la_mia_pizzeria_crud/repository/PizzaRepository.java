package org.lessons.java.spring_la_mia_pizzeria_crud.repository;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    // JpaRepository fornisce già metodi per CRUD e ricerca
  
    public List<Pizza> findByNomeContainingIgnoreCase(String nome); // SELECT * FROM 'pizze' WHERE nome LIKE '%nome%'
}
