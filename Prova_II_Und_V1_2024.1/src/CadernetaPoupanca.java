public class CadernetaPoupanca {
    private String titular; // nome do titular
    private int diaAniversario; // dia de aniversário da caderneta de poupança (entre 1 e 31)
    private double depositoInicial; // depósito inicial
    private double rendimentoAcumulado; // rendimento acumulado da caderneta de poupança

    // construtor
    public CadernetaPoupanca(String titular, int diaAniversario, double depositoInicial) {
        // inicialização de campos de instância com parâmetros
        this.titular = titular;
        this.diaAniversario = diaAniversario;
        this.depositoInicial = depositoInicial;

        // inicialização de rendimentos acumulados
        this.rendimentoAcumulado = 0;
    }

    // metódos getter
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

    // atualização de rendimento acumulado considerando-se saldo atualizado e
    // taxa percentual de rendimento
    public void atualizarRendimento(double prTaxa) {
        // cálculo de rendimento considerando-se taxa de rendimento e rendimento acumulado
        double rendimento = (depositoInicial + rendimentoAcumulado) * prTaxa / 100;

        // atualização de rendimento acumulado
        this.rendimentoAcumulado += rendimento;
    }

    // retorno de saldo atualizado de caderneta considerando-se depósito inicial e rendimento acumulado
    public double getSaldo() {
        // retorno de soma de depósito inicial com rendimento acumulado
        return this.depositoInicial + this.rendimentoAcumulado;
    }

    // retorno de taxa percentual de rendimento acumulada considerando-se depósito inicial e
    // rendimento acumulado
    public double getTaxaRendimentoAcumulada() {
        return this.rendimentoAcumulado / getSaldo() * 100;
    }
}
