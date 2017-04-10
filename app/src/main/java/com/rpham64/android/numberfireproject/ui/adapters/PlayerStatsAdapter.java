package com.rpham64.android.numberfireproject.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rpham64.android.numberfireproject.R;
import com.rpham64.android.numberfireproject.models.Player;
import com.rpham64.android.numberfireproject.models.PlayerStat;
import com.rpham64.android.numberfireproject.models.Team;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rudolf on 4/10/2017.
 */

public class PlayerStatsAdapter extends RecyclerView.Adapter<PlayerStatsAdapter.PlayerStatsViewHolder> {

    private Context mContext;

    private List<Team> mTeams;
    private List<Player> mPlayers;
    private List<PlayerStat> mPlayerStats;

    public PlayerStatsAdapter(Context context, List<Team> teams, List<Player> players, List<PlayerStat> playerStats) {
        mContext = context;
        mTeams = teams;
        mPlayers = players;
        mPlayerStats = playerStats;
    }

    @Override
    public PlayerStatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.vholder_player_stats, parent, false);
        return new PlayerStatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayerStatsViewHolder holder, int position) {

        // Player Stats => Get player_id, team_id, points, assists, rebounds, nerd
        PlayerStat stats = mPlayerStats.get(position);

        // Player => Use player_id to get name and team_id
        Player player = getPlayer(stats.playerId);
        String name = player.name;

        // Team => Use team_id to get abbrev
        int teamId = player.teamId;
        String teamAbbrev = getTeamAbbreviation(teamId);

        holder.bindViewHolder(name, teamAbbrev, stats);
    }

    private Player getPlayer(int playerId) {
        for (Player player : mPlayers) {
            if (player.id == playerId) {
                return player;
            }
        }
        return null;
    }

    private String getTeamAbbreviation(int teamId) {

        for (Team team : mTeams) {
            if (team.id == teamId) {
                return team.abbreviation;
            }
        }

        return null;
    }

    @Override
    public int getItemCount() {
        if (mPlayerStats != null) return mPlayerStats.size();
        return 0;
    }

    public class PlayerStatsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_player_name_and_team_abbrev) TextView textPlayerNameAndTeamAbbrev;
        @BindView(R.id.text_points_assists_rebounds) TextView textPointsAssistsRebounds;
        @BindView(R.id.text_nerd_value) TextView textNerdValue;

        public PlayerStatsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindViewHolder(String playerName, String teamAbbrev, PlayerStat playerStat) {

            // Name and Team Abbreviation
            String nameAndTeam = playerName + " - " + teamAbbrev;
            textPlayerNameAndTeamAbbrev.setText(nameAndTeam);

            // Points, Assists, Rebounds
            int pointsValue = playerStat.points;
            int assistsValue = playerStat.assists;
            int reboundsValue = playerStat.rebounds;

            StringBuilder builder = new StringBuilder();
            builder.append(pointsValue).append(" Pts, ")
                    .append(assistsValue).append(" Ast, ")
                    .append(reboundsValue).append(" Reb");

            textPointsAssistsRebounds.setText(builder.toString());

            // nERD
            textNerdValue.setText(String.valueOf(playerStat.nerd));
        }
    }
}
