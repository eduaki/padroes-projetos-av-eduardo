public interface FabricaRecursos {

    MaquinaVirtual criarMaquinaVirtual();

    Armazenamento criarArmazenamento();

    Fila criarFila();

    double calcularCustoEstimado(int quantidadeMaquinas, int quantidadeGb);
}
