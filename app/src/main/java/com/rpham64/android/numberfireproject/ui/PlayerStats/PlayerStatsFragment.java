package com.rpham64.android.numberfireproject.ui.PlayerStats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpham64.android.numberfireproject.R;
import com.rpham64.android.numberfireproject.models.Player;
import com.rpham64.android.numberfireproject.models.PlayerStat;
import com.rpham64.android.numberfireproject.models.Team;
import com.rpham64.android.numberfireproject.ui.adapters.PlayerStatsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class PlayerStatsFragment extends Fragment implements PlayerStatsPresenter.View {

    public static final String TAG = PlayerStatsFragment.class.getName();

    @BindView(R.id.recycler_view_player_stats) RecyclerView recyclerView;

    private Unbinder mUnbinder;
    private PlayerStatsPresenter mPresenter;
    private PlayerStatsAdapter mAdapter;

    public static PlayerStatsFragment newInstance() {
        return new PlayerStatsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PlayerStatsPresenter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_stats, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mPresenter.attachView(this);
        mPresenter.fetch();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void getStatsInfo(List<Team> teams, List<Player> players, List<PlayerStat> playerStats) {
        mAdapter = new PlayerStatsAdapter(getContext(), teams, players, playerStats);
        recyclerView.setAdapter(mAdapter);
    }
}
