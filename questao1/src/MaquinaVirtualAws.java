public class MaquinaVirtualAws implements MaquinaVirtual {

    private final String id;

    public MaquinaVirtualAws(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getCustoHora() {
        return 0.10;
    }
}
