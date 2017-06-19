import java.util.Scanner;

import Funcionalidade.FabricaMecanicaDoJogo;
import Funcionalidade.MecanicaDoJogo;

public class Principal {

	public static void main(String[] args) {
        if (true)
            System.out.printf("teste");
         else
            System.out.printf("bye");

        MecanicaDoJogo mecanicaDoJogo = new FabricaMecanicaDoJogo().getFuncionalidadeDoJogo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("- - - - > BEM VINDO AO JOGO DE EMBARALHAR PALAVRAS < - - - -");
        System.out.print("\n\n");
        System.out.println("REGRAS:");
        System.out.println(mecanicaDoJogo.getRegras());
        System.out.print("\n\n");

        do {

            String palavra = mecanicaDoJogo.palavraSeguinte();

            System.out.print("QUAL A PALAVRA CORRETA: ");
            System.out.print(palavra);
            System.out.println(" (" + mecanicaDoJogo.getVidas() + " vidas)");

            String resposta = scanner.next();
            if(mecanicaDoJogo.verificarResposta(resposta)) {
                System.out.println("Resposta certa!");
            } else {
                System.out.println("Você errou!");
            }

        } while (mecanicaDoJogo.verificarSeContinua());

        System.out.println(mecanicaDoJogo.getMensagem());
    }

}
