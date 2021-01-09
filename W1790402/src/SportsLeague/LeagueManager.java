package SportsLeague;

public interface LeagueManager
{
    public void addTheClub(FootballClub club, String clubName,
                           String location, String clubStatistics, int wins, int draws, int defeats,
                           int numberOfGoalsReceived, int numberOfGoalsScored,
                           int numberOfCurrentPoints, int numberOfMatchPlayed);

    public void addTheClub(UniversityFootballClub uclub, String clubName,
                           String location, String clubStatistics, int wins, int draws, int defeats,
                           int numberOfGoalsReceived, int numberOfGoalsScored,
                           int numberOfCurrentPoints, int numberOfMatchPlayed, String universityName, int universityClubNo,
                           String universityClubCaptain, String universityClubTrainer);

    public void addTheClub( SchoolFootballClub sclub, String clubName,
                            String location, String clubStatistics, int wins, int draws, int defeats,
                            int numberOfGoalsReceived, int numberOfGoalsScored,
                            int numberOfCurrentPoints, int numberOfMatchPlayed, String schoolName, int schoolClubNo,
                            String schoolClubCaptain, String schoolClubTrainer);

    public boolean deleteClub(String clubName);

    public void addTheClub(FootballClub club, String clubName, String location, String clubStatistics);

    public void showTheClubs();

    public void showTheClubs(String clubName);

    public void displayPremierLeague();

    public void updateScore(String clubName, int score);

    public void save();

    public void showSaveData();

    public void table();

    public void setMatch(Match match,String team1, String team2, int team1Goals, int team2Goals, Date matchDate);

    public void showMatch();




}
