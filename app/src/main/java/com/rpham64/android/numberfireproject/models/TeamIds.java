package com.rpham64.android.numberfireproject.models;

import java.util.List;

/**
 * Given a Game Id, returns the id's for the home and away teams.
 *
 * Created by Rudolf on 4/10/2017.
 */

public class TeamIds {

    private List<Game> mGames;
    private int mGameId;
    private int mHomeTeamId;
    private int mAwayTeamId;

    public TeamIds(List<Game> games, int gameId) {
        mGames = games;
        mGameId = gameId;
    }

    public int getHomeTeamId() {
        return mHomeTeamId;
    }

    public int getAwayTeamId() {
        return mAwayTeamId;
    }

    public TeamIds invoke() {
        for (Game game : mGames) {
            if (game.id == mGameId) {
                mHomeTeamId = game.homeTeamId;
                mAwayTeamId = game.awayTeamId;
            }
        }
        return this;
    }
}
