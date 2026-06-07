import domain.Periodo;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PeriodoTest {

    @Test
    public void naoDevePermitirDataFimAnteriorADataInicio() {
        LocalDate inicio = LocalDate.of(2026, 7, 20);
        LocalDate fim = LocalDate.of(2026, 7, 10); // 10 dias antes do início!

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Periodo(inicio, fim);
        });

        assertEquals("A data de fim não pode ser anterior à data de início.", exception.getMessage());
    }
}