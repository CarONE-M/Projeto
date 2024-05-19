package entities;

public class Avaliacao {
	private Integer nota;
	private String comentario;

	public Avaliacao() {
	}

	public Avaliacao(Integer nota, String comentario) {
		this.nota = nota;
		this.comentario = comentario;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
