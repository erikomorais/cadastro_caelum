package br.com.caelum.cadastro.modelo;

public class Aluno {
	private String nome;
	private String telefone;
	private String endereco;
	private String site;
	private String foto;
	private double nota;

	private Long id;
	
	public String toString(){
		return id.toString() + " - " +  nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {

		this.foto = foto;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
}