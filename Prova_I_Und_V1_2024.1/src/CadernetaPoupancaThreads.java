import java.util.Scanner;

public class CadernetaPoupancaThreads {
    public static void main(String[] args) throws Exception {
        CadernetaPoupanca[] cadernetas = new CadernetaPoupanca[3];

        // cadernetas de poupança pré-cadastradas para teste
        cadernetas[0] = new CadernetaPoupanca("João", 1, 125);
        cadernetas[1] = new CadernetaPoupanca("João", 1, 150);
        cadernetas[2] = new CadernetaPoupanca("João", 1, 200);
        for (int i = 0; i < cadernetas.length; i++) {
            cadernetas[i].start();
        }

        Scanner s = new Scanner(System.in);
        boolean encerrar = false;

        System.out.println("Bem-vindo ao sistema de consulta de saldo cadernetas de poupança!");
        while (!encerrar) {
            // menu de opções
            System.out.println("===============================================");
            System.out.println("Selecione uma opção do menu: ");
            System.out.println("""
                    1 - Cadastrar caderneta de poupança
                    2 - Consultar o saldo de uma caderneta específica
                    3 - Encerrar""");
            System.out.println("===============================================");

            int opcao = s.nextInt();
            boolean campoValido = false;
            String titular;
            int diaAniversario;
            double depositoInicial;
            int caderneta;

            switch (opcao) {
                case (1):
                    System.out.println("Preencha os dados da caderneta de poupança: ");
                    System.out.println("Digite o nome do titular: ");
                    titular = s.next();
                    while (!campoValido) {
                        try {
                            System.out.println("Digite o dia do aniversário: ");
                            diaAniversario = s.nextInt();
                            for (int i = 0; i < cadernetas.length; i++) {
                                System.out.println("Digite o depósito inicial da caderneta N°" + (i + 1) + ": ");
                                depositoInicial = s.nextDouble();
                                if (cadernetas[i] == null) {
                                    cadernetas[i] = new CadernetaPoupanca(titular, diaAniversario, depositoInicial);
                                    cadernetas[i].start();
                                }
                                campoValido = true;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage() + " Tente novamente!");
                        }
                    }
                    System.out.println("Caderneta cadastrada com sucesso!");
                    break;
                case (2):
                    System.out.println("Insira o número da caderneta de poupança que deseja consultar (1, 2 ou 3): ");
                    caderneta = s.nextInt();
                    while (!campoValido) {
                        for (int i = 0; i < cadernetas.length; i++) {
                            if (cadernetas[caderneta - 1] != null) {
                                System.out.println("Saldo atual: R$" + cadernetas[caderneta - 1].getSaldo());
                                campoValido = true;
                                break;
                            }
                        }
                        if (!campoValido) {
                            System.out.println("Caderneta não encontrada! Tente novamente.");
                        }
                    }
                    break;
                case (3):
                    encerrar = true;
                    for (int i = 0; i < cadernetas.length; i++) {
                        if (cadernetas[i] != null) {
                            cadernetas[i].interrupt();
                        }
                    }
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
