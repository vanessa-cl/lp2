import java.util.Random;

public class CadernetaPoupanca extends Thread {
    // variaveis de instancia
    private String titular;
    private int diaAniversario;
    private double depositoInicial;
    private double rendimentoAcumulado;
    private final Random gerador = new Random();
    private final int PAUSA = 2000;

    // construtor
    public CadernetaPoupanca(String titular, int diaAniversario, double depositoInicial) throws Exception {
        this.titular = titular;
        this.diaAniversario = diaAniversario;
        if (diaAniversario < 1 || diaAniversario > 31) {
            throw new Exception("Dia de aniversário deve estar entre 1 e 31!");
        }
        this.depositoInicial = depositoInicial;
        if (depositoInicial <= 0) {
            throw new Exception("Depósito inicial deve ser maior que zero!");
        }
        this.rendimentoAcumulado = 0;
    }

    // getters
    public String getTitular() {
        return titular;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public double getDepositoInicial() {
        return depositoInicial;
    }

    public double getRendimentoAcumulado() {
        return rendimentoAcumulado;
    }

    // métodos
    public void atualizarRendimento(double prTaxa) throws Exception {
        if (prTaxa <= 0) {
            throw new Exception("Taxa de rendimento deve ser maior que zero!");
        } else {
            prTaxa = prTaxa / 100;
            rendimentoAcumulado += depositoInicial * prTaxa;
        }
    }

    public double getSaldo() {
        return depositoInicial + rendimentoAcumulado;
    }

    public double getTaxaRendimentoAcumulada() {
        return rendimentoAcumulado / depositoInicial;
    }

    public double getTaxaAleatoria() {
        return gerador.nextDouble(0.5, 1);
    }

    public void run() {
        boolean threadInterrompida = Thread.currentThread().isInterrupted();
        while (!threadInterrompida) {
            try {
                atualizarRendimento(getTaxaAleatoria());
                sleep(PAUSA);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
