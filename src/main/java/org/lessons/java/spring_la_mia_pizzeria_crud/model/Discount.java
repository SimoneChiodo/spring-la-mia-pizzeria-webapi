package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "sconti")
public class Discount {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  // Pizza da cui dipende lo sconto
  @ManyToOne
  @JoinColumn(name = "pizza_id")
  @JsonBackReference  // Evita il problema di ridondanza di dati in JSON
  private Pizza pizza;

  @NotBlank(message = "Il nome non può essere vuoto")
  private String nome;

  @NotNull(message = "La data di inizio non può essere null")
  @PastOrPresent(message = "La data di inizio deve essere nel passato o nel presente")
  private LocalDate dataInizio;

  @NotNull(message = "La data di fine non può essere null")
  @FutureOrPresent(message = "La data di fine deve essere nel futuro o nel presente")
  private LocalDate dataFine;

  // Costructors
  public Discount() {

  }

  public Discount(String nome, LocalDate dataInizio, LocalDate dataFine) {
    this.nome = nome;
    this.dataInizio = dataInizio;
    this.dataFine = dataFine;
  }

  // Getters & Setters

  public Pizza getPizza() {
    return this.pizza;
  }

  public void setPizza(Pizza pizza) {
    this.pizza = pizza;
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

  public LocalDate getDataInizio() {
    return this.dataInizio;
  }

  public void setDataInizio(LocalDate dataInizio) {
    this.dataInizio = dataInizio;
  }

  public LocalDate getDataFine() {
    return this.dataFine;
  }

  public void setDataFine(LocalDate dataFine) {
    this.dataFine = dataFine;
  }


}
