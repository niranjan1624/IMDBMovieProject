package in.movies.niranjan.com.movieproj.models;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Niranjan on 12/30/2015.
 */
public class MovieDetail {

    @SerializedName("adult")
    public boolean isAdult;

    @SerializedName("backdrop_path")
    public String backdropPath;

    @SerializedName("belongs_to_collection")
    public BelongsToCollection belongsToCollection;

    @SerializedName("budget")
    public BigInteger budget;

    @SerializedName("genres")
    public List<Genre> genres;

    @SerializedName("homepage")
    public String homePage;

    @SerializedName("id")
    public int movieId;

    @SerializedName("imdb_id")
    public String imdbId;

    @SerializedName("original_language")
    public String originalLanguage;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("overview")
    public String overview;

    @SerializedName("popularity")
    public float popularity;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("production_companies")
    public List<ProductionCompany> productionCompanies;

    @SerializedName("production_countries")
    public List<ProductionCountry> productionCountries;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("revenue")
    public BigInteger revenue;

    @SerializedName("runtime")
    public BigInteger runTime;

    @SerializedName("spoken_languages")
    public List<SpokenLanguage> spokenLanguages;

    @SerializedName("status")
    public String status;

    @SerializedName("tagline")
    public String tagLine;

    @SerializedName("title")
    public String title;

    @SerializedName("video")
    public boolean isVideoPresent;

    @SerializedName("vote_average")
    public Double voteAverage;

    @SerializedName("vote_count")
    public int voteCount;

    public class BelongsToCollection {
        @SerializedName("id")
        public String belongsToCollectionId;

        @SerializedName("name")
        public String name;

        @SerializedName("poster_path")
        public String posterPath;

        @SerializedName("backdrop_path")
        public String backdropPath;
    }

    public class Genre {
        @SerializedName("id")
        public String genreID;

        @SerializedName("name")
        public String genreName;
    }

    public class ProductionCompany {
        @SerializedName("id")
        public String productionCompanyId;

        @SerializedName("name")
        public String productionCompanyName;
    }

    public class ProductionCountry {
        @SerializedName("iso_3166_1")
        public String iso31661;

        @SerializedName("name")
        public String countryName;
    }

    public class SpokenLanguage {
        @SerializedName("iso_639_1")
        public String iso6391;

        @SerializedName("name")
        public String languageName;
    }
}
