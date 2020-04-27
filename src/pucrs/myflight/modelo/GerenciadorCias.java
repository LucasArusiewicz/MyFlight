package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {

    private ArrayList<CiaAerea> empresas;

    public GerenciadorCias() {
        empresas = new ArrayList<>();
    }

    public void adicionar(CiaAerea cia) {
        this.empresas.add(cia);
    }

    public ArrayList<CiaAerea> listarTudo() {
        return this.empresas;
    }

    public CiaAerea buscaPorCodigo(String codigo) {
        for (CiaAerea cia : this.empresas) {
            if (cia.getCodigo().equals(codigo)) {
                return cia;
            }
        }
        return null;
    }

    public CiaAerea buscaPorNome(String nome) {
        for (CiaAerea cia : this.empresas) {
            if (cia.getNome().equals(nome)) {
                return cia;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GerenciadorCias{" +
                "empresas=" + empresas +
                '}';
    }
}
