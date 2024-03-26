package Modules.Gestores;

import Modules.Atividade.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import Modules.PlanoTreino;
import Modules.Utilizador.*;

public class Gestor {
    private GestorAtividades gestorAtividades;
    private GestorUtilizadores gestorUtilizadores;
    private GestorPlanosTreino gestorPlanosTreino;

    public Gestor() {
        this.gestorAtividades = new GestorAtividades();
        this.gestorUtilizadores = new GestorUtilizadores();
        this.gestorPlanosTreino = new GestorPlanosTreino();
    }

    // Métodos para interagir com o GestorAtividades
    public void addAtividade(Atividade atividade) throws Exception {
        gestorAtividades.addAtividade(atividade);
    }

    public void removerAtividade(int nomeAtividade) throws Exception {
        gestorAtividades.removeAtividade(nomeAtividade);
    }

    public Atividade getAtividade(int nomeAtividade) throws Exception {
        return gestorAtividades.getAtividade(nomeAtividade);
    }

    public String listarAtividades() {
        return gestorAtividades.listarAtividades();
    }

    // Métodos para interagir com o GestorUtilizadores
    public void addUtilizador(Utilizador utilizador) throws Exception {
        gestorUtilizadores.addUtilizador(utilizador);
    }

    public void removerUtilizador(int codigoUtilizador) throws Exception {
        gestorUtilizadores.removeUtilizador(codigoUtilizador);
    }

    public Utilizador getUtilizador(int codigoUtilizador) throws Exception {
        return gestorUtilizadores.getUtilizador(codigoUtilizador);
    }

    public Utilizador getUtilizadorPorEmail(String email) throws Exception {
        return gestorUtilizadores.getUtilizadorPorEmail(email);
    }

    public String listarUtilizadores() {
        return gestorUtilizadores.listarUtilizadores();
    }

    // Métodos para interagir com o GestorPlanosTreino
    public void addPlanoTreino(PlanoTreino planoTreino) throws Exception {
        gestorPlanosTreino.addPlanoTreino(planoTreino);
    }

    public void removerPlanoTreino(int codigoPlanoTreino) throws Exception {
        gestorPlanosTreino.removePlanoTreino(codigoPlanoTreino);
    }

    public PlanoTreino getPlanoTreino(int codigoPlanoTreino) throws Exception {
        return gestorPlanosTreino.getPlanoTreino(codigoPlanoTreino);
    }

    public String listarPlanosTreino() {
        return gestorPlanosTreino.listarPlanosTreino();
    }

    public void registarAtividade(int codigoUtilizador, int codigoAtividade, Date data) throws Exception {
        // Primeiro, verifique se o utilizador existe
        Utilizador utilizador = gestorUtilizadores.getUtilizador(codigoUtilizador);
        if (utilizador == null) {
            throw new Exception("Utilizador inexistente");
        }

        // Em seguida, verifique se a atividade existe
        Atividade atividade = gestorAtividades.getAtividade(codigoAtividade);
        if (atividade == null) {
            throw new Exception("Atividade inexistente");
        }

        // Adicione o registo de atividade ao utilizador
        utilizador.addAtividade(atividade);
    }

    public List<Utilizador> getUtilizadoresPorNome(String nome) {
        return gestorUtilizadores.getUtilizadoresPorNome(nome);

    }

    // get atividade por nome
    public Atividade getAtividadePorNome(String nome) throws Exception {
        return gestorAtividades.getAtividadePorNome(nome);
    }

}
