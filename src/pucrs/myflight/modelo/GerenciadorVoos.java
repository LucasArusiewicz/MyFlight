package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {

    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        this.voos = new ArrayList<>();
    }

    public void adicionar(Voo rota) {
        this.voos.add(rota);
    }

    public ArrayList<Voo> listarTudo() {
        return this.voos;
    }

    public Voo buscaPorData(LocalDateTime localDateTime) {
        for (Voo rota : this.voos) {
            if (rota.getDatahora().isEqual(localDateTime)) {
                return rota;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GerenciadorVoos{" +
                "voos=" + voos +
                '}';
    }
}
