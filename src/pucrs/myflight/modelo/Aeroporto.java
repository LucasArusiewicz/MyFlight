package pucrs.myflight.modelo;

import java.util.Objects;

public class Aeroporto {
    private String codigo;
    private String nome;
    private Geo loc;

    public Aeroporto(String codigo, String nome, Geo loc) {
        this.codigo = codigo;
        this.nome = nome;
        this.loc = loc;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Geo getGeo() {
        return loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aeroporto)) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return Objects.equals(getCodigo(), aeroporto.getCodigo()) &&
                Objects.equals(getNome(), aeroporto.getNome()) &&
                Objects.equals(loc, aeroporto.loc);
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", loc=" + loc +
                '}';
    }
}
