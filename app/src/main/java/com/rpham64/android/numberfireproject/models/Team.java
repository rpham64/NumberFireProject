package com.rpham64.android.numberfireproject.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class Team {

    public final int id;

    public final String name;

    public final String city;

    @SerializedName("full_name")
    public final String fullName;

    @SerializedName("abbrev")
    public final String abbreviation;

    public Team(int id, String name, String city, String fullName, String abbreviation) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.fullName = fullName;
        this.abbreviation = abbreviation;
    }
}
