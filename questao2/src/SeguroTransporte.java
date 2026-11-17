public class SeguroTransporte extends ServicoDecorator {

    public SeguroTransporte(ServicoAdicional servicoInterno) {
        super(servicoInterno);
    }

    public String getDescricao() {
        return servicoInterno.getDescricao()
                + String.format("\nSeguro de Transporte: R$ %.2f", getValorVenda() * 0.015);
    }

    public double getCusto() {
        return servicoInterno.getCusto() + getValorVenda() * 0.015;
    }
}
