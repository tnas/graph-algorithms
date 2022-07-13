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
	}
	
	public void executarTeste1() {
		
		var numVertices = 13;
		Integer[][] arestas = { 
				{ 0, 6 }, { 0, 5 }, { 0, 1 }, { 2, 0 }, { 2, 3 }, 
				{ 3, 5 }, { 5, 4 }, { 6, 4 }, { 6, 9 }, { 7, 6 }, 
				{ 8, 7 }, { 9, 10 }, { 9, 11 }, { 9, 12 }, { 11, 12 }
		};
		
		var ordenacaoTopologica = new OrdenacaoTopologica();
		ordenacaoTopologica.ordenar(new ListaAdjacencia(numVertices, arestas));
	}
	
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

}
