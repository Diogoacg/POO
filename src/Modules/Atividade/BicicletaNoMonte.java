package Modules.Atividade;

import java.util.Objects;

import Modules.Utilizador.Utilizador;

public class BicicletaNoMonte extends Atividade {
    private double distancia;
    private double altimetria;

    public BicicletaNoMonte(double tempo, double frequenciaCardiacaMedia, double distancia, double altimetria) {
        super(tempo, frequenciaCardiacaMedia);
        this.setHard(true); // dar override ao isHard
        this.distancia = distancia;
        this.altimetria = altimetria;
    }

    public BicicletaNoMonte(BicicletaNoMonte atividade) {
        super(atividade);
        this.distancia = atividade.getDistancia();
        this.altimetria = atividade.getAltimetria();
    }

    public BicicletaNoMonte clone() {
        return new BicicletaNoMonte(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getAltimetria() {
        return altimetria;
    }

    public void setAltimetria(double altimetria) {
        this.altimetria = altimetria;
    }

    @Override
    public String toString() {
        return "\nBicicleta No Monte \n"+
                "Distância : " + distancia + "\n" +
                "Altimetria : " + altimetria + "\n" +
                "Código da Atividade : " + this.hashCode() + "\n"
                + "------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        BicicletaNoMonte atividade = (BicicletaNoMonte) o;
        return super.equals(atividade) && this.distancia == atividade.getDistancia()
                && this.altimetria == atividade.getAltimetria();
    }

    // override do metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.distancia, this.altimetria, "BicicletaNoMonte");
    }

    public double calcularCalorias(Utilizador utilizador, int frequenciaCardiacaMedia) {
        double tMinuto = this.getTempo(); // minuto
        double tHora = this.getTempo() / 60; // hora
        double alt = this.getAltimetria(); // metro
        double d = this.getDistancia(); // km
        double v = d * tHora; // km/hora
        double fm = utilizador.calcularFatorMultiplicativo(frequenciaCardiacaMedia);
        double fatorAjuste = 1 + alt / 1000;
        double calorias = 0;

        if (this.isHard() == true) {
            calorias = 0.8 * (1.5 * fm * v * 0.0175 * tMinuto * fatorAjuste);
        } else {
            calorias = 0.8 * (fm * v * 0.0175 * tMinuto * fatorAjuste);
        }
        return calorias;
    }

}
