package Modules.Atividade;

import java.util.Objects;

import Modules.Utilizador.Utilizador;

public class Abdominais extends Atividade {
    private int repeticoes;

    public Abdominais(double tempo, double frequenciaCardiacaMedia, int repeticoes) {
        super(tempo, frequenciaCardiacaMedia);
        this.setHard(true); // dar override ao isHard
        this.repeticoes = repeticoes;
    }

    public Abdominais(Abdominais atividade) {
        super(atividade);
        this.repeticoes = atividade.getRepeticoes();
    }

    public Abdominais clone() {
        return new Abdominais(this);
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "\nAbdominais \n" +
               "Repetições : " + repeticoes + "\n" +
               "Código da Atividade : " + this.hashCode() + "\n" +
               "------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Abdominais atividade = (Abdominais) o;
        return super.equals(atividade) && this.repeticoes == atividade.getRepeticoes();
    }

    // override do metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.repeticoes, "Abdominais");
    }

    @Override
    public double calcularCalorias(Utilizador utilizador, int frequenciaCardiacaMedia) {
        double fm = utilizador.calcularFatorMultiplicativo(frequenciaCardiacaMedia);
        double tMinuto = this.getTempo(); // minuto
        double tSegundo = tMinuto * 60; // segundo
        int reps = this.getRepeticoes();
        double fatorT = (tSegundo * reps) / 11.2;
        double calorias = 0;

        if (this.isHard() == true) {
            calorias = (1.5 * fm * reps * 0.1083 * fatorT);
        } else {
            calorias = (fm * reps * 0.1083 * fatorT);
        }
        return calorias;
    }
}
