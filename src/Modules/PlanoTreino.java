package Modules;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import Modules.Atividade.Atividade;
import Modules.Utilizador.Utilizador;

public class PlanoTreino implements Serializable {
    private Utilizador utilizador;
    private LocalDate data;
    private Map<Atividade, Integer> atividades; // Mapeia atividades para o número de iterações

    public PlanoTreino(Utilizador utilizador, LocalDate data, Map<Atividade, Integer> atividades) {
        this.utilizador = utilizador;
        this.data = data;
        this.atividades = atividades;
    }

    public PlanoTreino(PlanoTreino planoTreino) {
        this.utilizador = planoTreino.getUtilizador();
        this.data = planoTreino.getData();
        this.atividades = planoTreino.getAtividades();
    }

    // Método para adicionar uma atividade ao plano de treino e o número de
    // iterações
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Map<Atividade, Integer> getAtividades() {
        return atividades;
    }

    public void setAtividades(Map<Atividade, Integer> atividades) {
        this.atividades = atividades;
    }

    public double calcularCaloriasEstimativa() {
        double calorias = 0;
        for (Map.Entry<Atividade, Integer> entry : atividades.entrySet()) {
            calorias += entry.getKey().calcularCalorias(utilizador, (int) utilizador.getFrequenciaCardiacaMedia())
                    * entry.getValue();
        }
        return calorias;
    }

    // clone
    public PlanoTreino clone() {
        return new PlanoTreino(this);
    }

    // toString
    @Override
    public String toString() {
        return "------------------------------------------\n" +
               "Plano de Treino:\n" + "Utilizador: " + utilizador + "\nData: " + data + "\nAtividades: " + atividades + "\n" +
               "------------------------------------------\n";
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        PlanoTreino planoTreino = (PlanoTreino) o;
        return this.utilizador.equals(planoTreino.getUtilizador()) && this.data.equals(planoTreino.getData())
                && this.atividades.equals(planoTreino.getAtividades());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(utilizador, data, atividades);
    }

}