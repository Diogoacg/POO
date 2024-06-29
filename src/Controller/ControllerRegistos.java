package Controller;

import Modules.Gestores.*;
import Modules.Utilizador.*;
import Modules.Atividade.*;
import Modules.PlanoTreino;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControllerRegistos {
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void insertRegisto(Gestor gestor, String[] tokens, int flag) throws Exception {
        switch (flag) {
            case Controller.INSERT_UTILIZADOR:
                Utilizador utilizador;
                switch (tokens[1]) {
                    case "Amador":
                        utilizador = new UtilizadorAmador(
                                tokens[2],
                                tokens[3],
                                tokens[4],
                                tokens[5],
                                Double.parseDouble(tokens[6]));
                        break;
                    case "Ocasional":
                        utilizador = new UtilizadorPraticanteOcasional(
                                tokens[2],
                                tokens[3],
                                tokens[4],
                                tokens[5],
                                Double.parseDouble(tokens[6]));
                        break;
                    case "Profissional":
                        utilizador = new UtilizadorProfissional(
                                tokens[2],
                                tokens[3],
                                tokens[4],
                                tokens[5],
                                Double.parseDouble(tokens[6]));
                        System.err.println(utilizador.getNome());
                        break;
                    default:
                        throw new Exception("Tipo de utilizador desconhecido: \n" + tokens[1]);
                }
                gestor.addUtilizador(utilizador);
                System.out.println(GREEN + "Utilizador adicionado com sucesso \n" + utilizador.getNome() + BLUE);
                break;

            case Controller.INSERT_ATIVIDADE:
                Atividade atividade;
                switch (tokens[1]) {
                    case "Natacao":
                        atividade = new Natacao(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]));
                        break;
                    case "Corrida em Pista":
                        atividade = new CorridaEmPista(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]));
                        break;
                    case "Corrida no Monte":
                        atividade = new CorridaNoMonte(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]),
                                Double.parseDouble(tokens[5]));
                        break;
                    case "Bicicleta no Monte":
                        atividade = new BicicletaNoMonte(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]),
                                Double.parseDouble(tokens[5]));
                        break;
                    case "Flexoes":
                        atividade = new Flexoes(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Integer.parseInt(tokens[4]));
                        break;
                    case "Abdominais":
                        atividade = new Abdominais(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Integer.parseInt(tokens[4]));
                        break;
                    case "Prensa":
                        atividade = new Prensa(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Integer.parseInt(tokens[4]),
                                Double.parseDouble(tokens[5]));
                        break;
                    case "Supino":
                        atividade = new Supino(
                                Double.parseDouble(tokens[2]),
                                Double.parseDouble(tokens[3]),
                                Integer.parseInt(tokens[4]),
                                Double.parseDouble(tokens[5]));
                        break;
                    // case "DistanciaAltimetria":
                    // atividade = new AtividadeDistanciaAltimetria(
                    // tokens[2],
                    // Double.parseDouble(tokens[3]),
                    // Double.parseDouble(tokens[4]),
                    // Boolean.parseBoolean(tokens[5]),
                    // Double.parseDouble(tokens[6]),
                    // Double.parseDouble(tokens[7]));
                    // break;
                    // case "Repeticoes":
                    // atividade = new AtividadeRepeticoes(
                    // tokens[2],
                    // Double.parseDouble(tokens[3]),
                    // Double.parseDouble(tokens[4]),
                    // Boolean.parseBoolean(tokens[5]),
                    // Integer.parseInt(tokens[6]));
                    // break;
                    // case "RepeticoesPeso":
                    // atividade = new AtividadeRepeticoesPesos(
                    // tokens[2],
                    // Double.parseDouble(tokens[3]),
                    // Double.parseDouble(tokens[4]),
                    // Boolean.parseBoolean(tokens[5]),
                    // Integer.parseInt(tokens[6]),
                    // Double.parseDouble(tokens[7]));
                    // break;

                    default:
                        throw new Exception("Tipo de atividade desconhecido: \n" + tokens[1]);
                }
                gestor.addAtividade(atividade);
                break;

            case Controller.INSERT_PLANOTREINO:
                Utilizador utilizadorPlano = gestor.getUtilizador(Integer.parseInt(tokens[1]));
                String dataTexto = tokens[2];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(dataTexto, formatter);

                // atividades em (codigoAtividade, iteracoes) separadas por ponto e virgula
                // enquanto houver tokens para ler insere no mapa de atividades
                // (codigoAtividade, iteracoes)

                Map<Atividade, Integer> atividades = new HashMap<>();
                for (int i = 3; i < tokens.length; i++) {
                    String[] atividadePlano = tokens[i].split(",");

                    // obter atividade por codigo
                    Atividade actividade = gestor.getAtividade(Integer.parseInt(atividadePlano[0]));

                    atividades.put(actividade, Integer.parseInt(atividadePlano[1]));
                }

                PlanoTreino planoTreino = new PlanoTreino(utilizadorPlano, data, atividades);
                gestor.addPlanoTreino(planoTreino);

                System.out.println(GREEN + "Plano de treino adicionado com sucesso \n" + planoTreino + BLUE);

                break;
        }
    }

    public static void removeRegisto(Gestor gestor, String[] tokens, int flag) throws Exception {
        switch (flag) {
            case Controller.REMOVE_UTILIZADOR:
                gestor.removerUtilizador(Integer.parseInt(tokens[1]));
                break;

            case Controller.REMOVE_ATIVIDADE:
                gestor.removerAtividade(Integer.parseInt(tokens[1]));
                break;

            case Controller.REMOVE_PLANOTREINO:
                gestor.removerPlanoTreino(Integer.parseInt(tokens[1]));
                break;
        }
    }

    public static void updateRegisto(Gestor gestor, String[] tokens, int flag) {
        // Implementar a lógica para atualizar um registo
    }

    public static Utilizador getUtilizador(Gestor gestor, String email) throws Exception {
        // Implementar a lógica para obter um registo
        // obter um utilizador pelo email

        Utilizador utilizador = gestor.getUtilizadorPorEmail(email);
        return utilizador;

    }

    public static void listRegistos(Gestor gestor, int flag) {
        switch (flag) {
            case Controller.LIST_UTILIZADORES:
                System.out.println(gestor.listarUtilizadores());
                break;
            case Controller.LIST_ATIVIDADES:
                System.out.println(gestor.listarAtividades());
                break;
            case Controller.LIST_PLANOSTREINO:
                System.out.println(gestor.listarPlanosTreino());
                break;
            case Controller.LIST_RECORDS:
                System.out.println(gestor.listarRecordes());
                break;
            default:
                System.out.println("Flag desconhecida: \n" + flag);
        }
    }

    // regista uma atividade
    public static void registarAtividade(Gestor gestor, String[] tokens, int flag) throws Exception {
        Utilizador utilizador = gestor.getUtilizador(Integer.parseInt(tokens[1]));
        // getAtividadePorCodigo
        Atividade atividade = gestor.getAtividade(Integer.parseInt(tokens[2]));
        LocalDate data = LocalDate.now();
        gestor.registarAtividade(utilizador.getCodigo(), atividade.hashCode(), data, Integer.parseInt(tokens[3]));
    }

    public static void avancarTempo(Gestor gestor, String[] tokens, int flag) throws Exception {
        int dias = Integer.parseInt(tokens[1]);
        gestor.avancarTempo(dias);
    }
}
