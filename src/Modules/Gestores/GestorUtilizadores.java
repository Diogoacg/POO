package Modules.Gestores;

import Modules.Atividade.Atividade;
import Modules.Utilizador.Utilizador;
import Modules.Gestores.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalDate;

public class GestorUtilizadores implements Serializable {

    private static final long serialVersionUID = 8L;

    private Map<Integer, Utilizador> catalogo_utilizadores;

    public GestorUtilizadores() {
        this.catalogo_utilizadores = new HashMap<Integer, Utilizador>();
    }

    private void lookUpUtilizador(int codigo_utilizador) throws Exception {
        if (!this.catalogo_utilizadores.containsKey(codigo_utilizador)) {
            throw new Exception("Utilizador inexistente");
        }
    }

    public void addUtilizador(Utilizador utilizador) throws Exception {
        if (this.catalogo_utilizadores.containsKey(utilizador.hashCode())) {
            throw new Exception("Utilizador já inserido");
        }
        this.catalogo_utilizadores.put(utilizador.hashCode(), utilizador.clone());
    }

    public Utilizador removeUtilizador(int codigo_utilizador) throws Exception {
        this.lookUpUtilizador(codigo_utilizador);
        return this.catalogo_utilizadores.remove(codigo_utilizador).clone();
    }

    public Utilizador getUtilizador(int codigo_utilizador) throws Exception {
        this.lookUpUtilizador(codigo_utilizador);
        return this.catalogo_utilizadores.get(codigo_utilizador).clone();
    }

    public String listarUtilizadores() {
        return this.catalogo_utilizadores.values().stream()
                .map(Utilizador::clone)
                .map(Utilizador::toString)
                .collect(Collectors.joining("\n"));
    }
    // retorna todos os utilizadores com o mesmo nome

    public List<Utilizador> getUtilizadoresPorNome(String nome) {
        return this.catalogo_utilizadores.values().stream()
                .filter(utilizador -> utilizador.clone().getNome().equals(nome)).collect(Collectors.toList());
    }
}
