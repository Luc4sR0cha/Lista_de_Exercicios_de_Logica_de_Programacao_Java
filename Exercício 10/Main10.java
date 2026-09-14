/*
10. Caça palavras multidirecional

Desenvolva um programa que represente um caça palavras por meio de uma matriz de caracteres. O usuário deverá informar as dimensões da matriz, as letras de cada posição e uma lista de palavras que deverão ser procuradas.

Cada palavra poderá aparecer em qualquer uma das oito direções:

• horizontal da esquerda para a direita;
• horizontal da direita para a esquerda;
• vertical de cima para baixo;
• vertical de baixo para cima;
• diagonal superior esquerda para inferior direita;
• diagonal inferior direita para superior esquerda;
• diagonal superior direita para inferior esquerda;
• diagonal inferior esquerda para superior direita.

Para cada palavra, o programa deverá informar se ela foi encontrada. Em caso positivo, deverá apresentar a posição inicial, a posição final e a direção em que foi localizada. As buscas não poderão ultrapassar os limites da matriz nem continuar do lado oposto ao atingir uma borda. Palavras poderão compartilhar letras. A verificação de uma palavra em determinada posição e direção deverá ser realizada por um método específico, reutilizado durante toda a busca.
*/

import java.util.Scanner;

public class Main10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de linhas: ");
        int linhas = sc.nextInt();

        System.out.print("Digite o número de colunas: ");
        int colunas = sc.nextInt();

        char[][] matriz = new char[linhas][colunas];

        // Preencher matriz
        System.out.println("\nDigite as letras:");

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.next().toUpperCase().charAt(0);
            }
        }

        System.out.print("\nQuantas palavras deseja procurar? ");
        int quantidade = sc.nextInt();

        String[] palavras = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite a palavra " + (i + 1) + ": ");
            palavras[i] = sc.next().toUpperCase();
        }

        // Procurar palavras
        for (int p = 0; p < palavras.length; p++) {

            String palavra = palavras[p];
            boolean encontrada = false;

            for (int i = 0; i < linhas && !encontrada; i++) {

                for (int j = 0; j < colunas && !encontrada; j++) {

                    for (int direcao = 0; direcao < 8; direcao++) {

                        int[] resultado = verificarPalavra(
                                matriz, palavra, i, j, direcao
                        );

                        if (resultado != null) {

                            System.out.println("\nPalavra: " + palavra);
                            System.out.println(
                                "Inicio: (" + i + ", " + j + ")"
                            );
                            System.out.println(
                                "Fim: (" + resultado[0] + ", " + resultado[1] + ")"
                            );
                            System.out.println(
                                "Direção: " + nomeDirecao(direcao)
                            );

                            encontrada = true;
                            break;
                        }
                    }
                }
            }

            if (!encontrada) {
                System.out.println("\nPalavra: " + palavra);
                System.out.println("Não encontrada.");
            }
        }

        sc.close();
    }

    // Verifica palavra
    public static int[] verificarPalavra(
            char[][] matriz,
            String palavra,
            int linha,
            int coluna,
            int direcao) {

        int[] linhaDirecao = {
            0, 0, 1, -1, 1, -1, 1, -1
        };

        int[] colunaDirecao = {
            1, -1, 0, 0, 1, -1, -1, 1
        };

        int linhaAtual = linha;
        int colunaAtual = coluna;

        for (int i = 0; i < palavra.length(); i++) {

            if (linhaAtual < 0 ||
                linhaAtual >= matriz.length ||
                colunaAtual < 0 ||
                colunaAtual >= matriz[0].length) {

                return null;
            }

            if (matriz[linhaAtual][colunaAtual] != palavra.charAt(i)) {
                return null;
            }

            linhaAtual += linhaDirecao[direcao];
            colunaAtual += colunaDirecao[direcao];
        }

        return new int[] {
            linhaAtual - linhaDirecao[direcao],
            colunaAtual - colunaDirecao[direcao]
        };
    }

    // Nome da direção
    public static String nomeDirecao(int direcao) {

        if (direcao == 0) {
            return "Esquerda para direita";
        } else if (direcao == 1) {
            return "Direita para esquerda";
        } else if (direcao == 2) {
            return "Cima para baixo";
        } else if (direcao == 3) {
            return "Baixo para cima";
        } else if (direcao == 4) {
            return "Diagonal superior esquerda para inferior direita";
        } else if (direcao == 5) {
            return "Diagonal inferior direita para superior esquerda";
        } else if (direcao == 6) {
            return "Diagonal superior direita para inferior esquerda";
        } else {
            return "Diagonal inferior esquerda para superior direita";
        }
    }
}
