package Modules.Atividade;

import java.io.Serializable;
import java.util.Objects;

import Modules.Utilizador.Utilizador;

public abstract class Atividade implements Serializable {
    private double tempo;
    private boolean isHard;

    // constructors
    public Atividade(double tempo, double frequenciaCardiacaMedia) {
        this.tempo = tempo;
        this.isHard = false;
    }

    public Atividade(Atividade atividade) {
        this.tempo = atividade.getTempo();
        this.isHard = atividade.isHard();
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public boolean isHard() {
        return isHard;
    }

    public void setHard(boolean isHard) {
        this.isHard = isHard;
    }

    // toString
    @Override
    public String toString() {
        return "\n------------------------------------------\n"+
                "Atividade : \n" +
                "É difícil : " + isHard + "\n" +
                "Tempo = " + tempo + "\n" +
                "------------------------------------------\n";
    }

    // equals

    @Override

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Atividade)) {
            return false;
        }
        Atividade atividade = (Atividade) o;
        return isHard == atividade.isHard
                && tempo == atividade.tempo;
    }

    // Clone
    public abstract Atividade clone();

    // abstract method
    public abstract double calcularCalorias(Utilizador utilizador, int frequenciaCardiacaMedia);

    @Override
    public int hashCode() {
        return Objects.hash(isHard, tempo);
    }

}