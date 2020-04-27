package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {

    private ArrayList<Aeronave> aeronaves;

    public GerenciadorAeronaves() {
        this.aeronaves = new ArrayList<>();
    }

    public void adicionar(Aeronave aeronave) {
        this.aeronaves.add(aeronave);
    }

    public ArrayList<Aeronave> listarTudo() {
        return this.aeronaves;
    }

    public Aeronave buscaPorCodigo(String codigo) {
        for (Aeronave aeronave : this.aeronaves) {
            if (aeronave.getCodigo().equals(codigo)) {
                return aeronave;
            }
        }
        return null;
    }

    public Aeronave buscaPorDescricao(String nome) {
        for (Aeronave aeronave : this.aeronaves) {
            if (aeronave.getDescricao().equals(nome)) {
                return aeronave;
            }
        }
        return null;
    }

    public Aeronave buscaPorCapacidade(int capacidade) {
        for (Aeronave aeronave : this.aeronaves) {
            if (aeronave.getCapacidade() == capacidade) {
                return aeronave;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GerenciadorAeronaves{" +
                "aeronaves=" + aeronaves +
                '}';
    }
}
