package com.rpham64.android.numberfireproject.models;

import java.util.List;

/**
 * Given a list of Team and id's for home team and away team,
 * returns the respective home and away teams.
 *
 * Created by Rudolf on 4/10/2017.
 */

public class Teams {

    private List<Team> mTeams;
    private int mHomeTeamId;
    private int mAwayTeamId;
    private Team mHomeTeam;
    private Team mAwayTeam;

    public Teams(List<Team> teams, int homeTeamId, int awayTeamId) {
        mTeams = teams;
        mHomeTeamId = homeTeamId;
        mAwayTeamId = awayTeamId;
    }

    public Team getHomeTeam() {
        return mHomeTeam;
    }

    public Team getAwayTeam() {
        return mAwayTeam;
    }

    public Teams invoke() {

        for (Team team : mTeams) {
            if (team.id == mHomeTeamId) {
                mHomeTeam = team;
            }
            if (team.id == mAwayTeamId) {
                mAwayTeam = team;
            }
        }

        return this;
    }
}
