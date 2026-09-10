/*

Desenvolva um programa que leia o nome de um estudante, três notas entre 0 e 10 e seu percentual de frequência, entre 0 e 100. O programa deverá calcular a média aritmética das notas e determinar a situação acadêmica do estudante de acordo com as seguintes regras: 
● frequência inferior a 75%: reprovado por frequência; 
● frequência igual ou superior a 75% e média igual ou superior a 7: aprovado; 
● frequência igual ou superior a 75% e média entre 5 e 6,99: recuperação;
● frequência igual ou superior a 75% e média inferior a 5: reprovado por nota. 
O cálculo da média e a determinação da situação deverão ser realizados por métodos separados. Ao final, o programa deverá apresentar o nome, a média com duas casas decimais, a frequência e a situação do estudante.

 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Double> notas = new ArrayList<>();

        System.out.println("Escreva o nome do estudante");
        String nomeAluno = sc.nextLine();
        System.out.println("");

        sc.close();

        double media = media(notas, nomeAluno);

        double frequencia = frequencia(nomeAluno);

        String aprovacao = aprovarAluno(media, frequencia);

        print("================================================================");
        print("");
        print("Aluno: " + nomeAluno);
        print("");
        print("================================================================");
        print("");
        print("Tirou as seguintes notas: ");
        print("");
        for(int i = 0; i < 3; i++){
            print(i+1 + "º nota: " + notas.get(i));
            print("");
        }
        print("A frequência foi de " + frequencia + "%");
        print("");
        print("================================================================");
        print("");
        System.out.printf("A média foi de: %.2f\n", media);
        print("");
        print("================================================================");
        print("");
        print("Aluno foi: " + aprovacao);
        print("");
        print("================================================================");

        


    }

    public static double media(ArrayList<Double> notas, String nomeAluno) {
        Scanner sc = new Scanner(System.in);

        double media = 0;
        
        System.out.println("Escreva as três notas em sequência do aluno " + nomeAluno + ".");
        
        for (int i = 0; i < 3; i++){

            if (i == 0) {
            }
            else {
                System.out.println("");
            }
            System.out.println("Escreva a " + (i+1) + "º nota: ");
            double nota = sc.nextDouble();
            notas.add(nota);
            media += nota;
        }

        media = media / 3;

        sc.close();

        return media;

       
    }

    public static double frequencia( String nomeAluno) {
        Scanner sc = new Scanner(System.in);

        double frequencia;

        System.out.println("");
        System.out.println("Escreva a frequencia do aluno " + nomeAluno + " (obs: Não coloque porcentagem): ");
        frequencia = sc.nextDouble();
        System.out.println("");

        sc.close();

        return frequencia;
    }

    public static String aprovarAluno(double media, double frequencia) {

        String aprovacao;

        if (media >= 7 && frequencia >= 75) {
            aprovacao = "Aprovado";
        }
        
        else if (media >= 5 && media < 7 && frequencia >= 75) {
            aprovacao = "Recuperação";
        }

        else if (media < 5 && frequencia >= 75) {
            aprovacao = "Reprovado por nota baixa";
        }

        else {
            if (media < 5) {
                aprovacao = "Reprovado por frequência baixa e nota baixa";
            }
            else {
                aprovacao = "Reprovado por frequência baixa";
            }
        }

        return aprovacao;
    }

    public static void print(Object texto) {
        System.out.println(texto);
    }
}
