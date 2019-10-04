package com.example.loacalstoragetest;

import java.util.ArrayList;

public class GameDate {
    private ArrayList<Game> tennisMatches = new ArrayList<Game>();
    String currentDate;
    public GameDate() {}

    public GameDate(String date) {
        currentDate = date;
    }

    public void newGame(boolean isItSingles, String teamONEplayerONEname, String teamONEplayerTWOname, String teamTWOplayerONEname, String teamTWOplayerTWOname, boolean doesTeamONEserve) {
        tennisMatches.add(new Game(isItSingles, teamONEplayerONEname, teamONEplayerTWOname, teamTWOplayerONEname, teamTWOplayerTWOname, doesTeamONEserve));
    }

    public void changeGame(int index, boolean isItSingles, String teamONEplayerONEname, String teamONEplayerTWOname, String teamTWOplayerONEname, String teamTWOplayerTWOname, boolean doesTeamONEserve, int teamONEsets, int teamTWOsets, int teamONEscore, int teamTWOscore) {
        tennisMatches.set(index, new Game(isItSingles, teamONEplayerONEname, teamONEplayerTWOname, teamTWOplayerONEname, teamTWOplayerTWOname, doesTeamONEserve, teamONEsets, teamTWOsets, teamONEscore, teamTWOscore));
    }

    public void addGameSets(int index, int team) {
        tennisMatches.get(index).addSet(team);
    }

    public void addGameScore(int index, int team) {
        tennisMatches.get(index).addPoint(team);
    }

    public void setGameIsSingles(int index, boolean isItSingles) {
        tennisMatches.get(index).setIsSingles(isItSingles);
    }

    public void setGameTeamONEplayerONEname(int index, String teamONEplayerONE) {
        tennisMatches.get(index).setTeamONEplayerONE(teamONEplayerONE);
    }

    public void setGameTeamONEplayerTWOname(int index, String teamONEplayerTWO) {
        tennisMatches.get(index).setTeamONEplayerONE(teamONEplayerTWO);
    }

    public void setGameTeamTWOplayerONEname(int index, String teamTWOplayerONE) {
        tennisMatches.get(index).setTeamONEplayerONE(teamTWOplayerONE);
    }

    public void setGameTeamTWOplayerTWOname(int index, String teamONEplayerTWO) {
        tennisMatches.get(index).setTeamONEplayerONE(teamONEplayerTWO);
    }

    public void setGameTeamONEsets(int index, int amount) {
        tennisMatches.get(index).setTeamONEsets(amount);
    }

    public void setGameTeamTWOsets(int index, int amount) {
        tennisMatches.get(index).setTeamTWOsets(amount);
    }

    public void setGameTeamONEscore(int index, int amount) {
        tennisMatches.get(index).setTeamONEscore(amount);
    }

    public void setGameTeamTWOscore(int index, int amount) {
        tennisMatches.get(index).setTeamTWOscore(amount);
    }

    public Game getGame(int index) {
        return tennisMatches.get(index);
    }

    public String getDate() {
        return currentDate;
    }

    public int getGameWinningTeam(int index) {
        return tennisMatches.get(index).getWinningTeam();
    }

    public boolean getGameIsSingles(int index) {
        return tennisMatches.get(index).getIsSingles();
    }

    public String getGameTeamONEplayerONEname(int index) {
        return tennisMatches.get(index).getTeamONEplayerONE();
    }

    public String getGameTeamONEplayerTWOname(int index) {
        return tennisMatches.get(index).getTeamONEplayerTWO();
    }

    public String getGameTeamTWOplayerONEname(int index) {
        return tennisMatches.get(index).getTeamTWOplayerONE();
    }

    public String getGameTeamTWOplayerTWOname(int index) {
        return tennisMatches.get(index).getTeamTWOplayerTWO();
    }

    public boolean getGameIsTeamONEserving(int index) {
        return tennisMatches.get(index).getIsTeamONEserving();
    }

    public int getGameTeamONEsets(int index) {
        return tennisMatches.get(index).getTeamONEsets();
    }

    public int getGameTeamTWOsets(int index) {
        return tennisMatches.get(index).getTeamTWOsets();
    }

    public int getGameTeamONEscore(int index) {
        return tennisMatches.get(index).getTeamONEscore();
    }

    public int getGameTeamTWOscore(int index) {
        return tennisMatches.get(index).getTeamTWOscore();
    }
}
