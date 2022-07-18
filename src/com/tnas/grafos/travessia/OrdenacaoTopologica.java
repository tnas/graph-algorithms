package com.tnas.grafos.travessia;

import java.util.LinkedList;
import java.util.Objects;

import com.tnas.grafos.representacoes.ListaAdjacencia;
import com.tnas.grafos.representacoes.Vertice;

public class OrdenacaoTopologica {


	public void ordenar(ListaAdjacencia listaAdjacencia) {
		
		var buscaProfundidade = new BuscaProfundidade();
		buscaProfundidade.executarBuscaRecursiva(listaAdjacencia);
		var ordemTopologica = buscaProfundidade.getOrdemTopologica(); 
		this.imprimir(ordemTopologica);
	}
	
	private void imprimir(LinkedList<Vertice> ordemTopologica) {
		ordemTopologica.forEach(v -> {
			var vertice = Objects.isNull(v.getRotulo()) ? v.getNumero() : v.getRotulo();
			System.out.print(vertice + " ");
		});
	}

}
