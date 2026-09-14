/*5. Estatísticas de uma sequência numérica
Desenvolva um programa que leia uma quantidade indeterminada de números inteiros. A leitura deverá continuar enquanto o usuário não informar o valor zero. Ao final, o programa deverá informar:

● quantidade de números digitados
● soma de todos os valores e média geral
● maior e menor valor
● quantidade de valores positivos e negativos
● quantidade de valores pares e ímpares
● quantidade de múltiplos de três
O programa também deverá tratar a situação em que o primeiro valor informado seja zero, evitando cálculos inválidos. Crie métodos auxiliares para as classificações numéricas utilizadas. */


import java.util.Scanner;

public class Main5 {
    public static boolean positivo(int numero) {
        return numero > 0;
    }

    public static boolean negativo(int numero) {
        return numero < 0;
    }

    public static boolean par(int numero) {
        return numero % 2 == 0;
    }

    public static boolean multiploDeTres(int numero) {
        return numero % 3 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;
        int quantidade = 0;
        int soma = 0;
        int maior = 0;
        int menor = 0;
        int positivos = 0;
        int negativos = 0;
        int pares = 0;
        int impares = 0;
        int multiplosDeTres = 0;

        System.out.print("Digite um número: ");
        numero = sc.nextInt();

        while (numero != 0) {
            if (quantidade == 0) {
                maior = numero;
                menor = numero;
            }

            quantidade++;
            soma += numero;

            if (numero > maior) {
                maior = numero;
            }

            if (numero < menor) {
                menor = numero;
            }

            if (positivo(numero)) {
                positivos++;
            }

            if (negativo(numero)) {
                negativos++;
            }

            if (par(numero)) {
                pares++;
            } else {
                impares++;
            }

            if (multiploDeTres(numero)) {
                multiplosDeTres++;
            }

            System.out.print("Digite um número: ");
            numero = sc.nextInt();
        }

        if (quantidade == 0) {
            System.out.println("Nenhum número foi digitado.");
        } else {
            double media = (double) soma / quantidade;

            System.out.println("Quantidade: " + quantidade);
            System.out.println("Soma: " + soma);
            System.out.println("Média: " + media);
            System.out.println("Maior: " + maior);
            System.out.println("Menor: " + menor);
            System.out.println("Positivos: " + positivos);
            System.out.println("Negativos: " + negativos);
            System.out.println("Pares: " + pares);
            System.out.println("Ímpares: " + impares);
            System.out.println("Múltiplos de três: " + multiplosDeTres);
        }

        sc.close();
    }
}