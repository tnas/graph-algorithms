package com.tnas.grafos.representacoes;

public class Vertice {

	private static Integer INDICE = 0;
	
	public enum StatusVisitaVertice {
		NOVO, VISITADO;
	}
	
	private Integer numero;
	
	private String rotulo;
	
	private StatusVisitaVertice status;
	
	private Integer distancia;
	
	private Vertice pai;
	
	private Integer tempoDescoberta;
	
	private Integer tempoFinalizacao;
	
	private Integer cor;
	
	public Vertice(String rotulo) {
		this.rotulo = rotulo;
		this.numero = INDICE++;
	}

	public Vertice(Integer numero) {
		this.numero = numero;
	}
	
	public Vertice(Integer numero, StatusVisitaVertice status) {
		this.numero = numero;
		this.status = status;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public StatusVisitaVertice getStatus() {
		return status;
	}

	public void setStatus(StatusVisitaVertice status) {
		this.status = status;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Vertice getPai() {
		return pai;
	}

	public void setPai(Vertice pai) {
		this.pai = pai;
	}

	public Integer getTempoDescoberta() {
		return tempoDescoberta;
	}

	public void setTempoDescoberta(Integer tempoDescoberta) {
		this.tempoDescoberta = tempoDescoberta;
	}

	public Integer getTempoFinalizacao() {
		return tempoFinalizacao;
	}

	public void setTempoFinalizacao(Integer tempoFinalizacao) {
		this.tempoFinalizacao = tempoFinalizacao;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public Integer getCor() {
		return cor;
	}

	public void setCor(Integer cor) {
		this.cor = cor;
	}
	
}
