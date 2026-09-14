/*
8. Gerenciador de lista de compras

Desenvolva um programa para gerenciar uma lista de compras utilizando estruturas ArrayList. Para cada produto, deverão ser armazenados seu nome, sua quantidade e seu preço unitário. Como ainda não serão utilizadas classes próprias, essas informações deverão ser mantidas em listas paralelas. O programa deverá apresentar continuamente as seguintes opções:

• adicionar um produto;
• alterar a quantidade de um produto;
• alterar o preço de um produto;
• remover um produto;
• pesquisar produtos pelo nome ou por parte dele;
• listar todos os produtos;
• calcular o valor total da compra;
• identificar o produto com maior subtotal;
• encerrar.

O subtotal de um produto corresponde à multiplicação de sua quantidade pelo preço unitário. O programa deverá impedir quantidades negativas, preços inválidos e inconsistências entre as posições das listas. Ao adicionar um produto que já exista, o programa deverá oferecer a possibilidade de atualizar sua quantidade, em vez de criar uma duplicação.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompras {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n--- LISTA DE COMPRAS ---");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Alterar quantidade");
            System.out.println("3 - Alterar preço");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Pesquisar produto");
            System.out.println("6 - Listar produtos");
            System.out.println("7 - Valor total");
            System.out.println("8 - Maior subtotal");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            // Adicionar
            if (opcao == 1) {

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                int posicao = nomes.indexOf(nome);

                if (posicao != -1) {
                    System.out.println("Produto já existe!");
                    System.out.print("Nova quantidade: ");
                    int quantidade = sc.nextInt();

                    if (quantidade >= 0) {
                        quantidades.set(posicao, quantidade);
                    } else {
                        System.out.println("Quantidade inválida!");
                    }

                } else {

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    if (quantidade >= 0 && preco >= 0) {
                        nomes.add(nome);
                        quantidades.add(quantidade);
                        precos.add(preco);

                        System.out.println("Produto adicionado!");
                    } else {
                        System.out.println("Quantidade ou preço inválido!");
                    }
                }
            }

            // Alterar quantidade
            else if (opcao == 2) {

                System.out.print("Nome do produto: ");
                String nome = sc.nextLine();

                int posicao = nomes.indexOf(nome);

                if (posicao != -1) {
                    System.out.print("Nova quantidade: ");
                    int quantidade = sc.nextInt();

                    if (quantidade >= 0) {
                        quantidades.set(posicao, quantidade);
                        System.out.println("Quantidade alterada!");
                    } else {
                        System.out.println("Quantidade inválida!");
                    }

                } else {
                    System.out.println("Produto não encontrado!");
                }
            }

            // Alterar preço
            else if (opcao == 3) {

                System.out.print("Nome do produto: ");
                String nome = sc.nextLine();

                int posicao = nomes.indexOf(nome);

                if (posicao != -1) {
                    System.out.print("Novo preço: ");
                    double preco = sc.nextDouble();

                    if (preco >= 0) {
                        precos.set(posicao, preco);
                        System.out.println("Preço alterado!");
                    } else {
                        System.out.println("Preço inválido!");
                    }

                } else {
                    System.out.println("Produto não encontrado!");
                }
            }

            // Remover
            else if (opcao == 4) {

                System.out.print("Nome do produto: ");
                String nome = sc.nextLine();

                int posicao = nomes.indexOf(nome);

                if (posicao != -1) {
                    nomes.remove(posicao);
                    quantidades.remove(posicao);
                    precos.remove(posicao);

                    System.out.println("Produto removido!");
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }

            // Pesquisar
            else if (opcao == 5) {

                System.out.print("Digite o nome ou parte do nome: ");
                String pesquisa = sc.nextLine();

                for (int i = 0; i < nomes.size(); i++) {

                    if (nomes.get(i).toLowerCase().contains(pesquisa.toLowerCase())) {

                        System.out.println(
                            nomes.get(i) +
                            " - Quantidade: " + quantidades.get(i) +
                            " - Preço: R$ " + precos.get(i)
                        );
                    }
                }
            }

            // Listar
            else if (opcao == 6) {

                for (int i = 0; i < nomes.size(); i++) {

                    double subtotal = quantidades.get(i) * precos.get(i);

                    System.out.println(
                        nomes.get(i) +
                        " | Quantidade: " + quantidades.get(i) +
                        " | Preço: R$ " + precos.get(i) +
                        " | Subtotal: R$ " + subtotal
                    );
                }
            }

            // Total
            else if (opcao == 7) {

                double total = 0;

                for (int i = 0; i < nomes.size(); i++) {
                    total += quantidades.get(i) * precos.get(i);
                }

                System.out.println("Valor total: R$ " + total);
            }

            // Maior subtotal
            else if (opcao == 8) {

                if (nomes.size() > 0) {

                    int maior = 0;

                    for (int i = 1; i < nomes.size(); i++) {

                        double subtotalAtual =
                            quantidades.get(i) * precos.get(i);

                        double subtotalMaior =
                            quantidades.get(maior) * precos.get(maior);

                        if (subtotalAtual > subtotalMaior) {
                            maior = i;
                        }
                    }

                    System.out.println(
                        "Maior subtotal: " + nomes.get(maior) +
                        " - R$ " +
                        (quantidades.get(maior) * precos.get(maior))
                    );

                } else {
                    System.out.println("Lista vazia!");
                }
            }
            else{
                System.out.println("Opcão Inválida");
            }

        } while (opcao != 0);

        System.out.println("Programa encerrado!");

        sc.close();
    }
}
