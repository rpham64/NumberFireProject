package com.rpham64.android.numberfireproject.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class PlayerStat {

    public final int id;

    @SerializedName("game_id")
    public final int gameId;

    @SerializedName("player_id")
    public final int playerId;

    @SerializedName("team_id")
    public final int teamId;

    public final int points;

    public final int assists;

    public final int rebounds;

    public final int nerd;

    public PlayerStat(int id, int gameId, int playerId, int teamId, int points, int assists, int rebounds, int nerd) {
        this.id = id;
        this.gameId = gameId;
        this.playerId = playerId;
        this.teamId = teamId;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.nerd = nerd;
    }
}
