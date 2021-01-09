package SportsLeague;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

import static SportsLeague.PremierLeagueManager.matchList;

public class ButtonAction extends Application
{
    Scene scene1;
    Scene scene2;
    Scene scene3;
    Scene scene4;

    private ArrayList<FootballClub> sports = new ArrayList<>();
    private ArrayList<Match> MatchList = new ArrayList<>();

    TableView<Object> tableView = new TableView<>();
    TableView<Object> tableView1 = new TableView<>();

    ObservableList<Object> object1 = FXCollections.observableArrayList();
    ObservableList<Object> object2 = FXCollections.observableArrayList();



    private void file1() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("PremierFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(sports);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readFile1() {
        try{
            FileInputStream readFileInputStream = new FileInputStream("Club Data.txt");
            ObjectInputStream readObjectInputStream = new ObjectInputStream(readFileInputStream);

            ArrayList<FootballClub> team1 = (ArrayList<FootballClub>) readObjectInputStream.readObject();
            readObjectInputStream.close();
            sports = team1;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void file2() {
        try {
            FileOutputStream fileStream = new FileOutputStream("DateFile.txt");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            objectStream.writeObject(MatchList);
            objectStream.flush();
            objectStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void readFile2(){
        try{
            FileInputStream fileRead = new FileInputStream("Date.txt");
            ObjectInputStream objectRead = new ObjectInputStream(fileRead);

            ArrayList<Match> Match1 = (ArrayList<Match>) objectRead.readObject();
            objectRead.close();
            MatchList = Match1;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
     //RANDOMLY GENERATING MATCH
        Label label1 = new Label("Generate matches randomly");
        label1.setLayoutX(100);
        label1.setLayoutY(25);
        label1.setStyle("-fx-font: normal bold 40px 'arial';-fx-alignment: center");
        label1.setTextFill(Color.DARKRED);

        Label label2 = new Label("** Enter the Match Day    : ");
        label2.setLayoutX(150);
        label2.setLayoutY(130);
        label2.setStyle("-fx-font: normal  18px 'serif' ");
        label2.setTextFill(Color.BLACK);

        Label label3 = new Label("** Enter the Match Month : ");
        label3.setLayoutX(150);
        label3.setLayoutY(180);
        label3.setStyle("-fx-font: normal  18px 'serif' ");
        label3.setTextFill(Color.BLACK);

        Label label4 = new Label("** Enter the Match Year   : ");
        label4.setLayoutX(150);
        label4.setLayoutY(230);
        label4.setStyle("-fx-font: normal  18px 'serif' ");
        label4.setTextFill(Color.BLACK);

        TextField textField5 = new TextField();
        textField5.setLayoutX(530);
        textField5.setLayoutY(125);
        textField5.setPrefWidth(110);
        textField5.setPrefHeight(30);

        TextField textField6 = new TextField();
        textField6.setLayoutX(530);
        textField6.setLayoutY(175);
        textField6.setPrefWidth(110);
        textField6.setPrefHeight(30);

        TextField textField1 = new TextField();
        textField1.setLayoutX(400);
        textField1.setLayoutY(125);
        textField1.setPrefWidth(110);
        textField1.setPrefHeight(30);

        TextField textField2 = new TextField();
        textField2.setLayoutX(400);
        textField2.setLayoutY(175);
        textField2.setPrefWidth(110);
        textField2.setPrefHeight(30);

        TextField textField3 = new TextField();
        textField3.setLayoutX(400);
        textField3.setLayoutY(225);
        textField3.setPrefWidth(110);
        textField3.setPrefHeight(30);

        Button showMatch = new Button("Back To Main Screen");
        showMatch.setLayoutX(420);
        showMatch.setLayoutY(360);
        showMatch.setPrefWidth(180);
        showMatch.setPrefHeight(35);
        showMatch.setOnAction(event -> primaryStage.setScene(scene1));

        Button randomMatch = new Button("Randomly Played Match");
        randomMatch.setLayoutX(420);
        randomMatch.setLayoutY(470);
        randomMatch.setPrefWidth(180);
        randomMatch.setPrefHeight(35);

        Image image1 = new Image(new FileInputStream("C:\\images\\match.jpg"));
        ImageView img3 = new ImageView();
        img3.setImage(image1);
        img3.setFitWidth(200);
        img3.setFitHeight(200);
        img3.setLayoutX(180);
        img3.setLayoutY(336);

        randomMatch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sports.size()<2){
                    System.out.println("Match is required for at least 2 clubs");
                    return;
                }
                Collections.shuffle(sports);
                Random random = new Random();
                Scanner sc = new Scanner(System.in);
                Match match = new Match("","",0,0,new Date("","",""));

                while (true){
                    try {

                        Date date = new Date(String.valueOf(textField1.getText()), String.valueOf(textField2.getText()), String.valueOf(textField3.getText()));

                        int i = 0;
                        int team1Goals = 0;
                        int team2Goals = 0;
                        String winner = null;
                        int count = 0;

                        for (FootballClub footballClub : sports) {
                            i++;
                            if (i == 1) {
                                String team1;
                                team1 = footballClub.getClubName();
                                match.setTeam1(team1);
                                team1Goals = random.nextInt(12);
                                match.setTeam1Goals(team1Goals);
                            } else if (i == 2) {
                                String team2;
                                team2 = footballClub.getClubName();
                                match.setTeam2(team2);
                                team2Goals = random.nextInt(12);
                                match.setTeam2Goals(team2Goals);
                                break;
                            }
                        }
                        Match match1 = new Match("", "", 0, 0, new Date("", "", ""));
                        matchList.add(match1);

                        if (team1Goals>team2Goals){
                            sports.get(0).setWins(sports.get(0).getWins()+1);
                            sports.get(0).setNumberOfGoalsReceived(sports.get(0).getNumberOfGoalsReceived()+team2Goals);
                            sports.get(0).setNumberOfGoalsScored(sports.get(0).getNumberOfGoalsReceived()+team1Goals);
                            sports.get(0).setNumberOfCurrentPoints(sports.get(0).getNumberOfCurrentPoints()+1);
                            sports.get(0).setNumberOfMatchPlayed(sports.get(0).getNumberOfMatchPlayed()+1);
                            winner = sports.get(0).getClubName();

                            sports.get(1).setDefeats(sports.get(1).getDefeats()+1);
                            sports.get(1).setNumberOfGoalsReceived(sports.get(1).getNumberOfGoalsReceived()+team1Goals);
                            sports.get(1).setNumberOfGoalsScored(sports.get(1).getNumberOfGoalsScored()+team2Goals);
                            sports.get(1).setNumberOfMatchPlayed(sports.get(1).getNumberOfMatchPlayed()+1);
                        }
                        else if (team2Goals>team1Goals){
                            sports.get(1).setWins(sports.get(1).getWins()+1);
                            sports.get(1).setNumberOfGoalsReceived(sports.get(1).getNumberOfGoalsReceived()+team1Goals);
                            sports.get(1).setNumberOfGoalsScored(sports.get(1).getNumberOfGoalsScored()+team2Goals);
                            sports.get(1).setNumberOfCurrentPoints(sports.get(1).getNumberOfCurrentPoints()+1);
                            sports.get(1).setNumberOfMatchPlayed(sports.get(1).getNumberOfMatchPlayed()+1);
                            winner = sports.get(1).getClubName();

                            sports.get(0).setDefeats(sports.get(0).getDefeats()+1);
                            sports.get(0).setNumberOfGoalsReceived(sports.get(0).getNumberOfGoalsReceived()+team2Goals);
                            sports.get(0).setNumberOfGoalsScored(sports.get(0).getNumberOfGoalsScored()+team1Goals);
                            sports.get(0).setNumberOfMatchPlayed(sports.get(0).getNumberOfMatchPlayed()+1);
                        }
                        else {
                            sports.get(0).setDraws(sports.get(0).getDraws()+1);
                            sports.get(0).setNumberOfGoalsReceived(sports.get(0).getNumberOfGoalsReceived()+team2Goals);
                            sports.get(0).setNumberOfGoalsScored(sports.get(0).getNumberOfGoalsScored()+team1Goals);
                            sports.get(0).setNumberOfMatchPlayed(sports.get(0).getNumberOfMatchPlayed()+1);

                            sports.get(1).setDraws(sports.get(1).getDraws()+1);
                            sports.get(1).setNumberOfGoalsReceived(sports.get(1).getNumberOfGoalsReceived()+team1Goals);
                            sports.get(1).setNumberOfGoalsScored(sports.get(1).getNumberOfGoalsScored()+team2Goals);
                            sports.get(1).setNumberOfMatchPlayed(sports.get(1).getNumberOfMatchPlayed()+1);
                            count++;
                        }
                        textField5.setText("    Final Results\n" + sports.get(0).getClubName() + " Vs " + sports.get(1).getClubName() +"\n Match Date : "+match.getMatchDate() +
                                "\nTeam 1 Goals : "+team1Goals + "\nTeam 2 Goals : "+team2Goals);

                        if (count==1){
                            textField6.setText("\n      Draw Match : ");
                        }
                        else {
                            textField6.setText("\n      Match Winner : "+winner);
                        }
                        sports.sort(FootballClub::compareTo);
                        file1();
                        readFile1();
                        for(int n=0; n<tableView.getItems().size(); n++){
                            tableView.getItems().clear();
                        }
                        object1.addAll(sports);
                        tableView.setItems(object1);
                        break;
                    }catch (InputMismatchException e){
                        System.out.println(" Enter an Integer : "+e);
                        sc.nextLine();
                    }
                }
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                file2();
            }
        });
        Pane root1 = new Pane(img3,label1,label2,textField1,label3,textField2,label4,textField3,textField5,textField6, showMatch, randomMatch);
        root1.setStyle("-fx-background-color:#0cedda;");
        scene2 = (new Scene(root1, 800, 600));
        primaryStage.setScene(scene2);

        TableView tableView = new TableView();

        TableColumn<FootballClub, String> column1 = new TableColumn<>("Club Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("clubName"));


        TableColumn<FootballClub, String> column2 = new TableColumn<>("Location");
        column2.setCellValueFactory(new PropertyValueFactory<>("location"));


        TableColumn<FootballClub, String> column3 = new TableColumn<>("Club Statistics");
        column3.setCellValueFactory(new PropertyValueFactory<>("clubStatistics"));

        TableColumn<FootballClub, String> column4 = new TableColumn<>("Wins");
        column4.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<FootballClub, String> column5 = new TableColumn<>("Draws");
        column5.setCellValueFactory(new PropertyValueFactory<>("draws"));

        TableColumn<FootballClub, String> column6 = new TableColumn<>("Defeats");
        column6.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        TableColumn<FootballClub, String> column7 = new TableColumn<>("Number of Goals Received");
        column7.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));

        TableColumn<FootballClub, String> column8 = new TableColumn<>("Number of Goals Scored");
        column8.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

        TableColumn<FootballClub, String> column9 = new TableColumn<>("Number of Current Points");
        column9.setCellValueFactory(new PropertyValueFactory<>("numberOfCurrentPoints"));

        TableColumn<FootballClub, String> column10 = new TableColumn<>("Number of Match Played");
        column10.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchPlayed"));

        tableView.setLayoutX(25);
        tableView.setLayoutY(25);
        tableView.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9,column10);
        tableView.getItems().addAll(PremierLeagueManager.sports);

        Button dateSearch = new Button("Sort By Points");
        dateSearch.setLayoutX(195);
        dateSearch.setLayoutY(435);
        dateSearch.setPrefWidth(325);
        dateSearch.setPrefHeight(30);
        dateSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column9.setSortType(TableColumn.SortType.DESCENDING);
                tableView.getSortOrder().addAll(column9);
            }
        });
        Button btn2 = new Button("Sort By Goals");
        btn2.setLayoutX(195);
        btn2.setLayoutY(485);
        btn2.setPrefWidth(325);
        btn2.setPrefHeight(30);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column8.setSortType(TableColumn.SortType.DESCENDING);
                tableView.getSortOrder().addAll(column8);
        }
        });

        Button btn3 = new Button("Sort By Wins");
        btn3.setLayoutX(195);
        btn3.setLayoutY(525);
        btn3.setPrefWidth(325);
        btn3.setPrefHeight(30);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column4.setSortType(TableColumn.SortType.DESCENDING);
                tableView.getSortOrder().addAll(column4);
            }
        });
        Button backbutton = new Button("Back");
        backbutton.setLayoutX(335);
        backbutton.setLayoutY(575);
        backbutton.setPrefWidth(80);
        backbutton.setPrefHeight(30);
        backbutton.setOnAction(event -> primaryStage.setScene(scene1));

        Image image = new Image(new FileInputStream("C:\\images\\win.jpg"));
        ImageView img2 = new ImageView();
        img2.setImage(image);
        img2.setFitWidth(200);
        img2.setFitHeight(200);
        img2.setLayoutX(800);
        img2.setLayoutY(445);

        Pane root2 = new Pane(tableView, dateSearch,btn2,btn3, backbutton,img2);
        root2.setStyle("-fx-background-color:#cc007e;");
        scene3 = (new Scene(root2, 1220, 660));
        primaryStage.setScene(scene3);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //SEARCH DATE

        TableView tableView1 = new TableView();

        TableColumn<Match, String> column11 = new TableColumn<>("Team 1");
        column11.setCellValueFactory(new PropertyValueFactory<>("team1"));


        TableColumn<Match, String> column22 = new TableColumn<>("Team 2");
        column22.setCellValueFactory(new PropertyValueFactory<>("team2"));


        TableColumn<Match, String> column33 = new TableColumn<>("Team 1 Goals");
        column33.setCellValueFactory(new PropertyValueFactory<>("team1Goals"));

        TableColumn<Match, String> column44 = new TableColumn<>("Team 2 Goals");
        column44.setCellValueFactory(new PropertyValueFactory<>("team2Goals"));

        TableColumn<Match, String> column55 = new TableColumn<>("Match Date");
        column55.setCellValueFactory(new PropertyValueFactory<>("matchDate"));

        tableView1.setLayoutX(50);
        tableView1.setLayoutY(25);
        tableView1.getColumns().addAll(column11,column22,column33,column44,column55);
        tableView1.getItems().addAll(PremierLeagueManager.matchList);

        TextField search = new TextField();
        search.setLayoutX(600);
        search.setLayoutY(25);

        TextField search1 = new TextField();
        search1.setLayoutX(600);
        search1.setLayoutY(75);

        TextField search2 = new TextField();
        search2.setLayoutX(600);
        search2.setLayoutY(125);

        Label labelDay = new Label("Day :");
        labelDay.setLayoutX(500);
        labelDay.setLayoutY(25);
        labelDay.setStyle("-fx-font: normal bold  18px 'serif' ");
        labelDay.setTextFill(Color.WHITE);

        Label labelMonth = new Label("Month :");
        labelMonth.setLayoutX(500);
        labelMonth.setLayoutY(75);
        labelMonth.setStyle("-fx-font: normal bold  18px 'serif' ");
        labelMonth.setTextFill(Color.WHITESMOKE);

        Label labelYear = new Label("Year :");
        labelYear.setLayoutX(500);
        labelYear.setLayoutY(125);
        labelYear.setStyle("-fx-font: normal bold  18px 'serif' ");
        labelYear.setTextFill(Color.WHITE);

        Image image2 = new Image(new FileInputStream("C:\\images\\look.jpg"));
        ImageView img4 = new ImageView();
        img4.setImage(image2);
        img4.setFitWidth(200);
        img4.setFitHeight(200);
        img4.setLayoutX(550);
        img4.setLayoutY(200);

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(530);
        backBtn.setLayoutY(440);
        backBtn.setPrefWidth(80);
        backBtn.setPrefHeight(30);
        backBtn.setOnAction(e -> primaryStage.setScene(scene1));

        Button clearBtn = new Button("Clear");
        clearBtn.setLayoutX(690);
        clearBtn.setLayoutY(440);
        clearBtn.setPrefWidth(80);
        clearBtn.setPrefHeight(30);

        clearBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int o=1; o<=2; o++){
                    for(int n=0; n<tableView1.getItems().size(); n++){
                        tableView1.getItems().clear();
                    }
                    object2.addAll(matchList);
                    tableView1.setItems(object2);
                    search.setText("");
                    search1.setText("");
                    search2.setText("");
                }
            }
        });
        Button searching = new Button("Search");
        searching.setLayoutX(570);
        searching.setLayoutY(500);
        searching.setPrefWidth(80);
        searching.setPrefHeight(30);

        searching.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Click");
                int a = 0;
                for (Match match:matchList){
                    if (match.getMatchDate().getDay() == String.valueOf(search.getText()) && match.getMatchDate().getMonth() == String.valueOf(search1.getText())) {
                        String.valueOf(search2.getText());
                    }
                    a++;
                }
                if (a!=-1){
                    Alert a4 = new Alert(Alert.AlertType.INFORMATION);
                    a4.setTitle("           Alert");
                    a4.setHeaderText("          Wrong Information !!!");
                    a4.setContentText("         Sorry No Datas on this Date");
                    a4.showAndWait();

                }
            }
        });





        Pane root3 = new Pane(img4,tableView1,backBtn,search,search1,search2,clearBtn, searching, labelDay, labelMonth, labelYear);
        root3.setStyle("-fx-background-color:#260087;");
        scene4 = (new Scene(root3, 900, 600));
        primaryStage.setScene(scene4);

        //HOMEPAGE

        Label lbF = new Label("Welcome to Premier League Manager 2020!!");
        lbF.setLayoutX(100);
        lbF.setLayoutY(30);
        lbF.setStyle("-fx-font: normal bold 40px 'serif';-fx-alignment: center");
        lbF.setTextFill(Color.web("#FFFFFF"));

        Image home_image = new Image(new FileInputStream("C:\\images\\League.png"));
        ImageView img1 = new ImageView();
        img1.setImage(home_image);
        img1.setFitWidth(300);
        img1.setFitHeight(300);
        img1.setLayoutX(120);
        img1.setLayoutY(100);

        showMatch = new Button();
        showMatch.setText("Show Match Table");
        showMatch.setLayoutX(600);
        showMatch.setLayoutY(100);
        showMatch.setPrefWidth(150);
        showMatch.setPrefHeight(30);

        showMatch.setOnAction(event -> primaryStage.setScene(scene3));

        randomMatch = new Button();
        randomMatch.setText("Random Match");
        randomMatch.setLayoutX(600);
        randomMatch.setLayoutY(180);
        randomMatch.setPrefWidth(150);
        randomMatch.setPrefHeight(30);

        randomMatch.setOnAction(event -> primaryStage.setScene(scene2));

        dateSearch = new Button();
        dateSearch.setText("Date Search");
        dateSearch.setLayoutX(600);
        dateSearch.setLayoutY(270);
        dateSearch.setPrefWidth(150);
        dateSearch.setPrefHeight(30);

        dateSearch.setOnAction(event -> primaryStage.setScene(scene4));

        searching = new Button();
        searching.setText("Exit");
        searching.setLayoutX(600);
        searching.setLayoutY(370);
        searching.setPrefWidth(150);
        searching.setPrefHeight(30);

        searching.setOnAction(event -> primaryStage.close());

        Pane root4 = new Pane();
        root4.setStyle("-fx-background-color:purple;");
        root4.getChildren().addAll(lbF,img1,showMatch,randomMatch,dateSearch, searching);
        scene1 = (new Scene(root4, 900, 500));
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main (String[]args){
        launch(args);
    }
}

