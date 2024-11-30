package questao_1;

public class CronometroUtil {
    Cronometro[] listaCronometros;
    private int indice;

    public CronometroUtil(int tamanho) {
        listaCronometros = new Cronometro[tamanho];
        indice = 0;
    }

    public Cronometro criarCronometro(String nome, boolean verbose) {
        if (indice < listaCronometros.length) {
            Cronometro cronometro = new Cronometro(verbose);
            cronometro.setName(nome);
            listaCronometros[indice] = cronometro;
            indice++;
            cronometro.start();
            return cronometro;
        }
        System.out.println("Limite de cronometros atingido.");
        return null;
    }

    public static void getCronometro(Cronometro c) {
        System.out.println(c.getName() + ": " + c.getContador());
    }

    public void getTodosCronometros() {
        for (int i = 0; i <= listaCronometros.length; i++) {
            if (listaCronometros[i] == null) {
                break;
            }
            System.out.println(listaCronometros[i].getName() + ": " + listaCronometros[i].getContador());
        }
        System.out.println();
    }
}
