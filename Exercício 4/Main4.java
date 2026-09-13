    /* Analisador de texto
    Desenvolva um programa que leia uma frase completa e produza uma análise de seu conteúdo. O
    programa deverá informar:
    ● quantidade de caracteres;
    ● quantidade de letras;
    ● quantidade de vogais;
    ● quantidade de consoantes;
    ● quantidade de algarismos;
    ● quantidade de espaços;
    ● quantidade de outros caracteres;
    ● quantidade de palavras;
    ● maior palavra encontrada;
    ● frequência de uma letra escolhida pelo usuário.
    O programa também deverá verificar se a frase é um palíndromo, desconsiderando espaços, pontuação e
    diferenças entre letras maiúsculas e minúsculas. Organize cada operação principal em um método
    separado e percorra a string utilizando estruturas de repetição. */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma frase para realizar a verificação: ");
        String frase = sc.nextLine();

        analiseFrase(frase);
        palidromo(frase);
        
        System.out.println("Digite uma letra para verificar a frequência:");
        String letraUsuario = sc.nextLine();
        frequenciaLetra(frase, letraUsuario);

        sc.close();
    }

    public static void analiseFrase(String frase) {
        System.out.println("Seu texto possuí " + frase.length() + " caracteres!");
        String letras = frase.replaceAll("[^\\p{L}]", "");
        String semVogal = letras.replaceAll("[aeiouAEIOUáéíóúâêîôûãõüÁÉÍÓÚÂÊÎÔÛÃÕÜ]", ""); 
        String algarismos = frase.replaceAll("[^0-9]", ""); 

        System.out.println("Seu texto possuí " + letras.length() + " letras! (" + letras + ")");
        System.out.println("Seu texto possuí " + (letras.length() - semVogal.length()) + " vogais");
        System.out.println("Seu texto possuí " + semVogal.length() + " consoantes!");
        System.out.println("Seu texto possuí " + algarismos.length() + " algarismos!");
        System.out.println("Seu texto possuí " + frase.replaceAll("[^ ]", "").length() + " espaços!");
        System.out.println("Seu texto possuí " + (frase.length() - letras.length() - algarismos.length() - frase.replaceAll("[^ ]", "").length()) + " de outros caractéres!");

        String[] palavras = frase.replaceAll("[^\\p{L} ]", "").replaceAll("\\s+", " ").trim().split(" ");
        System.out.println("Seu texto possuí " + palavras.length + " palavras");
        
        List<String> maioresPalavras = new ArrayList<>();
        int maiorTamanho = 0;

        for (String palavra : palavras) {
            int tamanhoAtual = palavra.length();

            // 1. Se encontramos uma palavra maior que a anterior
            if (tamanhoAtual > maiorTamanho) {
                maiorTamanho = tamanhoAtual;
                maioresPalavras.clear(); // Limpa as antigas menores
                maioresPalavras.add(palavra); // Adiciona o novo limite
                
            // 2. Se encontramos outra palavra do mesmo tamanho da maior
            } else if (tamanhoAtual == maiorTamanho) {
                maioresPalavras.add(palavra); 
            }
        }

        if (maioresPalavras.size() == 1) {
            System.out.println("A maior palavra é: " + maioresPalavras.get(0));
        } 
        else {
            System.out.println("As maiores palavras são: " + maioresPalavras);
        }
    }

    public static void palidromo(String frase) {
        String textoLimpo = frase.toLowerCase().replaceAll("[^\\p{L}]", "");
        int inicio = 0;
        int fim = textoLimpo.length() - 1;
        boolean Palindromo = true;

        while (inicio < fim) {
            if (textoLimpo.charAt(inicio) != textoLimpo.charAt(fim)) {
                Palindromo = false;
                break;
            }
            inicio++;
            fim--;
        }

        if (Palindromo && !textoLimpo.isEmpty()) {
            System.out.println("A frase É um palíndromo!");
        } else {
            System.out.println("A frase NÃO é um palíndromo!");
        }
    }

    public static void frequenciaLetra(String frase, String letra) {
        if (letra.isEmpty()) return;
        
        char busca = Character.toLowerCase(letra.charAt(0));
        String fraseMinuscula = frase.toLowerCase();
        int contador = 0;

        for (int i = 0; i < fraseMinuscula.length(); i++) {
            if (fraseMinuscula.charAt(i) == busca) {
                contador++;
            }
        }
        System.out.println("A frequência da letra '" + busca + "' é: " + contador);
    }
}
