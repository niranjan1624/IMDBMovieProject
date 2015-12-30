package in.movies.niranjan.com.movieproj.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 12/30/2015.
 */
public class Video {

    @SerializedName("id")
    public String videoId;

    @SerializedName("iso_639_1")
    public String iso_639_1;

    @SerializedName("key")
    public String key;

    @SerializedName("name")
    public String name;

    @SerializedName("site")
    public String site;

    @SerializedName("size")
    public int size;

    @SerializedName("type")
    public String type;

}
