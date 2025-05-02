package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pizza")
public class PizzaAdvancedRestController {
  
  @Autowired
  private PizzaService pizzaService;
  
  // GET
  @GetMapping()
  public List<Pizza> index() {
    List<Pizza> pizze = pizzaService.findAll(); 
    return pizze;
  }

  // SHOW
  @GetMapping("/{id}")
  public ResponseEntity show(@PathVariable("id") Integer id) {
    Pizza pizza = pizzaService.findById(id);
    return pizza;
  }
  
  // SEARCH
  @GetMapping("/search")
  public List<Pizza> search(@RequestParam(name = "title") String title) {
    List<Pizza> pizze = pizzaService.findByTitle(title); 
    return pizze;
  }
  
  // STORE
  @PostMapping("/create")
  public Pizza store(@RequestBody Pizza pizza) {
    return pizzaService.create(pizza);
  }
  
  // UPDATE
  @PutMapping("/edit/{id}")
  public Pizza update(@RequestBody Pizza pizza, @PathVariable Integer id) {
    pizza.setId(id); // Imposto l'id della pizza che voglio aggiornare
    return pizzaService.update(pizza); // Restituisco la pizza aggiornata
  }
  
  // DELETE
  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Integer id) {
    pizzaService.deleteById(id);
  }

}
