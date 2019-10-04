package com.example.loacalstoragetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences myPreferences;
    private SharedPreferences.Editor editor;
    private ArrayList<GameDate> tennisGames;

    private Game gameClass = new Game();

    private Spinner spHome;
    private String nmsHome[] = {"Bob", "Jane", "John", "Rose"};//{gameClass.getTeamONEplayerONE(), gameClass.getTeamONEplayerTWO(), gameClass.getTeamTWOplayerONE(), gameClass.getTeamTWOplayerTWO()};
    ArrayAdapter<String> adptHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor = myPreferences.edit();
        tennisGames = new ArrayList<GameDate>();
        logThisGame("today", true, "Bob", "Jane", "John", "Rose", false);
//        logThisGame("today", true, "Bob", "Jane", "John", "Rose", false);
//        logThisGame("today", true, "aaa", "sss", "ddd", "fff", false);
//        saveData();
//        retriveData();
//        for (int i = 0; i < tennisGames.size(); i++) {
//            Log.d("name " + i, " " + tennisGames.get(0).getGameTeamONEplayerONEname(i));
//        }
        spHome = (Spinner) findViewById(R.id.spHome);
        adptHome = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nmsHome);
        spHome.setAdapter(adptHome);

        spHome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, nmsHome[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void logThisGame(String day, boolean isItSingles, String teamONEplayerONEname, String teamONEplayerTWOname, String teamTWOplayerONEname, String teamTWOplayerTWOname, boolean doesTeamONEserve) {
        String today;
        if (day.equals("today")) {
            today = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        }
        else {
            today = day;
        }
        int indexFound = checkIfDateExists(today);
        if (indexFound != -1) {
            tennisGames.get(indexFound).newGame(isItSingles, teamONEplayerONEname, teamONEplayerTWOname, teamTWOplayerONEname, teamTWOplayerTWOname, doesTeamONEserve);
        }
        else {
            tennisGames.add(new GameDate(today));
            tennisGames.get((tennisGames.size() - 1)).newGame(isItSingles, teamONEplayerONEname, teamONEplayerTWOname, teamTWOplayerONEname, teamTWOplayerTWOname, doesTeamONEserve);
        }

        tennisGames.add(new GameDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date())));

    }

    private void updateThisGame(int GameDateIndex, int GameIndex, boolean isItSingles, String teamONEplayerONEname, String teamONEplayerTWOname, String teamTWOplayerONEname, String teamTWOplayerTWOname, boolean doesTeamONEserve, int teamONEsets, int teamTWOsets, int teamONEscore, int teamTWOscore) {
        tennisGames.get(GameDateIndex).changeGame(GameIndex, isItSingles, teamONEplayerONEname, teamONEplayerTWOname, teamTWOplayerONEname, teamTWOplayerTWOname, doesTeamONEserve, teamONEsets, teamTWOsets, teamONEscore, teamTWOscore);
    }

    private void saveData() {
        for (int i = 0; i < tennisGames.size(); i++) {
            editor.putString(Integer.toString(i), new Gson().toJson(tennisGames.get(i)));
        }
        editor.putInt("amountOfLoggedDates", tennisGames.size());
        editor.apply();
    }

    private void retriveData() {
        tennisGames = new ArrayList<GameDate>();
        for (int i = 0; i < myPreferences.getInt("amountOfLoggedDates", -1); i++) {
            tennisGames.add(new Gson().fromJson(myPreferences.getString(Integer.toString(i), "none"), GameDate.class));
        }
        //tennisGames.add(new Gson().fromJson(myPreferences.getString(Integer.toString(0), "none"), GameDate.class));
    }

    public int checkIfDateExists(String date) {
        for (int i = 0; i < tennisGames.size(); i++) {
            if (tennisGames.get(i).getDate().equals(date)) {
                return i;
            }
        }
        return -1;
    }
}
