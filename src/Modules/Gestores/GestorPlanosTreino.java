package Modules.Gestores;

import Modules.PlanoTreino;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

public class GestorPlanosTreino implements Serializable {

    private static final long serialVersionUID = 8L;

    private Map<Integer, PlanoTreino> catalogo_planosTreino;

    public GestorPlanosTreino() {
        this.catalogo_planosTreino = new HashMap<Integer, PlanoTreino>();
    }

    public Map<Integer, PlanoTreino> getCatalogoPlanosTreino() {
        return this.catalogo_planosTreino;
    }

    public List<PlanoTreino> getPlanosTreinoList() {
        return this.catalogo_planosTreino.values().stream()
                .map(PlanoTreino::clone)
                .collect(Collectors.toList());
    }

    private void lookUpPlanoTreino(int codigo_planoTreino) throws Exception {
        if (!this.catalogo_planosTreino.containsKey(codigo_planoTreino)) {
            throw new Exception("Plano de Treino inexistente");
        }
    }

    public void addPlanoTreino(PlanoTreino planoTreino) throws Exception {
        if (this.catalogo_planosTreino.containsKey(planoTreino.hashCode())) {
            throw new Exception("Plano de Treino já inserido");
        }
        this.catalogo_planosTreino.put(planoTreino.hashCode(), planoTreino.clone());
    }

    public PlanoTreino removePlanoTreino(int codigo_planoTreino) throws Exception {
        this.lookUpPlanoTreino(codigo_planoTreino);
        return this.catalogo_planosTreino.remove(codigo_planoTreino).clone();
    }

    public PlanoTreino getPlanoTreino(int codigo_planoTreino) throws Exception {
        this.lookUpPlanoTreino(codigo_planoTreino);
        return this.catalogo_planosTreino.get(codigo_planoTreino).clone();
    }

    public String listarPlanosTreino() {
        return this.catalogo_planosTreino.values().stream()
                .map(PlanoTreino::clone)
                .map(PlanoTreino::toString)
                .collect(Collectors.joining("\n"));
    }
}
