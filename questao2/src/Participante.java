public class Participante implements Interessado {

    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void notificarLance(Lote lote, double valor) {
        System.out.println("Lote: " + lote.getNome() + " novo lance: " + valor);
    }
}
