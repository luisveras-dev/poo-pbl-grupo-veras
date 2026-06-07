import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EventoTest {

    @Test
    public void naoDevePermitirInscricaoAlemDoLimite() {
        Evento evento = new Evento("Workshop de Java", 2);

        evento.adicionarInscricao();
        evento.adicionarInscricao();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            evento.adicionarInscricao();
        });

        assertEquals("Limite de vagas excedido para este evento.", exception.getMessage());
    }
}