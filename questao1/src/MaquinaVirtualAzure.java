public class MaquinaVirtualAzure implements MaquinaVirtual {

    private final String id;

    public MaquinaVirtualAzure(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getCustoHora() {
        return 0.12;
    }
}
