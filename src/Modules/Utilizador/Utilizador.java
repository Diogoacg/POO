package Modules.Utilizador;

import Modules.Atividade.Atividade;

import java.time.LocalDate;
import java.util.*;

// Classe abstrata para Utilizador
public abstract class Utilizador {
    private String codigo;
    private String nome;
    private String morada;
    private String email;
    private double frequenciaCardiacaMedia;
    private Map<Integer, Atividade> atividades;

    // Método abstrato para calcular o fator multiplicativo, a ser implementado nas
    // subclasses
    public abstract double calcularFatorMultiplicativo();

    // construtores
    public Utilizador(String codigo, String nome, String morada, String email, double frequenciaCardiacaMedia) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.atividades = new HashMap<Integer, Atividade>();
    }

    public Utilizador(Utilizador utilizador) {
        this.codigo = utilizador.getCodigo();
        this.nome = utilizador.getNome();
        this.morada = utilizador.getMorada();
        this.email = utilizador.getEmail();
        this.frequenciaCardiacaMedia = utilizador.getFrequenciaCardiacaMedia();
        this.atividades = utilizador.getAtividades();
    }

    // clone
    public abstract Utilizador clone();

    // getters e setters
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

    public Map<Integer, Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Map<Integer, Atividade> atividades) {
        this.atividades = atividades;
    }

    // Método para adicionar uma atividade
    public void addAtividade(Atividade atividade) {
        this.atividades.put(atividade.hashCode(), atividade);
    }

    // toString

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Nome: ").append(this.nome).append("\n");
        s.append("Morada: ").append(this.morada).append("\n");
        s.append("Email: ").append(this.email).append("\n");
        s.append("Frequência Cardíaca Média: ").append(this.frequenciaCardiacaMedia).append("\n");
        s.append("Atividades: ").append(this.atividades).append("\n");
        return s.toString();
    }

    // equals

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Utilizador utilizador = (Utilizador) o;
        return this.nome.equals(utilizador.getNome()) && this.morada.equals(utilizador.getMorada())
                && this.email.equals(utilizador.getEmail())
                && this.frequenciaCardiacaMedia == utilizador.getFrequenciaCardiacaMedia()
                && this.atividades.equals(utilizador.getAtividades());
    }

    // Métodos extra

}
