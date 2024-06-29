package Modules;

import Modules.Atividade.Atividade;
import Modules.Utilizador.Utilizador;

import java.util.Objects;
import java.time.LocalDate;

public class Recordes implements java.io.Serializable {
    private Atividade atividade;
    private Utilizador utilizador;
    private LocalDate data;
    // especificaçao do valor do recorde, por exemplo, calorias queimadas, distancia
    // percorrida, etc.
    private String especificacao;
    private double valor; // o valor do recorde (por exemplo, calorias queimadas, distância percorrida,
                          // etc.)

    // construtores, getters, setters, etc.
    public Recordes(Atividade atividade, Utilizador utilizador, LocalDate data, String especificacao, double valor) {
        this.atividade = atividade;
        this.utilizador = utilizador;
        this.data = data;
        this.especificacao = especificacao;
        this.valor = valor;
    }

    public Recordes(Recordes recorde) {
        this.atividade = recorde.getAtividade();
        this.utilizador = recorde.getUtilizador();
        this.data = recorde.getData();
        this.especificacao = recorde.getEspecificacao();
        this.valor = recorde.getValor();
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\n------------------------------------------\n" +
                "Recorde :\n" +
                "Atividade = " + atividade.getClass().getSimpleName() + "\n" +
                "Data = " + data + "\n" +
                "Utilizador = " + utilizador.getEmail() + "\n" +
                "Especificacao = " + especificacao + "\n" +
                "Valor = " + valor + "\n" +
                "------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Recordes recorde = (Recordes) o;
        return this.atividade.equals(recorde.getAtividade()) && this.utilizador.equals(recorde.getUtilizador())
                && this.data.equals(recorde.getData()) &&
                this.especificacao.equals(recorde.getEspecificacao()) &&
                this.valor == recorde.getValor();
    }

    @Override
    public int hashCode() {
        // obter nome da classe
        return Objects.hash(this.atividade.getClass().getSimpleName(), this.especificacao);
    }

    public Recordes clone() {
        return new Recordes(this);
    }

}
