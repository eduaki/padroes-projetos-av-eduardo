public class FilaAzure implements Fila {

    private final String id;

    public FilaAzure(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getCustoFixo() {
        return 0.50;
    }
}
