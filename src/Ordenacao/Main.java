package Ordenacao;

import java.util.Random;

public class Main {

    private static int COMPARACOES_RADIX = 0;
    private static int COMPARACOES_BUBBlE = 0;
    private static int COMPARACOES_QUICK = 0;


    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = split(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int split(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {

            if (vetor[i] <= pivo) {
                COMPARACOES_QUICK++;
                i++;
            }
            else if (pivo < vetor[f]) {
                f--;
                COMPARACOES_QUICK++;
            }
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    private static void bubbleSort(int[] vet){
        int aux;
        int i;

        for(i = 0; i<vet.length; i++){
            for(int j = 0; j<(vet.length-1); j++){
                if(vet[j] > vet[j + 1]){
                    COMPARACOES_BUBBlE++;
                    aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
            }
        }
    }
    private static void radixSort(int vector[]){
        for(int digit = 0; digit < 3; digit ++){
            int power = (int) Math.pow(10, digit+1);

            int z[][] = new int[vector.length][10];
            int n[] = new int[10];

            for (int num : vector) {
                z[n[(num % power) / (power / 10)]][(num % power) / (power / 10)] = num;
                n[(num % power) / (power / 10)]++;

            }
            int c = 0;
            for(int i = 0; i < 10; i ++){

                for(int j = 0; j < vector.length; j ++){
                    if(j < n[i]){
                        COMPARACOES_RADIX++;
                        vector[c] = z[j][i];
                        c++;
                    }else{break;}
                }
            }

        }
    }
    public static void main(String[] args) {

        Random random = new Random();
        int[] vetor_bubble = new int[1000];
        int[] vetor_radix = new int[1000];
        int[] vetor_quick = new int[1000];

        System.out.println("Vetor desordenado:");
        for (int i = 0; i < vetor_bubble.length; i++) {
            vetor_bubble[i] = random.nextInt(1000);
        }

        for (int i = 0; i <vetor_bubble.length ; i++) {
            vetor_quick[i] = vetor_bubble[i];
            vetor_radix[i] = vetor_bubble[i];
        }


        for (double aVetor : vetor_bubble) {
            System.out.println(aVetor);

        }

        bubbleSort(vetor_bubble);

        System.out.println("Vetor ordenado:");
        for (double aVetor : vetor_bubble) {
            System.out.println(aVetor);

        }
        System.out.println("Comparações com o bubbleSort: " + COMPARACOES_BUBBlE);


        radixSort(vetor_radix);

        System.out.println("Vetor ordenado:");
        for (int aVetor : vetor_radix) {
            System.out.println(aVetor);

        }
        System.out.println("Comparações com o radix: " + COMPARACOES_RADIX);


        quickSort(vetor_quick,0,vetor_quick.length-1);

        System.out.println("Vetor ordenado:");
        for (int aVetor : vetor_radix) {
            System.out.println(aVetor);

        }
        System.out.println("Comparações com o quick: " + COMPARACOES_QUICK);

    }
}
