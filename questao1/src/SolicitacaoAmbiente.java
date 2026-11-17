public class SolicitacaoAmbiente {

    private final String nome;
    private final String provedor;
    private final int quantidadeMaquinas;
    private final int quantidadeGb;

    public SolicitacaoAmbiente(String nome, String provedor, int quantidadeMaquinas, int quantidadeGb) {
        this.nome = nome;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.quantidadeGb = quantidadeGb;
    }

    public String getNome() {
        return nome;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQuantidadeMaquinas() {
        return quantidadeMaquinas;
    }

    public int getQuantidadeGb() {
        return quantidadeGb;
    }
}
