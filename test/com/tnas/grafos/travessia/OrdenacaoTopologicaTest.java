package com.tnas.grafos.travessia;

import com.tnas.grafos.representacoes.ListaAdjacencia;

public class OrdenacaoTopologicaTest {

	public static void main(String[] args) {
		
		var ordenacaoTest = new OrdenacaoTopologicaTest();
		
		System.out.println("*** Teste 1 ***");
		ordenacaoTest.executarTeste1();
		System.out.println();
		
		System.out.println("*** Teste 2 ***");
		ordenacaoTest.executarTeste2();
		System.out.println();
		
		System.out.println("*** Teste 3 ***");
		ordenacaoTest.executarTeste3();
		System.out.println();
	}
	
	/**
	 * Exemplo extraído de Sedgewick e Wayne (2011, p. 583)
	 */
	public void executarTeste1() {
		
		var numVertices = 13;
		Integer[][] arestas = { 
				{ 0, 5 }, { 0, 1 }, { 0, 6 }, { 2, 0 }, { 2, 3 }, 
				{ 3, 5 }, { 5, 4 }, { 6, 4 }, { 6, 9 }, { 7, 6 }, 
				{ 8, 7 }, { 9, 11 }, { 9, 12 }, { 9, 10 }, { 11, 12 }
		};
		
		var ordenacaoTopologica = new OrdenacaoTopologica();
		ordenacaoTopologica.ordenar(new ListaAdjacencia(numVertices, arestas));
	}
	
	/**
	 * Exemplo extraído de Cormen et al. (2009 p. 613)
	 */
	public void executarTeste2() {
		
		String[] rotulos = { "shirt", "watch", "undershorts", "pants", "tie", "belt", "jacket", "socks", "shoes" };
		String[][] arestas = { 
				{ "undershorts", "shoes" }, { "undershorts", "pants" }, { "pants", "shoes" }, 
				{ "pants", "belt" }, { "belt", "jacket" }, { "shirt", "tie" }, 
				{ "shirt", "belt" }, { "tie", "jacket" }, { "socks", "shoes" }
		};
		
		var ordenacaoTopologica = new OrdenacaoTopologica();
		ordenacaoTopologica.ordenar(new ListaAdjacencia(rotulos, arestas));
	}
	
	/**
	 * Solução: 0, 6, 1, 4, 3, 2, 7, 5, 8, 9
	 */
	public void executarTeste3() {
		
		var numVertices = 10;
		Integer[][] arestas = { 
				{ 0, 6 }, { 0, 1 }, { 0, 4 }, { 1, 2 }, { 3, 8 }, 
				{ 4, 5 }, { 2, 7 }, { 5, 9 }, { 8, 9 }, { 7, 8 },
				{ 2, 5 }, { 6, 3 }
		};
		
		var ordenacaoTopologica = new OrdenacaoTopologica();
		ordenacaoTopologica.ordenar(new ListaAdjacencia(numVertices, arestas));
	}

}
