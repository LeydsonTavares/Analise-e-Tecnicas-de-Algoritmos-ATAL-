package br.com.guloso;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * @author leyds
 *
 */
public class Divisor {

	private static final int VALOR_INICIAL = 1000;
	private static final int VALOR_FINAL = 99999;
	private static final int CINCO_DIGITOS = 5;
	private static final int QUATRO_DIGITOS = 4;

	public static void main(String[] args) {
		
		int numero = Integer.valueOf(JOptionPane.showInputDialog("Digite o numero para encontrar os pares : "));

		while (numero != 0) {
			calcula(numero);
			numero = Integer.valueOf(JOptionPane.showInputDialog("Digite o numero para encontrar os pares : "));
		}
	}

	/**
	 * Método que verifica se Tem numero repetido
	 * 
	 * @param nmr1
	 * @param nmr2
	 * @param valor
	 * @return
	 */
	private static boolean Repeated(double nmr1, double nmr2, long valor) {

		long numberOne, numberTwo;
		String str1, str2;

		Set<Character> set1 = new HashSet<Character>(), set2 = new HashSet<Character>(),
				setAux = new HashSet<Character>();

		numberOne = (long) nmr1;
		numberTwo = (long) nmr2;
		str1 = numberOne + "";
		str2 = numberTwo + "";

		if (str1.length() == QUATRO_DIGITOS)
			str1 = "0" + str1;

		if (str2.length() == QUATRO_DIGITOS)
			str2 = "0" + str2;

		for (int i = 0; i < str1.length(); i++)
			set1.add(str1.charAt(i));

		for (int i = 0; i < str2.length(); i++)
			set2.add(str2.charAt(i));

		if (set1.size() != CINCO_DIGITOS || set2.size() != CINCO_DIGITOS)
			return true;

		setAux.addAll(set1);
		setAux.addAll(set2);

		if (setAux.size() == set1.size() + set2.size()) {

			return imprime(valor, str1, str2);
		}
		return true;
	}

	private static void calcula(int valor) {
		boolean contains = false;
		for (double i = VALOR_INICIAL; i < VALOR_FINAL; i++) {
			for (double j = VALOR_INICIAL; j < VALOR_FINAL; j++) {
				if (i / j == (double) valor && !Repeated(i, j, valor))
					contains = true;
			}
		}

		if (!contains) {
			System.out.println("There are no solutions for " + valor);
		}

	}

	/**
	 * Método que imprime os pares de números
	 * 
	 * @param valor
	 * @param str1
	 * @param str2
	 * @return false
	 */
	private static boolean imprime(long valor, String str1, String str2) {
		System.out.println(str1 + " / " + str2 + " = " + valor);
		return false;
	}

}
