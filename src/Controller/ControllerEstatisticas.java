package Controller;

import Modules.PlanoTreino;
import Modules.Gestores.Gestor;
import Modules.Utilizador.Utilizador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControllerEstatisticas {
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";

    public static void getEstatistica(Gestor gestor, String[] tokens, int flag) throws Exception {

        switch (flag) {

            case Controller.ESTATISTICA:
                switch (Integer.parseInt(tokens[1])) {
                    case 1:
                        if (tokens.length != 4) {
                            Utilizador utilizador = gestor.utilizadorComMaisCaloriasGastas(null, null);
                            System.out.println("Utilizador com mais calorias gastas\n");
                            System.out.println(utilizador);
                            break;
                        }
                        // parse tokens to LocalDate
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataInicio = LocalDate.parse(tokens[2], formatter);
                        LocalDate dataFim = LocalDate.parse(tokens[3], formatter);
                        Utilizador utilizador = gestor.utilizadorComMaisCaloriasGastas(dataInicio, dataFim);

                        System.out.println("Utilizador com mais calorias gastas\n");
                        System.out.println(utilizador);
                        break;
                    case 2:
                        if (tokens.length != 4) {
                            Utilizador utilizador2 = gestor.utilizadorComMaisAtividades(null, null);
                            System.out.println("Utilizador com mais atividades realizadas\n");
                            System.out.println(utilizador2);
                            break;

                        }
                        // parse tokens to LocalDate
                        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataInicio2 = LocalDate.parse(tokens[2], formatter2);
                        LocalDate dataFim2 = LocalDate.parse(tokens[3], formatter2);

                        Utilizador utilizador2 = gestor.utilizadorComMaisAtividades(dataInicio2, dataFim2);

                        System.out.println("Utilizador com mais atividades realizadas\n");
                        System.out.println(utilizador2);
                        break;
                    case 3:
                        String atividade = gestor.atividadeMaisRealizada();
                        System.out.println("Atividade mais realizada: \n");
                        System.out.println(atividade);
                        break;
                    case 4:
                        if (tokens.length != 5) {
                            Utilizador user = gestor.getUtilizadorPorEmail(tokens[2]);
                            double distancia = gestor.kmRealizados(user, null, null);
                            System.out.println(distancia + "Km realizados");

                            break;
                        }
                        // parse tokens to LocalDate
                        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataInicio4 = LocalDate.parse(tokens[3], formatter4);
                        LocalDate dataFim4 = LocalDate.parse(tokens[4], formatter4);

                        Utilizador user = gestor.getUtilizadorPorEmail(tokens[2]);

                        double distancia = gestor.kmRealizados(user, dataInicio4, dataFim4);
                        System.out.println(distancia + "Km realizados");

                        break;
                    case 5:
                        if (tokens.length != 5) {
                            Utilizador user5 = gestor.getUtilizadorPorEmail(tokens[2]);

                            double altimetria = gestor.altimetriaTotal(user5, null, null);
                            System.out.println(altimetria + "m de altimetria totalizados");

                            break;
                        }
                        // parse tokens to LocalDate
                        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataInicio5 = LocalDate.parse(tokens[3], formatter5);
                        LocalDate dataFim5 = LocalDate.parse(tokens[4], formatter5);

                        Utilizador user5 = gestor.getUtilizadorPorEmail(tokens[2]);
                        double altimetria = gestor.altimetriaTotal(user5, dataInicio5, dataFim5);
                        System.out.println(altimetria + "m de altimetria totalizados");

                        break;
                    case 6:
                        PlanoTreino pt = gestor.planoMaisExigente();
                        System.out.println("Plano de treino mais exigente: \n");
                        System.out.println(pt);
                        break;
                    case 7:
                        if (tokens.length != 3) {
                            // erro
                            System.err.println(RED + "Erro: Número de argumentos inválido \n" + BLUE);
                            break;
                        }
                        System.out.println("Atividades do utilizador: \n");

                        System.out.println(gestor.listarAtividadesUtilizador(tokens[2]));
                        break;
                }

                // case Controller.MAIS_ATIVIDADES:
                // gestor.getAtividadeMaisRealizada();
                // break;

                // case Controller.MAIS_REALIZADA:
                // gestor.getAtividadeMaisRealizada();
                // break;
        }
    }
}