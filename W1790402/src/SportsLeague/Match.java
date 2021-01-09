package SportsLeague;

public class Match
{
    private String team1;
    private String team2;
    private int team1Goals;
    private int team2Goals;
    private Date matchDate;

    public Match(String team1, String team2, int team1Goals, int team2Goals, Date matchDate) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.matchDate = matchDate;
    }

    //getters
    public String getTeam1() {
        return team1;
    }
    public String getTeam2() {
        return team2;
    }
    public int getTeam1Goals() {
        return team1Goals;
    }
    public int getTeam2Goals() {
        return team2Goals;
    }
    public Date getMatchDate() { return matchDate; }

    //setters
    public void setTeam1(String team1) {
        this.team1 = team1;
    }
    public void setTeam2(String team2) {
        this.team2 = team2;
    }
    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }
    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }
    public void setMatchDate(Date matchDate) { this.matchDate = matchDate; }


}

