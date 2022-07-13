package com.tnas.grafos.travessia;

import java.util.Collections;
import java.util.Objects;

import com.tnas.grafos.representacoes.ListaAdjacencia;

public class OrdenacaoTopologica {


	public void ordenar(ListaAdjacencia listaAdjacencia) {
		
		var buscaProfundidade = new BuscaProfundidade();
		buscaProfundidade.executarBuscaRecursiva(listaAdjacencia);
		var ordemTopologica = buscaProfundidade.getOrdemTopologica(); 
		Collections.reverse(ordemTopologica);
		
		ordemTopologica.forEach(v -> {
			var vertice = Objects.isNull(v.getRotulo()) ? v.getNumero() : v.getRotulo();
			System.out.print(vertice + " ");
		});
	}

}
