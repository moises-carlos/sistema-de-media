public class Aluno {
  //atributos da classe
  private String nome;
  private double notaUm;
  private double notaDois;
  private double media;
  private int qtdFaltas;
  private String statusAprovacao;
  // construtor 
  public Aluno(String nome, double notaUm, double notaDois, int qtdFaltas){
    this.nome = nome;
    this.notaUm = notaUm;
    this.notaDois = notaDois;
    this.qtdFaltas = qtdFaltas;
    this.media = 0;
    this.statusAprovacao = "Não Avaliado!";
  }
  //getters and setters
  public String getNome(){
    return this.nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public double getNotaUm (){
    return this.notaUm;
  }
  public void setNotaUm(double notaUm){
    this.notaUm = notaUm;
  }
  public double getNotaDois (){
    return this.notaDois;
  }
  public void setNotaDois(double notaDois){
    this.notaDois = notaDois;
  }
  public int getQtdFaltas (){
    return this.qtdFaltas;
  }
  public void setQtdFaltas (int qtdFaltas){
    this.qtdFaltas = qtdFaltas;
  }
  public double getMedia(){
    return this.media;
  }
  private void setMedia(double media){
    this.media = media;
  }
  public String getStatusAprovacao (){
    return this.statusAprovacao;
  }
  private void setStatusAprovacao(String statusAprovacao){
    this.statusAprovacao = statusAprovacao;
  }
  //métodos de aluno
  public void calcularMedia(){
    double media = CalculosUteis.media(this);
    setMedia(media);
  }
  public void calcularMediaPonderada(){
    double media = CalculosUteis.mediaPonderada(this);
    setMedia(media);
  }
  public void avaliarAprovacao (){
    if (qtdFaltas <= 16){
      if (media >= 7){
        setStatusAprovacao("Aprovado!");
      } else if (media < 7 && media > 4){
        setStatusAprovacao("Aprovado na recuperação!");
      }else{
        setStatusAprovacao("Reprovado por nota!");
      }
    }else{
      setStatusAprovacao("Reprovado por falta!");
    }
  }
  //toString
  @Override
  public String toString (){
    return "--Dados do aluno--\nNome: " + this.nome +
    "\nNota um: " + this.notaUm +
    "\nNota dois: " + this.notaDois +
    "\nMédia: " + this.media +
    "\nQuantidade de faltas: " + this.qtdFaltas +
    "\nStatus de aprovação: "+ this.getStatusAprovacao().toUpperCase();
  }
}
