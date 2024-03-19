package Modules;

import java.util.Date;

import Modules.Atividade.Atividade;
import Modules.Utilizador.Utilizador;

public class RegistroAtividade {
    Utilizador utilizador;
    Atividade atividade;
    Date dataHora;
    double caloriasConsumidas;

    public RegistroAtividade(Utilizador utilizador, Atividade atividade, Date dataHora) {
        this.utilizador = utilizador;
        this.atividade = atividade;
        this.dataHora = dataHora;
        this.caloriasConsumidas = atividade.calcularCalorias(utilizador);
    }

    // Métodos get e set para cada atributo
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getCaloriasConsumidas() {
        return caloriasConsumidas;
    }

    public void setCaloriasConsumidas(double caloriasConsumidas) {
        this.caloriasConsumidas = caloriasConsumidas;
    }

    public String toString() {
        return "RegistroAtividade [atividade=" + atividade + ", caloriasConsumidas=" + caloriasConsumidas
                + ", dataHora="
                + dataHora + ", utilizador=" + utilizador + "]";
    }

    public boolean equals(RegistroAtividade registro) {
        return this.atividade.equals(registro.atividade) && this.utilizador.equals(registro.utilizador)
                && this.dataHora.equals(registro.dataHora);

    }
}
