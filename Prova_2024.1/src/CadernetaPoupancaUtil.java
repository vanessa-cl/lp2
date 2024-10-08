import java.util.Arrays;
import java.util.Scanner;

public class CadernetaPoupancaUtil {
    public static void main(String[] args) throws Exception {
        // array de cadernetas de poupança
        CadernetaPoupanca[] cadernetas = new CadernetaPoupanca[7];

        // cadernetas de poupança pré-cadastradas para teste
        cadernetas[0] = new CadernetaPoupanca("João", 1, 125);
        cadernetas[1] = new CadernetaPoupanca("Alana", 10, 150);
        cadernetas[2] = new CadernetaPoupanca("Erica", 11, 200);
        cadernetas[3] = new CadernetaPoupanca("Jean", 16, 250);
        cadernetas[4] = new CadernetaPoupanca("Ana Luiza", 7, 300);
        cadernetas[5] = new CadernetaPoupanca("Bruna", 20, 350);
        cadernetas[6] = new CadernetaPoupanca("Gustavo", 1, 400);

        // variável para controle do encerramento do programa
        boolean encerrar = false;
        Scanner s = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de cadernetas de poupança!");
        while (!encerrar) {
            // menu de opções
            System.out.println("===============================================");
            System.out.println("Selecione uma opção do menu: ");
            System.out.println("""
                    1 - Cadastrar caderneta de poupança
                    2 - Atualizar rendimento acumulado
                    3 - Visualizar cadernetas e saldos pelo dia do aniversário
                    4 - Visualizar dados de uma caderneta específica
                    5 - Encerrar""");
            System.out.println("===============================================");

            int opcao = s.nextInt();
            boolean campoValido = false;
            boolean dadoEncontrado = false;
            String titular;
            int diaAniversario;
            double depositoInicial;

            switch (opcao) {
                case (1):
                    System.out.println("Preencha os dados da caderneta de poupança: ");
                    System.out.println("Digite o nome do titular: ");
                    titular = s.next();
                    while (!campoValido) {
                        try {
                            System.out.println("Digite o dia do aniversário: ");
                            diaAniversario = s.nextInt();
                            System.out.println("Digite o depósito inicial: ");
                            depositoInicial = s.nextDouble();
                            for (int i = 0; i < cadernetas.length; i++) {
                                if (cadernetas[i] == null) {
                                    cadernetas[i] = new CadernetaPoupanca(titular, diaAniversario, depositoInicial);
                                    cadernetas[i].start();
                                    break;
                                }
                            }
                            campoValido = true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage() + " Tente novamente!");
                        }
                    }
                    System.out.println("Caderneta cadastrada com sucesso!");
                    break;
                case (2):
                    System.out.println("Digite o nome do titular da caderneta: ");
                    titular = s.next();
                    while (!campoValido) {
                        System.out.println("Digite a taxa de rendimento: ");
                        double taxa = s.nextDouble();
                        for (int i = 0; i < cadernetas.length; i++) {
                            if (cadernetas[i] != null && cadernetas[i].getTitular().equals(titular)) {
                                try {
                                    System.out.println("Saldo anterior: R$" + cadernetas[i].getSaldo());
                                    cadernetas[i].atualizarRendimento(taxa);
                                    System.out.println("Saldo atual: R$" + cadernetas[i].getSaldo());
                                    campoValido = true;
                                    dadoEncontrado = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage() + " Tente novamente!");
                                }
                                break;
                            } else {
                                dadoEncontrado = false;
                                campoValido = true;
                                break;
                            }
                        }
                    }
                    if (dadoEncontrado) {
                        System.out.println("Rendimento acumulado atualizado com sucesso!");
                    } else {
                        System.out.println("Caderneta não encontrada!");
                    }
                    break;
                case (3):
                    System.out.println("Digite o dia do aniversário: ");
                    diaAniversario = s.nextInt();
                    for (int i = 0; i < cadernetas.length; i++) {
                        if (cadernetas[i] != null && cadernetas[i].getDiaAniversario() == diaAniversario) {
                            System.out.println("Titular: " + cadernetas[i].getTitular());
                            System.out.println("Saldo: " + cadernetas[i].getSaldo());
                            dadoEncontrado = true;
                        }
                    }
                    if (!dadoEncontrado) {
                        System.out.println("Não foram encontradas cadernetas com o dia de aniversário informado!");
                    }
                    break;
                case (4):
                    System.out.println("Digite o nome do titular da caderneta: ");
                    titular = s.next();
                    for (int i = 0; i < cadernetas.length; i++) {
                        if (cadernetas[i] != null && cadernetas[i].getTitular().equalsIgnoreCase(titular)) {
                            System.out.println("Depósito inicial: " + cadernetas[i].getDepositoInicial());
                            System.out.println("Dia do aniversário: " + cadernetas[i].getDiaAniversario());
                            System.out.println("Saldo: " + cadernetas[i].getSaldo());
                            dadoEncontrado = true;
                            break;
                        }
                    }
                    if (!dadoEncontrado) {
                        System.out.println("Não foram encontradas cadernetas para o titular informado!");
                    }
                    break;
                case (5):
                    encerrar = true;
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
