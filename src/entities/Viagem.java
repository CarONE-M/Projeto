package entities;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Viagem {
	private int quantidadeDeLugares;
	private Local pontoDePartida;
	private Local destino;
	private double preco;
	private String data;
	private Boolean progresso;
	private Motorista motorista;
	private double precoPorKm;
	private List<Local> trajeto = new ArrayList<Local>();
	private List<Passageiro> passageiros = new ArrayList<Passageiro>();
	private List<Passageiro> espera = new ArrayList<Passageiro>();
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	private List<Passageiro> passageirosJaAvaliaram = new ArrayList<Passageiro>();

	// Contrustores
	public Viagem() {
	}

	public Viagem(int quantidadeDeLugares, Local pontoDePartida, Local destino, String data, Motorista motorista,
			double precoPorKm) {
		this.quantidadeDeLugares = quantidadeDeLugares;
		this.pontoDePartida = pontoDePartida;
		this.destino = destino;
		this.precoPorKm = precoPorKm;
		this.preco = calcularPreco(pontoDePartida, destino);
		this.data = data;
		this.motorista = motorista;
		motorista.addViagem(this);
		this.progresso = false;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public List<Passageiro> getPassageirosJaAvaliaram() {
		return passageirosJaAvaliaram;
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
	
	// Sobrecarga
	public void addLocal(int index, Local local) {
		trajeto.add(index, local);
	}


	public void addPassageiros(Passageiro passageiro) {
		if (quantidadeDeLugares > 0) {
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
	
	public void addJaAvaliaram(Passageiro passageiro) {
		passageirosJaAvaliaram.add(passageiro);
	}
	
	public void removeEspera(Passageiro passageiro) {
		espera.remove(passageiro);
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
		String resumo = "\n - Viagem: " + pontoDePartida + " --> " + destino + "\n - Trajeto: " + trajeto;
		
		return resumo;
	}

	public double calcularDistancia(Local partida, Local destino) {
		double x1 = partida.getX();
		double y1 = partida.getY();
		double x2 = destino.getX();
		double y2 = destino.getY();

		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	public double calcularPreco(Local partida, Local destino) {
		double distancia = calcularDistancia(partida, destino);
		double preco = distancia * precoPorKm;

		DecimalFormat df = new DecimalFormat("#.##");
		preco = Double.valueOf(df.format(preco));

		return preco;
	}

}
