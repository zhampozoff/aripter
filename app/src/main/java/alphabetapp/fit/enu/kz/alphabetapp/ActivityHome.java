package alphabetapp.fit.enu.kz.alphabetapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityHome extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnstudy, btntest, btnsetting;
        btnstudy = (Button) findViewById(R.id.btnstudy);
        btnstudy.setOnClickListener(this);
        btntest = (Button) findViewById(R.id.btntest);
        btntest.setOnClickListener(this);
        btnsetting = (Button) findViewById(R.id.btnsetting);
        btnsetting.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ActivityHome.this, About.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent myIntent;
        switch (view.getId()){
            case R.id.btnstudy:
                myIntent = new Intent(ActivityHome.this, MainActivity.class);
                startActivity(myIntent);
                break;

            case R.id.btntest:
                myIntent = new Intent(ActivityHome.this, ActivityTest.class);
                startActivity(myIntent);
                break;

            case R.id.btnsetting:
                myIntent = new Intent(ActivityHome.this, ActivitySettings.class);
                startActivity(myIntent);
                break;

                default: break;
        }
    }

    public void createNotification(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
