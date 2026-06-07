package domain;

public class Evento {
    private String nome;
    private int limiteVagas;
    private int inscricoesAtuais;

    public Evento(String nome, int limiteVagas) {
        this.nome = nome;
        this.limiteVagas = limiteVagas;
        this.inscricoesAtuais = 0; // O evento nasce com 0 inscrições
    }

    public void adicionarInscricao() {
        if (this.inscricoesAtuais >= this.limiteVagas) {
            throw new IllegalStateException("Limite de vagas excedido para este evento.");
        }
        this.inscricoesAtuais++;
    }
}