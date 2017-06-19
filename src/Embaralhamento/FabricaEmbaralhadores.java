package Embaralhamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {
	private List<Embaralhador> aleatorio;
	
	public FabricaEmbaralhadores() {
		aleatorio = new ArrayList<>();
		aleatorio.add(new Aleatorio());
	}
	
	public FabricaEmbaralhadores(List<Embaralhador> aleatorio) {
		this.aleatorio = aleatorio;
	}

	public Embaralhador getEmbaralhador() {
		int itemAleatorio = new Random().nextInt(aleatorio.size());
		return aleatorio.get(itemAleatorio);
	}
	
}
