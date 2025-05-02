package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Discount;
import org.lessons.java.spring_la_mia_pizzeria_crud.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/discount")
public class DiscountController {

  //Repository
  @Autowired
  private DiscountService discountService;


  // STORE
  @PostMapping("/create")
  public String store(@Valid @ModelAttribute("sconto") Discount sconto, BindingResult bindingResult,  Model model) {
      
      //Controllo eventuali errori di validazione
      if(bindingResult.hasErrors()) {
          return "discount/create";
      }

      discountService.create(sconto);

      return "redirect:/pizza/" + sconto.getPizza().getId(); // Redirect alla pagina della pizza associata allo sconto
  }

  // EDIT
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
      Discount sconto = discountService.findById(id);

      // Redirect a una pagina di errore se lo sconto non esiste
      if (sconto == null) {
          return "redirect:/error"; 
      }

      model.addAttribute("sconto", sconto);
      return "discount/edit";
  }

  // UPDATE
  @PostMapping("/edit/{id}")
  public String update(@PathVariable Integer id, @Valid @ModelAttribute("formSconto") Discount formSconto, BindingResult bindingResult, Model model) {
    //Controllo eventuali errori di validazione
    if(bindingResult.hasErrors()) {
        return "discount/edit";
    }

    // Salva le modifiche nel repository
    discountService.update(formSconto); 

    // Redirect alla pagina della pizza associata allo sconto
    return "redirect:/pizza/" + formSconto.getPizza().getId(); 
  }

  // DELETE
  @PostMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {
    Discount sconto = discountService.findById(id); 

    discountService.delete(sconto); 

    // Redirect alla pagina della pizza associata allo sconto
    return "redirect:/pizza/" + sconto.getPizza().getId(); 
  }

}
