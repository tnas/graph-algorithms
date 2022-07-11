package com.tnas.grafos.travessia;

import java.util.Objects;
import java.util.Stack;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.StatusVisitaVertice;
import com.tnas.grafos.representacoes.Vertice;

public class BuscaProfundidade {

	public void executarBusca(ListaAdjacencia listaAdjacencia, Vertice origem) {
		
		var pilha = new Stack<Vertice>();
		
		listaAdjacencia.obterVertices().forEach(v -> v.setStatus(StatusVisitaVertice.NOVO));
		pilha.push(listaAdjacencia.obterVertice(origem.getNome()));
		
		while (!pilha.empty()) {
			
			var vertice = pilha.pop();
			
			if (vertice.getStatus() == StatusVisitaVertice.NOVO) {
				
				System.out.print(vertice.getNome() + " ");
				
				vertice.setStatus(StatusVisitaVertice.VISITADO);
				listaAdjacencia.obterAdjacentes(vertice).stream()
					.filter(v -> v.getStatus() == StatusVisitaVertice.NOVO)
					.forEach(v -> pilha.push(v));
			}
		}
	}
	
	public void executarBusca(ListaAdjacencia listaAdjacencia, Vertice origem, Vertice destino) {
		
		var pilha = new Stack<Vertice>();
		
		listaAdjacencia.obterVertices().forEach(v -> { 
			v.setStatus(StatusVisitaVertice.NOVO);
			v.setPai(null);
		});
		
		pilha.push(listaAdjacencia.obterVertice(origem.getNome()));
		
		while (!pilha.empty()) {
			
			var vertice = pilha.pop();
			
			if (vertice.getNome() == destino.getNome()) {
				
				while (Objects.nonNull(vertice)) {
					System.out.print(vertice.getNome() + " ");
					vertice = vertice.getPai();
				}
				
				break;
			}
			
			if (vertice.getStatus() == StatusVisitaVertice.NOVO) {
				
				vertice.setStatus(StatusVisitaVertice.VISITADO);
				
				for (var v : listaAdjacencia.obterAdjacentes(vertice)) {
					if (v.getStatus() == StatusVisitaVertice.NOVO) {
						pilha.push(v);
						v.setPai(vertice);
					}
				}
			}
		}
	}
}
