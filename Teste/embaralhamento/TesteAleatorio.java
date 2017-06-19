package embaralhamento;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Embaralhamento.Aleatorio;
import Embaralhamento.Embaralhador;
import Embaralhamento.EmbaralhadorSimples;

public class TesteAleatorio {

	@Test
    public void testePalavraIgual() {
        Aleatorio aleatorico = new Aleatorio();
        String palavra = aleatorico.palavraEmbaralhada("peixe");
        
        List<String> palavrasPossiveis = Arrays.asList(new String[] {"eeixp", "piexe", "eixep"});

        assertEquals(true, palavrasPossiveis.contains(palavra));
    }
	
	@Test
	public void TesteResultadoDiferente(){
		Aleatorio basico = new Aleatorio();
		String palavra = basico.palavraEmbaralhada("boss");
		assertNotEquals(palavra, "boss");
	}     
	
	@Test
    public void testeEmbaralharPalavraTamanhoIgual(){
        String palavraOriginal = "glorioso";
        Aleatorio Basico = new Aleatorio();
        String palavra = Basico.palavraEmbaralhada(palavraOriginal);

        assertEquals(palavraOriginal.length(), palavra.length());
    }

}
