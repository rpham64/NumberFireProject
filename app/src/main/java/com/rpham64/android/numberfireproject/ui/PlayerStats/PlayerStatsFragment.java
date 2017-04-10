package com.rpham64.android.numberfireproject.ui.PlayerStats;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class PlayerStatsFragment extends Fragment {

    public static PlayerStatsFragment newInstance() {

        Bundle args = new Bundle();

        PlayerStatsFragment fragment = new PlayerStatsFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
