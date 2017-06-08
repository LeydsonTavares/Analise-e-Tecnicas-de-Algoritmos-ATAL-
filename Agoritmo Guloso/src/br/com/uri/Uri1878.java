package br.com.uri;

import java.util.HashSet;
import java.util.Scanner;

public class Uri1878 {

	static int f(int[] coeficiente, int i, int j) {
		return coeficiente[0] * i + coeficiente[1] * j;
	}

	static int f(int[] coeficiente, int i, int j, int k) {
		return coeficiente[0] * i + coeficiente[1] * j + coeficiente[2] * k;
	}

	public static void main(String[] args) {

		int numConcurso, numAluno;

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String entrada1 = scanner.nextLine();
			String[] valores = entrada1.split(" ");

			numConcurso = Integer.parseInt(valores[0]);
			numAluno = Integer.parseInt(valores[1]);

			int[] coeficiente = new int[numConcurso];

			String entrada2 = scanner.nextLine();
			String[] valoresEntrada2 = entrada2.split(" ");

			for (int i = 0; i < numConcurso; i++) {
				coeficiente[i] = Integer.parseInt(valoresEntrada2[i]);
			}

			if (numConcurso == 1) {
				System.out.println("Lucky Denis!");
				continue;
			}
			if (numConcurso == 2) {
				HashSet<Integer> conjunto = new HashSet<Integer>();
				int ok = 1;
				for (int i = 0; i < numAluno && ok != 0; ++i) {
					for (int j = 0; j < numAluno && ok != 0; ++j) {
						if (conjunto.contains(f(coeficiente, i, j))) {
							ok = 0;
						} else {
							conjunto.add(f(coeficiente, i, j));
						}
					}
				}
				if (ok == 1)
					System.out.println("Lucky Denis!");
				else
					System.out.println("Try again later, Denis...");

				continue;

			}

			HashSet<Integer> conjunto = new HashSet<Integer>();
			int ok = 1;
			for (int i = 0; i < numAluno && ok != 0; ++i) {
				for (int j = 0; j < numAluno && ok != 0; ++j) {
					for (int k = 0; k < numAluno && ok != 0; ++k) {
						if (conjunto.contains(f(coeficiente, i, j, k))) {
							ok = 0;
						} else {
							conjunto.add(f(coeficiente, i, j, k));
						}
					}
				}

			}
			if (ok == 1)
				System.out.println("Lucky Denis!");
			else
				System.out.println("Try again later, Denis...");

			continue;

		}
	}

}
