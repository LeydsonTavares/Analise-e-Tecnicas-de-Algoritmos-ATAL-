package br.com.guloso;

import javax.swing.JOptionPane;

public class Subconjunto {
	
	// numero inserido para gerar conjuntos
	private static int numero;
	
	// vetor que armazena os subconjuntos
	private static int vetorAux[];
	

	/**
	 * @param elemento base 
	 * @param numero do conjunto
	 */
	private static void subconjunto(int elemento, int numero) {

			imprimeSubconjunto(elemento, numero);
	}

	
	/**Método que imprime os Subconjuntos
	 * @param elemento
	 * @param numero
	 */
	private static void imprimeSubconjunto(int elemento, int numero) {
		if (elemento > numero) {
			System.out.printf("{");

			for (int posicao = 1; posicao <= numero; posicao++)
				if (vetorAux[posicao] == 1) {
					System.out.printf(" %d ", posicao);
				}

			System.out.printf("} \n");

		} else {
			
			vetorAux[elemento] = 1;
			subconjunto(elemento + 1, numero);
			vetorAux[elemento] = 0;
			subconjunto(elemento + 1, numero);
		}
	}

	public static void main(String[] args) {

		numero = Integer.valueOf(JOptionPane.showInputDialog("Digite o Numero?"));
		vetorAux = new int[numero+ 1];
		subconjunto(1, numero);
	}
}
