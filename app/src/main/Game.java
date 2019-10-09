package com.example.loacalstoragetest;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Game {
    private boolean isSingles = false;
    private String teamONEplayerONE = "none";
    private String teamONEplayerTWO = "none";
    private String teamTWOplayerONE = "none";
    private String teamTWOplayerTWO = "none";
    private boolean isTeamONEserving = false;
    private int teamONEsets = 0;
    private int teamTWOsets = 0;
    private int teamONEscore = 0;
    private int teamTWOscore = 0;
    private int teamWon = 0;


    public Game() {}

    public Game(boolean isItSingles, String teamONEplayerONEname, String teamONEplayerTWOname, String teamTWOplayerONEname, String teamTWOplayerTWOname, boolean doesTeamONEserve) {
        isSingles = isItSingles;
        teamONEplayerONE = teamONEplayerONEname;
        teamONEplayerTWO = teamONEplayerTWOname;
        teamTWOplayerONE = teamTWOplayerONEname;
        teamTWOplayerTWO = teamTWOplayerTWOname;
        isTeamONEserving = doesTeamONEserve;
    }

    public Game(boolean isItSingles, String teamONEplayerONEname, String teamONEplayerTWOname, String teamTWOplayerONEname, String teamTWOplayerTWOname, boolean doesTeamONEserve, int teamONEsetsNum, int teamTWOsetsNum, int teamONEscoreNum, int teamTWOscoreNum) {
        isSingles = isItSingles;
        teamONEplayerONE = teamONEplayerONEname;
        teamONEplayerTWO = teamONEplayerTWOname;
        teamTWOplayerONE = teamTWOplayerONEname;
        teamTWOplayerTWO = teamTWOplayerTWOname;
        isTeamONEserving = doesTeamONEserve;
        teamONEsets = teamONEsetsNum;
        teamTWOsets = teamTWOsetsNum;
        teamONEscore = teamONEscoreNum;
        teamTWOscore =   teamTWOscoreNum;
    }

    public void addPoint(int team) {
        switch (team) {
            case 1:
                teamONEscore++;
                if (teamONEscore >= 6 && teamONEscore >= (teamTWOscore + 2)) {
                    teamONEscore = 0;
                    teamTWOscore = 0;
                    teamONEsets++;
                    if (teamONEsets == 2) {
                        teamWon = 1;
                    }
                }
                break;
            default:
                teamTWOscore++;
                if (teamTWOscore >= 6 && teamTWOscore >= (teamONEscore + 2)) {
                    teamONEscore = 0;
                    teamTWOscore = 0;
                    teamONEsets ++;
                    if (teamONEsets == 2) {
                        teamWon = 1;
                    }
                }
                break;
        }
    }

    public void setIsSingles(boolean isItSingles) {
        isSingles = isItSingles;
    }

    public void setTeamONEplayerONE(String teamONEplayerONEname) {
        teamONEplayerONE = teamONEplayerONEname;
    }

    public void setTeamONEplayerTWO(String teamONEplayerTWOname) {
        teamONEplayerTWO = teamONEplayerTWOname;
    }

    public void setTeamTWOplayerONE(String teamTWOplayerONEname) {
        teamTWOplayerONE = teamTWOplayerONEname;
    }

    public void setTeamTWOplayerTWO(String teamTWOplayerTWOname) {
        teamTWOplayerTWO = teamTWOplayerTWOname;
    }

    public void setIsTeamONEserving(boolean doesTeamONEserve) {
        isTeamONEserving = doesTeamONEserve;
    }

    public void setTeamONEsets(int teamONEsetsNum) {
        teamONEsets = teamONEsetsNum;
    }

    public void setTeamTWOsets(int teamTWOsetsNum) {
        teamTWOsets = teamTWOsetsNum;
    }

    public  void setTeamONEscore(int teamONEscoreNum) {
        teamONEscore = teamONEscoreNum;
    }

    public  void setTeamTWOscore(int teamTWOscoreNum) {
        teamTWOscore = teamTWOscoreNum;
    }

    public int getWinningTeam() {
        return teamWon;
    }

    public boolean getIsSingles() {
        return isSingles;
    }

    public String getTeamONEplayerONE() {
        return teamONEplayerONE;
    }

    public String getTeamONEplayerTWO() {
        return teamONEplayerTWO;
    }

    public String getTeamTWOplayerONE() {
        return teamTWOplayerONE;
    }

    public String getTeamTWOplayerTWO() {
        return teamTWOplayerTWO;
    }

    public boolean getIsTeamONEserving() {
        return isTeamONEserving;
    }

    public int getTeamONEsets() { return teamONEsets; }

    public int getTeamTWOsets() { return teamTWOsets; }

    public int getTeamONEscore() { return teamONEscore; }

    public int getTeamTWOscore() { return teamTWOscore; }
}