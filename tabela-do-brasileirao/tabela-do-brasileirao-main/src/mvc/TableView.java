package src.mvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class TableView extends View implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;

    public TableView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    @Override
    public void createView() {
        frame = new JFrame("Tabela do Brasileirão");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Cabeçalho da tabela
        String[] columnNames = {
            "Posição", "Time", "Pontos", "Jogos", 
            "Vitórias", "Empates", "Derrotas", 
            "Gols Pró", "Gols Contra", "Saldo"
        };

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        
        // Impede edição da tabela
        table.setDefaultEditor(Object.class, null);
        
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton updateButton = new JButton("Atualizar Tabela");
        updateButton.addActionListener(this);
        btnPanel.add(updateButton);

        JButton addResultButton = new JButton("Adicionar Resultado");
        addResultButton.addActionListener(e -> new AddController(model));
        btnPanel.add(addResultButton);

        frame.add(btnPanel, BorderLayout.SOUTH);

        // Carrega os dados iniciais
        updateTable();
    }

    private void updateTable() {
        // Limpa a tabela
        tableModel.setRowCount(0);
        
        // Obtém os dados do modelo
        Collection<TeamStats> teamsStats = model.getResults();
        
        // Adiciona os dados à tabela
        int position = 1;
        for (TeamStats stats : teamsStats) {
            tableModel.addRow(new Object[]{
                position++,
                stats.getName(),
                stats.getScore(),
                stats.getNumberOfMatches(),
                stats.getNumberOfWins(),
                stats.getNumberOfDraws(),
                stats.getNumberOfLosses(),
                stats.getGoalsFor(),
                stats.getGoalsAgainst(),
                stats.getGoalsDifference()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTable();
    }
}