package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Voo {

    private LocalDateTime datahora;
    private Duration duracao;
    private Rota rota;
    private Status status;

    public Voo(Rota rota, LocalDateTime datahora, Duration duracao, Status status) {
        this.rota = rota;
        this.datahora = datahora;
        this.duracao = duracao;
        this.status = status;
    }

    public Rota getRota() {
        return rota;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public String getDuracaoFormatada() {
        long seconds = duracao.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voo)) return false;
        Voo voo = (Voo) o;
        return Objects.equals(getDatahora(), voo.getDatahora()) &&
                Objects.equals(getDuracao(), voo.getDuracao()) &&
                Objects.equals(getRota(), voo.getRota()) &&
                getStatus() == voo.getStatus();
    }

    @Override
    public String toString() {
        return "Voo{" +
                "datahora=" + datahora +
                ", duracao=" + getDuracaoFormatada() +
                ", rota=" + rota +
                ", status=" + status +
                '}';
    }

    public enum Status {CONFIRMADO, ATRASADO, CANCELADO}
}
