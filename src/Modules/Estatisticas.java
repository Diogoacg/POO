
package Modules;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import Modules.Atividade.*;
import Modules.Utilizador.Utilizador;
import java.util.Map;
import java.util.stream.*;
import java.io.Serializable;

// 1. qual é o utilizador que mais calorias dispendeu num período ou desde sempre
// 2. qual o utilizador que mais actividades realizou num período ou desde sempre
// 3. qual o tipo de actividade mais realizada
// 4. quantos kms é que um utilizdor realizou num período ou desde sempre
// 5. quantos metros de altimetria é que um utilizar totalizou num período ou desde sempre
// 6. qual o plano de treino mais exigente em função do dispêndio de calorias proposto
// 7. listar as actividades de um utilizador

public class Estatisticas implements Serializable {

    public static Utilizador utilizadorComMaisCalorias(List<Utilizador> utilizadores, LocalDate inicio, LocalDate fim) {
        return utilizadores.stream()
                .max(Comparator.comparingDouble(utilizador -> utilizador.getAtividadesList().entrySet().stream()
                        .filter(entry -> (inicio == null || !entry.getKey().isBefore(inicio)) &&
                                (fim == null || !entry.getKey().isAfter(fim)))
                        .flatMap(entry -> entry.getValue().stream())
                        .mapToDouble(AtividadeComCaloriasGastas::getCalorias)
                        .sum()))
                .orElse(null);
    }

    public static Utilizador utilizadorComMaisAtividades(List<Utilizador> utilizadores, LocalDate inicio,
            LocalDate fim) {
        return utilizadores.stream()
                .max(Comparator.comparingInt(u -> u.getAtividadesList().entrySet().stream()
                        .filter(entry -> (inicio == null || !entry.getKey().isBefore(inicio)) &&
                                (fim == null || !entry.getKey().isAfter(fim)))
                        .mapToInt(entry -> entry.getValue().size())
                        .sum()))
                .orElse(null);
    }

    // vezes que uma atividade foi realizada, recebe uma lista de utilizadores, uma
    // atividade e devolve o numero de vezes que foi realizada
    public static int vezesAtividadeRealizada(List<Utilizador> utilizadores, Atividade atividade) {
        int n = (int) utilizadores.stream()
                .flatMap(u -> u.getAtividadesList().values().stream())
                .flatMap(List::stream)
                .map(AtividadeComCaloriasGastas::getAtividade)
                .filter(a -> a.equals(atividade))
                .count();
        System.out.println(n);
        return n;
    }

    public static String atividadeMaisRealizada(List<Utilizador> utilizadores) {
        return utilizadores.stream()
                .flatMap(u -> u.getAtividadesList().values().stream())
                .flatMap(List::stream)
                .map(AtividadeComCaloriasGastas::getAtividade)
                .collect(Collectors.groupingBy(a -> a.getClass().getSimpleName(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static double altimetriaTotal(Utilizador utilizador, LocalDate inicio, LocalDate fim) {
        return utilizador.getAtividadesList().entrySet().stream()
                .filter(entry -> (inicio == null || !entry.getKey().isBefore(inicio)) &&
                        (fim == null || !entry.getKey().isAfter(fim)))
                .flatMap(entry -> entry.getValue().stream())
                .map(AtividadeComCaloriasGastas::getAtividade)
                .filter(atividade -> atividade instanceof CorridaNoMonte
                        || atividade instanceof BicicletaNoMonte)
                .mapToDouble(atividade -> {
                    if (atividade instanceof CorridaNoMonte) {
                        return ((CorridaNoMonte) atividade).getAltimetria();
                    } else if (atividade instanceof BicicletaNoMonte) {
                        return ((BicicletaNoMonte) atividade).getAltimetria();
                    } else {
                        return 0;
                    }
                })
                .sum();
    }

    public static double kmRealizados(Utilizador utilizador, LocalDate inicio, LocalDate fim) {
        return utilizador.getAtividadesList().entrySet().stream()
                .filter(entry -> (inicio == null || !entry.getKey().isBefore(inicio)) &&
                        (fim == null || !entry.getKey().isAfter(fim)))
                .flatMap(entry -> entry.getValue().stream())
                .map(AtividadeComCaloriasGastas::getAtividade)
                .filter(atividade -> atividade instanceof CorridaNoMonte
                        || atividade instanceof BicicletaNoMonte || atividade instanceof Natacao
                        || atividade instanceof CorridaEmPista)
                .mapToDouble(atividade -> {
                    if (atividade instanceof CorridaNoMonte) {
                        return ((CorridaNoMonte) atividade).getDistancia();
                    } else if (atividade instanceof BicicletaNoMonte) {
                        return ((BicicletaNoMonte) atividade).getDistancia();
                    } else if (atividade instanceof Natacao) {
                        return ((Natacao) atividade).getDistancia() / 1000;
                    } else if (atividade instanceof CorridaEmPista) {
                        return ((CorridaEmPista) atividade).getDistancia();
                    } else {
                        return 0;
                    }
                })
                .sum();
    }

    public static PlanoTreino planoMaisExigente(List<PlanoTreino> planos) {
        return planos.stream()
                .max(Comparator.comparingDouble(PlanoTreino::calcularCaloriasEstimativa))
                .orElse(null);
    }

    public static List<Atividade> listarAtividadesUtilizador(Utilizador utilizador) {
        return utilizador.getAtividadesList().values().stream()
                .flatMap(List::stream)
                .map(AtividadeComCaloriasGastas::getAtividade)
                .collect(Collectors.toList());
    }

}