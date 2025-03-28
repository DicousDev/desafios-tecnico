package br.com.desafio.secondQuestion;

import br.com.desafio.secondQuestion.model.Autor;
import br.com.desafio.secondQuestion.model.Biblioteca;
import br.com.desafio.secondQuestion.model.Livro;
import java.util.Objects;

public class ExecuteProvider {

  private final GetLivros getLivros;

  public ExecuteProvider(GetLivros getLivros) {
    Objects.requireNonNull(getLivros, "getLivros não pode ser nulo");
    this.getLivros = getLivros;
  }

  public void bootstrap() {
    Livro[] livros = getLivros.getLivros();
    Biblioteca biblioteca = new Biblioteca("Biblioteca In House", "Florianópolis/SC minha residência");
    biblioteca.cadastrarLivros(livros);
    System.out.println("Imprimindo todos livros da biblioteca: Biblioteca In House");
    System.out.println("+--------------------------------+");
    biblioteca.buscarLivros().stream().forEach(livro -> System.out.println(livro));
    System.out.println("+--------------------------------+");
    System.out.println("Imprimindo todos livros do autor Robert C. Martin");
    biblioteca.buscarLivrosPeloAutor(new Autor("Robert C. Martin")).stream().forEach(livro -> System.out.println(livro));
    System.out.println("+--------------------------------+");
    System.out.println("Imprimindo livro pelo título: Código Limpo: Habilidades Práticas do Agile Software");
    Livro livro = biblioteca.buscarLivroPeloTitulo("Código Limpo: Habilidades Práticas do Agile Software").get();
    System.out.println(livro);
    System.out.println("+--------------------------------+");
  }
}
