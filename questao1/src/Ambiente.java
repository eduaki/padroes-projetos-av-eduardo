import java.util.List;

public class Ambiente {

    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final Fila fila;
    private final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
            Armazenamento armazenamento, Fila fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public void imprimirResumo() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Ambiente: ").append(nome).append(System.lineSeparator());
        resumo.append("Provedor: ").append(provedor).append(System.lineSeparator());
        resumo.append("Região: ").append(regiao).append(System.lineSeparator());
        for (MaquinaVirtual maquina : maquinas) {
            resumo.append("Máquina virtual: ").append(maquina.getId()).append(System.lineSeparator());
        }
        resumo.append("Armazenamento: ").append(armazenamento.getId()).append(System.lineSeparator());
        resumo.append("Fila: ").append(fila.getId()).append(System.lineSeparator());
        resumo.append(String.format("Custo mensal: R$ %.2f", custoMensal)).append(System.lineSeparator());
        System.out.println(resumo);
    }
}
