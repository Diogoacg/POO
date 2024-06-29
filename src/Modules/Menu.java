package Modules;

import java.util.Scanner;
import Controller.Controller;
import Modules.Utilizador.Utilizador;

public class Menu {
    private Controller Controller;
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public Menu(Controller Controller) {
        this.Controller = Controller;
    }

    public void Run() throws Exception {
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println(BLUE + "           Fitness           ");
            System.out.println(" ______________________________");
            System.out.println("| Dia: " + this.Controller.getGestor().currentDate + "              |");
            System.out.println("| Por favor, escolha uma opção:|");
            System.out.println("| 1. Inserir Utilizador        |");
            System.out.println("| 2. Inserir Atividade         |");
            System.out.println("| 3. Inserir Plano de Treino   |");
            System.out.println("| 4. Remover Utilizador        |");
            System.out.println("| 5. Remover Atividade         |");
            System.out.println("| 6. Remover Plano de Treino   |");
            System.out.println("| 7. Listar Utilizadores       |");
            System.out.println("| 8. Listar Atividades         |");
            System.out.println("| 9. Listar Planos de Treino   |");
            System.out.println("| 10. Registar Atividade       |");
            System.out.println("| 11. Obter Recordes           |");
            System.out.println("| 12. Avançar no tempo         |");
            System.out.println("| 13. Estatísticas             |");
            System.out.println("| 20. Sair                     |");
            System.out.println("|______________________________|");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    // Adicionar um utilizador
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
                            System.out.println(RED + "Tipo inválido" + BLUE);
                            break;
                    }
                    input.nextLine();

                    String codigo = "0";

                    StringBuilder sb = new StringBuilder();
                    sb.append("Inserir Utilizador;");
                    sb.append(user).append(";");
                    sb.append(codigo).append(";");
                    sb.append(nome).append(";");
                    sb.append(morada).append(";");
                    sb.append(email).append(";");
                    sb.append("0");

                    String strInput = sb.toString();

                    System.out.println(GREEN + "Utilizador introduzido: " + strInput + BLUE);

                    this.Controller.collectDadosLine(strInput.split(";", 0));

                    break;
                case 2:
                    // Adicionar uma atividade
                    System.out.println("Tempo: ");
                    double tempo = input.nextDouble();
                    System.out.println("Frequência Cardíaca Média: ");
                    double frequenciaCardiacaMedia = input.nextDouble();

                    System.out.println("Tipo de atividade: ");
                    System.out.println("1. Natacao");
                    System.out.println("2. Corrida em Pista");
                    System.out.println("3. Corrida no Monte");
                    System.out.println("4. Bicicleta no Monte");
                    System.out.println("5. Flexoes");
                    System.out.println("6. Abdominais");
                    System.out.println("7. Prensa");
                    System.out.println("8. Supino");
                    System.out.print("Escolha uma opção: ");
                    int tipoAtividade = input.nextInt();
                    input.nextLine();
                    String tipoAtivividadeString = "";
                    String strInputAtividade = "";

                    switch (tipoAtividade) {
                        case 1:
                            // Natacao
                            tipoAtivividadeString = "Natacao";
                            System.out.println("Distancia: ");
                            double distancia = input.nextDouble();
                            StringBuilder sbA = new StringBuilder();
                            sbA.append("Inserir Atividade;");
                            sbA.append(tipoAtivividadeString).append(";");
                            sbA.append(tempo).append(";");
                            sbA.append(frequenciaCardiacaMedia).append(";");
                            sbA.append(distancia);

                            strInputAtividade = sbA.toString();
                            break;
                        case 2:
                            // Corrida em Pista
                            tipoAtivividadeString = "Corrida em Pista";
                            System.out.println("Distancia: ");
                            double distanciaCP = input.nextDouble();
                            StringBuilder sbB = new StringBuilder();
                            sbB.append("Inserir Atividade;");
                            sbB.append(tipoAtivividadeString).append(";");
                            sbB.append(tempo).append(";");
                            sbB.append(frequenciaCardiacaMedia).append(";");
                            sbB.append(distanciaCP);

                            strInputAtividade = sbB.toString();

                            break;
                        case 3:

                            // Corrida no Monte
                            tipoAtivividadeString = "Corrida no Monte";
                            System.out.println("Distancia: ");
                            double distanciaCM = input.nextDouble();
                            System.out.println("Altimetria: ");
                            double altimetria = input.nextDouble();
                            StringBuilder sbC = new StringBuilder();
                            sbC.append("Inserir Atividade;");
                            sbC.append(tipoAtivividadeString).append(";");
                            sbC.append(tempo).append(";");
                            sbC.append(frequenciaCardiacaMedia).append(";");
                            sbC.append(distanciaCM).append(";");
                            sbC.append(altimetria);

                            strInputAtividade = sbC.toString();

                            break;
                        case 4:
                            // Bicicleta no Monte
                            tipoAtivividadeString = "Bicicleta no Monte";
                            System.out.println("Distancia: ");
                            double distanciaBM = input.nextDouble();
                            System.out.println("Altimetria: ");
                            double altimetriaBM = input.nextDouble();
                            StringBuilder sbD = new StringBuilder();
                            sbD.append("Inserir Atividade;");
                            sbD.append(tipoAtivividadeString).append(";");
                            sbD.append(tempo).append(";");
                            sbD.append(frequenciaCardiacaMedia).append(";");
                            sbD.append(distanciaBM).append(";");
                            sbD.append(altimetriaBM);

                            strInputAtividade = sbD.toString();
                            break;

                        case 5:
                            // Flexoes
                            tipoAtivividadeString = "Flexoes";
                            System.out.println("Repetições: ");
                            int repeticoes = input.nextInt();
                            StringBuilder sbE = new StringBuilder();
                            sbE.append("Inserir Atividade;");
                            sbE.append(tipoAtivividadeString).append(";");
                            sbE.append(tempo).append(";");
                            sbE.append(frequenciaCardiacaMedia).append(";");
                            sbE.append(repeticoes);

                            strInputAtividade = sbE.toString();
                            break;
                        case 6:
                            // Abdominais
                            tipoAtivividadeString = "Abdominais";
                            System.out.println("Repetições: ");
                            int repeticoesA = input.nextInt();
                            StringBuilder sbF = new StringBuilder();
                            sbF.append("Inserir Atividade;");
                            sbF.append(tipoAtivividadeString).append(";");
                            sbF.append(tempo).append(";");
                            sbF.append(frequenciaCardiacaMedia).append(";");
                            sbF.append(repeticoesA);

                            strInputAtividade = sbF.toString();
                            break;
                        case 7:
                            // Prensa
                            tipoAtivividadeString = "Prensa";
                            System.out.println("Repetições: ");
                            int repeticoesP = input.nextInt();
                            StringBuilder sbG = new StringBuilder();
                            sbG.append("Inserir Atividade;");
                            sbG.append(tipoAtivividadeString).append(";");
                            sbG.append(tempo).append(";");
                            sbG.append(frequenciaCardiacaMedia).append(";");
                            sbG.append(repeticoesP);

                            strInputAtividade = sbG.toString();
                            break;
                        case 8:
                            // Supino
                            tipoAtivividadeString = "Supino";
                            System.out.println("Repetições: ");
                            int repeticoesS = input.nextInt();
                            System.out.println("Peso: ");
                            double peso = input.nextDouble();
                            StringBuilder sbH = new StringBuilder();
                            sbH.append("Inserir Atividade;");
                            sbH.append(tipoAtivividadeString).append(";");
                            sbH.append(tempo).append(";");
                            sbH.append(frequenciaCardiacaMedia).append(";");
                            sbH.append(repeticoesS).append(";");
                            sbH.append(peso);

                            strInputAtividade = sbH.toString();
                            break;
                        default:
                            System.out.println(RED + "Tipo inválido" + BLUE);
                            break;
                    }

                    System.out.println("Input: " + strInputAtividade);

                    this.Controller.collectDadosLine(strInputAtividade.split(";", 0));

                    break;
                case 3:
                    // Adicionar um plano de treino
                    System.out.println("Email de utilizador: ");
                    String emailUtilizador = input.nextLine();

                    Utilizador utilizador = this.Controller.getUtilizador(emailUtilizador);
                    if (utilizador == null) {
                        System.out.println(RED + "Utilizador não encontrado" + BLUE);
                        break;
                    }
                    int codigoUtilizador = utilizador.getCodigo();

                    System.out.println("Atividades Disponiveis: ");
                    this.Controller.collectDadosLine("Listar Atividades".split(";", 0));
                    System.out.println(
                            "Que atividades quer adicionar ao plano de treino? E as respetivas iterações (atividade1, iteracoes1; atividade2, iteracoes2; ...)");
                    String atividades = input.nextLine();

                    // data do plano de treino
                    System.out.println("Data do plano de treino: ");
                    String data = input.nextLine();

                    StringBuilder sbPlano = new StringBuilder();
                    sbPlano.append("Inserir Plano de Treino;");
                    sbPlano.append(codigoUtilizador).append(";");
                    sbPlano.append(data).append(";");
                    sbPlano.append(atividades);

                    System.out.println("Input: " + sbPlano.toString());
                    System.err.println("Input: " + sbPlano.toString().split(";", 0));
                    this.Controller.collectDadosLine(sbPlano.toString().split(";", 0));
                    break;
                case 4:
                    // Remover um utilizador
                    System.out.println("Email de utilizador: ");
                    String emailUtilizadorRemover = input.nextLine();

                    Utilizador utilizadorRemover = this.Controller.getUtilizador(emailUtilizadorRemover);
                    if (utilizadorRemover == null) {
                        System.out.println(RED + "Utilizador não encontrado" + BLUE);
                        break;
                    }
                    int codigoUtilizadorRemover = utilizadorRemover.getCodigo();

                    StringBuilder sbRemover = new StringBuilder();
                    sbRemover.append("Remover Utilizador;");
                    sbRemover.append(codigoUtilizadorRemover);
                    this.Controller.collectDadosLine(sbRemover.toString().split(";", 0));
                    break;
                case 5:
                    // Remover uma atividade
                    System.out.println("Código da atividade: ");
                    int codigoAtividadeRemover = input.nextInt();

                    StringBuilder sbRemoverAtividade = new StringBuilder();
                    sbRemoverAtividade.append("Remover Atividade;");
                    sbRemoverAtividade.append(codigoAtividadeRemover);
                    this.Controller.collectDadosLine(sbRemoverAtividade.toString().split(";", 0));
                    break;
                case 6:
                    // Remover um plano de treino
                    System.out.println("Código do plano de treino: ");
                    int codigoPlanoRemover = input.nextInt();

                    StringBuilder sbRemoverPlano = new StringBuilder();
                    sbRemoverPlano.append("Remover Plano de Treino;");
                    sbRemoverPlano.append(codigoPlanoRemover);
                    this.Controller.collectDadosLine(sbRemoverPlano.toString().split(";", 0));
                    break;
                case 7:
                    // Listar utilizadores
                    System.out.println("Lista de utilizadores:");
                    this.Controller.collectDadosLine("Listar Utilizadores".split(";", 0));
                    break;
                case 8:
                    // Listar atividades
                    System.out.println("Lista de atividades:");
                    this.Controller.collectDadosLine("Listar Atividades".split(";", 0));
                    break;
                case 9:
                    // Listar planos de treino
                    System.out.println("Lista de planos de treino:");
                    this.Controller.collectDadosLine("Listar Planos de Treino".split(";", 0));
                    break;
                case 10:
                    // Registar atividade
                    System.out.println("Email de utilizador: ");
                    String emailUtilizadorRegisto = input.nextLine();

                    Utilizador utilizadorRegisto = this.Controller.getUtilizador(emailUtilizadorRegisto);
                    if (utilizadorRegisto == null) {
                        System.out.println(RED + "Utilizador não encontrado" + BLUE);
                        break;
                    }
                    int codigoUtilizadorRegisto = utilizadorRegisto.getCodigo();

                    System.out.println("Atividades Disponiveis: ");
                    this.Controller.collectDadosLine("Listar Atividades".split(";", 0));
                    System.out.println("Que atividade quer registar? ");
                    int codigoAtividade = input.nextInt();

                    System.out.println("Frequência Cardíaca Média: da atividade feita: ");
                    double frequenciaCardiacaMediaRegisto = input.nextDouble();
                    input.nextLine();

                    StringBuilder sbRegisto = new StringBuilder();
                    sbRegisto.append("Registar Atividade;");
                    sbRegisto.append(codigoUtilizadorRegisto).append(";");
                    sbRegisto.append(codigoAtividade).append(";");
                    sbRegisto.append(frequenciaCardiacaMediaRegisto);
                    this.Controller.collectDadosLine(sbRegisto.toString().split(";", 0));
                    break;
                case 11:
                    // Obter Recordes
                    StringBuilder sbRecordes = new StringBuilder();
                    sbRecordes.append("Listar Recordes;");
                    this.Controller.collectDadosLine(sbRecordes.toString().split(";", 0));
                    break;
                case 12:
                    // Avançar no tempo
                    System.out.println("Quantos dias quer avançar?");
                    int dias = input.nextInt();
                    input.nextLine();

                    StringBuilder sbTempo = new StringBuilder();
                    sbTempo.append("Avançar no Tempo;");
                    sbTempo.append(dias);

                    System.out.println("Input: " + sbTempo.toString());
                    System.err.println("Input: " + sbTempo.toString().split(";", 0));
                    this.Controller.collectDadosLine(sbTempo.toString().split(";", 0));
                    break;
                case 13:
                    // Estatísticas
                    System.out.println("Estatísticas disponíveis:");
                    System.out.println("1. Utilizador com mais calorias gastas num período ou desde sempre");
                    System.out.println("2. Utilizador com mais atividades num período ou desde sempre");
                    System.out.println("3. Atividade mais realizada");
                    System.out.println("4. Utilizador com mais kms num período ou desde sempre");
                    System.out.println("5. Utilizador com mais metros de altimetria num período ou desde sempre");
                    System.out.println("6. Plano de treino mais exigente em função do dispêndio de calorias proposto");
                    System.out.println("7. Listar as atividades de um utilizador");

                    System.out.print("Escolha uma opção: ");
                    int estatistica = input.nextInt();
                    input.nextLine();

                    switch (estatistica) {
                        case 1:
                            // Utilizador com mais calorias gastas
                            System.out.println("1. Desde sempre");
                            System.out.println("2. Num período");
                            System.out.print("Escolha uma opção: ");
                            int opcaoCalorias = input.nextInt();
                            input.nextLine();

                            if (opcaoCalorias == 2) {
                                System.out.println("Data de início: (formato dd/MM/yyyy)");
                                String dataInicio = input.nextLine();
                                System.out.println("Data de fim: (formato dd/MM/yyyy)");
                                String dataFim = input.nextLine();

                                StringBuilder sbEstatistica1Periodo = new StringBuilder();
                                sbEstatistica1Periodo.append("Estatistica;1;");
                                sbEstatistica1Periodo.append(dataInicio).append(";");
                                sbEstatistica1Periodo.append(dataFim);
                                this.Controller.collectDadosLine(sbEstatistica1Periodo.toString().split(";", 0));
                                break;
                            }

                            else if (opcaoCalorias == 1) {
                                StringBuilder sbEstatistica1 = new StringBuilder();
                                sbEstatistica1.append("Estatistica;1");
                                this.Controller.collectDadosLine(sbEstatistica1.toString().split(";", 0));
                                break;
                            } else {
                                System.out.println(RED + "Opção inválida. Por favor, tente novamente." + BLUE);
                                break;
                            }

                        case 2:
                            // Utilizador com mais atividades
                            System.out.println("1. Desde sempre");
                            System.out.println("2. Num período");
                            System.out.print("Escolha uma opção: ");
                            int opcaoAtividades = input.nextInt();
                            input.nextLine();

                            if (opcaoAtividades == 2) {
                                System.out.println("Data de início: (formato dd/MM/yyyy)");
                                String dataInicio = input.nextLine();
                                System.out.println("Data de fim: (formato dd/MM/yyyy)");
                                String dataFim = input.nextLine();

                                StringBuilder sbEstatistica2Periodo = new StringBuilder();
                                sbEstatistica2Periodo.append("Estatistica;2;");
                                sbEstatistica2Periodo.append(dataInicio).append(";");
                                sbEstatistica2Periodo.append(dataFim);
                                this.Controller.collectDadosLine(sbEstatistica2Periodo.toString().split(";", 0));
                                break;
                            }

                            else if (opcaoAtividades == 1) {
                                StringBuilder sbEstatistica2 = new StringBuilder();
                                sbEstatistica2.append("Estatistica;2");
                                this.Controller.collectDadosLine(sbEstatistica2.toString().split(";", 0));
                                break;
                            } else {
                                System.out.println(RED + "Opção inválida. Por favor, tente novamente." + BLUE);
                                break;
                            }

                        case 3:
                            // Atividade mais realizada
                            StringBuilder sbEstatistica3 = new StringBuilder();
                            sbEstatistica3.append("Estatistica;");
                            sbEstatistica3.append("3");
                            this.Controller.collectDadosLine(sbEstatistica3.toString().split(";", 0));
                            break;

                        case 4:
                            // Utilizador com mais kms
                            System.out.println("1. Desde sempre");
                            System.out.println("2. Num período");
                            System.out.print("Escolha uma opção: ");
                            int opcaoKms = input.nextInt();

                            if (opcaoKms == 2) {
                                // limpar buffer
                                input.nextLine();
                                System.out.println("Email de utilizador: ");
                                String emailUtilizadorKms = input.nextLine();
                                System.out.println("Data de início: (formato dd/MM/yyyy)");
                                String dataInicio = input.nextLine();
                                System.out.println("Data de fim: (formato dd/MM/yyyy)");
                                String dataFim = input.nextLine();

                                StringBuilder sbEstatistica4Periodo = new StringBuilder();
                                sbEstatistica4Periodo.append("Estatistica;4;");
                                sbEstatistica4Periodo.append(emailUtilizadorKms).append(";");
                                sbEstatistica4Periodo.append(dataInicio).append(";");
                                sbEstatistica4Periodo.append(dataFim);
                                this.Controller.collectDadosLine(sbEstatistica4Periodo.toString().split(";", 0));
                                break;
                            }

                            else if (opcaoKms == 1) {
                                // limpar buffer
                                input.nextLine();
                                StringBuilder sbEstatistica4 = new StringBuilder();
                                System.out.println("Email de utilizador: ");
                                String emailUtilizadorKms = input.nextLine();
                                sbEstatistica4.append("Estatistica;4;");
                                sbEstatistica4.append(emailUtilizadorKms);
                                this.Controller.collectDadosLine(sbEstatistica4.toString().split(";", 0));
                                break;
                            } else {
                                System.out.println(RED + "Opção inválida. Por favor, tente novamente." + BLUE);
                                break;
                            }
                        case 5:
                            // Utilizador com mais metros de altimetria
                            System.out.println("1. Desde sempre");
                            System.out.println("2. Num período");
                            System.out.print("Escolha uma opção: ");
                            int opcaoAltimetria = input.nextInt();

                            if (opcaoAltimetria == 2) {
                                // limpar buffer
                                input.nextLine();
                                System.out.println("Email de utilizador: ");
                                String emailUtilizadorAltimetria = input.nextLine();
                                System.out.println("Data de início: (formato dd/MM/yyyy)");
                                String dataInicio = input.nextLine();
                                System.out.println("Data de fim: (formato dd/MM/yyyy)");
                                String dataFim = input.nextLine();

                                StringBuilder sbEstatistica5Periodo = new StringBuilder();
                                sbEstatistica5Periodo.append("Estatistica;5;");
                                sbEstatistica5Periodo.append(emailUtilizadorAltimetria).append(";");
                                sbEstatistica5Periodo.append(dataInicio).append(";");
                                sbEstatistica5Periodo.append(dataFim);
                                this.Controller.collectDadosLine(sbEstatistica5Periodo.toString().split(";", 0));
                                break;
                            }

                            else if (opcaoAltimetria == 1) {
                                // limpar buffer
                                input.nextLine();
                                StringBuilder sbEstatistica5 = new StringBuilder();
                                System.out.println("Email de utilizador: ");
                                String emailUtilizadorAltimetria = input.nextLine();
                                sbEstatistica5.append("Estatistica;5;");
                                sbEstatistica5.append(emailUtilizadorAltimetria);
                                this.Controller.collectDadosLine(sbEstatistica5.toString().split(";", 0));
                                break;
                            } else {
                                System.out.println(RED + "Opção inválida. Por favor, tente novamente." + BLUE);
                                break;
                            }
                        case 6:
                            // Plano de treino mais exigente
                            StringBuilder sbEstatistica6 = new StringBuilder();
                            sbEstatistica6.append("Estatistica;");
                            sbEstatistica6.append("6");
                            this.Controller.collectDadosLine(sbEstatistica6.toString().split(";", 0));
                            break;

                        case 7:
                            // Listar as atividades de um utilizador
                            System.out.println("Email de utilizador: ");
                            String emailUtilizadorAtividades = input.nextLine();

                            StringBuilder sbEstatistica7 = new StringBuilder();
                            sbEstatistica7.append("Estatistica;");
                            sbEstatistica7.append("7;");
                            sbEstatistica7.append(emailUtilizadorAtividades);
                            this.Controller.collectDadosLine(sbEstatistica7.toString().split(";", 0));
                            break;

                        default:
                            System.out.println(RED + "Opção inválida. Por favor, tente novamente." + BLUE);
                            break;
                    }
                    break;
                case 20:
                    continuar = false;
                    break;

                default:
                    System.out.println(RED + "Opção inválida. Por favor, tente novamente." + BLUE);
            }
        }

        input.close();
        System.out.println("Bye!");
    }
}