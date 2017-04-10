package com.rpham64.android.numberfireproject.network;

import com.google.gson.annotations.SerializedName;
import com.rpham64.android.numberfireproject.models.Game;
import com.rpham64.android.numberfireproject.models.GameState;
import com.rpham64.android.numberfireproject.models.Player;
import com.rpham64.android.numberfireproject.models.PlayerStat;
import com.rpham64.android.numberfireproject.models.Team;

import java.util.List;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class BasketballDataResponse {

    @SerializedName("Teams")
    public final List<Team> teams;

    @SerializedName("Players")
    public final List<Player> players;

    @SerializedName("Games")
    public final List<Game> games;

    @SerializedName("Player Stats")
    public final List<PlayerStat> playerStats;

    @SerializedName("Game State")
    public final List<GameState> gameStates;

    public BasketballDataResponse(List<Team> teams, List<Player> players, List<Game> games, List<PlayerStat> playerStats, List<GameState> gameStates) {
        this.teams = teams;
        this.players = players;
        this.games = games;
        this.playerStats = playerStats;
        this.gameStates = gameStates;
    }
}
