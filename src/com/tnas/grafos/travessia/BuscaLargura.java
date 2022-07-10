package com.tnas.grafos.travessia;

import java.util.LinkedList;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.StatusVisitaVertice;
import com.tnas.grafos.representacoes.Vertice;

public class BuscaLargura {


	public void executarBusca(ListaAdjacencia listaAdjacencia, Vertice origem) {
		
		listaAdjacencia.obterVertices().forEach(v -> {
			v.setStatus(StatusVisitaVertice.NOVO);
			v.setDistancia(Integer.MAX_VALUE);
			v.setPai(null);
		});
		
		var vOrigem = listaAdjacencia.obterVertice(origem.getNome());
		vOrigem.setStatus(StatusVisitaVertice.VISITADO);
		vOrigem.setDistancia(0);
		
		var fila = new LinkedList<Vertice>();
		fila.add(vOrigem);
		
		while (!fila.isEmpty()) {
			
			var vertice = fila.remove();
			
			System.out.print(vertice.getNome() + " ");
			
			listaAdjacencia.obterAdjacentes(vertice).stream()
				.filter(v -> v.getStatus() == StatusVisitaVertice.NOVO)
				.forEach(v -> {
					v.setStatus(StatusVisitaVertice.VISITADO);
					v.setDistancia(vertice.getDistancia() + 1);
					v.setPai(vertice);
					fila.add(v);
				});
		}
	}
}
