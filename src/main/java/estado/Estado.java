package estado;

import java.util.LinkedHashMap;
import java.util.Map;

public class Estado {
	public static void main(String[] args) {
		
		// Faturamento por estado
		
		Map<String, Double> faturamentoPorEstado = new LinkedHashMap<>();
		faturamentoPorEstado.put("SP", 67836.43);
		faturamentoPorEstado.put("RJ", 36678.66);
		faturamentoPorEstado.put("MG", 29229.88);
		faturamentoPorEstado.put("ES", 27165.48);
		faturamentoPorEstado.put("Outros", 19849.53);

		// Calcula o faturamento total
		
		double faturamentoTotal = 0.0;
		for (double valor : faturamentoPorEstado.values()) {
			faturamentoTotal += valor;
		}

		// Exibe o percentual de representação de cada estado
		
		System.out.println("Percentual de representação por estado:");
		for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
			String estado = entry.getKey();
			double valor = entry.getValue();
			double percentual = (valor / faturamentoTotal) * 100;
			System.out.printf("%s: %.2f%%%n", estado, percentual);
		}
	}
}
