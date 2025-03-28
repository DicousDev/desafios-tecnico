package br.com.desafio.secondQuestion;

import br.com.desafio.secondQuestion.model.Livro;

@FunctionalInterface
public interface GetLivros {

  Livro[] getLivros();
}
