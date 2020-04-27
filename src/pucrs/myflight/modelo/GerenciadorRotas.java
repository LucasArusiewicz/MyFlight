package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {

    private ArrayList<Rota> rotas;

    public GerenciadorRotas() {
        this.rotas = new ArrayList<>();
    }

    public void adicionar(Rota rota) {
        this.rotas.add(rota);
    }

    public ArrayList<Rota> listarTudo() {
        return this.rotas;
    }

    public Rota buscaPorCia(CiaAerea cia) {
        for (Rota rota : this.rotas) {
            if (rota.getCia().equals(cia)) {
                return rota;
            }
        }
        return null;
    }

    public Rota buscaPorOrigem(Aeroporto aeroporto) {
        for (Rota rota : this.rotas) {
            if (rota.getOrigem().equals(aeroporto)) {
                return rota;
            }
        }
        return null;
    }

    public Rota buscaPorDestino(Aeroporto aeroporto) {
        for (Rota rota : this.rotas) {
            if (rota.getDestino().equals(aeroporto)) {
                return rota;
            }
        }
        return null;
    }

    public Rota buscaPorAeronave(Aeronave aeronave) {
        for (Rota rota : this.rotas) {
            if (rota.getAeronave().equals(aeronave)) {
                return rota;
            }
        }
        return null;
    }

    public Rota buscaPorHash(String hash) {
        for (Rota rota : this.rotas) {
            if (rota.getHash().equals(hash)) {
                return rota;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GerenciadorRotas{" +
                "rotas=" + rotas +
                '}';
    }
}
