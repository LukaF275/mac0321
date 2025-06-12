package src.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddView extends View implements ActionListener {

    private JComboBox<String> homeTeamCombo;
    private JTextField homeGoalsField;
    private JComboBox<String> visitorTeamCombo;
    private JTextField visitorGoalsField;

    public AddView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    @Override
    public void createView() {
        frame = new JFrame("Adicionar Resultado");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Time mandante
        inputPanel.add(new JLabel("Time Mandante:"));
        homeTeamCombo = new JComboBox<>(getTeamAbbreviations());
        inputPanel.add(homeTeamCombo);

        // Gols mandante
        inputPanel.add(new JLabel("Gols Mandante:"));
        homeGoalsField = new JTextField(2);
        inputPanel.add(homeGoalsField);

        // Time visitante
        inputPanel.add(new JLabel("Time Visitante:"));
        visitorTeamCombo = new JComboBox<>(getTeamAbbreviations());
        inputPanel.add(visitorTeamCombo);

        // Gols visitante
        inputPanel.add(new JLabel("Gols Visitante:"));
        visitorGoalsField = new JTextField(2);
        inputPanel.add(visitorGoalsField);

        frame.add(inputPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton addButton = new JButton("Adicionar Resultado");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> frame.dispose());
        buttonPanel.add(cancelButton);   

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private String[] getTeamAbbreviations() {
        return new String[]{
            "SAO", "BOT", "ATH", "SAN", "CRU", "FOR", "COR", "PAL",
            "BAH", "FLU", "ATL", "AME", "CUI", "CUR", "INT", "VAS",
            "GOI", "RED", "FLA", "GRE"
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String homeTeam = (String) homeTeamCombo.getSelectedItem();
            int homeGoals = Integer.parseInt(homeGoalsField.getText());
            String visitorTeam = (String) visitorTeamCombo.getSelectedItem();
            int visitorGoals = Integer.parseInt(visitorGoalsField.getText());

            if (homeTeam.equals(visitorTeam)) {
                JOptionPane.showMessageDialog(frame, "Um time não pode jogar contra si mesmo!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (homeGoals < 0 || visitorGoals < 0) {
                JOptionPane.showMessageDialog(frame, "Número de gols não pode ser negativo!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Chama o controller para adicionar o resultado
            ((AddController)controller).addMatchResult(homeTeam, homeGoals, visitorTeam, visitorGoals);
            
            JOptionPane.showMessageDialog(frame, "Resultado adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos para os gols!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        homeGoalsField.setText("");
        visitorGoalsField.setText("");
    }
}