package domain;

import java.time.LocalDate;

public class Periodo {

    private final LocalDate dataInicio;
    private final LocalDate dataFim;

    public Periodo(LocalDate dataInicio, LocalDate dataFim) {
        // Regra de negócio blindada no construtor
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início.");
        }

        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Apenas Getters (Imutabilidade garantida)
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
}