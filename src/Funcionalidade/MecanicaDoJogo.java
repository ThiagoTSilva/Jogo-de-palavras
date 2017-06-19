package Funcionalidade;

public interface MecanicaDoJogo {
	String palavraSeguinte();
	boolean verificarSeContinua();
	boolean verificarResposta(String resposta);
	int getVidas();
	String getMensagem();
	String getRegras();

}
