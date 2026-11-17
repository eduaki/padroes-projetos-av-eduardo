import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {

    private final List<String> registros = new ArrayList<>();

    public void notificarLance(Lote lote, double valor) {
        registros.add(LocalDateTime.now() + " - " + lote.getNome() + " - R$ " + valor);
    }

    public void imprimirRegistros() {
        System.out.println("Registros do auditor");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
