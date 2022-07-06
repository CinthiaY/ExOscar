package service;

import model.DadosOscar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class OscarService {
    private final List<DadosOscar> dadosOscar;

    public OscarService(List<DadosOscar> dadosOscars) {
        this.dadosOscar = dadosOscars;
    }

    public void printPremiadoMaisJovem() {
        var maisJovem = dadosOscar.stream()
                .sorted(Comparator.comparingInt(DadosOscar::getAge)).findFirst();
        maisJovem.ifPresent(atorMaisJovem -> System.out.printf("%s é o ator/atriz mais novo a ser premiado, com %d anos",
                atorMaisJovem.getName(), atorMaisJovem.getAge()));

    }

    public void printMaisPremiado() {
        var maisPremiado = dadosOscar.stream()
                .collect(
                        Collectors.groupingBy(ator -> ator.getName(),
                                Collectors.summingInt(ator -> 1)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        maisPremiado.ifPresent(ator -> System.out.
                printf("%s é o ator/atriz mais premiado, com %d prêmios", ator.getKey(), ator.getValue()));

    }

    public void printMaisPremiado2() { //só testando outro jeito!
        var maisPremiado2 = dadosOscar.stream()
                .collect(
                        Collectors.groupingBy(ator -> ator.getName(),
                                Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maisPremiado2.ifPresent(ator -> System.out.
                printf("%s é o ator mais premiado/atriz, com %d prêmios", ator.getKey(), ator.getValue()));


    }

    public void printJovemMaisPremiado() {
        var jovemMaisPremiado = dadosOscar.stream()
                .filter(ator -> ator.getAge()>17)
                .filter(ator -> ator.getAge()<25)
                .collect(
                        Collectors.groupingBy(ator -> ator.getName(),
                                Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        jovemMaisPremiado.ifPresent(ator -> System.out.
                printf("%s é o ator/atriz entre 18 e 24 mais premiado, com %d prêmios", ator.getKey(), ator.getValue()));


    }

}
