public class ComissaoEletronicos implements Comissao {

    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50);
    }
}
