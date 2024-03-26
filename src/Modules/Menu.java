package Modules;

import java.util.Map;
import java.util.Scanner;
import Controller.Controller;
import Modules.Utilizador.Utilizador;

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
                case 2:
                    // adicionar uma atividade
                    // private String nome;
                    // private double tempo;
                    // private double frequenciaCardiacaMedia;
                    // private boolean isHard;
                    System.out.println("Nome: ");
                    String nomeAtividade = input.nextLine();
                    System.out.println("Tempo: ");
                    double tempo = input.nextDouble();
                    System.out.println("Frequência Cardíaca Média: ");
                    double frequenciaCardiacaMedia = input.nextDouble();
                    System.out.println("Dificuldade: ");
                    System.out.println("1. Fácil");
                    System.out.println("2. Difícil");
                    System.out.print("Escolha uma opção: ");
                    int dificuldade = input.nextInt();
                    boolean isHard = false;
                    if (dificuldade == 2) {
                        isHard = true;
                    }
                    // tipo de atividade, 1 - Distancia, 2 - DistanciaAltimetria, 3 - Repeticoes, 4
                    // - RepeticoesPeso

                    System.out.println("Tipo de atividade: ");
                    System.out.println("1. Distancia");
                    System.out.println("2. DistanciaAltimetria");
                    System.out.println("3. Repeticoes");
                    System.out.println("4. RepeticoesPeso");
                    System.out.print("Escolha uma opção: ");
                    int tipoAtividade = input.nextInt();
                    input.nextLine(); // Consume newline left-over´
                    String tipoAtivividadeString = "";
                    String strInputAtividade = "";

                    switch (tipoAtividade) {
                        case 1:
                            // Distancia
                            tipoAtivividadeString = "Distancia";
                            // perguntar ao utilizador a distancia
                            System.out.println("Distancia: ");
                            double distancia = input.nextDouble();
                            // criar string para ser lida pelo controller
                            // Inserir Atividade;Distancia;Corrida;60;120;false;10
                            StringBuilder sbA = new StringBuilder();
                            sbA.append("Inserir Atividade;");
                            sbA.append(tipoAtivividadeString).append(";");
                            sbA.append(nomeAtividade).append(";");
                            sbA.append(tempo).append(";");
                            sbA.append(frequenciaCardiacaMedia).append(";");
                            sbA.append(isHard).append(";");
                            sbA.append(distancia);

                            strInputAtividade = sbA.toString();
                            break;
                        case 2:
                            // DistanciaAltimetria
                            tipoAtivividadeString = "DistanciaAltimetria";
                            // perguntar ao utilizador a distancia e a altimetria
                            System.out.println("Distancia: ");
                            double distanciaA = input.nextDouble();
                            System.out.println("Altimetria: ");
                            double altimetria = input.nextDouble();
                            // criar string para ser lida pelo controller
                            // Inserir Atividade;DistanciaAltimetria;Corrida;60;120;false;10;20
                            StringBuilder sbB = new StringBuilder();
                            sbB.append("Inserir Atividade;");
                            sbB.append(tipoAtivividadeString).append(";");
                            sbB.append(nomeAtividade).append(";");
                            sbB.append(tempo).append(";");
                            sbB.append(frequenciaCardiacaMedia).append(";");
                            sbB.append(isHard).append(";");
                            sbB.append(distanciaA).append(";");
                            sbB.append(altimetria);

                            strInputAtividade = sbB.toString();

                            break;
                        case 3:

                            // Repeticoes
                            tipoAtivividadeString = "Repeticoes";
                            // perguntar ao utilizador a distancia e a altimetria
                            System.out.println("Repetições: ");
                            int repeticoes = input.nextInt();
                            // criar string para ser lida pelo controller
                            // Inserir Atividade;Repeticoes;Flexoes;60;120;false;10
                            StringBuilder sbC = new StringBuilder();
                            sbC.append("Inserir Atividade;");
                            sbC.append(tipoAtivividadeString).append(";");
                            sbC.append(nomeAtividade).append(";");
                            sbC.append(tempo).append(";");
                            sbC.append(frequenciaCardiacaMedia).append(";");
                            sbC.append(isHard).append(";");
                            sbC.append(repeticoes);

                            strInputAtividade = sbC.toString();

                            break;
                        case 4:
                            // RepeticoesPeso
                            tipoAtivividadeString = "RepeticoesPeso";
                            // perguntar ao utilizador a distancia e a altimetria
                            System.out.println("Repetições: ");
                            int repeticoesPeso = input.nextInt();
                            System.out.println("Peso: ");
                            double peso = input.nextDouble();
                            // criar string para ser lida pelo controller
                            // Inserir Atividade;RepeticoesPeso;Flexoes;60;120;false;10;20
                            StringBuilder sbD = new StringBuilder();
                            sbD.append("Inserir Atividade;");
                            sbD.append(tipoAtivividadeString).append(";");
                            sbD.append(nomeAtividade).append(";");
                            sbD.append(tempo).append(";");
                            sbD.append(frequenciaCardiacaMedia).append(";");
                            sbD.append(isHard).append(";");
                            sbD.append(repeticoesPeso).append(";");
                            sbD.append(peso);

                            strInputAtividade = sbD.toString();
                            break;

                        default:
                            System.out.println("Tipo inválido");
                            break;
                    }

                    System.out.println("Input: " + strInputAtividade);

                    this.Controller.collectDadosLine(strInputAtividade.split(";", 0));

                    break;
                case 3:
                    // adicionar um plano de treino
                    System.out.println("Email de utilizador: ");
                    String emailUtilizador = input.nextLine();
                    // pelo controller ir buscar o utilizador

                    Utilizador utilizador = this.Controller.getUtilizador(emailUtilizador);
                    if (utilizador == null) {
                        System.out.println("Utilizador não encontrado");
                        break;
                    }
                    int codigoUtilizador = utilizador.getCodigo();
                    // lista de atividades Map<Atividade, Integer> atividades; // Mapeia atividades
                    // para o número de iterações
                    System.out.println("Atividades Disponiveis: ");
                    this.Controller.collectDadosLine("Listar Atividades".split(";", 0));
                    System.out.println(
                            "Que atividades quer adicionar ao plano de treino? E as respetivas iterações (atividade1, iteracoes1; atividade2, iteracoes2; ...)");
                    String atividades = input.nextLine();

                    // data do plano de treino
                    System.out.println("Data do plano de treino: ");
                    String data = input.nextLine();
                    // criar mapa de atividades e iterações
                    StringBuilder sbPlano = new StringBuilder();
                    sbPlano.append("Inserir Plano de Treino;");
                    sbPlano.append(codigoUtilizador).append(";");
                    sbPlano.append(data).append(";");
                    sbPlano.append(atividades);

                    System.out.println("Input: " + sbPlano.toString());
                    System.err.println("Input: " + sbPlano.toString().split(";", 0));
                    this.Controller.collectDadosLine(sbPlano.toString().split(";", 0));
                case 13:
                    // Aqui você pode adicionar o código para listar utilizadores
                    System.out.println("Lista de utilizadores:");
                    this.Controller.collectDadosLine("Listar Utilizadores".split(";", 0));
                    break;

                case 14:
                    // Aqui você pode adicionar o código para listar atividades
                    System.out.println("Lista de atividades:");
                    this.Controller.collectDadosLine("Listar Atividades".split(";", 0));
                    break;
                case 15:
                    // Aqui você pode adicionar o código para listar planos de treino
                    System.out.println("Lista de planos de treino:");
                    this.Controller.collectDadosLine("Listar Planos de Treino".split(";", 0));
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