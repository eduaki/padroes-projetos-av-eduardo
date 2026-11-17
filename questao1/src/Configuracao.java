import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracao {

    private static final Configuracao INSTANCIA = new Configuracao();

    private final String regiao;
    private final double orcamentoMensal;

    private Configuracao() {
        Properties propriedades = new Properties();
        try (InputStream entrada = new FileInputStream("config.properties")) {
            propriedades.load(entrada);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler config.properties", e);
        }
        this.regiao = propriedades.getProperty("regiao");
        this.orcamentoMensal = Double.parseDouble(propriedades.getProperty("orcamentoMensal"));
    }

    public static Configuracao getInstancia() {
        return INSTANCIA;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getOrcamentoMensal() {
        return orcamentoMensal;
    }
}
