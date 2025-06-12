package src.mvc;

public class AddController implements Controller {
    
    private View view;
    private LeagueStatsModel model;

    public AddController(LeagueStatsModel theModel) {
        model = theModel;
        view = new AddView(this, theModel);
        view.show();
    }

    public void addMatchResult(String homeTeam, int homeGoals, String visitorTeam, int visitorGoals) {
        model.addResult(homeTeam, homeGoals, visitorTeam, visitorGoals);
    }
}