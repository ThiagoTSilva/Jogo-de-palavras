package Funcionalidade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

enum Nivel {
	Facil,
	Dificil
}

public class BancoDePalavras {
	
	private List<String> palavrasUsadas = new ArrayList<>();
	
	private List<String> jogo = new ArrayList<>();
	
	public BancoDePalavras(Nivel nivel){
		String file = nivel == nivel.Facil ? "Recurso/fases-faceis.txt" : "Recurso/fases-dificeis.txt";
		try {
			carregandoPalavras(file);
		} catch (Exception e) {
			carrengandoPalavrasSimples();
		}
	}

	private void carregandoPalavras(String file) throws FileNotFoundException {
		Scanner palavrasFile = new Scanner(new File(file)).useDelimiter("\n");
		while (palavrasFile.hasNext()) {
			jogo.add(palavrasFile.next());
		}
		palavrasFile.close();
	}
	
	private void carrengandoPalavrasSimples() {
		jogo.add("cão");
		jogo.add("pessoa");
		jogo.add("gato");
		jogo.add("sabão");
		jogo.add("água");
		jogo.add("peixe");
		jogo.add("vento");
		jogo.add("paralelepipedo");
		jogo.add("psicopneumaticoanalfamegabetico");
		jogo.add("analise");
		jogo.add("desenvolvimento");
	}

	public String getPalavra(){
		
		if (palavrasUsadas.size() == jogo.size()) {
			return null;
		}
		
		int indice = new Random().nextInt(jogo.size());
		String palavraEscohida = jogo.get(indice);
		
		 if (palavrasUsadas.contains(palavraEscohida)) {
			return getPalavra();
		}
		
		 palavrasUsadas.add(palavraEscohida);
		
		return palavraEscohida.toLowerCase();
		
	}
	
}
