package Modules.Atividade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Modules.Utilizador.Utilizador;

public class AtividadeDistancia extends Atividade {
    private double distancia;

    public AtividadeDistancia(String nome, double tempo, double frequenciaCardiacaMedia, boolean isHard,
            double distancia) {
        super(nome, tempo, frequenciaCardiacaMedia, isHard);
        this.distancia = distancia;
    }

    public AtividadeDistancia(AtividadeDistancia atividade) {
        super(atividade);
        this.distancia = atividade.getDistancia();
    }

    public AtividadeDistancia clone() {
        return new AtividadeDistancia(this);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nAtividade: ").append(super.toString());
        s.append(this.distancia).append(" km");
        return s.toString();
    }

    @Override
    public double calcularCalorias(Utilizador utilizador) {
        double fm = utilizador.calcularFatorMultiplicativo();

        return 1;
    }

}
