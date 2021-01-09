package SportsLeague;

public class SchoolFootballClub extends SportsClub
{
    private String schoolName;
    private int schoolClubNo;
    private String schoolClubCaptain;
    private String schoolClubTrainer;

    public SchoolFootballClub(String clubName, String location, String clubStatistics, int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfMatchPlayed, int numberOfCurrentPoints, String schoolName,
                              int schoolClubNo, String schoolClubCaptain, String schoolClubTrainer)
    {
        super(clubName, location, clubStatistics);
        this.schoolName = schoolName;
        this.schoolClubNo = schoolClubNo;
        this.schoolClubCaptain = schoolClubCaptain;
        this.schoolClubTrainer = schoolClubTrainer;
    }


    //getters
    public String getSchoolName() { return schoolName; }
    public int getSchoolClubNo() { return schoolClubNo; }
    public String getSchoolClubCaptain() { return schoolClubCaptain; }
    public String getSchoolClubTrainer() { return schoolClubTrainer; }


    //setters
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }
    public void setSchoolClubNo(int schoolClubNo) { this.schoolClubNo = schoolClubNo; }
    public void setSchoolClubCaptain(String schoolClubCaptain) { this.schoolClubCaptain = schoolClubCaptain; }
    public void setSchoolClubTrainer(String schoolClubTrainer) { this.schoolClubTrainer = schoolClubTrainer; }

    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "schoolName = '" + schoolName + '\'' +
                ", schoolClubNo = " + schoolClubNo +
                ", schoolClubCaptain = '" + schoolClubCaptain + '\'' +
                ", schoolClubTrainer = '" + schoolClubTrainer + '\'' +
                '}';
    }
}
