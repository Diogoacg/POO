package Modules;

// Importações necessárias
import java.util.*;

public class Utilizador {
    String codigo;
    String nome;
    String morada;
    String email;
    double frequenciaCardiacaMedia;
    String tipo; // Tipo de utilizador (profissional, amador, ocasional)
    List<Atividade> atividades;

    // Método para calcular o fator multiplicativo
    double calcularFatorMultiplicativo() {
        // Implementar a fórmula para calcular o fator multiplicativo
        // baseado no tipo de utilizador
        return 0;
    }

    // Métodos get e set para cada atributo

    public Utilizador(String codigo, String nome, String morada, String email, double frequenciaCardiacaMedia,
            String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.tipo = tipo;
        this.atividades = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFrequenciaCardiacaMedia() {
        return frequenciaCardiacaMedia;
    }

    public void setFrequenciaCardiacaMedia(double frequenciaCardiacaMedia) {
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) {
        atividades.remove(atividade);
    }

    public String toString() {
        return "Utilizador [atividades=" + atividades + ", codigo=" + codigo + ", email=" + email
                + ", frequenciaCardiacaMedia=" + frequenciaCardiacaMedia + ", morada=" + morada + ", nome=" + nome
                + ", tipo=" + tipo + "]";
    }

    public boolean equals(Utilizador utilizador) {
        return this.codigo.equals(utilizador.codigo);
    }

}