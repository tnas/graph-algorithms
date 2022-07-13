package com.tnas.grafos.travessia;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.Vertice;

public class BuscaProfundidade {

	private LinkedList<Vertice> ordemTopologica;
	private Integer tempo;
	
	public void executarBusca(ListaAdjacencia listaAdjacencia, Vertice origem) {
		
		var pilha = new Stack<Vertice>();
		
		listaAdjacencia.obterVertices().forEach(v -> v.setStatus(Vertice.StatusVisitaVertice.NOVO));
		pilha.push(listaAdjacencia.obterVertice(origem.getNumero()));
		
		while (!pilha.empty()) {
			
			var vertice = pilha.pop();
			
			if (vertice.getStatus() == Vertice.StatusVisitaVertice.NOVO) {
				
				System.out.print(vertice.getNumero() + " ");
				
				vertice.setStatus(Vertice.StatusVisitaVertice.VISITADO);
				listaAdjacencia.obterAdjacentes(vertice).stream()
					.filter(v -> v.getStatus() == Vertice.StatusVisitaVertice.NOVO)
					.forEach(v -> pilha.push(v));
			}
		}
	}
	
	public void executarBusca(ListaAdjacencia listaAdjacencia, Vertice origem, Vertice destino) {
		
		var pilha = new Stack<Vertice>();
		
		listaAdjacencia.obterVertices().forEach(v -> { 
			v.setStatus(Vertice.StatusVisitaVertice.NOVO);
			v.setPai(null);
		});
		
		pilha.push(listaAdjacencia.obterVertice(origem.getNumero()));
		
		while (!pilha.empty()) {
			
			var vertice = pilha.pop();
			
			if (vertice.getNumero() == destino.getNumero()) {
				
				while (Objects.nonNull(vertice)) {
					System.out.print(vertice.getNumero() + " ");
					vertice = vertice.getPai();
				}
				
				pilha.clear();
			}
			else {
				
				if (vertice.getStatus() == Vertice.StatusVisitaVertice.NOVO) {
					
					vertice.setStatus(Vertice.StatusVisitaVertice.VISITADO);
					
					for (var v : listaAdjacencia.obterAdjacentes(vertice)) {
						if (v.getStatus() == Vertice.StatusVisitaVertice.NOVO) {
							pilha.push(v);
							v.setPai(vertice);
						}
					}
				}
			}
			
		}
	}
	
	public void executarBuscaRecursiva(ListaAdjacencia listaAdjacencia) {
		
		this.ordemTopologica = new LinkedList<Vertice>();
		listaAdjacencia.obterVertices().forEach(v -> v.setStatus(Vertice.StatusVisitaVertice.NOVO));
		this.tempo = 0;
		
		listaAdjacencia.obterVertices().stream()
			.filter(v -> v.getStatus() == Vertice.StatusVisitaVertice.NOVO)
			.forEach(v -> this.visitarVertice(listaAdjacencia, v));
	}
	
	private void visitarVertice(ListaAdjacencia listaAdjacencia, Vertice vertice) {
		
		vertice.setTempoDescoberta(++this.tempo);
		vertice.setStatus(Vertice.StatusVisitaVertice.VISITADO);
		
		for (var v : listaAdjacencia.obterAdjacentes(vertice)) {
			
			if (v.getStatus() == Vertice.StatusVisitaVertice.NOVO) {
				this.visitarVertice(listaAdjacencia, v);
			}
		}
		
		vertice.setTempoFinalizacao(++this.tempo);
		this.ordemTopologica.add(vertice);
	}

	public LinkedList<Vertice> getOrdemTopologica() {
		return ordemTopologica;
	}
	
}
