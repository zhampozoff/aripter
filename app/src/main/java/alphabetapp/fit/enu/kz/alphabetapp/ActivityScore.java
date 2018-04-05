package alphabetapp.fit.enu.kz.alphabetapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityScore extends AppCompatActivity {

    TextView yourScore, highestScore;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        yourScore = findViewById(R.id.yourScore);
        highestScore = findViewById(R.id.highestScore);
        btnOk = findViewById(R.id.buttonOk);

        final Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        yourScore.setText("Сіздің Баллыңыз : " + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highScore", 0);
        if (highScore >= score){
            highestScore.setText("Ең көп балл: " + highScore);
        } else {
            highestScore.setText("Ең көп балл: " + score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highScore", score);
            editor.commit();
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ActivityScore.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
