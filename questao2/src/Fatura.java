public class Fatura {

    public static void imprimir(Lote lote, ServicoAdicional servico) {
        System.out.println();
        System.out.println("Fatura - " + lote.getNome());
        System.out.println(String.format("Valor de venda: R$ %.2f", lote.getLanceAtual()));
        System.out.println(servico.getDescricao());
        System.out.println(String.format("Total: R$ %.2f", servico.getCusto()));
        System.out.println();
    }
}
