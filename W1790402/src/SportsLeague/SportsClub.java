package SportsLeague;

public class SportsClub
{
    private String clubName;
    private String location;
    private String clubStatistics;

    public SportsClub(String clubName, String location, String clubStatistics)
    {
        super();
        this.clubName = clubName;
        this.location = location;
        this.clubStatistics = clubStatistics;
    }


    //getters
    public String getClubName() { return clubName; }
    public String getLocation() { return location; }
    public String getClubStatistics() { return clubStatistics; }

    //setters
    public void setClubName(String clubName) { this.clubName = clubName; }
    public void setLocation(String location) { this.location = location; }
    public void setClubStatistics(String clubStatistics) { this.clubStatistics = clubStatistics; }


}

