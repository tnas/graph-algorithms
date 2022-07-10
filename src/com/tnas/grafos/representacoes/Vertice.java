package com.tnas.grafos.representacoes;

public class Vertice {

	private Integer nome;
	
	private StatusVisitaVertice status;
	
	public Vertice(Integer nome) {
		this.nome = nome;
	}
	
	public Vertice(Integer nome, StatusVisitaVertice status) {
		this.nome = nome;
		this.status = status;
	}

	public Integer getNome() {
		return nome;
	}

	public void setNome(Integer nome) {
		this.nome = nome;
	}

	public StatusVisitaVertice getStatus() {
		return status;
	}

	public void setStatus(StatusVisitaVertice status) {
		this.status = status;
	}
}
