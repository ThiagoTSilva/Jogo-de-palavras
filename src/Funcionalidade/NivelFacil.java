package Funcionalidade;

import Embaralhamento.Embaralhador;
import Embaralhamento.FabricaEmbaralhadores;

public class NivelFacil implements MecanicaDoJogo {
	
	private Embaralhador embaralhador;
	private BancoDePalavras bancoDePalavras;
	private int vidas = 5;
	private String palavraDaVez;
	private String mensagem;
	
	
	public NivelFacil() {
		this.bancoDePalavras = new BancoDePalavras(Nivel.Facil);
		this.embaralhador = new FabricaEmbaralhadores().getEmbaralhador();
	}
	
	public String getRegras() {
		StringBuilder regras = new StringBuilder();
		regras.append("REGRAS DA MECÂNICA FÁCIL\n");
		regras.append("- O banco possui palavras simples. \n");
		regras.append("- As palavras aleatorias não muda ao longo do jogo \n");
		regras.append("- Você possui 5 vezes");
		
		return regras.toString();
	}
	
	public String palavraSeguinte() {
		if (palavraDaVez == null) {
			palavraDaVez = bancoDePalavras.getPalavra();
		}
		if (palavraDaVez == null) {
			return null;
		}
		return palavraEmbaralha(palavraDaVez);
	}
	
	private String palavraEmbaralha(String palavra){
		return embaralhador.palavraEmbaralhada(palavra);
	}

	public boolean verificarSeContinua() {
		if (vidas < 1) {
			setMensagem("=( aabaram as vidas!. O jogo acabou!");
			return false;
		} else if (palavraSeguinte() == null){
			setMensagem("INCRÍVEL!!! você venceu a máquina. não existem mais palavras");
			return false;
		}
		return true;
	}

	public boolean verificarResposta(String resposta) {
		boolean respostaCorreta = resposta.toLowerCase().equals(palavraDaVez);
		finalizaRodada(respostaCorreta);
		return respostaCorreta;
	}

	private void finalizaRodada(boolean respostaCorreta) {
		palavraDaVez = null;
		
		if (!respostaCorreta) {
			retirarVidas();
		}
		
	}


	private void retirarVidas() {
		--vidas;		
	}
	
	public int getVidas() {
		return vidas;
	}

	
	public void setMensagem(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}


}
