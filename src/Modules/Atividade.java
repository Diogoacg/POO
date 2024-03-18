package Modules;

public class Atividade {
    String nome;
    double tempo; // Tempo dispendido na atividade
    double frequenciaCardiacaMedia; // Frequência cardíaca média durante a atividade
    String tipo; // Tipo de atividade (distância e altimetria, apenas distância, repetições,
                 // repetições com pesos)
    boolean isHard; // Se a atividade é do tipo Hard
    double distancia; // Distância percorrida na atividade (se aplicável)
    double altimetria; // Altimetria acumulada na atividade (se aplicável)
    int repeticoes; // Número de repetições na atividade (se aplicável)
    double peso; // Peso usado na atividade (se aplicável)

    // Método para calcular calorias
    double calcularCalorias(Utilizador atleta) {
        // Implementar a fórmula para calcular calorias
        return 0;
    }

    // Métodos get e set para cada atributo

    public Atividade(String nome, double tempo, double frequenciaCardiacaMedia, String tipo, boolean isHard,
            double distancia, double altimetria, int repeticoes, double peso) {
        this.nome = nome;
        this.tempo = tempo;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.tipo = tipo;
        this.isHard = isHard;
        this.distancia = distancia;
        this.altimetria = altimetria;
        this.repeticoes = repeticoes;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getFrequenciaCardiacaMedia() {
        return frequenciaCardiacaMedia;
    }

    public void setFrequenciaCardiacaMedia(double frequenciaCardiacaMedia) {
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isHard() {
        return isHard;
    }

    public void setHard(boolean isHard) {
        this.isHard = isHard;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getAltimetria() {
        return altimetria;
    }

    public void setAltimetria(double altimetria) {
        this.altimetria = altimetria;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String toString() {
        return "Atividade [altimetria=" + altimetria + ", distancia=" + distancia + ", frequenciaCardiacaMedia="
                + frequenciaCardiacaMedia + ", isHard=" + isHard + ", nome=" + nome + ", peso=" + peso + ", repeticoes="
                + repeticoes + ", tempo=" + tempo + ", tipo=" + tipo + "]";
    }

    public boolean equals(Atividade atividade) {
        return this.nome.equals(atividade.nome);
    }

}
