package entities;

import java.util.List;
import java.util.ArrayList;

public class Viagem {
	private Integer quantidadeDeLugares;
	private Local pontoDePartida;
	private Local destino;
	private Motorista motorista;
	private Boolean progresso = false;
	private List<Local> trajeto = new ArrayList<Local>();
	private List<Passageiro> passageiros = new ArrayList<Passageiro>();
	private List<Passageiro> espera = new ArrayList<Passageiro>();
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

	// Contrustores
	public Viagem() {
	}

	public Viagem(Integer quantidadeDeLugares, Local pontoDePartida, Local destino, Motorista motorista) {
		this.quantidadeDeLugares = quantidadeDeLugares;
		this.pontoDePartida = pontoDePartida;
		this.destino = destino;
		this.motorista = motorista;
		motorista.addViagem(this);
	}

	// Getters e Setters
	public Integer getQuantidadeDeLugares() {
		return quantidadeDeLugares;
	}

	public void setQuantidadeDeLugares(Integer quantidadeDeLugares) {
		this.quantidadeDeLugares = quantidadeDeLugares;
	}

	public Local getPontoDePartida() {
		return pontoDePartida;
	}

	public void setPontoDePartida(Local pontoDePartida) {
		this.pontoDePartida = pontoDePartida;
	}

	public Local getDestino() {
		return destino;
	}

	public void setDestino(Local destino) {
		this.destino = destino;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
		motorista.addViagem(this);
	}

	public boolean getProgresso() {
		return progresso;
	}

	public List<Local> getTrajeto() {
		return trajeto;
	}

	public List<Passageiro> getPassageiros() {
		return passageiros;
	}

	public List<Passageiro> getEspera() {
		return espera;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	// Métodos para adicionar nas listas
	public void addLocal(Local local) {
		trajeto.add(local);
	}

	public void addPassageiros(Passageiro passageiro) {
		if (quantidadeDeLugares > 0){
			passageiros.add(passageiro);
			quantidadeDeLugares--;
		} else {
			System.out.println("Já está lotado.");
		}
	}

	public void addAvaliacao(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);
	}

	public void addEspera(Passageiro passageiro) {
		espera.add(passageiro);
	}

	// Exibir o progresso da viagem (concluída ou a fazer)
	public void exibirProgresso() {
		if (progresso) {
			System.out.println(", Progresso: concluído");
		} else {
			System.out.println(", Progresso: a fazer");
		}
	}

	// Concluir a viagem
	public void concluirViagem() {
		progresso = true;
	}

	// Exibir passageiros da viagem
	public void exibirPassageiros() {
		if (passageiros.size() > 0) {
			for (Passageiro pass : passageiros) {
				System.out.println("  - " + pass.getNome());
			}
		} else {
			System.out.println("  - Sem passageiros ainda...");
		}
	}

	// Método que retorna a partida e o destino da viagem
	public String resumoViagem() {
		return pontoDePartida.getDescricao() + " --> " + destino.getDescricao();
	}

}
