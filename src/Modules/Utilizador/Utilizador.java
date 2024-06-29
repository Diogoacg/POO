package Modules.Utilizador;

import Modules.Atividade.Atividade;
import Modules.Atividade.AtividadeComCaloriasGastas;

import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;

// Classe abstrata para Utilizador
public abstract class Utilizador implements Serializable {

    private static final long serialVersionUID = 5L;
    public static int USER_AUTO_INCREMENT = 0;

    private int codigo;
    private String nome;
    private String morada;
    private String email;
    private double frequenciaCardiacaMedia;
    // mapa de atividades Map<Date, Atividade>
    private HashMap<LocalDate, List<AtividadeComCaloriasGastas>> atividades;

    private double caloriasGastas;

    // Método abstrato para calcular o fator multiplicativo, a ser implementado nas
    // subclasses
    public abstract double calcularFatorMultiplicativo(int frequenciaCardiacaMedia);

    // construtores
    public Utilizador(String codigo, String nome, String morada, String email, double frequenciaCardiacaMedia) {
        this.codigo = Utilizador.USER_AUTO_INCREMENT++;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.frequenciaCardiacaMedia = 0;
        // lista de atividades List<Atividade>
        this.atividades = new HashMap<>();
        this.caloriasGastas = 0;
    }

    public Utilizador(Utilizador utilizador) {
        this.codigo = utilizador.getCodigo();
        this.nome = utilizador.getNome();
        this.morada = utilizador.getMorada();
        this.email = utilizador.getEmail();
        this.frequenciaCardiacaMedia = utilizador.getFrequenciaCardiacaMedia();
        this.atividades = utilizador.getAtividadesList();
        this.caloriasGastas = utilizador.getCaloriasGastas();
    }

    // clone
    public abstract Utilizador clone();

    // getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public double getCaloriasGastas() {
        return caloriasGastas;
    }

    public void setCaloriasGastas(double caloriasGastas) {
        this.caloriasGastas = caloriasGastas;
    }

    // lista de atividades
    public HashMap<LocalDate, List<AtividadeComCaloriasGastas>> getAtividadesList() {
        return this.atividades;
    }

    public void setAtividades(HashMap<LocalDate, List<AtividadeComCaloriasGastas>> atividades) {
        this.atividades = atividades;
    }

    public static int getAutoIncrement() {
        return Utilizador.USER_AUTO_INCREMENT;
    }

    public static int setAutoIncrement(int x) {
        return Utilizador.USER_AUTO_INCREMENT = x;
    }

    // Método para adicionar uma atividade
    public void addAtividade(Atividade atividade, LocalDate data, double calorias) {
        if (!this.atividades.containsKey(data)) {
            this.atividades.put(data, new ArrayList<>());
        }
        this.atividades.get(data).add(new AtividadeComCaloriasGastas(atividade, calorias));
    }

    // toString

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Código: ").append(this.codigo).append("\n");
        s.append("Nome: ").append(this.nome).append("\n");
        s.append("Morada: ").append(this.morada).append("\n");
        s.append("Email: ").append(this.email).append("\n");
        s.append("Frequência Cardíaca Média: ").append(this.frequenciaCardiacaMedia).append("\n");
        s.append("Atividades: ").append(this.atividades).append("\n");
        s.append("Calorias Gastas: ").append(this.caloriasGastas).append("\n");

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
        return this.codigo == utilizador.getCodigo() &&
                this.nome.equals(utilizador.getNome()) && this.morada.equals(utilizador.getMorada())
                && this.email.equals(utilizador.getEmail())
                && this.frequenciaCardiacaMedia == utilizador.getFrequenciaCardiacaMedia()
                && this.atividades.equals(utilizador.getAtividadesList());
    }

    // Métodos extra
    // hashCode
    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

}