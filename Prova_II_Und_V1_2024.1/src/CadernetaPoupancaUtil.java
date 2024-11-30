import java.util.*;

public class CadernetaPoupancaUtil {

    public static void main(String[] args) {
        // Lista de cadernetas de poupança
        ArrayList<CadernetaPoupanca> cadernetasLista = new ArrayList<CadernetaPoupanca>();

        // Cadernetas de poupança para teste
//        cadernetasLista.add(new CadernetaPoupanca("João", 1, 125));
//        cadernetasLista.add(new CadernetaPoupanca("Alana", 10, 150));
//        cadernetasLista.add(new CadernetaPoupanca("Erica", 11, 200));
//        cadernetasLista.add(new CadernetaPoupanca("Jean", 16, 250));
//        cadernetasLista.add(new CadernetaPoupanca("Ana Luiza", 7, 300));
//        cadernetasLista.add(new CadernetaPoupanca("Bruna", 20, 350));
//        cadernetasLista.add(new CadernetaPoupanca("Gustavo", 1, 400));

        Scanner s = new Scanner(System.in);
        String titular;
        int diaAniversario;
        CadernetaPoupanca cadernetaEncontrada = null;
        boolean encerrar = false;
        int opcao;

        System.out.println("Bem-vindo ao sistema de caderneta de poupança!");
        while (!encerrar) {
            menu();
            opcao = s.nextInt();
            switch (opcao) {
                // Cadastro de caderneta de poupança
                case 1:
                    System.out.println("Digite o nome do titular: ");
                    titular = s.next();
                    System.out.println("Digite o dia de aniversário da caderneta de poupança: ");
                    diaAniversario = s.nextInt();
                    System.out.println("Digite o depósito inicial: ");
                    double depositoInicial = s.nextDouble();
                    CadernetaPoupanca novaCaderneta = new CadernetaPoupanca(titular, diaAniversario, depositoInicial);
                    cadernetasLista.add(novaCaderneta);
                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                // Atualização de rendimento de caderneta de poupança
                case 2:
                    System.out.println("Digite o nome do titular da caderneta que deseja atualizar o rendimento: ");
                    titular = s.next();
                    for (CadernetaPoupanca caderneta : cadernetasLista) {
                        if (caderneta.getTitular().equalsIgnoreCase(titular)) {
                            cadernetaEncontrada = caderneta;
                            break;
                        }
                        cadernetaEncontrada = null;
                    }
                    if (cadernetaEncontrada == null) {
                        System.out.println("Caderneta não encontrada!");
                        return;
                    }
                    System.out.println("Rendimento atual: " + cadernetaEncontrada.getRendimentoAcumulado());
                    System.out.println("Digite a taxa de rendimento: ");
                    double taxaRendimento = s.nextDouble();
                    cadernetaEncontrada.atualizarRendimento(taxaRendimento);
                    System.out.println("Novo rendimento: " + cadernetaEncontrada.getRendimentoAcumulado());
                    System.out.println("Rendimento atualizado com sucesso!");
                    break;
                // Consulta de cadernetas de poupança por dia de aniversário
                case 3:
                    System.out.println("Digite o dia de aniversário que deseja consultar: ");
                    diaAniversario = s.nextInt();
                    for (CadernetaPoupanca caderneta : cadernetasLista) {
                        if (caderneta.getDiaAniversario() == diaAniversario) {
                            System.out.println("Titular: " + caderneta.getTitular() + "\nSaldo: " + caderneta.getSaldo());
                            System.out.println("__________________________________________________________");
                        }
                    }
                    break;
                // Consulta de cadernetas de poupança por titular
                case 4:
                    System.out.println("Digite o nome do titular que deseja consultar as cadernetas: ");
                    titular = s.next();
                    for (CadernetaPoupanca caderneta : cadernetasLista) {
                        if (caderneta.getTitular().equalsIgnoreCase(titular)) {
                            System.out.println("Depósito inicial: " + caderneta.getDepositoInicial() + "\nDia de aniversário: " + caderneta.getDiaAniversario() + "\nSaldo: " + caderneta.getSaldo());
                            System.out.println("__________________________________________________________");
                        }
                    }
                    break;
                // Encerrar
                case 5:
                    encerrar = true;
                    System.out.println("Encerrando o programa...");
                    // Questão 3 e 4
                    HashSet<Integer> diasAniversario = new HashSet<Integer>();
                    ArrayDeque<String> titulares = new ArrayDeque<>();
                    for (CadernetaPoupanca caderneta : cadernetasLista) {
                        if (caderneta.getTaxaRendimentoAcumulada() != 0) {
                            diasAniversario.add(caderneta.getDiaAniversario());
                        } else {
                            titulares.add(caderneta.getTitular());
                        }
                    }
                    System.out.println("Quantidade total de dias de aniversário com rendimentos acumulados: " + diasAniversario.size());
                    System.out.println("Titulares com rendimento acumulado igual a zero: ");
                    do {
                        System.out.println(titulares.poll());
                    } while (!titulares.isEmpty());
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Selecione uma opção:");
        System.out.println("__________________________________________________________");
        System.out.println("1 - Cadastrar caderneta de poupança");
        System.out.println("2 - Atualizar rendimento de caderneta de poupança");
        System.out.println("3 - Consultar cadernetas de poupança por dia de aniversário");
        System.out.println("4 - Consultar cadernetas de poupança por titular");
        System.out.println("5 - Encerrar");
        System.out.println("__________________________________________________________");
    }
}
