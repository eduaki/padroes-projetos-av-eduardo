import java.time.LocalDateTime;

public class Lance {

    private final Participante participante;
    private final double valor;
    private final LocalDateTime dataHora;

    public Lance(Participante participante, double valor, LocalDateTime dataHora) {
        this.participante = participante;
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
