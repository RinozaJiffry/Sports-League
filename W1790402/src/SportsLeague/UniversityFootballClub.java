package SportsLeague;

public class UniversityFootballClub extends SportsClub
{
    private String universityName;
    private int universityClubNo;
    private String universityClubCaptain;
    private String universityClubTrainer;

    public UniversityFootballClub(String clubName, String location, String clubStatistics, int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfCurrentPoints, int numberOfMatchPlayed, String universityName,
                                  int universityClubNo, String clubCaptain, String universityClubCaptain)
    {
        super(clubName, location, clubStatistics);
        this.universityName = universityName;
        this.universityClubNo = universityClubNo;
        this.universityClubCaptain = universityClubCaptain;
        this.universityClubTrainer = universityClubTrainer;
    }



    //getters
    public String getUniversityName() { return universityName; }
    public int getUniversityClubNo() { return universityClubNo; }
    public String getUniversityClubCaptain() { return universityClubCaptain; }
    public String getUniversityClubTrainer() { return universityClubTrainer; }

    //setters
    public void setUniversityName(String universityName) { this.universityName = universityName; }
    public void setUniversityClubNo(int universityClubNo) { this.universityClubNo = universityClubNo; }
    public void setUniversityClubCaptain(String universityClubCaptain) { this.universityClubCaptain = universityClubCaptain; }
    public void setUniversityClubTrainer(String universityClubTrainer) { this.universityClubTrainer = universityClubTrainer; }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "universityName = '" + universityName + '\'' +
                ", universityClubNo = " + universityClubNo +
                ", universityClubCaptain = '" + universityClubCaptain + '\'' +
                ", universityClubTrainer = '" + universityClubTrainer + '\'' +
                '}';
    }
}


