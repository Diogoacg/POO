package Modules;

import java.util.Scanner;
import Controller.Controller;

public class Menu {
    private Controller Controller;

    public Menu(Controller Controller) {
        this.Controller = Controller;
    }

    public void Run() throws Exception {
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Por favor, escolha uma opção:");
            System.out.println("1. Inserir Utilizador");
            System.out.println("2. Inserir Atividade");
            System.out.println("3. Inserir Plano de Treino");
            System.out.println("4. Remover Utilizador");
            System.out.println("5. Remover Atividade");
            System.out.println("6. Remover Plano de Treino");
            // System.out.println("7. Atualizar Utilizador");
            // System.out.println("8. Atualizar Atividade");
            // System.out.println("9. Atualizar Plano de Treino");
            System.out.println("10. Obter Utilizador");
            System.out.println("11. Obter Atividade");
            System.out.println("12. Obter Plano de Treino");
            System.out.println("13. Listar Utilizadores");
            System.out.println("14. Listar Atividades");
            System.out.println("15. Listar Planos de Treino");
            // System.out.println("16. Calcular Calorias");
            System.out.println("17. Registrar Atividade");
            // System.out.println("18. Obter Recordes");
            System.out.println("19. Sair");

            int opcao = input.nextInt();
            input.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    // Aqui você pode adicionar o código para inserir um utilizador
                    System.out.println("Nome: ");
                    String nome = input.nextLine();
                    System.out.println("Morada: ");
                    String morada = input.nextLine();
                    System.out.println("Email: ");
                    String email = input.nextLine();
                    System.out.println("Tipo: ");
                    System.out.println("1. Profissional");
                    System.out.println("2. Amador");
                    System.out.println("3. Ocasional");
                    System.out.print("Escolha uma opção: ");
                    int tipo = input.nextInt();
                    String user = "";

                    switch (tipo) {
                        case 1:
                            user = "Profissional";
                            break;
                        case 2:
                            user = "Amador";
                            break;
                        case 3:
                            user = "Ocasional";
                            break;
                        default:
                            System.out.println("Tipo inválido");
                            break;
                    }
                    input.nextLine(); // Consume newline left-over

                    String codigo = "0"; // Código é gerado automaticamente

                    // criar string para ser lida pelo controller
                    // Inserir Utilizador;Amador;123;Diogo;dsfgd;efsfff;70
                    StringBuilder sb = new StringBuilder();
                    sb.append("Inserir Utilizador;");
                    sb.append(user).append(";");
                    sb.append(codigo).append(";");
                    sb.append(nome).append(";");
                    sb.append(morada).append(";");
                    sb.append(email).append(";");
                    sb.append("0");

                    String strInput = sb.toString();

                    System.out.println("Input: " + strInput);

                    this.Controller.collectDadosLine(strInput.split(";", 0));

                    break;
                // ... outros casos ...
                case 13:
                    // Aqui você pode adicionar o código para listar utilizadores
                    System.out.println("Lista de utilizadores:");
                    this.Controller.collectDadosLine("Listar Utilizadores".split(";", 0));
                    break;
                case 19:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        input.close();
        System.out.println("Bye!");
    }
}