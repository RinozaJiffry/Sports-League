package SportsLeague;

import java.util.Scanner;

public class Main {
    public void start() {

        Scanner sc = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("************************************WELCOME TO PREMIER LEAGUE************************************");
        System.out.println("=================================================================================================");
        System.out.println("                                   ****   Action Menu   ****   ");
        System.out.println("                                        Keys  : Actions     ");
        System.out.println("=================================================================================================");
        System.out.println("    ** Press 1 : Create a new football club");
        System.out.println("    ** Press 2 : Delete a football club");
        System.out.println("    ** Press 3 : Display the various statistics");
        System.out.println("    ** Press 4 : Display the premier league event table");
        System.out.println("    ** Press 5 : Update Score");
        System.out.println("    ** Press 6 : Set match");
        System.out.println("    ** Press 7 : Exit the system");
        System.out.println("    ** Press 8 : Save Data");
        System.out.println("    ** Press 9 : Show Saved Data");
        System.out.println("    ** Press 10 : GUI Table View for match ");
        System.out.println("=================================================================================================");
        System.out.println("=================================================================================================");
        System.out.print("      Please enter your choice : ");

        String choice;
        choice = sc.next();
        switch (choice) {
            case "1":
                addClub();
                break;
            case "2":
                deleteClub();
                break;
            case "3":
                DisplayStatistics();
                break;
            case "4":
                displayEventTable();
                break;
            case "5":
                updateScore();
                break;
            case "6":
                setMatchScore();
                break;
            case "7":
                exit();
                break;
            case "8":
                save();
                break;
            case "9":
                showSaveData();
                break;
            case "10":
                GuiTableView();
                break;
            default:
                System.out.println("    Please follow the instruction...Give 1-10                  as input!!!");
                start();
        }
    }


    private void addClub() {

        PremierLeagueManager club = new PremierLeagueManager();
        PremierLeagueManager uclub = new PremierLeagueManager();
        PremierLeagueManager sclub = new PremierLeagueManager();
        Scanner sc1 = new Scanner(System.in);
        FootballClub sports = new FootballClub("", "", "", 0, 0, 0, 0, 0, 0, 0);
        UniversityFootballClub sports1 = new UniversityFootballClub("", "", "", 0, 0, 0, 0, 0, 0, 0, "", 0, "", "");
        SchoolFootballClub sports2 = new SchoolFootballClub("", "", "", 0, 0, 0, 0, 0, 0, 0, "", 0, "", "");
        System.out.println("=================================================================================================");
        System.out.println("************************************ADDING NEW FOOTBALL CLUB*************************************");
        System.out.println("=================================================================================================");
        System.out.print("            * Club Name : ");
        String clubName = sc1.nextLine();
        System.out.print("            * Club location : ");
        String location = sc1.nextLine();
        System.out.print("            * Club Statistics (Active / Not Active) : ");
        String clubStatistics = sc1.nextLine();
        System.out.print("            * wins : ");
        int wins = sc1.nextInt();
        System.out.print("            * draws : ");
        int draws = sc1.nextInt();
        System.out.print("            * defeats : ");
        int defeats = sc1.nextInt();
        System.out.print("            * Number of Goals Recieved : ");
        int numberOfGoalsReceived = sc1.nextInt();
        System.out.print("            * Number of Goals Scored : ");
        int numberOfGoalsScored = sc1.nextInt();
        System.out.print("            * Number Of Current Points : ");
        int numberOfCurrentPoints = sc1.nextInt();
        System.out.print("            * Number of Match Played : ");
        int numberOfMatchPlayed = sc1.nextInt();

        System.out.println("=================================================================================================");
        System.out.println("            Types :  (UniversityFootball - UFB) : (SchoolFootball - SFB)");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.print("          Type : ");
        Scanner sc2 = new Scanner(System.in);
        String type = sc2.nextLine();


        club.addTheClub(sports, clubName, location, clubStatistics, wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored,
                numberOfCurrentPoints, numberOfMatchPlayed);
        if (type.equals("UFB")) {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("                          You Selected UNIVERSITY FOOTBALL Club");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.print("          * University Name  : ");
            String universityName = sc2.nextLine();
            System.out.print("          * University Club Captain  : ");
            String universityClubCaptain = sc2.nextLine();
            System.out.print("          * University Club Trainer : ");
            String universityClubTrainer = sc2  .nextLine();
            System.out.print("          * University Club No : ");
            int universityClubNo = sc2.nextInt();

            uclub.addTheClub(sports1, clubName, location, clubStatistics, wins, draws, defeats, numberOfGoalsReceived,
                    numberOfGoalsScored, numberOfCurrentPoints, numberOfMatchPlayed, universityName, universityClubNo,
                    universityClubCaptain, universityClubTrainer);
            start();
        } else if (type.equals("SFB")) {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("                             You Selected SCHOOL FOOTBALL Club");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.print("          * School Name : ");
            String schoolName = sc2.nextLine();
            System.out.print("          * School Club Captain : ");
            String schoolClubCaptain = sc2.nextLine();
            System.out.print("          * School Club Trainer : ");
            String schoolClubTrainer = sc2.nextLine();
            System.out.print("          * School Club No : ");
            int schoolClubNo = sc2.nextInt();

            sclub.addTheClub(sports2, clubName, location, clubStatistics, wins, draws, defeats, numberOfGoalsReceived,
                    numberOfGoalsScored, numberOfCurrentPoints, numberOfMatchPlayed, schoolName, schoolClubNo, schoolClubCaptain,
                    schoolClubTrainer);
            start();
        } else {
            System.out.println("            Wrong input!!! ");
            System.out.println("            Only input UFB or SFB ");
            club.addTheClub(sports, clubName, location, clubStatistics);
            start();
        }
    }



    private void deleteClub()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("***********************************DELETING NEW FOOTBALL CLUB************************************");
        System.out.println("=================================================================================================");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                                  **** List of the  clubs ****");
        PremierLeagueManager sports = new PremierLeagueManager();
        sports.showTheClubs();
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.print("                * Enter the club name to delete : ");
        String clubName = sc1.nextLine();
        PremierLeagueManager club = new PremierLeagueManager();
        boolean result = club.deleteClub(clubName);
        if (result == true) {
            System.out.println("            Successfully club deleted!!");
        } else {
            System.out.println("            Club not found on your server!! Sorrr Try again!!");
        }
        System.out.println("            Do you want to delete another club?");
        System.out.print("                * If yes type - Y - If no type - N - : ");
        String choice = sc1.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            deleteClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("            Invalid input!! Sorry");
        }
    }
    private void DisplayStatistics()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("***********************************DISPLAY STATISTICS OF CLUBS***********************************");
        System.out.println("=================================================================================================");
        System.out.println(" ");
        System.out.println("            * Active clubs : ");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        PremierLeagueManager sports = new PremierLeagueManager();
        sports.showTheClubs();
        System.out.print("            * Enter the club name to display Statistics :");
        String clubName = sc1.nextLine();
        sports.showTheClubs(clubName);

        System.out.println("            Do you want to show another club statistics? ");
        System.out.print("                * If yes type - Y - If no type - N - : ");
        String choice = sc1.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            DisplayStatistics();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("            Invalid input!! Sorry");
        }
        sc1.close();
    }

    private void displayEventTable()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("*************************************DISPLAY CLUB EVENT TABLE************************************");
        System.out.println("=================================================================================================");
        System.out.println(" ");
        System.out.println(" ");
        PremierLeagueManager sports = new PremierLeagueManager();
        sports.displayPremierLeague();
        System.out.println("            Do you want to display the table again ? ");
        System.out.print("                * If yes type - Y - If no type - N - : ");
        String choice = sc1.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            displayEventTable();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("            Invalid input!! Sorry");
        }
        sc1.close();
    }

    private void updateScore()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("***************************************UPDATING CLUB SCORES**************************************");
        System.out.println("=================================================================================================");
        System.out.println(" ");
        PremierLeagueManager club = new PremierLeagueManager();
        club.showTheClubs();
        System.out.print("          * Enter the Club Name : ");
        String clubName = sc1.nextLine();
        System.out.print("          * Enter the new score : ");
        int score = sc1.nextInt();
        club.updateScore(clubName, score);

        System.out.print("          Do you want to update another club score ? ");
        System.out.print("                * If yes type - Y - If no type - N - : ");
        System.out.print(sc1.nextLine());
        String choice = sc1.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            updateScore();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("            Invalid input!! Sorry");
        }
    }

    private void setMatchScore()
    {
        PremierLeagueManager match = new PremierLeagueManager();
        Match matchList = new Match("","",0,0,new Date("","",""));
        match.testcase();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("***************************************SETTING MATCH SCORES**************************************");
        System.out.println("=================================================================================================");
        System.out.println(" ");
        System.out.println("                                    *** Active clubs ***");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        PremierLeagueManager club = new PremierLeagueManager();
        club.showTheClubs();
        match.showMatch();
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=***=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.print("          Enter the first club Name : ");
        String team1 = sc1.nextLine();
        System.out.print("          Enter the second club Name : ");
        String team2 = sc1.nextLine();
        System.out.print("          Match day   : ");
        String day = sc1.nextLine();
        System.out.print("          Match month : ");
        String month = sc1.nextLine();
        System.out.print("          Match year  : ");
        String year = sc1.nextLine();
        Date matchDate = new Date(day, month, year);
        System.out.print("          Enter the first club goals : ");
        int team1Goals = sc1.nextInt();
        System.out.print("          Enter the second club goals : ");
        int team2Goals = sc1.nextInt();
        match.setMatch(matchList,team1,team2,team1Goals,team2Goals,matchDate);
        System.out.printf("Result : %s vs %s", team1, team2);
        System.out.print("  ");
        System.out.print(matchDate);
        System.out.println("");
        System.out.println("            Do you want to set another Match ? ");
        System.out.print("                * If yes type - Y - If no type - N - : ");
        System.out.print(sc1.nextLine());
        String choice = sc1.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            setMatchScore();
        } else if (choice.equalsIgnoreCase("N")) {
            start();

        } else {
            System.out.println("            Invalid input!! Sorry");
        }
    }

    private void exit()
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("=================================================================================================");
        System.out.println("******************************************EXIT THE SYSTEM****************************************");
        System.out.println("=================================================================================================");
        System.out.println("            Do you want to exit the system ? ");
        System.out.print("                * If yes type - Y - If no type - N - : ");
        String choice = sc1.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("            -------!!Program Successfully Stopped!!---------");
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("            Invalid input!! Sorry");
        }

        System.exit(0);
    }

    private void save()
    {
        PremierLeagueManager club = new PremierLeagueManager();
        club.save();
        start();
    }

    private void showSaveData()
    {
        PremierLeagueManager club = new PremierLeagueManager();
        club.showSaveData();
        start();
    }


    private void GuiTableView()
    {
        PremierLeagueManager club = new PremierLeagueManager();
        club.table();
        start();
    }



}
