package br.com.desafio.secondQuestion.model;

import java.util.Objects;

public final class Autor {

  private final String nome;

  public Autor(String nome) {
    Objects.requireNonNull(nome, "Nome do autor não pode ser nulo.");
    this.nome = nome;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome);
  }

  @Override
  public boolean equals(Object other) {

    if(this == other) return true;

    if(other == null || getClass() != other.getClass()) return false;

    Autor autor = (Autor) other;
    return Integer.valueOf(hashCode()).equals(autor.hashCode());
  }

  @Override
  public String toString() {
    return "Autor[nome: %s]"
        .formatted(nome);
  }
}
