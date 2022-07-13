package com.tnas.grafos.travessia;

import java.util.LinkedList;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.Vertice;

public class BuscaLargura {


	public void executarBusca(ListaAdjacencia listaAdjacencia, Vertice origem) {
		
		listaAdjacencia.obterVertices().forEach(v -> {
			v.setStatus(Vertice.StatusVisitaVertice.NOVO);
			v.setDistancia(Integer.MAX_VALUE);
			v.setPai(null);
		});
		
		var vOrigem = listaAdjacencia.obterVertice(origem.getNumero());
		vOrigem.setStatus(Vertice.StatusVisitaVertice.VISITADO);
		vOrigem.setDistancia(0);
		
		var fila = new LinkedList<Vertice>();
		fila.add(vOrigem);
		
		while (!fila.isEmpty()) {
			
			var vertice = fila.remove();
			
			System.out.print(vertice.getNumero() + " ");
			
			listaAdjacencia.obterAdjacentes(vertice).stream()
				.filter(v -> v.getStatus() == Vertice.StatusVisitaVertice.NOVO)
				.forEach(v -> {
					v.setStatus(Vertice.StatusVisitaVertice.VISITADO);
					v.setDistancia(vertice.getDistancia() + 1);
					v.setPai(vertice);
					fila.add(v);
				});
		}
	}
}
