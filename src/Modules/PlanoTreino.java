package Modules;

import java.util.*;

import Modules.Atividade.Atividade;
import Modules.Utilizador.Utilizador;

public class PlanoTreino {
    private String codUtilizador;
    private Date data;
    private Map<String, Integer> atividades; // Mapeia atividades para o número de iterações

    public PlanoTreino(String codUser, Date data, Map<String,Integer> as) {
        this.codUtilizador = codUser;
        this.data = data;
        this.atividades = as;
    }

    public PlanoTreino(PlanoTreino planoTreino) {
        this.codUtilizador = planoTreino.getUtilizador();
        this.data = planoTreino.getData();
        this.atividades = planoTreino.getAtividades();
    }

    // Método para adicionar uma atividade ao plano de treino e o número de
    // iterações
    public void adicionarAtividade(String atividade, int iteracoes) {
        atividades.put(atividade, iteracoes);
    }

    // Métodos get e set para cada atributo
    public String getUtilizador() {
        return codUtilizador;
    }

    public void setUtilizador(String utilizador) {
        this.codUtilizador = utilizador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Map<String, Integer> getAtividades() {
        return atividades;
    }

    public void setAtividades(Map<String, Integer> atividades) {
        this.atividades = atividades;
    }

    public double calcularCalorias() {
        double calorias = 0;
        for (Map.Entry<Atividade, Integer> entry : atividades.entrySet()) {
            calorias += entry.getKey().calcularCalorias(codUtilizador) * entry.getValue();
        }
        return calorias;
    }

    // clone
    public PlanoTreino clone() {
        return new PlanoTreino(this);
    }

}
