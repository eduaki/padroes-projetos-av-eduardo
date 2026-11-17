public class Main {

    public static void main(String[] args) throws InterruptedException {
        Configuracao configuracao = Configuracao.getInstancia();
        System.out.println("Configuração carregada uma única vez.");
        System.out.println(String.format("Região: %s | Orçamento mensal: R$ %.2f",
                configuracao.getRegiao(), configuracao.getOrcamentoMensal()));
        System.out.println();

        SolicitacaoAmbiente producao = new SolicitacaoAmbiente("producao", "AWS", 2, 100);
        SolicitacaoAmbiente homologacao = new SolicitacaoAmbiente("homologacao", "AWS", 1, 50);
        SolicitacaoAmbiente teste = new SolicitacaoAmbiente("teste", "Azure", 2, 200);
        SolicitacaoAmbiente acimaDoOrcamento = new SolicitacaoAmbiente("excedente", "Azure", 100, 50000);

        Thread threadProducao = new Thread(() -> provisionar(producao));
        Thread threadTeste = new Thread(() -> provisionar(teste));
        threadProducao.start();
        threadTeste.start();
        threadProducao.join();
        threadTeste.join();

        provisionar(homologacao);
        provisionar(acimaDoOrcamento);

        System.out.println();
        System.out.println("Histórico de auditoria");
        for (RegistroAuditoria registro : HistoricoAuditoria.getInstancia().getRegistros()) {
            System.out.println(registro);
        }
    }

    private static void provisionar(SolicitacaoAmbiente solicitacao) {
        FabricaRecursos fabrica = SeletorFabrica.obter(solicitacao.getProvedor());
        new ServicoProvisionamento(fabrica).provisionar(solicitacao);
    }
}
