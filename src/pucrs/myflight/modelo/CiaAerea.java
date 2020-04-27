package pucrs.myflight.modelo;

import java.util.Objects;

public class CiaAerea {
    private String codigo;
    private String nome;

    public CiaAerea(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CiaAerea)) return false;
        CiaAerea ciaAerea = (CiaAerea) o;
        return Objects.equals(getCodigo(), ciaAerea.getCodigo()) &&
                Objects.equals(getNome(), ciaAerea.getNome());
    }

    @Override
    public String toString() {
        return "CiaAerea{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
