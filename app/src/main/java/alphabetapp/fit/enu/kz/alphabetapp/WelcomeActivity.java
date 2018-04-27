package alphabetapp.fit.enu.kz.alphabetapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final String nickname = prefs.getString("nickname", null);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent myIntent;
                if(nickname != null){
                    myIntent = new Intent(WelcomeActivity.this, ActivityHome.class);
                } else{
                    myIntent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                }
                startActivity(myIntent);
                finish();
            }
        }, 3000);
    }
}
