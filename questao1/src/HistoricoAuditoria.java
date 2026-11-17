import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoricoAuditoria {

    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();

    private final List<RegistroAuditoria> registros = Collections.synchronizedList(new ArrayList<>());

    private HistoricoAuditoria() {
    }

    public static HistoricoAuditoria getInstancia() {
        return INSTANCIA;
    }

    public synchronized void registrar(RegistroAuditoria registro) {
        registros.add(registro);
    }

    public List<RegistroAuditoria> getRegistros() {
        synchronized (registros) {
            return new ArrayList<>(registros);
        }
    }
}
