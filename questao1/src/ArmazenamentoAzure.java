public class ArmazenamentoAzure implements Armazenamento {

    private final String id;

    public ArmazenamentoAzure(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getCustoGb() {
        return 0.02;
    }
}
