package Modules.Atividade;

import Modules.Utilizador.Utilizador;

// AtividadeRepeticoesPesos.java
public class AtividadeRepeticoesPesos extends Atividade {

    private int repeticoes;
    private double peso;

    public AtividadeRepeticoesPesos(String nome, double tempo, double frequenciaCardiacaMedia, boolean isHard,
            int repeticoes, double peso) {
        super(nome, tempo, frequenciaCardiacaMedia, isHard);
        this.repeticoes = repeticoes;
        this.peso = peso;
    }

    public AtividadeRepeticoesPesos(AtividadeRepeticoesPesos atividade) {
        super(atividade);
        this.repeticoes = atividade.getRepeticoes();
        this.peso = atividade.getPeso();
    }

    public AtividadeRepeticoesPesos clone() {
        return new AtividadeRepeticoesPesos(this);
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
    public double calcularCalorias(Utilizador utilizador) {
        // temos que usar a "super" para chamar o método da classe mãe
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nAtividade: ").append(super.toString());
        s.append(this.repeticoes).append(" repetições");
        s.append(this.peso).append(" kg");
        return s.toString();

    }

}
