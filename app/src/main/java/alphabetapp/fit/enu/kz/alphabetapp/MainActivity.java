package alphabetapp.fit.enu.kz.alphabetapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String alphabet [] = {"A - А", "A' - Ә", "B - Б", "D - Д", "E - Е", "F - Ф", "G - Г", "G' - Ғ", "H - Х, Һ", "I - І", "I' - И, Й", "J - Ж", "K - К", "L - Л", "M - М", "N - Н", "N' - Ң",
                                              "O - О", "O' - Ө", "P - П", "Q - Қ", "R - Р", "S - С", "S' - Ш", "C' - Ч", "T - Т", "U - Ұ", "U' - Ү", "V - В", "Y - Ы", "Y' - У", "Z - З"};

    public static final String words[] = {"A - Alma", "A' - A'ke", "B - Bala", "D - Day'ys", "E - Ertegi", "F - Format", "G - Gu'l", "G' - G'asyr", "H - Hat", "I - Ine", "I' - I'od", "J - Jolbarys", "K - Kitap",
                                          "L - Las'yk", "M - Mons'aq", "N - Nemere", "N' - Tan'", "O - Oqtay'", "O' - O'mir", "P - Parasat", "Q - Qala", "R - Respubli'ka", "S - Sezim", "S' - S'ana", "C' - C'emodan", "T - Tasbaqa", "U - Ulys", "U' - U'mit", "V - Vagon", "Y - Yrys", "Y' - Y'yldyryq", "Z - Zebra" };

   public TextView textView, textViewWords;
   Button btnNext, btnLast;
   int index = 0;
   int intSize;
   String size;
   public static String textColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView);
        textViewWords = (TextView) findViewById(R.id.textViewWords);
        textView.setText(alphabet[0]);
        textViewWords.setText(words[0]);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnLast = (Button) findViewById(R.id.btnLast);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            size = getIntent().getStringExtra(ActivitySettings.PROGRESS);
            textColor = getIntent().getStringExtra(ActivitySettings.COLOR);
            intSize = Integer.parseInt(size);
            textViewWords.setTextSize(intSize);
            if (textColor.equals("Қара")){
                textViewWords.setTextColor(Color.BLACK);
            } else if (textColor.equals("Көк")){
                textViewWords.setTextColor(Color.BLUE);
            }else if (textColor.equals("Қызыл")){
                textViewWords.setTextColor(Color.RED);
            }else if (textColor.equals("Жасыл")){
                textViewWords.setTextColor(Color.GREEN);
            }
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index >= alphabet.length - 1) {
                    index =alphabet.length - 1;
                } else {
                    index++;
                }
                textView.setText(alphabet[index]);
                textViewWords.setText(words[index]);
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0){
                    index--;
                    textView.setText(alphabet[index]);
                    textViewWords.setText(words[index]);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                startActivity(new Intent(getApplicationContext(), ActivitySettings.class));
                break;
            case R.id.action_test:
                Intent intent = new Intent(getApplicationContext(), ActivityTest.class);
                intent.putExtra(textColor, textColor);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
