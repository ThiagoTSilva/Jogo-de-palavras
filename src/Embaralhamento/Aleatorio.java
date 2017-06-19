package Embaralhamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Aleatorio implements Embaralhador {
	
		private String PalavraInicial;

	public String palavraEmbaralhada(String palavra) {
		this.PalavraInicial = PalavraInicial;
		StringBuilder palavraJogo = new StringBuilder();
		ArrayList<String> letras = new ArrayList<>(Arrays.asList(palavra.split("")));
		
		while (palavraJogo.length() < palavra.length()) {
			
			int indice = new Random().nextInt(letras.size());
			palavraJogo.append(letras.remove(indice));
		}
		
		return palavraJogo.reverse().toString();
	}

}
