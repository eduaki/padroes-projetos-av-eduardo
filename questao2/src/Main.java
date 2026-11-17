public class Main {

    public static void main(String[] args) {
        Lote lote1 = new Lote("Lote de Arte", "Arte", 1000.0, 1200.0, new ComissaoArte());
        Lote lote2 = new Lote("Lote de Veículos", "Veículos", 5000.0, 8000.0, new ComissaoVeiculos());

        Participante joao = new Participante("João");
        Participante maria = new Participante("Maria");
        Participante pedro = new Participante("Pedro");

        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        lote1.adicionarInteressado(painel);
        lote1.adicionarInteressado(auditor);
        lote2.adicionarInteressado(painel);
        lote2.adicionarInteressado(auditor);

        lote1.adicionarInteressado(joao);
        lote1.adicionarInteressado(maria);
        lote1.adicionarInteressado(pedro);
        lote2.adicionarInteressado(joao);
        lote2.adicionarInteressado(maria);
        lote2.adicionarInteressado(pedro);

        System.out.println("Lote 1 - " + lote1.getNome());
        lote1.darLance(joao, 1000.0);
        lote1.darLance(maria, 1100.0);
        lote1.darLance(joao, 1150.0);
        lote1.darLance(joao, 1200.0);
        lote1.darLance(maria, 1400.0);
        lote1.removerInteressado(maria);
        lote1.trocarComissao(new ComissaoEletronicos());
        lote1.encerrar();

        System.out.println();
        System.out.println("Lote 2 - " + lote2.getNome());
        lote2.darLance(pedro, 5000.0);
        lote2.darLance(pedro, 6000.0);
        lote2.encerrar();

        AcertoVendedor.imprimir(lote1);

        ServicoAdicional servico = new VendaBase(lote1.getLanceAtual());
        servico = new SeguroTransporte(servico);
        servico = new CertificadoAutenticidade(servico);
        servico = new EmbalagemEspecial(servico);
        servico = new CertificadoAutenticidade(servico);
        Fatura.imprimir(lote1, servico);

        auditor.imprimirRegistros();
    }
}
