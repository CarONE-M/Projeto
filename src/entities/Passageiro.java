package entities;

import java.util.List;

public class Passageiro extends Usuario {
	public Passageiro() {
		super();
	}

	public Passageiro(String nome, String endereco, String email, String telefone, String senha) {
		super(nome, endereco, email, telefone, senha);
	}
	
	public Viagem buscarCarona(List<Viagem> viagensDisponiveis, Local partida, Local destino) {
	    for (Viagem viagem : viagensDisponiveis) {
	        if (viagem.getPontoDePartida().compararDistancia(partida) <= 2.0 && viagem.getDestino().compararDistancia(destino) <= 2.0) {
	            return viagem;
	        }
	    }
	    return null;
	}

}
