package questao_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String opcao = "";
        CronometroUtil cronometroUtil = new CronometroUtil(5);
        Cronometro c1 = cronometroUtil.criarCronometro("Cronometro 1", false);
        Cronometro c2 = cronometroUtil.criarCronometro("Cronometro 2", false);
        Cronometro c3 = cronometroUtil.criarCronometro("Cronometro 3", false);
        Boolean encerrar = false;

        while (!encerrar) {
            try {
                Thread.sleep(5000);
                System.out.println("Escolha uma opção do menu: ");
                System.out.println("1 - Consultar um cronometro");
                System.out.println("2 - Consultar todos os cronometros em execução");
                System.out.println("3 - Encerrar o programa");
                opcao = s.nextLine();
                switch (opcao) {
                    case "1":
                        System.out.println("Digite o nome do cronometro que deseja consultar: ");
                        String nome = s.nextLine().trim();
                        switch (nome) {
                            case "Cronometro 1":
                                cronometroUtil.getCronometro(c1);
                                break;
                            case "Cronometro 2":
                                cronometroUtil.getCronometro(c2);
                                break;
                            case "Cronometro 3":
                                cronometroUtil.getCronometro(c3);
                                break;
                            default:
                                System.out.println("Cronometro não encontrado.");
                        }
                        break;
                    case "2":
                        cronometroUtil.getTodosCronometros();
                        break;
                    case "3":
                        encerrar = true;
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}