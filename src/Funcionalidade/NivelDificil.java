package Funcionalidade;

import Embaralhamento.Embaralhador;
import Embaralhamento.FabricaEmbaralhadores;

public class NivelDificil implements MecanicaDoJogo {

	private Embaralhador embaralhador;
	private BancoDePalavras bancoDePalavras;
	private int vidas = 5;
	private int erros = 0;
	private String palavraDaVez;
	private String mensagem;
	
	public NivelDificil(){
		this.bancoDePalavras = new BancoDePalavras(Nivel.Dificil);
		
	}
	
	public String palavraSeguinte() {
		if (palavraDaVez != null) {
            return embaralhador.palavraEmbaralhada(palavraDaVez);
        }
		
		embaralhador = fazendoEmbaralhador();
        palavraDaVez = bancoDePalavras.getPalavra();
        if (palavraDaVez != null) {
            return embaralhador.palavraEmbaralhada(palavraDaVez);
        }
        return null;
	}

	public boolean verificarSeContinua() {
		if (!possuiVidas()) {
            setMensagem("=( acabaram as vidas!. O Jogo acabou!");
            return false;
        } else if (possuiErrosSeguidos()) {
            setMensagem("Você errou a jogada anterior, não pode mais errar");
            return false;
        } else if (palavraSeguinte() == null) {
            setMensagem("INCRÍVEL!!!! Você venceu a máquina. Não existem mais palavras.");
            return false;
        }

        return true;
	}
	
	private void finalizaRodada(boolean respostaCorreta) {
        palavraDaVez = null;

        if (!respostaCorreta) {
            retiraVida();
            erros++;
        }
    }

	public boolean verificarResposta(String resposta) {
		 boolean respostaCerta = resposta.toLowerCase().equals(palavraDaVez);

	        finalizaRodada(respostaCerta);

	        return respostaCerta;
	}
	

	private boolean possuiVidas() {
        return vidas > 0;
    }
	
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getRegras() {
		StringBuilder regras = new StringBuilder();
        regras.append("REGRAS DA MECÂNICA DIFICIL\n");
        regras.append("- O Banco de Palavras escolhido contém palavras raras.\n");
        regras.append("- Os embaralhadores podem mudar a cada nova palavra.\n");
        regras.append("- Você possui 5 vidas mas NÃO PODE cometer erros seguidos.");

        return regras.toString();
	}
	
	private Embaralhador fazendoEmbaralhador() {
        return new FabricaEmbaralhadores().getEmbaralhador();
    }
	

    private boolean possuiErrosSeguidos() {
        return erros > 1;
    }
    
    private void retiraVida() {
        --vidas;
    }

	public int getVidas() {
		return vidas;
	}

}
