package com.rpham64.android.numberfireproject.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rpham64.android.numberfireproject.R;
import com.rpham64.android.numberfireproject.models.Game;
import com.rpham64.android.numberfireproject.models.GameState;
import com.rpham64.android.numberfireproject.models.Team;
import com.rpham64.android.numberfireproject.models.TeamIds;
import com.rpham64.android.numberfireproject.models.Teams;
import com.rpham64.android.numberfireproject.utils.ButterKnifeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class GamesStateAdapter extends RecyclerView.Adapter<GamesStateAdapter.GamesStateViewHolder> {

    public static final String TAG = GamesStateAdapter.class.getName();

    private Context mContext;

    private List<Team> mTeams;
    private List<Game> mGames;
    private List<GameState> mStates;

    public GamesStateAdapter(Context context, List<Team> teams, List<Game> games, List<GameState> states) {
        mContext = context;
        mTeams = teams;
        mGames = games;
        mStates = states;
    }

    @Override
    public GamesStateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.vholder_games_state, parent, false);
        return new GamesStateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GamesStateViewHolder holder, int position) {

        // Game State => Get "game_id"
        GameState currentState = mStates.get(position);
        int gameId = currentState.gameId;

        // Games => Get "home_team_id" and "away_team_id"
        TeamIds teamIds = new TeamIds(mGames, gameId).invoke();
        int homeTeamId = teamIds.getHomeTeamId();
        int awayTeamId = teamIds.getAwayTeamId();

        // Teams => Get teams with respective ids
        Teams teams = new Teams(mTeams, homeTeamId, awayTeamId).invoke();
        Team homeTeam = teams.getHomeTeam();
        Team awayTeam = teams.getAwayTeam();

        holder.bindViewHolder(homeTeam, awayTeam, currentState);
    }

    @Override
    public int getItemCount() {
        if (mStates != null) return mStates.size();
        return 0;
    }

    public class GamesStateViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_home_team_name) TextView textHomeTeamName;
        @BindView(R.id.text_home_team_score) TextView textHomeTeamScore;
        @BindView(R.id.text_away_team_name) TextView textAwayTeamName;
        @BindView(R.id.text_away_team_score) TextView textAwayTeamScore;
        @BindView(R.id.layout_game_state_info) RelativeLayout layoutGameStateInfo;
        @BindView(R.id.text_final) TextView textFinal;
        @BindView(R.id.text_quarter_and_time_left) TextView textQuarterAndTimeLeft;
        @BindView(R.id.text_broadcast_provider) TextView textBroadcastProvider;

        @BindViews({R.id.text_quarter_and_time_left, R.id.text_broadcast_provider})
        List<TextView> viewsInProgress;

        public GamesStateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        /**
         * Teams: name (2)
         * Game State: home_team_score, away_team_score, broadcast, quarter, time_left_in_quarter, game_status
         *
         * @param homeTeam
         * @param awayTeam
         * @param state
         */
        public void bindViewHolder(@NonNull Team homeTeam, @NonNull Team awayTeam, @NonNull GameState state) {

            // Home Team Info
            textHomeTeamName.setText(homeTeam.name);
            textHomeTeamScore.setText(String.valueOf(state.homeTeamScore));

            // Away Team Info
            textAwayTeamName.setText(awayTeam.name);
            textAwayTeamScore.setText(String.valueOf(state.awayTeamScore));

            // Game State Info
            switch (state.status) {

                case GameState.STATUS_IN_PROGRESS:

                    // Display IN-PROGRESS info
                    textFinal.setVisibility(View.GONE);
                    ButterKnife.apply(viewsInProgress, ButterKnifeUtils.VISIBLE);

                    String quarter = "Q" + state.quarter;
                    String timeLeft = state.timeLeft;

                    textQuarterAndTimeLeft.setText(quarter + " " + timeLeft);
                    textBroadcastProvider.setText(state.broadcast);

                    break;

                case GameState.STATUS_FINAL:

                    // Display FINAL
                    textFinal.setVisibility(View.VISIBLE);
                    ButterKnife.apply(viewsInProgress, ButterKnifeUtils.GONE);

                    break;

            }
        }
    }
}
