package Modules.Gestores;

import Modules.Recordes;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class GestorRecordes implements Serializable {

    private static final long serialVersionUID = 8L;

    private Map<Integer, Recordes> catalogo_recordes;

    public GestorRecordes() {
        this.catalogo_recordes = new HashMap<Integer, Recordes>();
    }

    private void lookUpRecorde(int codigoRecorde) throws Exception {
        if (!this.catalogo_recordes.containsKey(codigoRecorde)) {
            throw new Exception("Recorde inexistente");
        }
    }

    public void addRecorde(Recordes recorde) throws Exception {
        if (this.catalogo_recordes.containsKey(recorde.hashCode())) {
            throw new Exception("Recorde já inserido");
        }

        this.catalogo_recordes.put(recorde.hashCode(), recorde.clone());
    }

    public Recordes removeRecorde(int codidoRecorde) throws Exception {
        this.lookUpRecorde(codidoRecorde);
        return this.catalogo_recordes.remove(codidoRecorde).clone();
    }

    public Recordes getRecorde(int codigoRecorde) throws Exception {
        this.lookUpRecorde(codigoRecorde);
        return this.catalogo_recordes.get(codigoRecorde).clone();
    }

    public String listarRecordes() {
        return this.catalogo_recordes.values().stream()
                .map(Recordes::clone)
                .map(Recordes::toString)
                .collect(java.util.stream.Collectors.joining("\n"));
    }

    public void updateRecorde(Recordes recorde) throws Exception {
        this.lookUpRecorde(recorde.hashCode());
        this.catalogo_recordes.put(recorde.hashCode(), recorde.clone());
    }

    public int getSize() {
        return this.catalogo_recordes.size();
    }
}