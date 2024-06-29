package Modules.Atividade;

public class AtividadeComCaloriasGastas implements java.io.Serializable {
    private Atividade atividade;
    private double calorias;

    public AtividadeComCaloriasGastas(Atividade atividade, double calorias) {
        this.atividade = atividade;
        this.calorias = calorias;
    }

    public AtividadeComCaloriasGastas(AtividadeComCaloriasGastas atividadeComCaloriasGastas) {
        this.atividade = atividadeComCaloriasGastas.getAtividade();
        this.calorias = atividadeComCaloriasGastas.getCalorias();

    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "\nAtividade :" + atividade + "\n" +
                "Calorias :" + calorias + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AtividadeComCaloriasGastas that = (AtividadeComCaloriasGastas) o;

        if (Double.compare(that.calorias, calorias) != 0)
            return false;
        return atividade != null ? atividade.equals(that.atividade) : that.atividade == null;
    }

    // construtores, getters, setters, etc.
}
