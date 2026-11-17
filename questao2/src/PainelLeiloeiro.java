public class PainelLeiloeiro implements Interessado {

    private double maiorLance;
    private int totalLances;

    public void notificarLance(Lote lote, double valor) {
        maiorLance = Math.max(maiorLance, valor);
        totalLances++;
        System.out.println(String.format("Painel do leiloeiro - %s | maior lance: R$ %.2f | total de lances: %d",
                lote.getNome(), maiorLance, totalLances));
    }
}
