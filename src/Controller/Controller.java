package Controller;

import java.util.*;
import Modules.Utilizador;
import Modules.Atividade;
import Modules.PlanoTreino;

// Classe do controlador
public class Controller {
    List<Utilizador> utilizadores;
    List<Atividade> atividades;
    Date dataAtual;

    public Controller() {
        utilizadores = new ArrayList<>();
        atividades = new ArrayList<>();
        dataAtual = new Date();
    }

    public void criarUtilizador(String codigo, String nome, String morada, String email, double frequenciaCardiacaMedia,
            String tipo) {
        // Implementar a lógica para criar um novo Utilizador

        Utilizador utilizador = new Utilizador(codigo, nome, morada, email, frequenciaCardiacaMedia, tipo);
        utilizadores.add(utilizador);
        System.out.println(utilizadores.toString());

    }

    void adicionarAtividade(Atividade atividade, PlanoTreino planoTreino, int iteracoes) {
        // Implementar a lógica para adicionar uma Atividade a um PlanoTreino
    }

    void avancarTempo(int dias) {
        // Implementar a lógica para avançar o tempo
    }

    // Outros métodos para as operações que um usuário pode realizar
}