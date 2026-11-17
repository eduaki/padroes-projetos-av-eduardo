public class FabricaAws implements FabricaRecursos {

    private int contadorMaquinas;
    private int contadorArmazenamentos;
    private int contadorFilas;

    public MaquinaVirtual criarMaquinaVirtual() {
        contadorMaquinas++;
        return new MaquinaVirtualAws("i-" + contadorMaquinas);
    }

    public Armazenamento criarArmazenamento() {
        contadorArmazenamentos++;
        return new ArmazenamentoAws("s3://" + contadorArmazenamentos);
    }

    public Fila criarFila() {
        contadorFilas++;
        return new FilaAws("sqs-" + contadorFilas);
    }

    public double calcularCustoEstimado(int quantidadeMaquinas, int quantidadeGb) {
        return quantidadeMaquinas * 0.10 * 730 + quantidadeGb * 0.023 + 0.40;
    }
}
