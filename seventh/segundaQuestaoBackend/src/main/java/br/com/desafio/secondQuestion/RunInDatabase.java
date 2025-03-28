package br.com.desafio.secondQuestion;

public class RunInDatabase {

  public static void main(String[] args) {
    GetLivros getLivros = new GetLivrosDatabaseImp();
    new ExecuteProvider(getLivros).bootstrap();
  }
}
