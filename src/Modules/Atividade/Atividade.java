package Modules.Atividade;

import Modules.Utilizador.Utilizador;

public abstract class Atividade {
    private String nome;
    private double tempo;
    private double frequenciaCardiacaMedia;
    private boolean isHard;

    // constructors
    public Atividade(String nome, double tempo, double frequenciaCardiacaMedia, boolean isHard) {
        this.nome = nome;
        this.tempo = tempo;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.isHard = isHard;
    }

    public Atividade(Atividade atividade) {
        this.nome = atividade.getNome();
        this.tempo = atividade.getTempo();
        this.frequenciaCardiacaMedia = atividade.getFrequenciaCardiacaMedia();
        this.isHard = atividade.isHard();
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getFrequenciaCardiacaMedia() {
        return frequenciaCardiacaMedia;
    }

    public void setFrequenciaCardiacaMedia(double frequenciaCardiacaMedia) {
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
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
        return "Atividade [frequenciaCardiacaMedia=" + frequenciaCardiacaMedia + ", isHard=" + isHard + ", nome=" + nome
                + ", tempo=" + tempo + "]";
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
        return frequenciaCardiacaMedia == atividade.frequenciaCardiacaMedia && isHard == atividade.isHard
                && nome.equals(atividade.nome) && tempo == atividade.tempo;
    }

    // Clone
    public abstract Atividade clone();

    // abstract method
    public abstract double calcularCalorias(Utilizador utilizador);

    public void guardarAtividade() {
        // do nothing
    }

}
