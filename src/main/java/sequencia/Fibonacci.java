package sequencia;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Solicita ao usuário que informe um número
		System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
		int numero = scanner.nextInt();

		if (isFibonacci(numero)) {
			System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
		} else {
			System.out.println("O número " + numero + " NÃO pertence à sequência de Fibonacci.");
		}

		scanner.close();
	}

	public static boolean isFibonacci(int numero) {
		if (numero < 0) {
			return false; // Números negativos não estão na sequência de Fibonacci
		}

		int a = 0, b = 1;

		// Gera a sequência de Fibonacci enquanto os valores não ultrapassarem o número
		// informado
		while (a <= numero) {
			if (a == numero) {
				return true; // Número encontrado na sequência
			}

			// Calcula o próximo número na sequência
			int proximo = a + b;
			a = b;
			b = proximo;
		}

		return false; // Número não encontrado na sequência
	}

}
