package in.movies.niranjan.com.movieproj.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import in.movies.niranjan.com.movieproj.BaseActivity;
import in.movies.niranjan.com.movieproj.R;
import in.movies.niranjan.com.movieproj.api.MovieProjApi;
import in.movies.niranjan.com.movieproj.api.data.ImagePosterResponse;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        test();
    }

    private void test() {

        MovieProjApi.getService().getImagesAndPostersByMovieId(157336).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ImagePosterResponse>() {
                    @Override
                    public void call(ImagePosterResponse imagePosterResponse) {
                        hideProgressBar();
                        Log.d("DEBUG_1", imagePosterResponse.backDrops + "");
                    }
                }, errorHandler);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
