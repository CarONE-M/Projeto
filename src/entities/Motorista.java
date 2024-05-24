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
		if (this.getViagens().contains(viagem)) {
			return viagem.getPassageiros();
		}
		return null;
	}

	// Retornar a média das avaliações de todas as viagens
	public String getMediaDeAvaliacoes() {
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
			return String.format("Nota geral: %.2f", media);
		} else {
			return "Nenhuma avaliação disponível!";
		}
	}

	// Exibir os comentários das avaliações de cada viagem
	public void exibirComentarios() {
		for (Viagem viagem : this.getViagens()) {
			System.out.println(viagem.resumoViagem());
			if (viagem.getAvaliacoes().size() > 0) {
				for (Avaliacao avaliacao : viagem.getAvaliacoes()) {
					if (avaliacao.getComentario() != "" || avaliacao.getComentario() != null) {
						System.out.println(avaliacao.getComentario());
					} else {
						System.out.println("-- avaliação sem comentarios --");
					}
				}
			} else
				System.out.println("\nSem comentários ainda!");
		}
	}

	public void aceitarPassageiro(Passageiro passageiro, Viagem viagem) {
		if (viagem.getQuantidadeDeLugares() > 0) {
			viagem.addPassageiros(passageiro);
		}else {
			System.out.println("Desculpe. Limite de passageiros atingido.");
			viagem.removeEspera(passageiro);
		}
	}
}
