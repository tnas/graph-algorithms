package com.tnas.grafos.representacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListaAdjacencia {

	private Integer numVertices;
	
	private List<List<Vertice>> adjacencias;
	
	private List<Vertice> vertices;
	
	public ListaAdjacencia(String[] rotulos, String[][] arestas) {
		
		this.numVertices = rotulos.length;
		this.vertices = new ArrayList<Vertice>();
		this.adjacencias = new ArrayList<List<Vertice>>();
		
		var mapRotuloNumero = new HashMap<String, Integer>();
		
		IntStream.range(0, numVertices).forEach(i -> { 
			this.adjacencias.add(new ArrayList<Vertice>());
			this.vertices.add(new Vertice(rotulos[i]));
			mapRotuloNumero.put(rotulos[i], i);
		});
		
		this.adjacencias.stream().forEach(a -> a = new ArrayList<Vertice>());
		Stream.of(arestas).forEach(a -> 
			this.adjacencias.get(mapRotuloNumero.get(a[0])).add(this.vertices.get(mapRotuloNumero.get(a[1]))));
	}
	
	
	public ListaAdjacencia(Integer numVertices, Integer[][] arestas) {
		
		this.numVertices = numVertices;
		this.vertices = new ArrayList<Vertice>();
		this.adjacencias = new ArrayList<List<Vertice>>();
		
		IntStream.range(0, numVertices).forEach(i -> { 
			this.adjacencias.add(new ArrayList<Vertice>());
			this.vertices.add(new Vertice(i));
		});
		
		this.adjacencias.stream().forEach(a -> a = new ArrayList<Vertice>());
		Stream.of(arestas).forEach(a -> this.adjacencias.get(a[0]).add(this.vertices.get(a[1])));
	}
	
	public List<Vertice> obterAdjacentes(Vertice vertice) {
		var adjacentes = this.adjacencias.get(vertice.getNumero());
		return Objects.nonNull(adjacentes) ? adjacentes : Collections.emptyList();
	}
	
	public Vertice obterVertice(Integer nomeVertice) {
		return this.vertices.get(nomeVertice);
	}
	
	public List<Vertice> obterVertices() {
		return this.vertices;
	}
	
	public void imprimir() {
		
		IntStream.range(0, numVertices).forEach(i -> {
			var vertice = this.vertices.get(i);
			var label = Objects.isNull(vertice.getRotulo()) ? vertice.getNumero() : vertice.getRotulo();
			System.out.print(label + " -> ");
			this.adjacencias.get(i).forEach(v -> {
				var rotuloVertice = Objects.isNull(v.getRotulo()) ? v.getNumero() : v.getRotulo(); 
				System.out.print(rotuloVertice + " - ");
			});
			System.out.println();
		});
	}

}
