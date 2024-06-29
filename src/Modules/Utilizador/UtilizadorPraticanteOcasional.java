package Modules.Utilizador;

public class UtilizadorPraticanteOcasional extends Utilizador {
    @Override
    public double calcularFatorMultiplicativo(int frequenciaCardiacaMedia) {
        return 0.0074 * frequenciaCardiacaMedia;
    }

    // construtores

    public UtilizadorPraticanteOcasional(String codigo, String nome, String morada, String email,
            double frequenciaCardiacaMedia) {
        super(codigo, nome, morada, email, frequenciaCardiacaMedia);
    }

    public UtilizadorPraticanteOcasional(UtilizadorPraticanteOcasional utilizador) {
        super(utilizador);
    }

    // clone

    public UtilizadorPraticanteOcasional clone() {
        return new UtilizadorPraticanteOcasional(this);
    }

    // toString

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nUtilizador Praticante Ocasional: ");
        s.append(super.toString());
        return s.toString();

    }

}
