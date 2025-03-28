package br.com.desafio.secondQuestion;

public class RunInMemory {

  public static void main(String[] args) {
    GetLivros getLivros = new GetLivrosMemoryImp();
    new ExecuteProvider(getLivros).bootstrap();
  }
}
