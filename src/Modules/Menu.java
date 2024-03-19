package Modules;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import Modules.Atividade.Atividade;
import Modules.Atividade.AtividadeRepeticoes;
import Modules.Atividade.AtividadeDistancia;
import Modules.Atividade.AtividadeDistanciaAltimetria;
import Modules.Atividade.AtividadeRepeticoesPesos;
import Modules.Utilizador.Utilizador;
import Modules.Utilizador.UtilizadorProfissional;
import Modules.Utilizador.UtilizadorAmador;
import Modules.Utilizador.UtilizadorPraticanteOcasional;
import Modules.PlanoTreino;
import Modules.RegistroAtividade;
import Controller.Controller;

public class Menu {
    private Scanner scanner;
    Controller controller = new Controller();

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        System.out.println("1. Criar utilizador");
        System.out.println("2. Criar atividade");
        System.out.println("3. Criar plano de treino");
        System.out.println("4. Registar atividade a utilizador");
        System.out.println("5. Sair");
    }

    public int obterOpcao() {
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;

    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                // perguntar se é profissional, amador ou ocasional
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Morada: ");
                String morada = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                System.out.println("Tipo: ");
                System.out.println("1. Profissional");
                System.out.println("2. Amador");
                System.out.println("3. Ocasional");
                System.out.print("Escolha uma opção: ");
                int tipo = scanner.nextInt();
                criarUtilizador(nome, morada, email, tipo);

                break;
            case 2:
                // Implementar a lógica para criar uma atividade
                System.out.println("Nome: ");
                String nomeAtividade = scanner.nextLine();
                System.out.println("Tempo: ");
                double tempo = scanner.nextDouble();
                System.out.println("Dificuldade: \n 1. Fácil \n 2. Difícil");
                boolean isHard = scanner.nextInt() == 2;
                System.out.println(
                        "Tipo: \n 1. Repetições \n 2. Distância \n 3. Distância e altimetria \n 4. Repetições e pesos");
                int tipoAtividade = scanner.nextInt();
                criarAtividade(nomeAtividade, tempo, isHard, tipoAtividade);
                break;
            case 3:
                Date data = new Date();
                // Implementar a lógica para criar um plano de treino
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                System.out.print("Insira uma data (dd/mm/yyyy): ");
                String dataStr = scanner.nextLine();

                try {
                    data = formato.parse(dataStr);
                    System.out.println("Data inserida: " + formato.format(data));
                } catch (Exception e) {
                    System.out.println("Formato de data inválido.");
                }

                System.out.println("Nome de Utilizador: ");
                String nomeUtilizador = scanner.nextLine();
                List<Utilizador> utilizadores = controller.obterUtilizadoresPorNome(nomeUtilizador);
                if (utilizadores.size() == 0) {
                    System.out.println("Utilizador não encontrado");
                    return;
                } else if (utilizadores.size() > 1) {
                    System.out.println("Vários utilizadores encontrados. Por favor, escolha um:");
                    for (int i = 0; i < utilizadores.size(); i++) {
                        System.out.println(i + ". " + utilizadores.get(i).getNome());
                    }
                    int index = scanner.nextInt();
                    criarPlanoTreino(utilizadores.get(index), data);
                } else {
                    Utilizador utilizador = utilizadores.get(0);
                    criarPlanoTreino(utilizador, data);
                }
                break;
            case 4:
                // Implementar a lógica para registar uma atividade a um utilizador

                System.out.println("Nome de Utilizador: ");
                String nomeUtilizador4 = scanner.next();
                List<Utilizador> utilizadores4 = controller.obterUtilizadoresPorNome(nomeUtilizador4);
                if (utilizadores4.size() == 0) {
                    System.out.println("Utilizador não encontrado");
                    return;
                } else if (utilizadores4.size() > 1) {
                    System.out.println("Vários utilizadores encontrados. Por favor, escolha um:");
                    for (int i = 0; i < utilizadores4.size(); i++) {
                        System.out.println(i + ". " + utilizadores4.get(i).getNome());
                    }
                    int index = scanner.nextInt();
                    registarAtividade(utilizadores4.get(index));
                } else {
                    Utilizador utilizador = utilizadores4.get(0);
                    registarAtividade(utilizador);
                }

                break;
            case 5:
                System.out.println("Saindo do programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

    // Método para criar um utilizador, recebe nome, morada, email, frequencia
    // cardiaca deve ser nula por default e tipo
    private void criarUtilizador(String nome, String morada, String email, int tipo) {
        String codigo = UUID.randomUUID().toString();
        double frequenciaCardiacaMedia = 0;
        Utilizador utilizador = null;
        switch (tipo) {
            case 1:
                utilizador = new UtilizadorProfissional(codigo, nome, morada, email, frequenciaCardiacaMedia);
                break;
            case 2:
                utilizador = new UtilizadorAmador(codigo, nome, morada, email, frequenciaCardiacaMedia);
                break;
            case 3:
                utilizador = new UtilizadorPraticanteOcasional(codigo, nome, morada, email, frequenciaCardiacaMedia);
                break;
            default:
                System.out.println("Tipo inválido");
                break;
        }
        System.out.println(utilizador.toString());
        controller.adicionarUtilizador(utilizador);

    }

    // // constructors
    // public Atividade(String nome, double tempo, double frequenciaCardiacaMedia,
    // boolean isHard) {
    // this.nome = nome;
    // this.tempo = tempo;
    // this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
    // this.isHard = isHard;
    // }
    private void criarAtividade(String nome, double tempo, boolean isHard, int tipo) {
        // Implementar a lógica para criar uma atividade
        double frequenciaCardiacaMedia = 0; // se uma atividade for conluida com sucesso, a frequencia cardiaca media é
                                            // atualizada
        Atividade atividade = null;
        switch (tipo) {
            case 1:
                // perguntar numero de repeticoes
                System.out.println("Repetições: ");
                int repeticoes = scanner.nextInt();
                atividade = new AtividadeRepeticoes(nome, tempo, frequenciaCardiacaMedia,
                        isHard, repeticoes);
                break;
            case 2:
                // perguntar distancia
                System.out.println("Distância: ");
                double distancia = scanner.nextDouble();
                atividade = new AtividadeDistancia(nome, tempo, frequenciaCardiacaMedia,
                        isHard, distancia);
                break;
            case 3:
                // perguntar distancia e altimetria
                System.out.println("Distância: ");
                double distanciaAltimetria = scanner.nextDouble();
                System.out.println("Altimetria: ");
                double altimetria = scanner.nextDouble();
                atividade = new AtividadeDistanciaAltimetria(nome, tempo, frequenciaCardiacaMedia,
                        isHard, distanciaAltimetria, altimetria);

                break;
            case 4:
                // perguntar peso e repeticoes
                System.out.println("Peso: ");
                double peso = scanner.nextDouble();
                System.out.println("Repetições: ");
                int repeticoesPesos = scanner.nextInt();

                atividade = new AtividadeRepeticoesPesos(nome, tempo, frequenciaCardiacaMedia,
                        isHard, repeticoesPesos, peso);

            default:
                System.out.println("Tipo inválido");
                break;
        }
        System.out.println(atividade.toString());
        controller.adicionarAtividade(atividade);
        System.out.println(controller.atividades.toString());

    }

    public void criarPlanoTreino(Utilizador utilizador, Date data) {
        PlanoTreino planoTreino = new PlanoTreino(utilizador, data);

        boolean adicionarMais = true;
        while (adicionarMais) {
            controller.listarAtividades();

            System.out.print("Escolha uma atividade: ");
            scanner.nextLine(); // provisório enquanto nao percebo pq da erro sem isto
            String nomeAtividade = scanner.nextLine();

            // escolher numero de iteracoes
            System.out.print("Número de iterações: ");
            int iteracoes = scanner.nextInt();

            Atividade atividadeEscolhida = controller.encontrarAtividadePorNome(nomeAtividade);
            if (atividadeEscolhida != null) {
                planoTreino.adicionarAtividade(atividadeEscolhida, iteracoes);
            }

            System.out.print("Deseja adicionar mais atividades? (s/n) ");
            String resposta = scanner.nextLine();
            adicionarMais = resposta.equalsIgnoreCase("s");
        }

        System.out.println(planoTreino.toString());

    }

    public void registarAtividade(Utilizador utilizador) {
        // Implementar a lógica para registar uma atividade a um utilizador

        // get dataAtual;
        Date dataAtual = new Date();

        // selecionar atividade concluida
        controller.listarAtividades();
        System.out.print("Escolha uma atividade: ");
        scanner.nextLine(); // provisório enquanto nao percebo pq da erro sem isto
        String nomeAtividade = scanner.nextLine();

        Atividade atividadeEscolhida = controller.encontrarAtividadePorNome(nomeAtividade);

        // registar atividade
        RegistroAtividade registroAtividade = new RegistroAtividade(utilizador, atividadeEscolhida, dataAtual);
        System.out.println(registroAtividade.toString());

    }

}
