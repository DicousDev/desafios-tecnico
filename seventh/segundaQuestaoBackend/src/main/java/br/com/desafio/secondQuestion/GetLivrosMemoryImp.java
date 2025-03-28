package br.com.desafio.secondQuestion;

import br.com.desafio.secondQuestion.model.Autor;
import br.com.desafio.secondQuestion.model.Livro;
import java.util.Set;

public class GetLivrosMemoryImp implements GetLivros {

  @Override
  public Livro[] getLivros() {
    Autor[] autores = getAutores();
    Livro[] livros = new Livro[11];
    livros[0] = Livro.create("Fundamentos da Arquitetura de Software: uma Abordagem de Engenharia", Set.of(autores[0], autores[1]), 2024);
    livros[1] = Livro.create("Arquitetura de Software: as Partes Difíceis: Análises Modernas de Trade-off Para Arquiteturas Distribuídas", Set.of(autores[0], autores[1], autores[2], autores[3]), 2024);
    livros[2] = Livro.create("Aprenda Domain-driven Design: Alinhando Arquitetura de Software e Estratégia de Negócios", autores[4], 2024);
    livros[3] = Livro.create("Domain-driven Design Destilado", autores[5], 2024);
    livros[4] = Livro.create("Implementando Domain-Driven Design", Set.of(autores[5], autores[6]), 2016);
    livros[5] = Livro.create("Arquitetura Limpa: o Guia do Artesão Para Estrutura e Design de Software", autores[7], 2016);
    livros[6] = Livro.create("Domain-Driven Design: Atacando as Complexidades no Coração do Software", autores[6], 2016);
    livros[7] = Livro.create("Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos", autores[8], 2017);
    livros[8] = Livro.create("Código Limpo: Habilidades Práticas do Agile Software", autores[7], 2009);
    livros[9] = Livro.create("Craftsmanship Limpo: Disciplinas, Padrões e ética", autores[7], 2023);
    livros[10] = Livro.create("Como ser um Programador Melhor: um Manual Para Programadores que se Importam com Código", autores[9], 2015);
    return livros;
  }

  private Autor[] getAutores() {
    Autor[] autores = new Autor[10];
    autores[0] = new Autor("Mark Richards");
    autores[1] = new Autor("Neal Ford");
    autores[2] = new Autor("Pramod Sadalage");
    autores[3] = new Autor("Zhamak Dehghani");
    autores[4] = new Autor("Vlad Khononov");
    autores[5] = new Autor("Vaughn Vernon");
    autores[6] = new Autor("Eric Evans");
    autores[7] = new Autor("Robert C. Martin");
    autores[8] = new Autor("Aditya Y. Bhargava");
    autores[9] = new Autor("Pete Goodliffe");
    return autores;
  }
}
