public abstract class ServicoDecorator implements ServicoAdicional {

    protected final ServicoAdicional servicoInterno;

    protected ServicoDecorator(ServicoAdicional servicoInterno) {
        this.servicoInterno = servicoInterno;
    }

    public double getValorVenda() {
        return servicoInterno.getValorVenda();
    }
}
