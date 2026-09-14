/*
9. Sistema de reservas de assentos

Desenvolva um programa que represente os assentos de uma sala de cinema por meio de uma matriz. Cada posição deverá indicar se o assento está livre ou ocupado.

O programa deverá apresentar um menu com as seguintes operações:

• exibir o mapa de assentos;
• reservar um assento;
• cancelar uma reserva;
• informar a quantidade e o percentual de assentos ocupados;
• identificar a fileira com maior ocupação;
• procurar um conjunto de X assentos consecutivos;
• encerrar.

Na busca por assentos consecutivos, o usuário deverá informar a quantidade desejada e o programa deverá localizar o primeiro conjunto disponível em uma mesma fileira. Caso exista, deverão ser informadas a fileira e as posições encontradas. O programa deverá validar os limites da matriz, impedir a reserva de assentos já ocupados e impedir o cancelamento de assentos livres. Cada operação deverá ser implementada em um método separado.
*/


import java.util.Scanner;

public class Main9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean[][] assentos = new boolean[5][10];

        int opcao;

        do {
            System.out.println("\n--- SISTEMA DE RESERVAS ---");
            System.out.println("1 - Exibir mapa");
            System.out.println("2 - Reservar assento");
            System.out.println("3 - Cancelar reserva");
            System.out.println("4 - Quantidade e percentual ocupados");
            System.out.println("5 - Fileira com maior ocupação");
            System.out.println("6 - Procurar assentos consecutivos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            if (opcao == 1) {
                exibirMapa(assentos);

            } else if (opcao == 2) {
                reservar(assentos, sc);

            } else if (opcao == 3) {
                cancelar(assentos, sc);

            } else if (opcao == 4) {
                mostrarOcupacao(assentos);

            } else if (opcao == 5) {
                maiorOcupacao(assentos);

            } else if (opcao == 6) {
                procurarAssentos(assentos, sc);

            } else if (opcao == 0) {
                System.out.println("Programa encerrado!");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // Mapa
    public static void exibirMapa(boolean[][] assentos) {

        System.out.println("\n--- MAPA DE ASSENTOS ---");

        for (int i = 0; i < assentos.length; i++) {

            System.out.print("Fileira " + (i + 1) + ": ");

            for (int j = 0; j < assentos[i].length; j++) {

                if (assentos[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
            }

            System.out.println();
        }
    }

    // Reservar
    public static void reservar(boolean[][] assentos, Scanner sc) {

        System.out.print("Digite a fileira: ");
        int fileira = sc.nextInt() - 1;

        System.out.print("Digite o assento: ");
        int assento = sc.nextInt() - 1;

        if (fileira < 0 || fileira >= assentos.length ||
            assento < 0 || assento >= assentos[0].length) {

            System.out.println("Assento inválido!");

        } else if (assentos[fileira][assento]) {

            System.out.println("Esse assento já está ocupado!");

        } else {

            assentos[fileira][assento] = true;

            System.out.println("Assento reservado!");
        }
    }

    // Cancelar
    public static void cancelar(boolean[][] assentos, Scanner sc) {

        System.out.print("Digite a fileira: ");
        int fileira = sc.nextInt() - 1;

        System.out.print("Digite o assento: ");
        int assento = sc.nextInt() - 1;

        if (fileira < 0 || fileira >= assentos.length ||
            assento < 0 || assento >= assentos[0].length) {

            System.out.println("Assento inválido!");

        } else if (!assentos[fileira][assento]) {

            System.out.println("Esse assento está livre!");

        } else {

            assentos[fileira][assento] = false;

            System.out.println("Reserva cancelada!");
        }
    }

    // Ocupação
    public static void mostrarOcupacao(boolean[][] assentos) {

        int ocupados = 0;
        int total = assentos.length * assentos[0].length;

        for (int i = 0; i < assentos.length; i++) {

            for (int j = 0; j < assentos[i].length; j++) {

                if (assentos[i][j]) {
                    ocupados++;
                }
            }
        }

        double percentual = (ocupados * 100.0) / total;

        System.out.println("Assentos ocupados: " + ocupados);
        System.out.println("Percentual ocupado: " + percentual + "%");
    }

    // Maior ocupação
    public static void maiorOcupacao(boolean[][] assentos) {

        int maior = 0;
        int fileiraMaior = 0;

        for (int i = 0; i < assentos.length; i++) {

            int ocupados = 0;

            for (int j = 0; j < assentos[i].length; j++) {

                if (assentos[i][j]) {
                    ocupados++;
                }
            }

            if (ocupados > maior) {
                maior = ocupados;
                fileiraMaior = i;
            }
        }

        System.out.println(
            "Fileira com maior ocupação: " + (fileiraMaior + 1)
        );

        System.out.println("Assentos ocupados: " + maior);
    }

    // Buscar consecutivos
    public static void procurarAssentos(
            boolean[][] assentos,
            Scanner sc) {

        System.out.print("Quantos assentos deseja? ");
        int quantidade = sc.nextInt();

        if (quantidade <= 0 || quantidade > assentos[0].length) {
            System.out.println("Quantidade inválida!");
            return;
        }

        boolean encontrou = false;

        for (int i = 0; i < assentos.length; i++) {

            int contador = 0;

            for (int j = 0; j < assentos[i].length; j++) {

                if (!assentos[i][j]) {
                    contador++;
                } else {
                    contador = 0;
                }

                if (contador == quantidade) {

                    int inicio = j - quantidade + 1;

                    System.out.println(
                        "Encontrado na fileira " + (i + 1)
                    );

                    System.out.print("Assentos: ");

                    for (int k = inicio; k <= j; k++) {
                        System.out.print((k + 1) + " ");
                    }

                    System.out.println();

                    encontrou = true;
                    return;
                }
            }
        }

        if (!encontrou) {
            System.out.println(
                "Não existe essa quantidade de assentos consecutivos."
            );
        }
    }
}
