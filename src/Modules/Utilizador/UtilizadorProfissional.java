package Modules.Utilizador;

public class UtilizadorProfissional extends Utilizador {
    @Override
    public double calcularFatorMultiplicativo(int frequenciaCardiacaMedia) {
        return 0.0089 * frequenciaCardiacaMedia;
    }

    // construtores

    public UtilizadorProfissional(String codigo, String nome, String morada, String email,
            double frequenciaCardiacaMedia) {
        super(codigo, nome, morada, email, frequenciaCardiacaMedia);
    }

    public UtilizadorProfissional(UtilizadorProfissional utilizador) {
        super(utilizador);
    }

    // clone
    public UtilizadorProfissional clone() {
        return new UtilizadorProfissional(this);
    }

    // toString
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nUtilizador Profissional: ");
        s.append(super.toString());
        return s.toString();

    }
}
