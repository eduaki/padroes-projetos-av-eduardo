import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroAuditoria {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final LocalDateTime dataHora;
    private final String nomeAmbiente;
    private final String provedor;
    private final String resultado;
    private final String motivo;

    public RegistroAuditoria(LocalDateTime dataHora, String nomeAmbiente, String provedor, String resultado, String motivo) {
        this.dataHora = dataHora;
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.resultado = resultado;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        String motivoExibido = motivo == null || motivo.isEmpty() ? "-" : motivo;
        return dataHora.format(FORMATO)
                + " | Ambiente: " + nomeAmbiente
                + " | Provedor: " + provedor
                + " | Resultado: " + resultado
                + " | Motivo: " + motivoExibido;
    }
}
