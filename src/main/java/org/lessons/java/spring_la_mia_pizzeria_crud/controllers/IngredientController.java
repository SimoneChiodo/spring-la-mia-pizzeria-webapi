package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Ingredient;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
  
  @Autowired
  private IngredientRepository ingredientRepository;

  // INDEX
  @GetMapping
  public String index(Model model) {
    model.addAttribute("ingredients", ingredientRepository.findAll());

    return "ingredient/index";
  } 
  
  // SEARCH
  @GetMapping("/search")
  public String search(@RequestParam(name = "nome") String nome, Model model) {
    List<Ingredient> ingredienti = ingredientRepository.findByNomeContainingIgnoreCase(nome); // SELECT * FROM 'ingredienti' WHERE nome LIKE '%nome%'
    
    model.addAttribute("ingredients", ingredienti);

    return "ingredient/index";
  }

  // CREATE
  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("ingredient", new Ingredient());
    model.addAttribute("create", true);

    return "ingredient/create-or-edit";
  } 

  // STORE
  @PostMapping("/create")
  public String store(@Valid @ModelAttribute Ingredient ingredient, BindingResult bindingResult, Model model) {
    
    //Controllo se ci sono errori di validazione
    if (bindingResult.hasErrors()) {
      model.addAttribute("create", true);
      return "ingredient/create-or-edit";
    }

    //Salvo l'ingrediente
    ingredientRepository.save(ingredient);

    return "redirect:/ingredient";
  } 

  // EDIT
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Ingredient ingredient = ingredientRepository.findById(id).get();

    // Controllo se l'ingrediente esiste, altrimenti reindirizzo alla lista degli ingredienti
    if (ingredient == null) {
      return "redirect:/ingredient";
    }

    model.addAttribute("ingredient", ingredient);
    model.addAttribute("create", false);

    return "ingredient/create-or-edit";
  }

  // UPDATE
  @PostMapping("/edit/{id}")
  public String update(@Valid @ModelAttribute("ingredient") Ingredient ingredient, BindingResult bindingResult, Model model) {
    
    //Controllo se ci sono errori di validazione
    if (bindingResult.hasErrors()) {
      model.addAttribute("create", false);
      return "ingredient/create-or-edit";
    }

    //Salvo l'ingrediente
    ingredientRepository.save(ingredient);

    return "redirect:/ingredient";
  }

  // DELETE
  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {

    // Elimino tutte le pizze associate all'ingrediente // <-- Non serve perché dentro Ingredient.java ho definito la relazione "ManyToMany" con "CascadeType.REMOVE"
    // Ingredient ingredient = ingredientRepository.findById(id).get();
    // for(Pizza pizza : ingredient.getPizze()) {
    //   pizza.getIngredienti().remove(ingredient);
    // }

    ingredientRepository.deleteById(id);

    return "redirect:/ingredient";
  }

}
