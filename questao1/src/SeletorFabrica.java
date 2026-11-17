public class SeletorFabrica {

    public static FabricaRecursos obter(String provedor) {
        if ("AWS".equalsIgnoreCase(provedor)) {
            return new FabricaAws();
        }
        if ("Azure".equalsIgnoreCase(provedor)) {
            return new FabricaAzure();
        }
        throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
    }
}
