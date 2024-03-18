package Modules;

import java.util.*;

public class PlanoTreino {
    Utilizador utilizador;
    Date data;
    Map<Atividade, Integer> atividades; // Mapeia atividades para o número de iterações

    public PlanoTreino(Utilizador utilizador, Date data) {
        this.utilizador = utilizador;
        this.data = data;
        this.atividades = new HashMap<>();
    }

    // Método para adicionar uma atividade ao plano de treino
    public void adicionarAtividade(Atividade atividade, int iteracoes) {
        atividades.put(atividade, iteracoes);
    }

    // Métodos get e set para cada atributo
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Map<Atividade, Integer> getAtividades() {
        return atividades;
    }

    public void setAtividades(Map<Atividade, Integer> atividades) {
        this.atividades = atividades;
    }

    public double calcularCalorias() {
        double calorias = 0;
        for (Map.Entry<Atividade, Integer> entry : atividades.entrySet()) {
            calorias += entry.getKey().calcularCalorias(utilizador) * entry.getValue();
        }
        return calorias;
    }

}