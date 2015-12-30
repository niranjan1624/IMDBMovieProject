package in.movies.niranjan.com.movieproj.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 12/30/2015.
 */
public class Cast {

    @SerializedName("cast_id")
    public int castId;

    @SerializedName("character")
    public String character;

    @SerializedName("credit_id")
    public String creditId;

    @SerializedName("id")
    public int movieId;

    @SerializedName("name")
    public String actorName;

    @SerializedName("order")
    public int popularity;

    @SerializedName("profile_path")
    public String profilePath;
}
