package com.tnas.grafos.travessia;

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
}
