package com.tnas.grafos.coloracao;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.Vertice;

public class ColoracaoSequencial {

	private static final Integer SEM_COR = -1;
	
	public Integer[] colorir(ListaAdjacencia listaAdjacencia) {
		
		var numVertices = listaAdjacencia.obterVertices().size();
		var coresDisponiveis = new Integer[numVertices]; 
		IntStream.range(0, numVertices).forEach(i -> coresDisponiveis[i] = i + 1);
		listaAdjacencia.obterVertices().forEach(v -> v.setCor(SEM_COR));
		
		for (var vertice : listaAdjacencia.obterVertices()) {
			
			var coresAdjacentes = listaAdjacencia.obterAdjacentes(vertice)
				.stream().map(Vertice::getCor).collect(Collectors.toList());
			
			vertice.setCor(Stream.of(coresDisponiveis).filter(c -> !coresAdjacentes.contains(c))
				.findFirst().orElse(SEM_COR));
		}
		
		var mapaCores = new Integer[numVertices];
		listaAdjacencia.obterVertices().forEach(v -> mapaCores[v.getNumero()] = v.getCor());
		this.imprimirMapaCores(mapaCores, listaAdjacencia);
		
		return mapaCores;
	}
	
	private void imprimirMapaCores(Integer[] mapaCores, ListaAdjacencia listaAdjacencia) {
		IntStream.range(0, mapaCores.length).forEach(i -> {
			var vertice = listaAdjacencia.obterVertice(i);
			System.out.println(vertice.getRotulo() + " -> " + vertice.getCor());
		});
	}

}
