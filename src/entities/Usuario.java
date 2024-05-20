package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String senha;
	private List<Viagem> viagens = new ArrayList<Viagem>();

	public Usuario() {
	}

	public Usuario(String nome, String endereco, String email, String telefone, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrarViagem(Viagem viagem) {
		viagens.add(viagem);
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void addViagem(Viagem viagem) {
		viagens.add(viagem);
	}
}
