public class ComissaoVeiculos implements Comissao {

    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, 5000);
    }
}
