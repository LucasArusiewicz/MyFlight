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
		gCias.adicionar(new CiaAerea("SA", "TPTAP Portugal"));
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
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("G3"), gAeroportos.buscaPorCodigo("GRU"), gAeroportos.buscaPorCodigo("POA"), gAeronaves.buscaPorCodigo("738")));
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("G3"), gAeroportos.buscaPorCodigo("POA"), gAeroportos.buscaPorCodigo("GRU"), gAeronaves.buscaPorCodigo("738")));
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("SA"), gAeroportos.buscaPorCodigo("MIA"), gAeroportos.buscaPorCodigo("LIS"), gAeronaves.buscaPorCodigo("332")));
		gRotas.adicionar(new Rota(gCias.buscaPorCodigo("JJ"), gAeroportos.buscaPorCodigo("GRU"), gAeroportos.buscaPorCodigo("MIA"), gAeronaves.buscaPorCodigo("320")));

		// Vôos
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("G3:POA-GRU"), LocalDateTime.of(2016, 8, 10, 8, 0), Duration.ofMinutes(90)/* 1:30 */, Voo.Status.ATRASADO));
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("G3:GRU-POA"), LocalDateTime.of(2016, 8, 10, 15, 0), Duration.ofMinutes(120)/* 2:00 */, Voo.Status.CONFIRMADO));
		gVoos.adicionar(new Voo(gRotas.buscaPorHash("JJ:GRU-MIA"), LocalDateTime.of(2016, 8, 15, 12, 0), Duration.ofMinutes(120)/* 2:00 */, Voo.Status.CANCELADO));

		System.out.println(gCias);
		System.out.println(gAeronaves);
		System.out.println(gAeroportos);
		System.out.println(gRotas);
		System.out.println(gVoos);
	}
}
