package Modules.Atividade;

import java.util.Objects;

import Modules.Utilizador.Utilizador;

public class Supino extends Atividade {
    private int repeticoes;
    private double peso;

    public Supino(double tempo, double frequenciaCardiacaMedia, int repeticoes, double peso) {
        super(tempo, frequenciaCardiacaMedia);
        this.setHard(true); // dar override ao isHard
        this.repeticoes = repeticoes;
        this.peso = peso;
    }

    public Supino(Supino atividade) {
        super(atividade);
        this.repeticoes = atividade.getRepeticoes();
        this.peso = atividade.getPeso();
    }

    public Supino clone() {
        return new Supino(this);
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "\nSupino \n" +
                "Repetições : " + repeticoes + "\n" +
                "Peso : " + peso + "\n" +
                "Código da Atividade : " + this.hashCode() + "\n" +
                "------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Supino atividade = (Supino) o;
        return super.equals(atividade) && this.repeticoes == atividade.getRepeticoes()
                && this.peso == atividade.getPeso();
    }

    // override do metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.repeticoes, this.peso, "Supino");
    }

    @Override
    public double calcularCalorias(Utilizador utilizador, int frequenciaCardiacaMedia) {
        double fm = utilizador.calcularFatorMultiplicativo(frequenciaCardiacaMedia);
        double tMinuto = this.getTempo(); // minuto
        double tSegundo = tMinuto * 60; // segundo
        double p = this.getPeso(); // kg
        int reps = this.getRepeticoes();
        double fatorT = (tSegundo * reps) / 9.2;
        double fatorP = p / 5;
        double calorias = 0;
        if (this.isHard() == true) {
            calorias = (1.5 * fm * reps * 0.1083 * fatorT) + fatorP;
        } else {
            calorias = (fm * reps * 0.1083 * fatorT) + fatorP;
        }
        return calorias;
    }
}
