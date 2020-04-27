package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo {

    private Rota rotaFinal;

    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao, Status status) {
        super(rota, datahora, duracao, status);
        this.rotaFinal = rotaFinal;
    }

    public Rota getRotaFinal() {
        return rotaFinal;
    }

    @Override
    public String toString() {
        return "VooEscalas{" +
                "rotaFinal=" + rotaFinal +
                "} " + super.toString();
    }
}
