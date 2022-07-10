package com.tnas.grafos.travessia;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.Vertice;

public class BuscaLarguraTest {

	public static void main(String[] args) {
		var testeBuscaLargura = new BuscaLarguraTest();
		testeBuscaLargura.executarTeste1();
	}
	
	public void executarTeste1() {
		
		var numVertices = 6;
		Integer[][] arestas = { 
				{ 0, 5 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 }, 
				{ 2, 3 }, { 2, 4 }, { 3, 2 }, { 4, 2 }, { 5, 0 }, 
				{ 2, 1 }, { 1, 2 }, { 3, 5 }, { 5, 3 }, { 3, 4 },
				{ 4, 3 }
		};
		
		var buscaProfundidade = new BuscaLargura();
		buscaProfundidade.executarBusca(new ListaAdjacencia(numVertices, arestas), new Vertice(0));
	}

}
