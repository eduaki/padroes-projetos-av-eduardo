public class AcertoVendedor {

    public static void imprimir(Lote lote) {
        double valorVenda = lote.getLanceAtual();
        double comissao = lote.getComissao().calcular(valorVenda);
        System.out.println();
        System.out.println("Acerto do vendedor - " + lote.getNome());
        System.out.println(String.format("Valor de venda: R$ %.2f", valorVenda));
        System.out.println(String.format("Comissão: R$ %.2f", comissao));
        System.out.println(String.format("Líquido: R$ %.2f", valorVenda - comissao));
        System.out.println();
    }
}
