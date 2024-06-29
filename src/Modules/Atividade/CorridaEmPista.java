package Modules.Atividade;

import java.util.Objects;

import Modules.Utilizador.Utilizador;

public class CorridaEmPista extends Atividade {
    private double distancia;

    public CorridaEmPista(double tempo, double frequenciaCardiacaMedia,
            double distancia) {
        super(tempo, frequenciaCardiacaMedia);
        this.setHard(false); // dar override ao isHard
        this.distancia = distancia;
    }

    public CorridaEmPista(CorridaEmPista atividade) {
        super(atividade);
        this.distancia = atividade.getDistancia();
    }

    public CorridaEmPista clone() {
        return new CorridaEmPista(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "\nCorrida Em Pista \n" +
                "Distância : " + distancia + "\n" +
                "Codigo da Atividade : " + this.hashCode() + "\n"
                + "------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        CorridaEmPista atividade = (CorridaEmPista) o;
        return super.equals(atividade) && this.distancia == atividade.getDistancia();
    }

    // override do metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.distancia, "CorridaEmPista");
    }

    @Override
    public double calcularCalorias(Utilizador utilizador, int frequenciaCardiacaMedia) {
        double tMinuto = this.getTempo(); // minuto
        double tHora = this.getTempo() / 60; // hora
        double d = this.getDistancia(); // km
        double fm = utilizador.calcularFatorMultiplicativo(frequenciaCardiacaMedia);
        double v = d * tHora; // km/hora
        double calorias = 0;

        if (this.isHard() == true) {
            calorias = 1.5 * fm * v * 0.0175 * tMinuto;
        } else {
            calorias = fm * v * 0.0175 * tMinuto;
        }
        return calorias;
    }
}