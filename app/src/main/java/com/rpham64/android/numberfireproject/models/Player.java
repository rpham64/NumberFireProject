package com.rpham64.android.numberfireproject.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class Player {

    public final int id;

    public final String name;

    @SerializedName("team_id")
    public final int teamId;

    public Player(int id, String name, int teamId) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
    }
}
