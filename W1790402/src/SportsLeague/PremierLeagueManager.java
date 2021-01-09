package SportsLeague;

import java.io.*;
import java.util.ArrayList;

import java.util.List;


public class PremierLeagueManager implements LeagueManager {
    static List<FootballClub> sports = new ArrayList<FootballClub>();
    static List<UniversityFootballClub> sports1 = new ArrayList<UniversityFootballClub>();
    static List<SchoolFootballClub> sports2 = new ArrayList<SchoolFootballClub>();
    static List<Match> matchList = new ArrayList<Match>();

    public static List<FootballClub> getList() {
        return sports;
    }

    public static List<Match> getMatchList() {
        return matchList;
    }


    @Override
    public void addTheClub(FootballClub club, String clubName, String location, String clubStatistics, int wins, int draws,
                           int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfCurrentPoints,
                           int numberOfMatchPlayed) {
        club = new FootballClub(clubName, location, clubStatistics, wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored,
                numberOfCurrentPoints, numberOfMatchPlayed);

        sports.add(club);
    }


    @Override
    public void addTheClub(UniversityFootballClub uclub, String clubName, String location, String clubStatistics, int wins,
                           int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored,
                           int numberOfCurrentPoints, int numberOfMatchPlayed, String universityName, int universityClubNo,
                           String universityClubCaptain, String universityClubTrainer) {
        uclub = new UniversityFootballClub(clubName, location, clubStatistics, wins, draws, defeats, numberOfGoalsReceived,
                numberOfGoalsScored, numberOfCurrentPoints, numberOfMatchPlayed, universityName, universityClubNo,
                universityClubCaptain, universityClubTrainer);

        sports1.add(uclub);
    }

    @Override
    public void addTheClub(SchoolFootballClub sclub, String clubName, String location,
                           String clubStatistics, int wins, int draws, int defeats, int numberOfGoalsReceived,
                           int numberOfGoalsScored, int numberOfCurrentPoints, int numberOfMatchPlayed, String schoolName,
                           int schoolClubNo, String schoolClubCaptain, String schoolClubTrainer) {
        sclub = new SchoolFootballClub(clubName, location, clubStatistics, wins, draws, defeats, numberOfGoalsReceived,
                numberOfGoalsScored, numberOfCurrentPoints, numberOfMatchPlayed, schoolName, schoolClubNo, schoolClubCaptain,
                schoolClubTrainer);

        sports2.add(sclub);
    }

    @Override
    public boolean deleteClub(String clubName) {
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).getClubName().equals(clubName)) {
                sports.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void addTheClub(FootballClub club, String clubName, String location, String clubStatistics) {

    }

    @Override
    public void showTheClubs() {
        for (int i = 0; i < sports.size(); i++) {
            System.out.print(sports.get(i).getClubName() + " | ");
        }
        System.out.println("");
    }

    @Override
    public void showTheClubs(String clubName) {
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).getClubName().equals(clubName)) {
                FootballClub index = sports.get(i);
                DisplayDetails send = new DisplayDetails();
                send.displayDetails(index);
            } else {
                System.out.println("            Invalid input!! Sorry");
            }
        }
    }

    @Override
    public void displayPremierLeague() {
        DisplayDetails send = new DisplayDetails();
        send.displayPremierLeagueTable(sports);
    }

    @Override
    public void updateScore(String clubName, int score) {
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).getClubName().equals(clubName)) {
                FootballClub index = sports.get(i);
                System.out.println("          Number of goals Scored : " + index.getNumberOfGoalsScored());
                int currentGoals = index.getNumberOfGoalsScored();
                index.setNumberOfGoalsScored(currentGoals += score);
                System.out.println("            Updated number of goals scored : " + index.getNumberOfGoalsScored());

            }
        }
    }

    @Override
    public void save() {
        File file = new File("MyFile.txt");
        BufferedWriter buffer = null;
        try {
            buffer = new BufferedWriter(new FileWriter(file));
            for (FootballClub sports : getList()) {
                buffer.write(sports.getClubName() + "  ,  " + sports.getLocation() + "  ,  "
                        + sports.getClubStatistics() + "  ,  " + sports.getWins() + "  ,  " + sports.getDraws()
                        + "  ,  " + sports.getDefeats() + "  ,  " + sports.getNumberOfGoalsReceived() + "  ,  "
                        + sports.getNumberOfGoalsScored() + "  ,  " + sports.getNumberOfCurrentPoints() + "  ,  "
                        + sports.getNumberOfMatchPlayed() + "\n");
            }
            buffer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                System.out.println("            All updates successfully saved to MyFile.txt ");
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void showSaveData() {
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader("MyFile.txt"));
            String sports;

            while ((sports = buffer.readLine()) != null) {
                System.out.println(sports);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            buffer.close();
        } catch (IOException e) {
            System.out.println("            Sorry!! Some problems found.");
            e.printStackTrace();
        }

    }

    @Override
    public void table() {
        ButtonAction.main(null);
    }

    @Override
    public void setMatch(Match match, String team1, String team2, int team1Goals, int team2Goals, Date matchDate) {
        match = new Match(team1, team2, team1Goals, team2Goals, matchDate);
        matchList.add(match);
    }

    @Override
    public void showMatch() {
        for (int i = 0; i < matchList.size(); i++) {
            System.out.print(matchList.get(i).getTeam1() + "Vs" + matchList.get(i).getTeam2() + " | ");
        }
        System.out.println("");
    }



    public void testcase() {
        Match testMatch = new Match("Rayons", "Demons", 10, 20, new Date("03", "09", "20202"));
        Match testMatch1 = new Match("Everton", "LiverPool", 15, 12, new Date("05", "10", "2020"));
        Match testMatch2 = new Match("Arsenal", "Chelsea", 34, 42, new Date("30", "10", "2020"));
        Match testMatch3 = new Match("BlackBurn", "Sunderland", 52, 26, new Date("15", "11", "2020"));
        Match testMatch4 = new Match("SouthEnd", "Portsmouth", 45, 54, new Date("14", "12", "2020"));
        this.matchList.add(testMatch);
        this.matchList.add(testMatch1);
        this.matchList.add(testMatch2);
        this.matchList.add(testMatch3);
        this.matchList.add(testMatch4);
    }

    public void testcase1()
    {
        FootballClub test = new FootballClub("Aztecs","America","Active",82,4,3,72,81,288,89);
        FootballClub test1 = new FootballClub("Goodison","England","Active",91,2,2,82,79,435,95);
        FootballClub test3 = new FootballClub("Barcilona","Sentyago","Not Active",98,4,2,77,87,561,104);
        sports.add(test);
        sports.add(test1);
        sports.add(test3);
    }


}

