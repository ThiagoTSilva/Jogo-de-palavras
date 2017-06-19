package Embaralhamento;


public class EmbaralhadorSimples implements Embaralhador {

	  public String palavraEmbaralhada(String palavra) {
			StringBuilder palavraJogo = new StringBuilder();
			
			String [] jogo = palavra.split("");
			
			for (int i = jogo.length -1; i >= 0 ; i--) {
				String palavraCorrente = jogo[i];
				
				if (i-1 >= 0) {
					String palavraAvancada = jogo[--i];
					palavraJogo.append(palavraAvancada);
					}
				palavraJogo.append(palavraCorrente);
			}
			
			return palavraJogo.toString(); 
		}

}

