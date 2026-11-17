public class FilaAws implements Fila {

    private final String id;

    public FilaAws(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getCustoFixo() {
        return 0.40;
    }
}
