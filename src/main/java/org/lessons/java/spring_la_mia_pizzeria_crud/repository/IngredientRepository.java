package org.lessons.java.spring_la_mia_pizzeria_crud.repository;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    // Le query sono già implementate da JpaRepository

    public List<Ingredient> findByNomeContainingIgnoreCase(String nome); // SELECT * FROM 'ingredienti' WHERE nome LIKE '%nome%'
}
