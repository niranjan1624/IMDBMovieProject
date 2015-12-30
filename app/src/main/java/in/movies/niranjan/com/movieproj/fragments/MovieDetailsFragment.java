package in.movies.niranjan.com.movieproj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.movies.niranjan.com.movieproj.BaseFragment;
import in.movies.niranjan.com.movieproj.R;
import in.movies.niranjan.com.movieproj.api.MovieProjApi;
import in.movies.niranjan.com.movieproj.models.Movie;
import in.movies.niranjan.com.movieproj.models.MovieDetail;
import in.movies.niranjan.com.movieproj.utils.AppConstants;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Niranjan on 12/30/2015.
 */
public class MovieDetailsFragment extends BaseFragment {
    private int movieId;
    ImageView moviePoster, myFavorite, myWatchlist;
    TextView title, tagLine, releaseDate, budget, revenue, status, voteAverage, voteCount, overView;
    RatingBar ratingBar;
    Movie movie;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieId = getArguments().getInt(AppConstants.MOVIE_ID);
        init();
        fetchMovieDetails();

    }

    private void init() {
        View view = getView();
        title = (TextView) view.findViewById(R.id.title);
        tagLine = (TextView) view.findViewById(R.id.tag_line);
        releaseDate = (TextView) view.findViewById(R.id.release_date);
        budget = (TextView) view.findViewById(R.id.budget);
        revenue = (TextView) view.findViewById(R.id.revenue);
        status = (TextView) view.findViewById(R.id.status);
        voteAverage = (TextView) view.findViewById(R.id.vote_average);
        voteCount = (TextView) view.findViewById(R.id.vote_num);
        overView = (TextView) view.findViewById(R.id.over_view);

        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        moviePoster = (ImageView) view.findViewById(R.id.movie_poster);
        myFavorite = (ImageView) view.findViewById(R.id.favorite);
        myWatchlist = (ImageView) view.findViewById(R.id.watch_list);

    }

    private void fetchMovieDetails() {
            showProgressBarWithBackground();

            MovieProjApi.getService().getMovieDetailsById(movieId).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<MovieDetail>() {
                        @Override
                        public void call(MovieDetail movieDetail) {
                            hideProgressBar();
                            updateContent(movieDetail);
                        }
                    }, errorHandler);

    }

    private void updateContent(final MovieDetail movieDetail) {
        title.setText(movieDetail.title);
        tagLine.setText(movieDetail.tagLine);
        releaseDate.setText(movieDetail.releaseDate);
        budget.setText("Revenue : " + movieDetail.budget);
        revenue.setText("Budget : " + movieDetail.revenue);
        status.setText("Status : " + movieDetail.status);
        overView.setText(movieDetail.overview);
        voteAverage.setText(" (" + movieDetail.voteAverage + "/10) ");
        voteCount.setText(movieDetail.voteCount + " users");
        Picasso.with(getActivity()).load(AppConstants.IMAGE_BASE_URL + movieDetail.posterPath).into(moviePoster);
        ratingBar.setRating(movieDetail.popularity);
        movie = getMovieByIdFromDB(movieDetail.movieId);
        if(movie == null)
            movie = new Movie(movieDetail.movieId, movieDetail.popularity, movieDetail.posterPath,
                movieDetail.releaseDate,movieDetail.title, movieDetail.voteAverage,
                movieDetail.voteCount, movieDetail.backdropPath, false, false);

        myFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMyFavorite();
                setMyFavoriteImage(myFavorite);
            }
        });

        myWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMyWatchlist();
                setMyWatchlistImage(myWatchlist);
            }
        });

        setMyWatchlistImage(myWatchlist);
        setMyFavoriteImage(myFavorite);

    }

    public void setMyFavoriteImage(ImageView myFavorite) {
        if(movie.isFavorite)
            Picasso.with(getActivity()).load(R.mipmap.favorite_enable_normal).into(myFavorite);
        else
            Picasso.with(getActivity()).load(R.mipmap.favorite_disable_normal).into(myFavorite);
    }

    public void setMyWatchlistImage(ImageView myWatchlist) {
        if(movie.isWatchlist)
            Picasso.with(getActivity()).load(R.mipmap.watchlist_enable_normal).into(myWatchlist);
        else
            Picasso.with(getActivity()).load(R.mipmap.watchlist_disable_normal).into(myWatchlist);
    }

    public void setMyFavorite() {
        if(movie != null) {
            movie.isFavorite = !movie.isFavorite;
            movie.save();
        }
    }
    public void setMyWatchlist() {
        if(movie != null) {
            movie.isWatchlist = !movie.isWatchlist;
            movie.save();
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_movie_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Show from database
        switch (item.getItemId()) {
            case R.id.my_favorite:

                break;
            case R.id.my_watch:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
