package SportsLeague;

import java.util.List;

public class DisplayDetails extends PremierLeagueManager{
    public void displayDetails(FootballClub index){
        testcase1();
        System.out.println("| Wins | Draws | Defeats | Goals Received | Goals Scored | Points | Matched Played |");
        System.out.println("|      |       |         |                |              |        |                |");
        System.out.println("| "+index.getWins()+"   | "+index.getDraws()+"     | "+index.getDefeats()+"  "
                + "     | "+index.getNumberOfGoalsReceived()+"             | "+index.getNumberOfGoalsScored()+"  "
                + "         | "+index.getNumberOfCurrentPoints()+"    | "+index.getNumberOfMatchPlayed()+"           |");
        System.out.println("|      |       |         |                |              |        |                |");
    }
    public void displayPremierLeagueTable(List<FootballClub> sports){

        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Club Name       |Points|%n");
        System.out.format("+-----------------+------+%n");
        for (int i= 0; i < sports.size(); i++) {
            System.out.format(leftAlignFormat,  sports.get(i).getClubName(), sports.get(i).getNumberOfCurrentPoints());
        }
        System.out.format("+-----------------+------+%n");
    }
}
