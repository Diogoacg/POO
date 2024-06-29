package Modules.Gestores;

import Modules.Atividade.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;

import Modules.Estatisticas;
import Modules.PlanoTreino;
import Modules.Recordes;
import Modules.Utilizador.*;

public class Gestor implements Serializable {
    private static final long serialVersionUID = 1L;
    public LocalDate currentDate;
    private GestorAtividades gestorAtividades;
    private GestorUtilizadores gestorUtilizadores;
    private GestorPlanosTreino gestorPlanosTreino;
    private GestorRecordes gestorRecordes;

    public Gestor() {
        this.gestorAtividades = new GestorAtividades();
        this.gestorUtilizadores = new GestorUtilizadores();
        this.gestorPlanosTreino = new GestorPlanosTreino();
        this.gestorRecordes = new GestorRecordes();
        this.currentDate = LocalDate.now();
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

    public void updateAtividade(Atividade atividade) throws Exception {
        gestorAtividades.updateAtividade(atividade);
    }

    // Métodos para interagir com o GestorUtilizadores
    public void addUtilizador(Utilizador utilizador) throws Exception {
        gestorUtilizadores.addUtilizador(utilizador);
    }

    // update utilizador
    public void updateUtilizador(Utilizador utilizador) throws Exception {
        gestorUtilizadores.updateUtilizador(utilizador);
    }

    public void removerUtilizador(int codigoUtilizador) throws Exception {
        gestorUtilizadores.removeUtilizador(codigoUtilizador);
    }

    public Utilizador getUtilizador(int codigoUtilizador) throws Exception {
        return gestorUtilizadores.getUtilizador(codigoUtilizador);
    }

    public List<Utilizador> getUtilizadores() throws Exception {
        return gestorUtilizadores.getUtilizadores();
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

    public void registarAtividade(int codigoUtilizador, int codigoAtividade, LocalDate data, int frequenciaCardiaca)
            throws Exception {
        System.out.println("Registar atividade\n");
        // Primeiro, verifique se o utilizador existe
        Utilizador utilizador = gestorUtilizadores.getUtilizador(codigoUtilizador);
        if (utilizador == null) {
            throw new Exception("Utilizador inexistente");
        }

        // Em seguida, verifique se a atividade existe
        Atividade atividade = gestorAtividades.getAtividade(codigoAtividade);
        System.out.println(codigoAtividade);
        if (atividade == null) {
            throw new Exception("Atividade inexistente");
        }
        System.out.println("Atividade: " + atividade);
        System.out.println("Data: " + data);
        // Adicione o registo de atividade ao utilizador
        utilizador.addAtividade(atividade, data, atividade.calcularCalorias(utilizador, frequenciaCardiaca));

        // print debug
        System.out.println("Atividade: " + atividade);

        // Atualize os dados do utilizador
        double calorias = atividade.calcularCalorias(utilizador, frequenciaCardiaca);
        utilizador.setCaloriasGastas(utilizador.getCaloriasGastas() + calorias);

        System.out.println("Calorias gastas: " + utilizador.getCaloriasGastas());
        System.out.println("Frequência cardíaca média: " + utilizador.getFrequenciaCardiacaMedia());

        // alterar a frequencia cardiaca media no utilizador

        double nrDeAtividades = utilizador.getAtividadesList().size();
        double frequenciaCardiacaMedia = (utilizador.getFrequenciaCardiacaMedia() * nrDeAtividades + frequenciaCardiaca)
                / nrDeAtividades;

        utilizador.setFrequenciaCardiacaMedia(frequenciaCardiacaMedia);

        // Atualize o utilizador
        updateUtilizador(utilizador);

        // Mapa de listas de funções para obter os valores dos campos
        Map<String, List<Function<Atividade, Double>>> funcoesCampo = new HashMap<>();

        // Adicionando funções para cada tipo de atividade
        funcoesCampo.put("Natacao", Arrays.asList(ativ -> ((Natacao) ativ).getDistancia()));
        funcoesCampo.put("CorridaEmPista", Arrays.asList(ativ -> ((CorridaEmPista) ativ).getDistancia()));
        funcoesCampo.put("CorridaNoMonte", Arrays.asList(
                ativ -> ((CorridaNoMonte) ativ).getDistancia(),
                ativ -> ((CorridaNoMonte) ativ).getAltimetria()));
        funcoesCampo.put("BicicletaNoMonte", Arrays.asList(
                ativ -> ((BicicletaNoMonte) ativ).getDistancia(),
                ativ -> ((BicicletaNoMonte) ativ).getAltimetria()));
        funcoesCampo.put("Flexoes", Arrays.asList(ativ -> (double) ((Flexoes) ativ).getRepeticoes()));
        funcoesCampo.put("Abdominais", Arrays.asList(ativ -> (double) ((Abdominais) ativ).getRepeticoes()));
        funcoesCampo.put("Prensa", Arrays.asList(
                ativ -> (double) ((Prensa) ativ).getRepeticoes(),
                ativ -> ((Prensa) ativ).getPeso()));
        funcoesCampo.put("Supino", Arrays.asList(
                ativ -> (double) ((Supino) ativ).getRepeticoes(),
                ativ -> ((Supino) ativ).getPeso()));

        System.out.println("Funções campo: " + funcoesCampo);
        // Verificar se o utilizador bateu um recorde
        String nomeAtividade = atividade.getClass().getSimpleName();
        List<Function<Atividade, Double>> listaFuncoes = funcoesCampo.get(nomeAtividade);
        Field[] campos = atividade.getClass().getDeclaredFields();
        for (Field campo : campos) {
            if (listaFuncoes != null) {
                for (Function<Atividade, Double> funcao : listaFuncoes) {
                    double valorCampo = funcao.apply(atividade);

                    // Criar recorde fake para verificar se existe
                    Recordes recorde = new Recordes(atividade, utilizador, data, campo.getName(), calorias);

                    // Obter recorde real
                    try {
                        System.out.println("Recorde: " + recorde.hashCode());
                        recorde = gestorRecordes.getRecorde(recorde.hashCode());
                    } catch (Exception e) {
                        recorde = null;
                    }
                    if (recorde == null) {
                        // Adicionar recorde
                        recorde = new Recordes(atividade, utilizador, data, campo.getName(), valorCampo);
                        gestorRecordes.addRecorde(recorde);
                        System.out.println("Recorde adicionado");
                        System.out.println(getRecorde(recorde.hashCode()));
                    } else if (valorCampo > recorde.getValor()) {
                        // Atualizar recorde
                        recorde.setValor(valorCampo);
                        recorde.setData(data);
                        gestorRecordes.updateRecorde(recorde);
                    }
                }
            }
        }

    }

    public List<Utilizador> getUtilizadoresPorNome(String nome) {
        return gestorUtilizadores.getUtilizadoresPorNome(nome);

    }

    private void atualizarPlanosTreino() throws Exception {
        for (PlanoTreino planoTreino : gestorPlanosTreino.getCatalogoPlanosTreino().values()) {
            if (planoTreino.getData().isBefore(currentDate) || planoTreino.getData().isEqual(currentDate)) {
                // get user do plano de treino
                Utilizador utilizador = planoTreino.getUtilizador();
                // get atividades do plano de treino
                Map<Atividade, Integer> atividades = planoTreino.getAtividades();
                // para cada atividade do plano de treino e respetivas iterações regista a
                // atividade
                // obter frequencia carddiaca random variando -40 +40 conforme a frequencia
                // media da atividade excepto se for 0

                for (Map.Entry<Atividade, Integer> entry : atividades.entrySet()) {
                    // get atividade by name
                    Atividade atividade = entry.getKey();
                    for (int i = 0; i < entry.getValue(); i++) {
                        if (utilizador.getFrequenciaCardiacaMedia() == 0) {
                            this.registarAtividade(utilizador.getCodigo(), atividade.hashCode(), currentDate, 100);
                        } else {
                            int frequenciaCardiaca = (int) (utilizador.getFrequenciaCardiacaMedia()
                                    + (Math.random() * 80))
                                    - 40;
                            this.registarAtividade(utilizador.getCodigo(), atividade.hashCode(), currentDate,
                                    frequenciaCardiaca);
                        }
                    }
                }
                // delete plano de treino
                gestorPlanosTreino.removePlanoTreino(planoTreino.hashCode());

            }

        }
    }

    // gestor de recordes
    public void addRecorde(Recordes recorde) throws Exception {
        gestorRecordes.addRecorde(recorde);
    }

    public void removerRecorde(int codidoRecorde) throws Exception {
        gestorRecordes.removeRecorde(codidoRecorde);
    }

    public Recordes getRecorde(int codigoRecorde) throws Exception {
        return gestorRecordes.getRecorde(codigoRecorde);
    }

    public String listarRecordes() {
        return gestorRecordes.listarRecordes();
    }

    public void updateRecorde(Recordes recorde) throws Exception {
        gestorRecordes.updateRecorde(recorde);
    }

    public int getSize() {
        return gestorRecordes.getSize();
    }

    // estatisticas
    public Utilizador utilizadorComMaisCaloriasGastas(LocalDate inicio, LocalDate fim) throws Exception {

        return Estatisticas.utilizadorComMaisCalorias(getUtilizadores(), inicio, fim).clone();
    }

    public Utilizador utilizadorComMaisAtividades(LocalDate inicio, LocalDate fim) throws Exception {
        return Estatisticas.utilizadorComMaisAtividades(getUtilizadores(), inicio, fim).clone();
    }

    public int vezesAtividadeRealizada(Atividade atividade) throws Exception {
        return Estatisticas.vezesAtividadeRealizada(getUtilizadores(), atividade);
    }

    public String atividadeMaisRealizada() throws Exception {
        return Estatisticas.atividadeMaisRealizada(getUtilizadores());
    }

    public double altimetriaTotal(Utilizador user, LocalDate inicio, LocalDate fim) throws Exception {
        return Estatisticas.altimetriaTotal(user, inicio, fim);
    }

    public double kmRealizados(Utilizador user, LocalDate inicio, LocalDate fim) throws Exception {
        return Estatisticas.kmRealizados(user, inicio, fim);
    }

    public PlanoTreino planoMaisExigente() throws Exception {
        return Estatisticas.planoMaisExigente(gestorPlanosTreino.getPlanosTreinoList());
    }

    public List<Atividade> listarAtividadesUtilizador(String email) throws Exception {
        Utilizador utilizador = getUtilizadorPorEmail(email);
        return Estatisticas.listarAtividadesUtilizador(utilizador);
    }

    // Método para avançar o tempo
    public void avancarTempo(int dias) throws Exception {
        this.currentDate = this.currentDate.plusDays(dias);
        System.out.println("Data atual: " + this.currentDate);
        this.atualizarPlanosTreino();
    }

}
