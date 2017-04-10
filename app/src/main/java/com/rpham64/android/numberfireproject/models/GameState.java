package com.rpham64.android.numberfireproject.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class GameState {

    public static final String STATUS_IN_PROGRESS = "IN_PROGRESS";
    public static final String STATUS_FINAL = "FINAL";

    public final int id;

    @SerializedName("game_id")
    public final int gameId;

    @SerializedName("home_team_score")
    public final int homeTeamScore;

    @SerializedName("away_team_score")
    public final int awayTeamScore;

    public final String broadcast;

    public final int quarter;

    @SerializedName("time_left_in_quarter")
    public final String timeLeft;

    @SerializedName("game_status")
    public final String status;

    public GameState(int id, int gameId, int homeTeamScore, int awayTeamScore, String broadcast, int quarter, String timeLeft, String status) {
        this.id = id;
        this.gameId = gameId;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.broadcast = broadcast;
        this.quarter = quarter;
        this.timeLeft = timeLeft;
        this.status = status;
    }
}
