package com.rpham64.android.numberfireproject.ui.GamesState;

import android.content.Context;

import com.rpham64.android.numberfireproject.models.Game;
import com.rpham64.android.numberfireproject.models.GameState;
import com.rpham64.android.numberfireproject.models.Team;
import com.rpham64.android.numberfireproject.network.BasketballDataResponse;
import com.rpham64.android.numberfireproject.utils.BasePresenter;
import com.rpham64.android.numberfireproject.utils.JsonUtils;

import java.util.List;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class GamesStatePresenter extends BasePresenter<GamesStatePresenter.View> {

    public static final String TAG = GamesStatePresenter.class.getName();

    private Context mContext;

    public GamesStatePresenter(Context context) {
        mContext = context;
    }

    public void fetch() {
        BasketballDataResponse response = JsonUtils.getBasketballDataResponse(mContext);
        getView().getGamesInfo(response.teams, response.games, response.gameStates);
    }

    public interface View {
        void getGamesInfo(List<Team> teams, List<Game> games, List<GameState> states);
    }
}
