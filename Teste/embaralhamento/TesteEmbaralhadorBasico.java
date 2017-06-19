package embaralhamento;

import org.junit.Test;

import Embaralhamento.EmbaralhadorSimples;

import static org.junit.Assert.*;

public class TesteEmbaralhadorBasico {

	@Test
	public void testeEmbaralhoDiferente(){
		EmbaralhadorSimples basico = new EmbaralhadorSimples();
		String diferente = basico.palavraEmbaralhada("testando");
		assertNotEquals(diferente, "testando");
	}

	@Test
	public void testeEmbaralhoPalavraMesmoTamanho(){
		String palavraOriginal = "formula";
		EmbaralhadorSimples basico = new EmbaralhadorSimples();
		String palavra = basico.palavraEmbaralhada(palavraOriginal);
		
		assertEquals(palavraOriginal.length(), palavra.length());
	}

    @Test
    public void testEmbaralharPalavraIgual() {
    	EmbaralhadorSimples basico = new EmbaralhadorSimples();
        String palavra = basico.palavraEmbaralhada("jabuticaba");

        assertEquals("bacatibuja", palavra);
    }
}