package pucrs.myflight.modelo;

import java.util.Objects;

public class Rota implements Comparable<Rota> {
    private CiaAerea cia;
    private Aeroporto origem;
    private Aeroporto destino;
    private Aeronave aeronave;

    public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
        this.cia = cia;
        this.origem = origem;
        this.destino = destino;
        this.aeronave = aeronave;
    }

    public CiaAerea getCia() {
        return cia;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public String getHash() {
        String cod = this.cia.getCodigo();
        String origem = this.origem.getCodigo();
        String destino = this.destino.getCodigo();
        return String.format("%s:%s-%s", cod, origem, destino);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o instanceof String) return o.equals(getHash());
        if (!(o instanceof Rota)) return false;
        Rota rota = (Rota) o;
        return Objects.equals(getCia(), rota.getCia()) &&
                Objects.equals(getOrigem(), rota.getOrigem()) &&
                Objects.equals(getDestino(), rota.getDestino()) &&
                Objects.equals(getAeronave(), rota.getAeronave());
    }

    @Override
    public String toString() {
        return "Rota{" +
                "cia=" + cia +
                ", origem=" + origem +
                ", destino=" + destino +
                ", aeronave=" + aeronave +
                '}';
    }

    @Override
    public int compareTo(Rota rota) {
        return cia.getNome().compareTo(rota.getCia().getNome());
    }
}
