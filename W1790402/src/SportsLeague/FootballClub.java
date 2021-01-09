package SportsLeague;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FootballClub extends SportsClub implements Serializable {
    private int wins;
    private int draws;
    private int defeats;
    private int numberOfGoalsReceived;
    private int numberOfGoalsScored;
    private int numberOfCurrentPoints;
    private int numberOfMatchPlayed;

    public FootballClub(String clubName, String location, String clubStatistics, int wins, int draws,
                        int defeats, int numberOfGoalsReceived, int numberOfGoalsScored,
                        int numberOfCurrentPoints, int numberOfMatchPlayed) {
        super(clubName, clubStatistics, location);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfCurrentPoints = numberOfCurrentPoints;
        this.numberOfMatchPlayed = numberOfMatchPlayed;
    }


    //getters
    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public int getNumberOfCurrentPoints() {
        return numberOfCurrentPoints;
    }

    public int getNumberOfMatchPlayed() {
        return numberOfMatchPlayed;
    }

    //setters
    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public void setNumberOfCurrentPoints(int numberOfCurrentPoints) {
        this.numberOfCurrentPoints = numberOfCurrentPoints;
    }

    public void setNumberOfMatchPlayed(int numberOfMatchPlayed) {
        this.numberOfMatchPlayed = numberOfMatchPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "wins = " + wins +
                ", draws = " + draws +
                ", defeats = " + defeats +
                ", numberOfGoalsReceived = " + numberOfGoalsReceived +
                ", numberOfGoalsScored = " + numberOfGoalsScored +
                ", numberOfCurrentPoints = " + numberOfCurrentPoints +
                ", numberOfMatchPlayed = " + numberOfMatchPlayed +
                '}';
    }

    public static class ClubComparator implements Comparator<FootballClub> {

        @Override
        public int compare(FootballClub obj1, FootballClub obj2) {
            return Integer.compare(obj1.numberOfCurrentPoints, obj2.numberOfCurrentPoints);
        }
    }

    void setArray(ArrayList<FootballClub> sports){
        for (FootballClub points : sports) {
            System.out.println(points.getNumberOfCurrentPoints());
        }
        Collections.sort(sports, new ClubComparator());
        for (FootballClub points : sports) {
            System.out.println(points.getNumberOfCurrentPoints());
        }
    }
    public int compareTo(FootballClub r) {
        return this.getClubName().compareTo(r.getClubName());
    }
}












