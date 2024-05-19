package entities;

public class Local {
	private String descricao;
	private Double x;
	private Double y;

	// Construtores
	public Local() {
	}

	public Local(String descricao, Double x, Double y) {
		this.descricao = descricao;
		this.x = x;
		this.y = y;
	}

	// Getters e Setters
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	// Método para comparar a distancia entre este e outro local
	public double compararDistancia(Local local) {
		return Math.sqrt(Math.pow(x - local.getX(), 2) + Math.pow(y - local.getY(), 2));
	}

}
