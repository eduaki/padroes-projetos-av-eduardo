public class ArmazenamentoAws implements Armazenamento {

    private final String id;

    public ArmazenamentoAws(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getCustoGb() {
        return 0.023;
    }
}
