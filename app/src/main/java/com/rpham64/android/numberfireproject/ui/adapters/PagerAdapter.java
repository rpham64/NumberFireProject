package com.rpham64.android.numberfireproject.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rpham64.android.numberfireproject.ui.GamesState.GamesStateFragment;
import com.rpham64.android.numberfireproject.ui.PlayerStats.PlayerStatsFragment;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 2;

    private String[] tabTitles = {"Games", "Stats"};

    public interface Pages {
        int GAMES_STATE = 0;
        int PLAYER_STATS = 1;
    }

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case Pages.GAMES_STATE:
                return GamesStateFragment.newInstance();

            case Pages.PLAYER_STATS:
                return PlayerStatsFragment.newInstance();

            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
