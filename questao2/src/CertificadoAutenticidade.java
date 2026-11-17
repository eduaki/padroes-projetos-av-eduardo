public class CertificadoAutenticidade extends ServicoDecorator {

    public CertificadoAutenticidade(ServicoAdicional servicoInterno) {
        super(servicoInterno);
    }

    public String getDescricao() {
        return servicoInterno.getDescricao() + "\nCertificado de Autenticidade: R$ 300,00";
    }

    public double getCusto() {
        return servicoInterno.getCusto() + 300;
    }
}
