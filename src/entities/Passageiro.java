package entities;

import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario {
	public Passageiro() {
		super();
	}

	public Passageiro(String nome, String endereco, String email, String telefone, String senha) {
		super(nome, endereco, email, telefone, senha);
	}

	public List<Viagem> buscarCarona(List<Viagem> viagensCadastradas, Local partida, Local destino) {
		List<Viagem> viagensDisponiveis = new ArrayList<>();

		for (Viagem viagem : viagensCadastradas) {
			boolean pontoPartidaEncontrado = false;
			boolean pontoDestinoEncontrado = false;
			if (viagem.getProgresso() == false && viagem.getQuantidadeDeLugares() > 0) {
				for (Local local : viagem.getTrajeto()) {
					if (local.compararDistancia(partida) <= 5.0 && pontoPartidaEncontrado == false) {
						pontoPartidaEncontrado = true;
					}
					if (pontoPartidaEncontrado && local.compararDistancia(destino) <= 5.0) {
						pontoDestinoEncontrado = true;
					}
					if (pontoPartidaEncontrado && pontoDestinoEncontrado) {
						viagensDisponiveis.add(viagem);
						break;
					}
				}
			}
		}
		if (viagensDisponiveis.size() > 0)
			return viagensDisponiveis;
		else
			return null;
	}

}