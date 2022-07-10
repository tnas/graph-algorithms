package com.tnas.grafos.travessia;

import com.tnas.grafos.representacoes.ListaAdjacencia;

public class BuscaProfundidadeTest {

	public static void main(String[] args) {
		var buscaProfundidade = new BuscaProfundidadeTest();
		buscaProfundidade.executarTeste1();
	}
	
	public void executarTeste1() {
		
		var numVertices = 13;
		Integer[][] arestas = { 
				{ 0, 6 }, { 0, 5 }, { 0, 1 }, { 2, 0 }, { 2, 3 }, 
				{ 3, 5 }, { 5, 4 }, { 6, 4 }, { 6, 9 }, { 7, 6 }, 
				{ 8, 7 }, { 9, 10 }, { 9, 11 }, { 9, 12 }, { 11, 12 }
		};
		
		var listaAdjacencia = new ListaAdjacencia(numVertices, arestas);
		listaAdjacencia.imprimir();
	}

}
