package Modules.Gestores;

import Modules.Estatisticas;
import Modules.Utilizador.Utilizador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.time.LocalDate;

public class GestorUtilizadores implements Serializable {

    private static final long serialVersionUID = 5L;
    private List<Utilizador> catalogo_utilizadores;
    // adicionar utilizador variavel de incrementação para o codigo do utilizador

    public GestorUtilizadores() {
        this.catalogo_utilizadores = new ArrayList<Utilizador>();
    }

    public void lookUpUtilizador(int codigo) throws Exception {
        if (codigo < 0 || codigo >= this.getSize()) {
            throw new Exception("Utilizador inexistente");
        }
    }

    public void lookupUtilizadorByEmail(String email) throws Exception {
        if (this.catalogo_utilizadores.stream().filter((x) -> x.getEmail().equals(email)).count() != 1) {
            throw new Exception("Utilizador inexistente");
        }
    }

    // private int getCodigo(String email) throws Exception {
    // this.lookupUtilizadorByEmail(email);
    // return this.catalogo_utilizadores.stream().filter((x) ->
    // x.getEmail().equals(email))
    // .mapToInt((x) -> x.getCodigo()).sum();
    // }

    public void addUtilizador(Utilizador utilizador) throws Exception {
        if (this.catalogo_utilizadores.stream().filter((x) -> x.getEmail().equals(utilizador.getEmail()))
                .count() != 0) {
            GestorUtilizadores.setAutoIncrement(utilizador.getCodigo());
            throw new Exception("Utilizador já inserido");
        }
        this.catalogo_utilizadores.add(utilizador.getCodigo(), utilizador.clone());
    }

    // update utilizador
    public void updateUtilizador(Utilizador utilizador) throws Exception {
        this.lookUpUtilizador(utilizador.getCodigo());
        this.catalogo_utilizadores.set(utilizador.getCodigo(), utilizador.clone());
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
        return this.catalogo_utilizadores.stream()
                .map(Utilizador::clone)
                .map(Utilizador::toString)
                .collect(Collectors.joining("\n"));
    }
    // retorna todos os utilizadores com o mesmo nome

    public List<Utilizador> getUtilizadoresPorNome(String nome) {
        return this.catalogo_utilizadores.stream()
                .filter(utilizador -> utilizador.clone().getNome().equals(nome)).collect(Collectors.toList());
    }

    // retorna utilizador pelo email unico
    public Utilizador getUtilizadorPorEmail(String email) {
        return this.catalogo_utilizadores.stream()
                .filter(utilizador -> utilizador.clone().getEmail().equals(email)).findFirst().orElse(null);
    }

    public static int getAutoIncrement() {
        return Utilizador.getAutoIncrement();
    }

    public static void setAutoIncrement(int x) {
        Utilizador.setAutoIncrement(x);
    }

    public int getSize() {
        return this.catalogo_utilizadores.size();
    }

    // obter lista de utilizadores
    public List<Utilizador> getUtilizadores() {
        return this.catalogo_utilizadores.stream().map(Utilizador::clone).collect(Collectors.toList());
    }

    // estatisticas
    public Utilizador utilizadorComMaisCaloriasGastas(LocalDate inicio, LocalDate fim) {

        return Estatisticas.utilizadorComMaisCalorias(getUtilizadores(), inicio, fim).clone();
    }

    public Utilizador utilizadorComMaisAtividades(LocalDate inicio, LocalDate fim) {
        return Estatisticas.utilizadorComMaisAtividades(this.catalogo_utilizadores, inicio, fim).clone();
    }

    // atividade mais realizada
    public String atividadeMaisRealizada() {
        return Estatisticas.atividadeMaisRealizada(this.catalogo_utilizadores);
    }

}
