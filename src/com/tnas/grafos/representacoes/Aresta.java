package com.tnas.grafos.representacoes;

public class Aresta {

	public Aresta() {
	}
	
	public Aresta(Vertice origem, Vertice destino, Integer peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	private Vertice origem;
	
	private Vertice destino;
	
	private Integer peso;

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
}
