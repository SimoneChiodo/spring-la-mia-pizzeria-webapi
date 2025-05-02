package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ingredienti")
public class Ingredient {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "Il nome non può essere vuoto")
  private String nome;

  // Constructors
  public Ingredient() {
  }

  public Ingredient(String nome) {
    this.nome = nome;
  }

  // Pizze di riferimento
  @ManyToMany(mappedBy = "ingredienti", cascade = { CascadeType.REMOVE })
  @JsonBackReference  // Evita il problema di ridondanza di dati in JSON
  private List<Pizza> pizze;

  // Getters & Setters
  public List<Pizza> getPizze() {
    return this.pizze;
  }

  public void setPizze(List<Pizza> pizze) {
    this.pizze = pizze;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
