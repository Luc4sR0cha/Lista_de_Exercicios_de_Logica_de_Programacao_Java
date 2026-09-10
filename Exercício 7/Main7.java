/*
Desenvolva um programa que leia um vetor de números inteiros e um valor alvo. O programa deverá
localizar todos os pares de posições diferentes cujos valores somados sejam iguais ao alvo. Para cada par
encontrado, deverão ser apresentados:
● os dois valores;
● os índices em que eles aparecem;
● a soma obtida.

Uma mesma posição do vetor não poderá ser utilizada duas vezes no mesmo par e os pares não poderão
ser repetidos em ordem inversa. Por exemplo, um par formado pelos índices 2 e 5 não deverá ser
apresentado novamente como 5 e 2.

Ao final, o programa deverá informar a quantidade total de pares encontrados. Caso nenhum par exista,
deverá apresentar uma mensagem apropriada. A busca deverá ser implementada em um método que
percorra o vetor.
*/

import java.util.Scanner;

public class Main7 {
    
    public static void encontraParComSoma(int[] numeros, int alvo){
        int quantidadePares = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i+1; j < numeros.length; j++) {
                if (numeros[i] +numeros[j] == alvo){
                    if (quantidadePares > 0) {
                        System.out.println("Pares encontrados!");
                    }else {
                        
                        System.out.println("Novo par encontrados!");
                    }
                    System.out.println("Primeiro valor: " +numeros[i] + " | Indice: "+ (i+1));
                    System.out.println("Segundo valor: " +numeros[j] + " | Indice: "+ (j+1));

                    System.out.println(" ");

                    System.out.println("A soma dos valores é: " + (numeros[i] + numeros[j]));
                    quantidadePares++;
                }
            }
        }
        if (quantidadePares > 0){
            System.out.println("A quantidade de pares é: "+ quantidadePares);
        }else if(quantidadePares == 1){
            System.out.println("Foi encontrado apenas " +quantidadePares + " par cujo a soma dos valores dê" + alvo);
        }
        else{
            System.out.println("Não foi encontrado nenhum valor cujo a soma dos pares dê " + alvo);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite quantos números você gostaria de digitar? ");
        int n = sc.nextInt();

        int[]  numeros = new int[n];

        for (int i = 0; i< numeros.length; i++){
            System.out.println("Informe o número da posição "+ (i+1) + ": ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Qual o valor alvo?");
        int alvo = sc.nextInt();

        encontraParComSoma(numeros, alvo);
        
    }
}
