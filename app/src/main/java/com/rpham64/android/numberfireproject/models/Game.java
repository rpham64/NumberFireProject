package com.rpham64.android.numberfireproject.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class Game {

    public final int id;

    @SerializedName("home_team_id")
    public final int homeTeamId;

    @SerializedName("away_team_id")
    public final int awayTeamId;

    public final String date;

    public Game(int id, int homeTeamId, int awayTeamId, String date) {
        this.id = id;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.date = date;
    }
}
