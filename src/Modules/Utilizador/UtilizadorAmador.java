package Modules.Utilizador;

public class UtilizadorAmador extends Utilizador {
    @Override
    public double calcularFatorMultiplicativo(int frequenciaCardiacaMedia) {
        return 0.0059 * frequenciaCardiacaMedia;
    }

    // construtores
    public UtilizadorAmador(String codigo, String nome, String morada, String email, double frequenciaCardiacaMedia) {
        super(codigo, nome, morada, email, frequenciaCardiacaMedia);
    }

    public UtilizadorAmador(UtilizadorAmador utilizador) {
        super(utilizador);
    }

    // clone

    public UtilizadorAmador clone() {
        return new UtilizadorAmador(this);
    }

    // toString

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nUtilizador Amador: ");
        s.append(super.toString());
        return s.toString();

    }

}