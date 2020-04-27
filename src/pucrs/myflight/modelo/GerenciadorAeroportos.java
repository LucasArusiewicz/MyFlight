package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        this.aeroportos = new ArrayList<>();
    }

    public void adicionar(Aeroporto aeroporto) {
        this.aeroportos.add(aeroporto);
    }

    public ArrayList<Aeroporto> listarTudo() {
        return this.aeroportos;
    }

    public Aeroporto buscaPorCodigo(String codigo) {
        for (Aeroporto aeroporto : this.aeroportos) {
            if (aeroporto.getCodigo().equals(codigo)) {
                return aeroporto;
            }
        }
        return null;
    }

    public Aeroporto buscaPorNome(String nome) {
        for (Aeroporto aeroporto : this.aeroportos) {
            if (aeroporto.getNome().equals(nome)) {
                return aeroporto;
            }
        }
        return null;
    }

    public Aeroporto buscaPorGeo(Geo geo) {
        for (Aeroporto aeroporto : this.aeroportos) {
            if (aeroporto.getGeo().equals(geo)) {
                return aeroporto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GerenciadorAeroportos{" +
                "aeroportos=" + aeroportos +
                '}';
    }
}
