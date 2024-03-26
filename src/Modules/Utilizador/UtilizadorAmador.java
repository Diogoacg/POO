package Modules.Utilizador;

public class UtilizadorAmador extends Utilizador {
    @Override
    double calcularFatorMultiplicativo() {
        // Implementar a fórmula para calcular o fator multiplicativo
        return 0;
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
        Utilizador.USER_AUTO_INCREMENT--;
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