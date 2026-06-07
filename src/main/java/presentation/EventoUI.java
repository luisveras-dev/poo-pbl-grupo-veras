package presentation;

import domain.Evento;
import infrastructure.EventoRepositoryH2;

import javax.swing.*;
import java.awt.*;

public class EventoUI {
    public static void main(String[] args) {
        EventoRepositoryH2 repository = new EventoRepositoryH2();

        JFrame frame = new JFrame("Gestão de Eventos Acadêmicos");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblNome = new JLabel("  Nome do Evento:");
        JTextField txtNome = new JTextField();

        JLabel lblLimite = new JLabel("  Limite de Vagas:");
        JTextField txtLimite = new JTextField();

        JButton btnSalvar = new JButton("Salvar Evento");

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                int limite = Integer.parseInt(txtLimite.getText());

                Evento evento = new Evento(nome, limite);

                repository.salvar(evento);

                JOptionPane.showMessageDialog(frame, "Evento '" + nome + "' salvo com sucesso no Banco H2!");

                txtNome.setText("");
                txtLimite.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "O limite de vagas deve ser um número válido.", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(lblNome);
        frame.add(txtNome);
        frame.add(lblLimite);
        frame.add(txtLimite);
        frame.add(new JLabel("")); // Espaço vazio para alinhar o botão à direita
        frame.add(btnSalvar);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}