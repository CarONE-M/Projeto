package entities;

import java.util.List;

public class Motorista extends Usuario {

	// Construtores
	public Motorista() {
		super();
	}

	public Motorista(String nome, String endereco, String email, String telefone, String senha) {
		super(nome, endereco, email, telefone, senha);
	}

	// Consular passageiro de uma viagem específica
	public List<Passageiro> consultarPassageiros(Viagem viagem) {
		if (getViagens().contains(viagem)) {
			return viagem.getPassageiros();
		}
		return null;
	}

	// Retornar a média das avaliações de todas as viagens
	public Double getMediaDeAvaliacoes() {
		double soma = 0.0;
		int qtdAvaliacoes = 0;
		for (Viagem viagem : this.getViagens()) {
			for (Avaliacao avaliacao : viagem.getAvaliacoes()) {
				soma += avaliacao.getNota();
				qtdAvaliacoes += 1;
			}
		}
		if (qtdAvaliacoes > 0) {
			double media = soma / qtdAvaliacoes;
			return media;
		} else {
			return null;
		}
	}

	// Exibir os comentários das avaliações de cada viagem
	public void exibirComentarios() {
		for (Viagem viagem : this.getViagens()) {
			System.out.println(viagem.resumoViagem());
			if (viagem.getAvaliacoes().size() > 0) {
				for (Avaliacao avaliacao : viagem.getAvaliacoes()) {
					System.out.println("Comentarios:");
					if (avaliacao.getComentario() != "" || avaliacao.getComentario() != null) {
						System.out.println(avaliacao.getComentario());
					} else {
						System.out.println("-- avaliação sem comentarios --");
					}
				}
			} else
				System.out.println("sem comentários ainda...");
		}
	}
}
