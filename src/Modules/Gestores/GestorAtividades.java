package Modules.Gestores;

import Modules.Atividade.Atividade;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.io.Serializable;

public class GestorAtividades implements Serializable {

    private static final long serialVersionUID = 8L;

    private Map<Integer, Atividade> catalogo_atividades;

    public GestorAtividades() {
        this.catalogo_atividades = new HashMap<Integer, Atividade>();
    }

    private void lookUpAtividade(int codigo_atividade) throws Exception {
        if (!this.catalogo_atividades.containsKey(codigo_atividade)) {
            throw new Exception("Atividade inexistente");
        }
    }

    public void addAtividade(Atividade atividade) throws Exception {
        if (this.catalogo_atividades.containsKey(atividade.hashCode())) {
            throw new Exception("Atividade já inserida");
        }
        this.catalogo_atividades.put(atividade.hashCode(), atividade.clone());
    }

    public Atividade removeAtividade(int codigo_atividade) throws Exception {
        this.lookUpAtividade(codigo_atividade);
        return this.catalogo_atividades.remove(codigo_atividade).clone();
    }

    public Atividade getAtividade(int codigo_atividade) throws Exception {
        this.lookUpAtividade(codigo_atividade);
        return this.catalogo_atividades.get(codigo_atividade).clone();
    }

    public void updateAtividade(Atividade atividade) throws Exception {
        this.lookUpAtividade(atividade.hashCode());
        this.catalogo_atividades.put(atividade.hashCode(), atividade.clone());
    }

    public String listarAtividades() {
        return this.catalogo_atividades.values().stream()
                .map(Atividade::clone)
                .map(Atividade::toString)
                .collect(Collectors.joining("\n"));
    }
}
