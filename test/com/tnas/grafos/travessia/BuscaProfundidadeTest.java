package com.tnas.grafos.travessia;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.Vertice;

public class BuscaProfundidadeTest {

	public static void main(String[] args) {
		
		var testeBuscaProfundidade = new BuscaProfundidadeTest();
		
		System.out.println("*** Teste 1 ***");
		testeBuscaProfundidade.executarTeste1();
		System.out.println();
		
		System.out.println("*** Teste 2 ***");
		testeBuscaProfundidade.executarTeste2();
		System.out.println();
	}
	
	public void executarTeste1() {
		
		var numVertices = 13;
		Integer[][] arestas = { 
				{ 0, 6 }, { 0, 5 }, { 0, 1 }, { 2, 0 }, { 2, 3 }, 
				{ 3, 5 }, { 5, 4 }, { 6, 4 }, { 6, 9 }, { 7, 6 }, 
				{ 8, 7 }, { 9, 10 }, { 9, 11 }, { 9, 12 }, { 11, 12 }
		};
		
		var buscaProfundidade = new BuscaProfundidade();
		buscaProfundidade.executarBusca(new ListaAdjacencia(numVertices, arestas), new Vertice(0));
	}
	
	public void executarTeste2() {
		
		var numVertices = 13;
		Integer[][] arestas = { 
				{ 0, 1 }, { 0, 5 }, { 2, 0 }, { 2, 3 }, { 3, 2 }, 
				{ 3, 5 }, { 4, 2 }, { 4, 3 }, { 5, 4 }, { 6, 4 }, 
				{ 6, 9 }, { 6, 0 }, { 7, 6 }, { 7, 8 }, { 8, 7 }, 
				{ 8, 9 }, { 9, 10 }, { 9, 11 }, { 10, 12 }, 
				{ 11, 4 }, { 11, 12 }, { 12, 9 }
		};
		
		var buscaProfundidade = new BuscaProfundidade();
		buscaProfundidade.executarBusca(new ListaAdjacencia(numVertices, arestas), 
				new Vertice(10), new Vertice(0));
	}

}
