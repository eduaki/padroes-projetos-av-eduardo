public class EntregaExpressa extends ServicoDecorator {

    public EntregaExpressa(ServicoAdicional servicoInterno) {
        super(servicoInterno);
    }

    public String getDescricao() {
        return servicoInterno.getDescricao() + "\nEntrega Expressa: R$ 450,00";
    }

    public double getCusto() {
        return servicoInterno.getCusto() + 450;
    }
}
