package br.com.desafio.secondQuestion.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Livro {

  private final String titulo;
  private Set<Autor> autores = new HashSet<>();
  private final Integer anoLancamento;

  public static Livro create(String titulo, Autor autor, Integer anoLancamento) {
    Objects.requireNonNull(autor, "Autor não pode ser nulo.");
    return create(titulo, Set.of(autor), anoLancamento);
  }

  public static Livro create(String titulo, Set<Autor> autores, Integer anoLancamento) {
    return new Livro(titulo, autores, anoLancamento);
  }

  private Livro(String titulo, Set<Autor> autores, Integer anoLancamento) {
    Objects.requireNonNull(titulo, "Titulo não pode ser nulo.");
    Objects.requireNonNull(autores, "Autores não pode ser nulo.");
    Objects.requireNonNull(anoLancamento, "Ano de lançamento não pode ser nulo.");

    if(autores.isEmpty()) {
      throw new RuntimeException("Não pode criar livro sem autores.");
    }

    if("".equals(titulo.strip())) {
      throw new RuntimeException("Não pode criar livro com titulo em branco.");
    }

    if(anoLancamento > LocalDate.now().getYear()) {
      throw new RuntimeException("Ano de lançamento não pode ser superior ao ano atual.");
    }

    this.titulo = titulo;
    this.autores = autores;
    this.anoLancamento = anoLancamento;
  }

  public String getTitulo() {
    return titulo;
  }

  public Boolean contemAutor(Autor autor) {
    Objects.requireNonNull(autor, "autor não pode ser nulo.");
    return autores.contains(autor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titulo, autores, anoLancamento);
  }

  @Override
  public boolean equals(Object other) {

    if(this == other) return true;

    if(other == null || getClass() != other.getClass()) return false;

    Livro livro = (Livro) other;
    return Integer.valueOf(hashCode()).equals(livro.hashCode());
  }

  @Override
  public String toString() {
    return "Livro[titulo: %s] - [autores: %s] - [anoLancamento: %s]"
        .formatted(titulo, autores.toString(), anoLancamento);
  }
}
