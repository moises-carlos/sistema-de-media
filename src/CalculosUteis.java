
import java.util.Arrays;

public class CalculosUteis {

    public static double media(Aluno aluno) {
        double notaUm = aluno.getNotaUm();
        double notaDois = aluno.getNotaDois();
        double media = (notaUm + notaDois) / 2;
        return media;
    }

    public static double mediaPonderada(Aluno aluno) {
        double notaUm = aluno.getNotaUm();
        double notaDois = aluno.getNotaDois();
        double media = ((notaUm * 2) + (notaDois * 3)) / 5;
        return media;
    }

    public static double mediana(double[] notas) {
        Arrays.sort(notas);
        int n = notas.length;
        if (n % 2 == 0) {
            return (notas[n / 2 - 1] + notas[n / 2]) / 2.0;
        } else {
            return notas[n / 2];
        }
    }

    public static double moda(double[] notas) {
        double moda = notas[0];
        int maiorRepeticao = 0;

        for (int i = 0; i < notas.length; i++) {
            double atual = notas[i];
            int contador = 0;

            
            for (int j = 0; j < notas.length; j++) {
                if (notas[j] == atual) {
                    contador++;
                }
            }

            
            if (contador > maiorRepeticao) {
                maiorRepeticao = contador;
                moda = atual;
            }
        }

        return moda;
    }

}
