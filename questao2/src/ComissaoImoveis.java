public class ComissaoImoveis implements Comissao {

    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500;
    }
}
