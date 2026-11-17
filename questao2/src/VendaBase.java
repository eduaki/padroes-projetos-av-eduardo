public class VendaBase implements ServicoAdicional {

    private final double valorVenda;

    public VendaBase(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDescricao() {
        return "Venda";
    }

    public double getCusto() {
        return valorVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }
}
