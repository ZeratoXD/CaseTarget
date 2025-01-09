package distribuidora;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

	    public static void main(String[] args) {
	        String caminhoArquivo = "faturamento.json";

	        try {
	            // Lê os dados do JSON
	            List<DiaFaturamento> faturamento = carregarFaturamento(caminhoArquivo);

	            // Calcula menor, maior e média
	            double menorValor = Double.MAX_VALUE;
	            double maiorValor = Double.MIN_VALUE;
	            double somaValores = 0.0;
	            int diasComFaturamento = 0;

	            for (DiaFaturamento dia : faturamento) {
	                if (dia.getValor() > 0) { // Ignora dias sem faturamento
	                    if (dia.getValor() < menorValor) {
	                        menorValor = dia.getValor();
	                    }
	                    if (dia.getValor() > maiorValor) {
	                        maiorValor = dia.getValor();
	                    }
	                    somaValores += dia.getValor();
	                    diasComFaturamento++;
	                }
	            }

	            // Calcula a média mensal (somente dias com faturamento)
	            double mediaMensal = somaValores / diasComFaturamento;

	            // Conta os dias com faturamento acima da média
	            int diasAcimaDaMedia = 0;
	            for (DiaFaturamento dia : faturamento) {
	                if (dia.getValor() > mediaMensal) {
	                    diasAcimaDaMedia++;
	                }
	            }

	            // Exibe os resultados
	            System.out.println("Menor valor de faturamento: " + menorValor);
	            System.out.println("Maior valor de faturamento: " + maiorValor);
	            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
	        }
	    }

	    /**
	     * Carrega o faturamento de um arquivo JSON.
	     *
	     * @param caminhoArquivo Caminho para o arquivo JSON
	     * @return Lista de objetos DiaFaturamento
	     * @throws IOException Se ocorrer um erro ao ler o arquivo
	     */
	    public static List<DiaFaturamento> carregarFaturamento(String caminhoArquivo) throws IOException {
	        Gson gson = new Gson();
	        Type listType = new TypeToken<ArrayList<DiaFaturamento>>() {}.getType();
	        FileReader reader = new FileReader(caminhoArquivo);
	        List<DiaFaturamento> faturamento = gson.fromJson(reader, listType);
	        reader.close();
	        return faturamento;
	    }

	    /**
	     * Classe representando o faturamento diário.
	     */
	    static class DiaFaturamento {
	        private int dia;
	        private double valor;

	        public int getDia() {
	            return dia;
	        }

	        public double getValor() {
	            return valor;
	        }
	    }
	}


