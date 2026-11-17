public class FabricaAzure implements FabricaRecursos {

    private int contadorMaquinas;
    private int contadorArmazenamentos;
    private int contadorFilas;

    public MaquinaVirtual criarMaquinaVirtual() {
        contadorMaquinas++;
        return new MaquinaVirtualAzure("vm-" + contadorMaquinas);
    }

    public Armazenamento criarArmazenamento() {
        contadorArmazenamentos++;
        return new ArmazenamentoAzure("blob://" + contadorArmazenamentos);
    }

    public Fila criarFila() {
        contadorFilas++;
        return new FilaAzure("sb-" + contadorFilas);
    }

    public double calcularCustoEstimado(int quantidadeMaquinas, int quantidadeGb) {
        return quantidadeMaquinas * 0.12 * 730 + quantidadeGb * 0.02 + 0.50;
    }
}
