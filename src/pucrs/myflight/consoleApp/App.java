package pucrs.myflight.consoleApp;

import pucrs.myflight.modelo.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class App {

	public static void main(String[] args) {
		System.out.println("MyFlight project...");

		GerenciadorCias gCias = new GerenciadorCias();
		GerenciadorAeronaves gAeronaves = new GerenciadorAeronaves();
		GerenciadorAeroportos gAeroportos = new GerenciadorAeroportos();
		GerenciadorRotas gRotas = new GerenciadorRotas();
		GerenciadorVoos gVoos = new GerenciadorVoos();

		// Companhias Aéreas
		gCias.adicionar(new CiaAerea("JJ", "LATAM Linhas Aéreas"));
		gCias.adicionar(new CiaAerea("G3", "Gol Linhas Aéreas"));
		gCias.adicionar(new CiaAerea("TP", "TAP Portugal"));
		gCias.adicionar(new CiaAerea("AD", "Azul Linhas Aéreas"));

		// Aeronaves
		gAeronaves.adicionar(new Aeronave("733", "Boeing 737-300", 140));
		gAeronaves.adicionar(new Aeronave("73G", "Boeing 737-700", 126));
		gAeronaves.adicionar(new Aeronave("380", "Airbus Industrie A380", 644));
		gAeronaves.adicionar(new Aeronave("764", "Boeing 767-400", 304));


		// Aeroportos
		gAeroportos.adicionar(new Aeroporto("POA", "Salgado Filho Intl Apt", new Geo(-29.9939, -51.1711)));
		gAeroportos.adicionar(new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", new Geo(-23.4356, -46.4731)));
		gAeroportos.adicionar(new Aeroporto("LIS", "Lisbon", new Geo(38.7742, -9.1342)));
		gAeroportos.adicionar(new Aeroporto("MIA", "Miami International Apt", new Geo(25.7933, -80.2906)));

		// Rotas
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("G3"), gAeroportos.buscaPorCodigo("GRU"), gAeroportos.buscaPorCodigo("POA"), gAeronaves.buscaPorCodigo("733")));
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("G3"), gAeroportos.buscaPorCodigo("POA"), gAeroportos.buscaPorCodigo("GRU"), gAeronaves.buscaPorCodigo("733")));
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("TP"), gAeroportos.buscaPorCodigo("MIA"), gAeroportos.buscaPorCodigo("LIS"), gAeronaves.buscaPorCodigo("380")));
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("JJ"), gAeroportos.buscaPorCodigo("GRU"), gAeroportos.buscaPorCodigo("MIA"), gAeronaves.buscaPorCodigo("764")));

		// Vôos
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("G3:POA-GRU"), LocalDateTime.of(2016, 8, 10, 8, 0), Duration.ofMinutes(90)/* 1:30 */, Voo.Status.ATRASADO));
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("G3:GRU-POA"), LocalDateTime.of(2016, 8, 10, 15, 0), Duration.ofMinutes(120)/* 2:00 */, Voo.Status.CONFIRMADO));
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("JJ:GRU-MIA"), LocalDateTime.of(2016, 8, 15, 12, 0), Duration.ofMinutes(120)/* 2:00 */, Voo.Status.CANCELADO));
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("TP:MIA-LIS"), Duration.ofMinutes(90)/* 1:30 */, Voo.Status.CONFIRMADO));

		System.out.println(gCias);
		System.out.println(gAeronaves);
		System.out.println(gAeroportos);
		System.out.println(gRotas);
		System.out.println(gVoos);

		double distanciaPoaGruClasse = Geo.distancia(gAeroportos.buscaPorCodigo("POA").getGeo(), gAeroportos.buscaPorCodigo("GRU").getGeo());
		System.out.println("Distancia metodo classe = " + distanciaPoaGruClasse);

		double distanciaPoaGru = gAeroportos.buscaPorCodigo("POA").getGeo().distancia(gAeroportos.buscaPorCodigo("GRU").getGeo());
		System.out.println("Distancia= " + distanciaPoaGru);

		// Testes Comparable
		System.out.println(gAeronaves.listarTudo());
		gAeronaves.ordenaDescricao();
		System.out.println(gAeronaves.listarTudo());

		System.out.println(gAeroportos.listarTudo());
		gAeroportos.ordenaNome();
		System.out.println(gAeroportos.listarTudo());

		System.out.println(gRotas.listarTudo());
		gRotas.ordenaCia();
		System.out.println(gRotas.listarTudo());

		VooEscalas vooEscalas = new VooEscalas(gRotas.buscaPorHash("G3:POA-GRU"), gRotas.buscaPorHash("JJ:GRU-MIA"), LocalDateTime.of(2020, 5, 20, 16, 0), Duration.ofMinutes(210)/* 3:30 */, VooEscalas.Status.ATRASADO);
		System.out.println(vooEscalas);
	}
}
