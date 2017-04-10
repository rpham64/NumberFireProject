package com.rpham64.android.numberfireproject.ui.GamesState;

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
import com.rpham64.android.numberfireproject.models.Game;
import com.rpham64.android.numberfireproject.models.GameState;
import com.rpham64.android.numberfireproject.models.Team;
import com.rpham64.android.numberfireproject.ui.adapters.GamesStateAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class GamesStateFragment extends Fragment implements GamesStatePresenter.View {

    public static final String TAG = GamesStateFragment.class.getName();

    @BindView(R.id.recycler_view_games_state) RecyclerView recyclerView;

    private Unbinder mUnbinder;
    private GamesStatePresenter mPresenter;
    private GamesStateAdapter mAdapter;

    public static GamesStateFragment newInstance() {
        return new GamesStateFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GamesStatePresenter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games_state, container, false);
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
    public void getGamesInfo(List<Team> teams, List<Game> games, List<GameState> states) {
        mAdapter = new GamesStateAdapter(getContext(), teams, games, states);
        recyclerView.setAdapter(mAdapter);
    }
}
