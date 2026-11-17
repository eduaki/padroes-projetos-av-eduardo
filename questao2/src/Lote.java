import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lote {

    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private double lanceAtual;
    private final List<Interessado> interessados = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();
    private Comissao comissao;
    private boolean encerrado;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, Comissao comissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.comissao = comissao;
        this.encerrado = false;
    }

    public void adicionarInteressado(Interessado interessado) {
        interessados.add(interessado);
    }

    public void removerInteressado(Interessado interessado) {
        interessados.remove(interessado);
    }

    public boolean darLance(Participante participante, double valor) {
        if (encerrado) {
            System.out.println("Lance de " + participante.getNome() + " recusado: o lote " + nome + " já foi encerrado.");
            return false;
        }
        if (valor < lanceAtual * 1.05) {
            System.out.println(String.format("Lance de %s recusado: o valor precisa ser de pelo menos R$ %.2f",
                    participante.getNome(), lanceAtual * 1.05));
            return false;
        }
        lanceAtual = valor;
        lances.add(new Lance(participante, valor, LocalDateTime.now()));
        System.out.println(String.format("%s deu um lance de R$ %.2f no %s", participante.getNome(), valor, nome));
        for (Interessado interessado : interessados) {
            if (interessado != participante) {
                interessado.notificarLance(this, valor);
            }
        }
        return true;
    }

    public void trocarComissao(Comissao novaComissao) {
        this.comissao = novaComissao;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void encerrar() {
        encerrado = true;
        System.out.println(nome + ": " + (lanceAtual >= precoReserva ? "VENDIDO" : "NÃO VENDIDO"));
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public List<Lance> getLances() {
        return lances;
    }
}
