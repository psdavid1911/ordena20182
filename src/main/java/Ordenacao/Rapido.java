package Ordenacao;

import Base.Lista;

public class Rapido {

    public static Lista<Integer> ordena(Lista<Integer> vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            ordena(vetor, inicio, posicaoPivo - 1);
            ordena(vetor, posicaoPivo + 1, fim);
        }
        return vetor;
    }

    public static int separar(Lista<Integer> vetor, int inicio, int fim) {
        int pivo = vetor.get(inicio);
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor.get(i) <= pivo) {
                i++;
            } else if (pivo < vetor.get(f)) {
                f--;
            } else {
                vetor.trocaElementos(i, f);
                i++;
                f--;
            }
        }
        vetor.set(inicio, vetor.get(f));
        vetor.set(f, pivo);
        return f;
    }
}
