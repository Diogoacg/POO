package Modules.Atividade;

import Modules.Utilizador.Utilizador;

public class AtividadeDistanciaAltimetria extends Atividade {
    private double distancia;
    private double altimetria;

    // constructores

    public AtividadeDistanciaAltimetria(String nome, double tempo, double frequenciaCardiacaMedia, boolean isHard,
            double distancia, double altimetria) {
        super(nome, tempo, frequenciaCardiacaMedia, isHard);
        this.distancia = distancia;
        this.altimetria = altimetria;
    }

    public AtividadeDistanciaAltimetria(AtividadeDistanciaAltimetria atividade) {
        super(atividade);
        this.distancia = atividade.getDistancia();
        this.altimetria = atividade.getAltimetria();
    }

    public AtividadeDistanciaAltimetria clone() {
        return new AtividadeDistanciaAltimetria(this);
    }

    // getters and setters
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

    // toString
    @Override
    public String toString() {
        // Stringbuilder
        StringBuilder s = new StringBuilder();
        s.append("\nAtividade: ").append(super.toString());
        s.append(this.distancia).append(" km");
        s.append(this.altimetria).append(" m");
        return s.toString();
    }

    @Override
    public double calcularCalorias(Utilizador utilizador) {
        
        return 0;
    }

}
