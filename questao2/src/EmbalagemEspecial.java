public class EmbalagemEspecial extends ServicoDecorator {

    public EmbalagemEspecial(ServicoAdicional servicoInterno) {
        super(servicoInterno);
    }

    public String getDescricao() {
        return servicoInterno.getDescricao() + "\nEmbalagem Especial: R$ 180,00";
    }

    public double getCusto() {
        return servicoInterno.getCusto() + 180;
    }
}
