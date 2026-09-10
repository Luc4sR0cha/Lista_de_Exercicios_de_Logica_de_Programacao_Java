/* 2. Validação e análise de uma data
Desenvolva um programa que leia três números inteiros correspondentes ao dia, ao mês e ao ano de uma
data. O programa deverá verificar se a data informada é válida, considerando:   .
● a quantidade de dias de cada mês;.
● anos bissextos;
● valores inválidos para dia, mês ou ano.
Caso a data seja válida, o programa deverá informar também qual trimestre do ano ela pertence e qual é
sua posição no ano, considerando 1o de janeiro como o dia 1. Utilize métodos separados para verificar se
um ano é bissexto, obter a quantidade de dias de determinado mês, validar a data e calcular sua posição
no ano. */

import java.util.Scanner;

public class Main2 {

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        
        int contarDias = 0;

        int[] data = new int[3];

        coletarDados(data);
        
        boolean bissexto = verificarBissexto(data);

        boolean verificarData = verificarData(data, bissexto);
        
        if (verificarData) {
            contarDias = contarDias(data, bissexto);
        }
        else {
            print("Data inválida");
            System.exit(0);
        }

        int verificarTrimestre = verificarTrimestre(data[1]);

        print("");
        print("Data: Válida");
        print("Data: " + data[0] + "/" + data[1] + "/" + data[2]);
        print("Posição do ano: " + contarDias + " dias");
        print(bissexto ? "Ano é bissexto: sim" : "Ano é bissexto: não");
        print("Trimestre pertencente: " + verificarTrimestre + "°");
    }

    public static void coletarDados(int[] data) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a data, mês e o Ano separados por barra: (Ex: 03/09/2007, Obs: Ano mínimo 1900)");
        
        String dados = sc.nextLine();

        String[] stringDados = dados.split("/");

        for(int i = 0; i < data.length; i++){
            data[i] = Integer.parseInt(stringDados[i].trim());
        }
        sc.close();
    }

    public static boolean verificarBissexto(int[] data) {
        boolean verificarBissexto = false;

        if ((data[2] % 4 == 0 && data[2] % 100 != 0) || data[2] % 400 == 0) {
            verificarBissexto = true;
        }
        else {
            verificarBissexto = false;
        }

        return verificarBissexto;
    }

    public static boolean verificarData(int[] data, boolean bissexto) {
        if (data[0] <= 0 || data[1] <= 0 || data[1] > 12 || data[2] < 1900) {
            return false;
        }

        if (data[1] == 4 || data[1] == 6 || data[1] == 9 || data[1] == 11) {
            return data[0] <= 30;
        }
        else if (data[1] == 2) {
            if (bissexto) {
                return data[0] <= 29;
            } else {
                return data[0] <= 28;
            }
        }
        else {
            return data[0] <= 31;
        }
    } 

    public static int contarDias (int[] data, boolean bissexto) {
        int[] d30 = {4, 6, 9, 11};
        int[] d31 = {1,3,5,7,8,10,12};
        int dias = data[0];
        
        for(int i = 1; i < data[1]; i++){
            for (int j = 0; j < d30.length; j++){
                if (i == d30[j]){
                    dias += 30;
                }
            }
            for (int k = 0; k < d31.length; k++){
                if (i == d31[k]){
                    dias += 31;
                }
            }
            if (i == 2) {
                if (bissexto){
                    dias += 29;
                }
                else {
                    dias += 28;
                }
            }
        }

        return dias;
    }

    public static int verificarTrimestre(int mes) {
        int trimestre = 0;
        if (mes < 4) {
            trimestre = 1;
        }
        else if (mes < 7) {
            trimestre = 2;
        }
        else if (mes < 10) {
            trimestre = 3;
        }
        else if (mes <= 12) {
            trimestre = 4;
        }

        return trimestre;
    }
}