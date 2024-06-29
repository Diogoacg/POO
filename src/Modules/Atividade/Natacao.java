package Modules.Atividade;

import java.util.Objects;

import Modules.Utilizador.Utilizador;

public class Natacao extends Atividade {
    private double distancia;

    public Natacao(double tempo, double frequenciaCardiacaMedia, double distancia) {
        super(tempo, frequenciaCardiacaMedia);
        this.setHard(false); // dar override ao isHard
        this.distancia = distancia;
    }

    public Natacao(Natacao atividade) {
        super(atividade);
        this.distancia = atividade.getDistancia();
    }

    public Natacao clone() {
        return new Natacao(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "\nNatacao \n" +
                "Distância = " + distancia + "\n" +
                "Código da Atividade = " + this.hashCode() + "\n" +
                "------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Natacao atividade = (Natacao) o;
        return super.equals(atividade) && this.distancia == atividade.getDistancia();
    }

    // override do metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.distancia, "Natacao");
    }

    public double calcularCalorias(Utilizador utilizador, int frequenciaCardiacaMedia) {
        double tMinuto = this.getTempo(); // minuto
        double tSegundo = this.getTempo() * 60; // segundo
        double d = this.getDistancia(); // m
        double fm = utilizador.calcularFatorMultiplicativo(frequenciaCardiacaMedia);
        double v = d * tSegundo; // m/segundo
        double calorias = 0;

        if (this.isHard() == true) {
            calorias = 1.5 * fm * v * 0.0175 * tMinuto;
        } else {
            calorias = fm * v * 0.0175 * tMinuto;
        }
        return calorias;
    }
}
