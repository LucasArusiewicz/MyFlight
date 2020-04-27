package pucrs.myflight.modelo;

import java.util.Objects;

public class Aeronave implements Imprimivel, Contavel, Comparable<Aeronave> {
    private static int totalAeronaves = 0;
    private String codigo;
    private String descricao;
    private int capacidade;

    public Aeronave(String codigo, String descricao, int capacidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.capacidade = capacidade;
        totalAeronaves++;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public void imprimir() {
        System.out.println(String.format("%s - %s", codigo, descricao));
    }

    @Override
    public int getTotalContador() {
        return totalAeronaves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aeronave)) return false;
        Aeronave aeronave = (Aeronave) o;
        return getCapacidade() == aeronave.getCapacidade() &&
                Objects.equals(getCodigo(), aeronave.getCodigo()) &&
                Objects.equals(getDescricao(), aeronave.getDescricao());
    }

    @Override
    public String toString() {
        return "Aeronave{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }

    @Override
    public int compareTo(Aeronave aeronave) {
        return descricao.compareTo(aeronave.descricao);
    }
}
