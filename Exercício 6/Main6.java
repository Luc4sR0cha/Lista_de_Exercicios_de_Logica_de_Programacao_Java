/*6. Ranking de tempos de uma competição

Desenvolva um programa para registrar os resultados de uma competição. Inicialmente, o usuário deverá informar a quantidade de participantes. Em seguida, deverão ser armazenados em vetores paralelos:

- O nome de cada participante;

- O tempo, em segundos, utilizado para concluir a prova.

O programa deverá:

- Calcular o tempo médio;

- Identificar o participante mais rápido e o mais lento;

- Informar quantos participantes ficaram abaixo do tempo médio;

- Ordenar os participantes do menor para o maior tempo;

- Apresentar na tela o ranking completo com os nomes e tempo de cada participante;

- Calcular a mediana e o desvio padrão dos tempos.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main6{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean repetir = true;
        int posicao = 0;
        ArrayList<String> nome = new ArrayList<>();
        ArrayList<Integer> tempo = new ArrayList<>();
        double mediana = 0;
        double desvio_padrao = 0;

        System.out.println("Escreva a quantidade de participantes: ");
        int particQuant = sc.nextInt();

        while (repetir == true) {

            posicao++;

            sc.nextLine();

            System.out.println("Escreva o nome do participante " + posicao + ": ");

            nome = nomes(sc.nextLine(), nome);

            System.out.println("Escreva o tempo do participante " + posicao + " em segundos: ");

            tempo = tempos(sc.nextInt(), tempo);

            int particList = tempo.size();

            if (particList == particQuant) {
                repetir = false;
            }
        }

        sc.close();

        double media = media(particQuant, tempo);

        int menorMedia = menorMedia(media, particQuant, tempo);

        int maxTempo = Collections.max(tempo);
        int minTempo = Collections.min(tempo);

        ArrayList<String> nomesRank = NomesRank(tempo, nome);

        ArrayList<Integer> temposRank = temposRank(tempo);

        mediana = mediana(temposRank);
        desvio_padrao = desvio_padrao(media, temposRank);

        System.out.println("=======================================");
        System.out.println("");
        System.out.println("Participantes e seus respectivos tempos: ");
        System.out.println("");
        for(int i = 0; i < nomesRank.size(); i++){
            System.out.println((i + 1) + "º " + nomesRank.get(i) + " tempo: " + temposRank.get(i));
            System.out.println("");
        }
        System.out.println("=======================================");
        System.out.println("");
        System.out.printf("Média geral dos tempos: %.2f\n", media);
        System.out.println("Quantidade de participantes abaixo da média: " + menorMedia);
        System.out.println("O maior tempo foi de: " + maxTempo);
        System.out.println("O maior tempo foi de: " + minTempo);
        System.out.printf("A mediana dos tempos dos participantes foi: %.2f\n", mediana);
        System.out.printf("O desvio padrao dos tempos foi: %.2f\n", desvio_padrao);
        System.out.println("");
        System.out.println("=======================================");
    }

    public static ArrayList<String> nomes(String nome, ArrayList<String> nomesLista) {

        nomesLista.add(nome);

        return nomesLista;
    }

    public static ArrayList<Integer> tempos(Integer tempo, ArrayList<Integer> temposLista) {

        temposLista.add(tempo);

        return temposLista;
    }

    public static double media(Integer particQuant, ArrayList<Integer> tempo) {
        double soma_tempo = 0;
        for (int i = 0; i < particQuant; i++) {
            soma_tempo += tempo.get(i);
        }
        double media = soma_tempo / particQuant;
        return media;
    }

    public static int menorMedia(double media, int particQuant, ArrayList<Integer> tempo) {
        Integer menorMedia = 0;

        for (int i = 0; i < particQuant; i++) {
            if (tempo.get(i) < media) {
                menorMedia++;
            }
        }
        return menorMedia;
    }

    public static ArrayList<String> NomesRank (ArrayList<Integer> tempos, ArrayList<String> nomes) {
        int tempVar;
        String tempNome;

        for (int i = 0; i < tempos.size(); i++) {

            for (int j = 0; j < tempos.size() - 1; j++) {
            
    
                if (tempos.get(j) > tempos.get(j + 1)) {
                
        
                    tempVar = tempos.get(j + 1);
                    tempos.set(j + 1, tempos.get(j));
                    tempos.set(j, tempVar);
                    
                
                    tempNome = nomes.get(j + 1);
                    nomes.set(j + 1, nomes.get(j));
                    nomes.set(j, tempNome);
                }
            }
        }     

        return nomes;
    }

    public static ArrayList<Integer> temposRank (ArrayList<Integer> tempos) {
        int tempVar;

        for (int i = 0; i < tempos.size(); i++) {

            for (int j = 0; j < tempos.size() - 1; j++) {
            
    
                if (tempos.get(j) > tempos.get(j + 1)) {
                
        
                    tempVar = tempos.get(j + 1);
                    tempos.set(j + 1, tempos.get(j));
                    tempos.set(j, tempVar);
                    
                }
            }
        }     

        return tempos;
    }

    public static double mediana (ArrayList<Integer> temposRank) {
        double v1 = 0;
        double v2 = 0;
        double mediana = 0;
        if (temposRank.size() % 2 == 0) {
            v1 = temposRank.get(temposRank.size() / 2  - 1);
            v2 = temposRank.get(temposRank.size() / 2);
            mediana = (v1 + v2) / 2;     
        }
        else {
            mediana = temposRank.get(temposRank.size() / 2);
        }
        return mediana;
    }

    public static double desvio_padrao (double media, ArrayList<Integer> tempos) {
        double desvio_padrao = 0;
        double diferenca = 0;
        double variancia = 0;

        for (int i = 0; i < tempos.size(); i++){
            diferenca = tempos.get(i) - media;
            variancia += diferenca * diferenca;
        }

        variancia = variancia / tempos.size();
        desvio_padrao = Math.sqrt(variancia);
        return desvio_padrao;
    }
}
