package Funcionalidade;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class FabricaMecanicaDoJogo {
	private ArrayList<MecanicaDoJogo> mecanicas;
	
	public FabricaMecanicaDoJogo() {
        mecanicas = new ArrayList<MecanicaDoJogo>();
        mecanicas.add(new NivelFacil());
        mecanicas.add(new NivelDificil());
    }


    public FabricaMecanicaDoJogo(List<MecanicaDoJogo> mecanicas) {
        this.mecanicas = (ArrayList<MecanicaDoJogo>) mecanicas;
    }

    public MecanicaDoJogo getFuncionalidadeDoJogo() {
        int randomItem = new Random().nextInt(mecanicas.size());
        return mecanicas.get(randomItem);
    }
}
