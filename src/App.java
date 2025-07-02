
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Aluno[] listaAlunos = new Aluno[5];
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("--MENU PRINCIPAL--");
            System.out.println("1- Registrar notas");
            System.out.println("2- Calcular Médias");
            System.out.println("3- Calcular Médias Ponderadas");
            System.out.println("4- Visualizar alunos!");
            System.out.println("5- Calcular Mediana");
            System.out.println("6- Calcular Moda");
            System.out.println("0 - Sair do sistema");
            opcao = in.nextInt();
            switch (opcao) {
                case 1 -> {
                    if (listaAlunos[listaAlunos.length - 1] != null) {
                        System.out.println("Não se pode adicionar mais alunos");
                    } else {
                        for (int i = 0; i < listaAlunos.length; i++) {
                            if (listaAlunos[i] == null) {
                                System.out.println("Informe o nome do aluno: ");
                                String nome = in.next();
                                System.out.println("Informe a primeira nota do aluno: ");
                                double notaUm = in.nextDouble();
                                System.out.println("Informe a segunda nota do aluno: ");
                                double notaDois = in.nextDouble();
                                System.out.println("Informe a quantidade de faltas do aluno: ");
                                int faltas = in.nextInt();
                                Aluno aluno = new Aluno(nome, notaUm, notaDois, faltas);
                                listaAlunos[i] = aluno;
                                break;
                            }
                        }
                    }
                }
                case 2 -> {
                    if (listaAlunos.length == 0) {
                        System.out.println("Não há notas cadastradas!");
                    } else {
                        for (Aluno listaAluno : listaAlunos) {
                            if (listaAluno != null) {
                                listaAluno.calcularMedia();
                                listaAluno.avaliarAprovacao();
                                System.out.println("A média do aluno " + listaAluno.getNome() + " é: " + listaAluno.getMedia());
                            }
                        }
                    }
                }
                case 3 -> {
                    if (listaAlunos.length == 0) {
                        System.out.println("Não há notas cadastradas!");
                    } else {
                        for (Aluno listaAluno : listaAlunos) {
                            if (listaAluno != null) {
                                listaAluno.calcularMediaPonderada();
                                listaAluno.avaliarAprovacao();
                                System.out.println("A média ponderada do aluno " + listaAluno.getNome() + " é: " + listaAluno.getMedia());
                            }
                        }
                    }
                }
                case 4 -> {
                    if (listaAlunos.length == 0) {
                        System.out.println("Não há notas cadastradas!");
                    } else {
                        System.out.println("Lista dos alunos:");
                        for (int i = 0; i < listaAlunos.length; i++) {
                            if (listaAlunos[i] != null) {
                                int auxiliar = i + 1;
                                System.out.println(auxiliar + "º aluno: \n" + listaAlunos[i].toString());
                            }
                        }
                    }
                }
                case 5 -> {
                    double[] notas = obterNotas(listaAlunos);
                    if (notas.length == 0) {
                        System.out.println("Não há notas cadastradas!");
                    } else {
                        double mediana = CalculosUteis.mediana(notas);
                        System.out.println("A mediana das notas é: " + mediana);
                    }
                }
                case 6 -> {
                    double[] notas = obterNotas(listaAlunos);
                    if (notas.length == 0) {
                        System.out.println("Não há notas cadastradas!");
                    } else {
                        double moda = CalculosUteis.moda(notas);
                        System.out.println("A moda das notas é: " + moda);
                    }
                }
                case 0 ->
                    System.out.println("Saindo do sistema...");
                default ->
                    System.out.println("Opção inválida!");
            }
        }
        in.close();
    }

    private static double[] obterNotas(Aluno[] listaAlunos) {
        List<Double> notas = new ArrayList<>();
        for (Aluno aluno : listaAlunos) {
            if (aluno != null) {
                notas.add(aluno.getNotaUm());
                notas.add(aluno.getNotaDois());
            }
        }
        return notas.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
