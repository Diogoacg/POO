package Controller;

import java.util.*;

import Modules.Atividade.Atividade;
import Modules.Utilizador.Utilizador;
import Modules.Utilizador.UtilizadorProfissional;
import Modules.PlanoTreino;
import Modules.RegistroAtividade;

// Classe do controlador
public class Controller {
    List<Utilizador> utilizadores;
    public List<Atividade> atividades;
    List<RegistroAtividade> registros;
    List<PlanoTreino> planos;
    Date dataAtual;

    public Controller() {
        utilizadores = new ArrayList<>();
        atividades = new ArrayList<>();
        registros = new ArrayList<>();
        planos = new ArrayList<>();
        dataAtual = new Date();
    }

    public void adicionarUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void adicionarRegistro(RegistroAtividade registro) {
        registros.add(registro);
    }

    // obter lista de utilizadores com o mesmo nome
    public List<Utilizador> obterUtilizadoresPorNome(String nome) {
        List<Utilizador> utilizadoresPorNome = new ArrayList<>();
        for (Utilizador utilizador : utilizadores) {
            System.out.println(utilizador.getNome());
            if (utilizador.getNome().equals(nome)) {
                utilizadoresPorNome.add(utilizador);
            }
        }
        return utilizadoresPorNome;
    }

    public void listarAtividades() {
        for (Atividade atividade : atividades) {
            // Imprime o nome de cada atividade
            System.out.println("Atividade: " + atividade.getNome());
        }
    }

    public Atividade encontrarAtividadePorNome(String nome) {
        for (Atividade atividade : atividades) {
            if (atividade.getNome().equals(nome)) {
                System.out.println("Atividade encontrada: " + atividade.getNome() + "\n");
                return atividade;
            }
        }
        return null;
    }

    // Outros métodos para as operações que um usuário pode realizar
}