package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v2/pizza")
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
  public ResponseEntity<Pizza> show(@PathVariable("id") Integer id) {
    Optional<Pizza> pizzaAttempt = pizzaService.findById(id);

    // Se non esiste un oggetto pizza con quell'id
    if(pizzaAttempt.isEmpty())
      return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND); // Restituisco un errore 404

    return new ResponseEntity<Pizza>(pizzaAttempt.get(), HttpStatus.OK); // Restituisco la pizza
  }
  
  // SEARCH
  @GetMapping("/search")
  public List<Pizza> search(@RequestParam(name = "title") String title) {
    List<Pizza> pizze = pizzaService.findByTitle(title); 
    return pizze;
  }
  
  // STORE
  @PostMapping("/create")
  public ResponseEntity<Pizza> store(@RequestBody Pizza pizza) {
    return new ResponseEntity<Pizza>(pizzaService.create(pizza), HttpStatus.OK); 
  }
  
  // UPDATE
  @PutMapping("/edit/{id}")
  public ResponseEntity<Pizza> update(@RequestBody Pizza pizza, @PathVariable Integer id) {
    // Se non esiste un oggetto pizza con quell'id
    if(pizzaService.findById(id).isEmpty())
      return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND); // Restituisco un errore 404  
    
    pizza.setId(id); // Imposto l'id della pizza che voglio aggiornare
    return new ResponseEntity<Pizza>(pizzaService.update(pizza), HttpStatus.OK); 
  }
  
  // DELETE
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Pizza> delete(@PathVariable Integer id) {
    pizzaService.deleteById(id);
    return new ResponseEntity<Pizza>(HttpStatus.OK);
  }

}
