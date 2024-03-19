package Modules.Atividade;

import Modules.Utilizador.Utilizador;

public class AtividadeRepeticoes extends Atividade {

    private int repeticoes;

    public AtividadeRepeticoes(String nome, double tempo, double frequenciaCardiacaMedia, boolean isHard,
            int repeticoes) {
        super(nome, tempo, frequenciaCardiacaMedia, isHard);
        this.repeticoes = repeticoes;
    }

    public AtividadeRepeticoes(AtividadeRepeticoes atividade) {
        super(atividade);
        this.repeticoes = atividade.getRepeticoes();
    }

    public AtividadeRepeticoes clone() {
        return new AtividadeRepeticoes(this);
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nAtividade: ").append(super.toString());
        s.append(this.repeticoes).append(" repetições");
        return s.toString();
    }

    @Override
    public double calcularCalorias(Utilizador utilizador) {
        // temos que usar a "super" para chamar o método da classe mãe
        return 0;
    }

}
