package src;

import src.mvc.Controller;
import src.mvc.TableController;
import src.mvc.AddController;
import src.mvc.LeagueStatsModel;
import src.mvc.LeagueStats;

// Aplicação


public class App {
    public static void main(String[] args) {
        // Cria o modelo
        LeagueStatsModel model = new LeagueStats();
        
        // Popula com dados iniciais (opcional)
        model.populate();
        
        // Cria e exibe a tabela
        new TableController(model);
    }
}

