package com.jsfood;

import com.jsfood.database.RestaurantDB;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreenActivity extends Activity {
	// Splash screen timer
	private RestaurantDB restaurantDB  = null;
	private SQLiteDatabase db          = null;
	// Splash screen timer
	private static int SPLASH_TIME_OUT = 3000;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        
        new MyFetchTask().execute();
    }
    
    public class MyFetchTask extends AsyncTask<Void, Void, Void> {
	    @Override
	    protected void onPreExecute() {
	        super.onPreExecute();
	    }

	    @Override
	    protected Void doInBackground(Void... params) {
	    	restaurantDB = new RestaurantDB(getApplicationContext());
			db 			 = restaurantDB.getWritableDatabase();
			restaurantDB.createTable(db, getBaseContext());
			restaurantDB.generateData(db);
			
	        return null;
	    }

	    @Override
	    protected void onPostExecute(Void result) {
	        super.onPostExecute(result);
	        
	        new Handler().postDelayed(new Runnable() {
				/*
				 * Showing splash screen with a timer. This will be useful when you
				 * want to show case your app logo / company
				 */
				@Override
				public void run() {
					// This method will be executed once the timer is over
					// Start your app main activity
					startActivity( new Intent( getApplicationContext(), MainActivity.class ) );
		    		overridePendingTransition( R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_top );

					// close this activity
					finish();
				}
			}, SPLASH_TIME_OUT);
	    }
	}
}
