package org.lessons.java.spring_la_mia_pizzeria_crud.service;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
  
  @Autowired
  private PizzaRepository pizzaRepository;

  // INDEX
  public List<Pizza> findAll() {
    return pizzaRepository.findAll();
  }

  // INDEX SORTED
  public List<Pizza> findAllSortedByNome() {
    return pizzaRepository.findAll(Sort.by("nome"));
  }

  // SHOW
  public Pizza findById(Integer id){
    Optional<Pizza> pizzaAttempt = pizzaRepository.findById(id);

    // Se non esiste un oggetto pizza con quell'id
    if(pizzaAttempt.isEmpty())
      return null;

    // Restituisco la pizza
    return pizzaRepository.findById(id).get();
  }

  // SHOW FILTERED
  public List<Pizza> findByTitle(String nome) {
    return pizzaRepository.findByNomeContainingIgnoreCase(nome);
  }

  // CREATE
  public Pizza create(Pizza pizza) {
    return pizzaRepository.save(pizza);
  }

  // UPDATE
  public Pizza update(Pizza pizza) {
    return pizzaRepository.save(pizza);
  }

  // DELETE
  public void delete(Pizza pizza) {
    
    // Elimino tutti gli sconti associati alla pizza // <-- Non serve perché dentro Pizza.java ho definito la relazione "OneToMany" con "CascadeType.REMOVE"
    // for(Discount sconto : pizza.getSconti()) { 
    //   discountRepository.delete(sconto); 
    // }

    pizzaRepository.delete(pizza);
  }
  
}
