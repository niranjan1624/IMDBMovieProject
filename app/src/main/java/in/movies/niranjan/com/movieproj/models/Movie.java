package in.movies.niranjan.com.movieproj.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Niranjan on 12/30/2015.
 */
public class Movie {

    @SerializedName("adult")
    public boolean isAdult;

    @SerializedName("genre_ids")
    public List<Integer> genreIds;

    @SerializedName("id")
    public int movieId;

    @SerializedName("original_language")
    public String originalLanguage;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("overview")
    public String overview;

    @SerializedName("popularity")
    public Double popularity;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("title")
    public String title;

    @SerializedName("video")
    public boolean isVideoPresent;

    @SerializedName("vote_average")
    public Double voteAverage;

    @SerializedName("vote_count")
    public int voteCount;

    @SerializedName("backdrop_path")
    public String backdropPath;

}
