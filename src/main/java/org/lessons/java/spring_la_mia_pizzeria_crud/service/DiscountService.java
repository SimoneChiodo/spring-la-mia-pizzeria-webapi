package org.lessons.java.spring_la_mia_pizzeria_crud.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Discount;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
  
  @Autowired
  private DiscountRepository discountRepository;

  // INDEX (non usata)
  public List<Discount> findAll() {
    return discountRepository.findAll();
  }

  // SHOW 
  public Discount findById(Integer id) {
    Optional<Discount> scontoAttempt = discountRepository.findById(id);

    // Se non esiste un oggetto sconto con quell'id
    if(scontoAttempt.isEmpty())
      return null;

    // Restituisco lo sconto
    return discountRepository.findById(id).get();
  }

  // CREATE 
  public Discount create(Discount sconto) {
    return discountRepository.save(sconto);
  }

  // UPDATE
  public Discount update(Discount sconto) {
    return discountRepository.save(sconto);
  }

  // DELETE
  public void delete(Discount sconto) {
    discountRepository.delete(sconto);
  }


}
