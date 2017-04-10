package com.rpham64.android.numberfireproject.ui.PlayerStats;

import android.content.Context;

import com.rpham64.android.numberfireproject.models.Player;
import com.rpham64.android.numberfireproject.models.PlayerStat;
import com.rpham64.android.numberfireproject.network.BasketballDataResponse;
import com.rpham64.android.numberfireproject.utils.BasePresenter;
import com.rpham64.android.numberfireproject.utils.JsonUtils;

import java.util.List;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class PlayerStatsPresenter extends BasePresenter<PlayerStatsPresenter.View> {

    public static final String TAG = PlayerStatsPresenter.class.getName();

    private Context mContext;

    public PlayerStatsPresenter(Context context) {
        mContext = context;
    }

    public void fetch() {

        BasketballDataResponse response = JsonUtils.getBasketballDataResponse(mContext);

        getView().getPlayers(response.players);
        getView().getPlayerStats(response.playerStats);
    }

    public interface View {
        void getPlayers(List<Player> players);
        void getPlayerStats(List<PlayerStat> playerStats);
    }
}
