package infrastructure;

import domain.Evento;
import domain.EventoRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoRepositoryH2 implements EventoRepository {

    private final String url = "jdbc:h2:mem:eventosdb;DB_CLOSE_DELAY=-1";
    private final String user = "sa";
    private final String password = "";

    public EventoRepositoryH2() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "CREATE TABLE IF NOT EXISTS eventos (nome VARCHAR(255), limite_vagas INT)";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvar(Evento evento) {
        String sql = "INSERT INTO eventos (nome, limite_vagas) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, evento.getNome());
            stmt.setInt(2, evento.getLimiteVagas());
            stmt.executeUpdate();

            System.out.println("✅ Evento '" + evento.getNome() + "' salvo no banco de dados H2 com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}