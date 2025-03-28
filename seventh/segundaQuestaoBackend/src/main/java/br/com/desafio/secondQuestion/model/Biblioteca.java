package br.com.desafio.secondQuestion.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;

public final class Biblioteca {

  private final String nome;
  private final String endereco;
  private final Map<String, Livro> livros = new TreeMap<>();

  public Biblioteca(String nome, String endereco) {
    Objects.requireNonNull(nome, "nome não pode ser nulo.");
    Objects.requireNonNull(endereco, "endereco não pode ser nulo.");
    this.nome = nome;
    this.endereco = endereco;
  }

  public void cadastrarLivro(Livro livro) {
    Objects.requireNonNull(livro, "Livro não deve ser nulo.");
    livros.put(livro.getTitulo(), livro);
  }

  public void cadastrarLivros(Livro[] livros) {
    Objects.requireNonNull(livros, "Livros não deve ser nulo.");
    Arrays.stream(livros).forEach(this::cadastrarLivro);
  }

  public Optional<Livro> buscarLivroPeloTitulo(String titulo) {
    Objects.requireNonNull(titulo, "Titulo não pode ser nulo.");
    return Optional.ofNullable(livros.getOrDefault(titulo, null));
  }

  public List<Livro> buscarLivrosPeloAutor(Autor autor) {
    Objects.requireNonNull(autor, "Autor não pode ser nulo.");
    return livros.values().stream()
        .filter(livro -> livro.contemAutor(autor))
        .toList();
  }

  public List<Livro> buscarLivros() {
    return livros.values().stream().toList();
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, endereco, livros);
  }

  @Override
  public boolean equals(Object other) {

    if(this == other) return true;

    if(other == null || getClass() != other.getClass()) return false;

    Biblioteca biblioteca = (Biblioteca) other;
    return Integer.valueOf(hashCode()).equals(biblioteca.hashCode());
  }

  @Override
  public String toString() {
    return "Biblioteca[nome: %s] - [endereco: %s] - [livros: %s]"
        .formatted(nome, endereco, livros.toString());
  }
}
