package src.mvc;

public class TableController implements Controller {
    
    private View view;
    private LeagueStatsModel model;

    public TableController(LeagueStatsModel theModel) {
        model = theModel;
        view = new TableView(this, theModel);
        view.show();
    }
}