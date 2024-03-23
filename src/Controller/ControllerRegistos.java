package Controller;

import Modules.Gestores.*;
import Modules.Utilizador.*;
import Modules.Atividade.*;
import Modules.PlanoTreino;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class ControllerRegistos {

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
                    case "PraticanteOcasional":
                        utilizador = new UtilizadorPraticanteOcasional(
                                tokens[2],
                                tokens[3],
                                tokens[4],
                                tokens[5],
                                Double.parseDouble(tokens[6]));
                        break;
                    case "Profissional":
                        System.out.println(tokens[0]);
                        System.out.println(tokens[1]);
                        System.out.println(tokens[2]);
                        System.out.println(tokens[3]);
                        System.out.println(tokens[4]);
                        System.out.println(tokens[5]);
                        System.out.println(Double.parseDouble(tokens[6]));
                        utilizador = new UtilizadorProfissional(
                                tokens[2],
                                tokens[3],
                                tokens[4],
                                tokens[5],
                                Double.parseDouble(tokens[6]));
                        System.err.println(utilizador.getNome());
                        break;
                    default:
                        throw new Exception("Tipo de utilizador desconhecido: " + tokens[1]);
                }
                gestor.addUtilizador(utilizador);
                System.out.println("Utilizador adicionado com sucesso" + utilizador.getNome());
                break;

            case Controller.INSERT_ATIVIDADE:
                Atividade atividade;
                switch (tokens[1]) {
                    case "Distancia":
                        atividade = new AtividadeDistancia(
                                tokens[2],
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]),
                                Boolean.parseBoolean(tokens[5]),
                                Double.parseDouble(tokens[6]));
                        break;
                    case "DistanciaAltimetria":
                        atividade = new AtividadeDistanciaAltimetria(
                                tokens[2],
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]),
                                Boolean.parseBoolean(tokens[5]),
                                Double.parseDouble(tokens[6]),
                                Double.parseDouble(tokens[7]));
                        break;
                    case "Repeticoes":
                        atividade = new AtividadeRepeticoes(
                                tokens[2],
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]),
                                Boolean.parseBoolean(tokens[5]),
                                Integer.parseInt(tokens[6]));
                        break;
                    case "RepeticoesPeso":
                        atividade = new AtividadeRepeticoesPesos(
                                tokens[2],
                                Double.parseDouble(tokens[3]),
                                Double.parseDouble(tokens[4]),
                                Boolean.parseBoolean(tokens[5]),
                                Integer.parseInt(tokens[6]),
                                Double.parseDouble(tokens[7]));
                        break;

                    default:
                        throw new Exception("Tipo de atividade desconhecido: " + tokens[1]);
                }
                gestor.addAtividade(atividade);
                break;

            case Controller.INSERT_PLANOTREINO:
                // tokens[1] = código do utilizador
                // tokens[2] = data
                // tokens[3..?] = código de atividades
                int tam = tokens.length;
                Map<String,Integer> a = new Map<String,Integer>();

                for (int i = 3; i <= tam; i++){
                    a.
                }

                Date date = new Date();

                PlanoTreino planoTreino = new PlanoTreino(
                        gestor.getUtilizador(Integer.parseInt(tokens[1])),
                        date);
                gestor.addPlanoTreino(planoTreino);
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

    public static void getRegisto(Gestor gestor, String[] tokens, int flag) {
        // Implementar a lógica para obter um registo
    }

    public static void listRegistos(Gestor gestor, int flag) {
        switch (flag) {
            case Controller.LIST_UTILIZADORES:
                System.out.println("Lista de utilizadores:");
                System.out.println(gestor.listarUtilizadores());
                break;
            case Controller.LIST_ATIVIDADES:
                System.out.println(gestor.listarAtividades());
                break;
            case Controller.LIST_PLANOSTREINO:
                System.out.println(gestor.listarPlanosTreino());
                break;
            default:
                System.out.println("Flag desconhecida: " + flag);
        }
    }

    // regista uma atividade
    public static void registarAtividade(Gestor gestor, String[] tokens, int flag) throws Exception {
        Utilizador utilizador = gestor.getUtilizador(Integer.parseInt(tokens[1]));
        Atividade atividade = gestor.getAtividade(Integer.parseInt(tokens[2]));
        Date data = new Date();
        gestor.registarAtividade(utilizador.hashCode(), atividade.hashCode(), data);

    }
}
