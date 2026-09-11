import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Main3 {

    public static void main(String[] args) {

        Object[] dados = new Object[3];

        dados(dados);

        switch ((int) dados[0]) {
            case 1:
                soma((ArrayList<Double>) dados[1], dados);
                break;
            case 2:
                subtracao((ArrayList<Double>) dados[1], dados);
                break;
            case 3:
                multiplicao((ArrayList<Double>) dados[1], dados);
                break;
            case 4:
                divisao((ArrayList<Double>) dados[1], dados);
                break;
            case 5:
                potenciacao((ArrayList<Double>) dados[1], dados);
                break;
            case 6:
                restoDivisao((ArrayList<Double>) dados[1], dados);
                break;
            default:
                System.out.println("Opção Inválida, programa encerrado");
                System.exit(0);
                break;
        }

        if (dados[2] != null) {
            System.out.println("O resultado da conta é: " + dados[2]);
        }
    }

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

        int operacao = sc.nextInt();
        sc.nextLine(); 

        if (operacao == 7) {
            System.out.println("Programa encerrado.");
            System.exit(0);
        }

        dados[0] = operacao;
        
        ArrayList<Double> valores = new ArrayList<Double>(); 

        boolean parar = false;
        int contador = 1;

        while (parar == false) {
            System.out.println("Digite o " + contador + "° número (obs: para sair digite 'sair'): ");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("sair")) { 
                if (valores.size() < 2) {
                    System.out.println("Números insuficientes para realizar o cálculo.");
                    System.exit(0);
                }
                parar = true;
            }
            else{
                try {
                    Double numero = Double.parseDouble(input);
                    valores.add(numero);
                    contador++; 
                } catch (Exception e) {
                    System.out.println("Digite um valor válido!!");
                }
            }
        }

        dados[1] = valores;
    }

    public static void soma(ArrayList<Double> valores, Object[] dados) {
        Double resultado = 0.0;
        for(int i = 0; i < valores.size(); i++){
            resultado += valores.get(i); 
        }
        dados[2] = resultado;
    }

    public static void subtracao(ArrayList<Double> valores, Object[] dados) {
        Double resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++){
            resultado -= valores.get(i); 
        }
        dados[2] = resultado;
    }

    public static void multiplicao(ArrayList<Double> valores, Object[] dados) {
        Double resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++){
            resultado = resultado * valores.get(i);
        }
        dados[2] = resultado;
    }

    public static void divisao(ArrayList<Double> valores, Object[] dados) {
        for(int i = 1; i < valores.size(); i++){
            if (valores.get(i) == 0){
                System.out.println("Não é possível dividir por zero!");
                dados[2] = null;
                return;
            }
        }
        Double resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++){
            resultado = resultado / valores.get(i);
        }
        dados[2] = resultado;
    }

    public static void potenciacao(ArrayList<Double> valores, Object[] dados) {
        Double resultado = valores.get(0);
        for(int i = 1; i < valores.size(); i++){
            resultado = Math.pow(resultado, valores.get(i));
        }
        dados[2] = resultado;
    }

    public static void restoDivisao(ArrayList<Double> valores, Object[] dados) {

    for(int i = 1; i < valores.size(); i++){
        if (valores.get(i) == 0){
            System.out.println("Não é possível dividir por zero!");
            dados[2] = null;
            return;
        }
    }


    Double resultado = valores.get(0);
    
    for(int i = 1; i < valores.size() - 1; i++){
        resultado = resultado / valores.get(i);
    }
    
    resultado = resultado % valores.get(valores.size() - 1);
    
    dados[2] = resultado;
}
}
