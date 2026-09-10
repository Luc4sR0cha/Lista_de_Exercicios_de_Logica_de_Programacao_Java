/*
3. Calculadora interativa
Desenvolva uma calculadora de console que apresenta repetidamente o seguinte menu:.
1. soma;
2. subtração;
3. multiplicação;
4. divisão;
5. potenciação;
6. resto da divisão;
7. encerrar.
Após a seleção de uma operação, o programa deverá solicitar os valores necessários, executar o cálculo e
apresentar o resultado. Cada operação deverá ser implementada em um método próprio. Divisões por zero
e opções inexistentes deverão ser tratadas sem encerrar inesperadamente o programa.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

    Object[] dados = new Object[3];

    dados(dados);

    };

    public static void dados (Object[] dados) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Escolha uma operação: \n" +
                        "1. soma;\n" + 
                        "2. subtração;\n" + 
                        "3. multiplicação;\n" + 
                        "4. divisão;\n" + 
                        "5. potenciação;\n" + 
                        "6. resto da divisão;\n" + 
                        "7. encerrar.");

    String operacao = sc.nextLine();

    dados[0] = operacao;
    
    ArrayList<Double> valores = new ArrayList<Double>(); 

    boolean parar = false;
    int contador = 1;

    while (parar == false) {
        System.out.println("Digite o " + contador + "° número (obs: para sair digite 'sair'): ");
        String input = sc.nextLine().toLowerCase();

        if (input == "sair") {
            parar = true;
        }
        else{
            try {
                Double numero = Double.parseDouble(input);
                valores.add(numero);
            } catch (Exception e) {
                System.out.println("Digite um valor válido!!");
            }
        }
        
    }

    dados[1] = valores;

    sc.close();
    }

    public static void soma() {
        
    }
    public static void subtracao() {
        
    }
    public static void multiplicao() {
        
    }
    public static void divisao() {
        
    }
    public static void potenciacao() {
        
    }
    public static void restoDivisao() {
        
    }

    

   




   
}
