package com.tnas.grafos.coloracao;

import com.tnas.grafos.representacoes.ListaAdjacencia;

public class ColoracaoSequencialTest {

	public static void main(String[] args) {
		
		String[] rotulos = { "A", "B", "C", "D", "E", "F" };
		String[][] arestas = { 
				{ "A", "B" }, { "A", "C" }, { "A", "F" }, 
				{ "B", "A" }, { "B", "C" }, { "B", "D" }, 
				{ "C", "A" }, { "C", "B" }, { "C", "D" },
				{ "D", "B" }, { "D", "C" }, { "D", "E" }, { "D", "F" },
				{ "E", "D" }, { "E", "F" }, 
				{ "F", "A" }, { "F", "D" }, { "F", "E" },
		};
		
		var coloracaoSequencial = new ColoracaoSequencial();
		coloracaoSequencial.colorir(new ListaAdjacencia(rotulos, arestas));
	}

}
