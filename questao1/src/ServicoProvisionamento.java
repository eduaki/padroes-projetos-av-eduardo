import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicoProvisionamento {

    private final FabricaRecursos fabrica;

    public ServicoProvisionamento(FabricaRecursos fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente provisionar(SolicitacaoAmbiente solicitacao) {
        double custoEstimado = fabrica.calcularCustoEstimado(
                solicitacao.getQuantidadeMaquinas(), solicitacao.getQuantidadeGb());
        double orcamentoMensal = Configuracao.getInstancia().getOrcamentoMensal();

        if (custoEstimado > orcamentoMensal) {
            HistoricoAuditoria.getInstancia().registrar(new RegistroAuditoria(
                    LocalDateTime.now(), solicitacao.getNome(), solicitacao.getProvedor(),
                    "RECUSADO", "Orçamento excedido"));
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.getQuantidadeMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento();
        Fila fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(solicitacao.getNome(), solicitacao.getProvedor(),
                Configuracao.getInstancia().getRegiao(), maquinas, armazenamento, fila, custoEstimado);

        HistoricoAuditoria.getInstancia().registrar(new RegistroAuditoria(
                LocalDateTime.now(), solicitacao.getNome(), solicitacao.getProvedor(), "ACEITO", ""));

        ambiente.imprimirResumo();
        return ambiente;
    }
}
