package Controller;

import Modules.Gestores.Gestor;
import Modules.Utilizador.Utilizador;

import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

public class Controller {
    // dia de simulação
    public LocalDate currentDate;
    public static final int INSERT_UTILIZADOR = 0;
    public static final int INSERT_ATIVIDADE = 1;
    public static final int INSERT_PLANOTREINO = 2;
    public static final int REMOVE_UTILIZADOR = 3;
    public static final int REMOVE_ATIVIDADE = 4;
    public static final int REMOVE_PLANOTREINO = 5;
    public static final int UPDATE_UTILIZADOR = 6;
    public static final int UPDATE_ATIVIDADE = 7;
    public static final int UPDATE_PLANOTREINO = 8;
    public static final int GET_UTILIZADOR = 9;
    public static final int GET_ATIVIDADE = 10;
    public static final int GET_PLANOTREINO = 11;
    public static final int LIST_UTILIZADORES = 12;
    public static final int LIST_ATIVIDADES = 13;
    public static final int LIST_PLANOSTREINO = 14;
    public static final int CALCULAR_CALORIAS = 15;
    public static final int REGISTAR_ATIVIDADE = 16;
    public static final int LIST_RECORDS = 17;
    public static final int AVANCAR_TEMPO = 18;
    public static final int ESTATISTICA = 19;

    private Map<String, Integer> tabela = new HashMap<>();
    private Gestor gestor;

    public Controller(Gestor gestor) {
        this.gestor = gestor;
        this.currentDate = gestor.currentDate;
        fillTabela();
    }

    public Gestor getGestor() {
        return this.gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public void fillTabela() {
        this.tabela.put("Inserir Utilizador", Controller.INSERT_UTILIZADOR);
        this.tabela.put("Inserir Atividade", Controller.INSERT_ATIVIDADE);
        this.tabela.put("Inserir Plano de Treino", Controller.INSERT_PLANOTREINO);
        this.tabela.put("Remover Utilizador", Controller.REMOVE_UTILIZADOR);
        this.tabela.put("Remover Atividade", Controller.REMOVE_ATIVIDADE);
        this.tabela.put("Remover Plano de Treino", Controller.REMOVE_PLANOTREINO);
        this.tabela.put("Atualizar Utilizador", Controller.UPDATE_UTILIZADOR);
        this.tabela.put("Atualizar Atividade", Controller.UPDATE_ATIVIDADE);
        this.tabela.put("Atualizar PlanoTreino", Controller.UPDATE_PLANOTREINO);
        this.tabela.put("Obter Utilizador", Controller.GET_UTILIZADOR);
        this.tabela.put("Obter Atividade", Controller.GET_ATIVIDADE);
        this.tabela.put("Obter PlanoTreino", Controller.GET_PLANOTREINO);
        this.tabela.put("Listar Utilizadores", Controller.LIST_UTILIZADORES);
        this.tabela.put("Listar Atividades", Controller.LIST_ATIVIDADES);
        this.tabela.put("Listar Planos de Treino", Controller.LIST_PLANOSTREINO);
        this.tabela.put("Calcular Calorias", Controller.CALCULAR_CALORIAS);
        this.tabela.put("Registar Atividade", Controller.REGISTAR_ATIVIDADE);
        this.tabela.put("Listar Recordes", Controller.LIST_RECORDS);
        this.tabela.put("Avançar no Tempo", Controller.AVANCAR_TEMPO);
        this.tabela.put("Estatistica", Controller.ESTATISTICA);
    }

    private int getCodigo(String identificador) {
        // retornar o código correspondente ao identificador
        return this.tabela.get(identificador);

    }

    public void collectDadosLine(String[] tokens) {
        try {
            switch (this.getCodigo(tokens[0])) {

                case Controller.INSERT_UTILIZADOR:
                case Controller.INSERT_ATIVIDADE:
                case Controller.INSERT_PLANOTREINO:
                    ControllerRegistos.insertRegisto(gestor, tokens, this.getCodigo(tokens[0]));
                    break;

                case Controller.REMOVE_UTILIZADOR:
                case Controller.REMOVE_ATIVIDADE:
                case Controller.REMOVE_PLANOTREINO:
                    ControllerRegistos.removeRegisto(gestor, tokens, this.getCodigo(tokens[0]));
                    break;

                case Controller.UPDATE_UTILIZADOR:
                case Controller.UPDATE_ATIVIDADE:
                case Controller.UPDATE_PLANOTREINO:
                    ControllerRegistos.updateRegisto(gestor, tokens, this.getCodigo(tokens[0]));
                    break;

                case Controller.GET_UTILIZADOR:
                case Controller.GET_ATIVIDADE:
                case Controller.GET_PLANOTREINO:
                    // ControllerRegistos.getRegisto(gestor, tokens, this.getCodigo(tokens[0]));
                    // break;

                case Controller.LIST_UTILIZADORES:
                case Controller.LIST_ATIVIDADES:
                case Controller.LIST_PLANOSTREINO:
                case Controller.LIST_RECORDS:
                    ControllerRegistos.listRegistos(gestor, this.getCodigo(tokens[0]));
                    break;

                case Controller.REGISTAR_ATIVIDADE:
                    ControllerRegistos.registarAtividade(gestor, tokens, this.getCodigo(tokens[0]));
                    break;

                case Controller.AVANCAR_TEMPO:
                    ControllerRegistos.avancarTempo(gestor, tokens, this.getCodigo(tokens[0]));
                    break;

                case Controller.ESTATISTICA:
                    ControllerEstatisticas.getEstatistica(gestor, tokens, this.getCodigo(tokens[0]));
                    break;
            }

        } catch (Exception e) {
            if (tokens.length != 0 && tokens[0].length() > 0) {
                System.err.println("Erro: " + e.getMessage() + "\n");
            }
        }
    }

    public Utilizador getUtilizador(String email) {
        // Implementar a lógica para obter um registo
        // obter um utilizador pelo email
        try {

            Utilizador utilizador = gestor.getUtilizadorPorEmail(email);
            return utilizador;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage() + "\n");
        }
        return null;
    }
}