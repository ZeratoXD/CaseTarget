package inverter;

import java.util.Scanner;

public class Inverter {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que informe uma string
        System.out.print("Informe uma string para inverter: ");
        String input = scanner.nextLine();

        // Chama a função que inverte a string
        String invertida = inverterString(input);

        // Exibe o resultado
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }

    /**
     * Inverte os caracteres de uma string.
     *
     * @param str A string de entrada
     * @return A string invertida
     */
    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;

        // Troca os caracteres do início e do fim até o meio da string
        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }

        return new String(caracteres);
    }
}


