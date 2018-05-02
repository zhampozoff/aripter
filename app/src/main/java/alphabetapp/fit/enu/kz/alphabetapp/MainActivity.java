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
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String alphabet [] = {"A - А", "A' - Ә", "B - Б", "D - Д", "E - Е", "F - Ф", "G - Г", "G' - Ғ", "H - Х, Һ", "I - І", "I' - И, Й", "J - Ж", "K - К", "L - Л", "M - М", "N - Н", "N' - Ң",
                                              "O - О", "O' - Ө", "P - П", "Q - Қ", "R - Р", "S - С", "S' - Ш", "C' - Ч", "T - Т", "U - Ұ", "U' - Ү", "V - В", "Y - Ы", "Y' - У", "Z - З"};

    public static final String words[] = {"A - Alma", "A' - A'ke", "B - Bala", "D - Day'ys", "E - Ertegi", "F - Futbol", "G - Gu'l", "G' - G'asyr", "H - Hat", "I - Ine", "I' - I'od", "J - Jolbarys", "K - Kitap",
                                          "L - Las'yk", "M - Mons'aq", "N - Nemere", "N' - Tan'", "O - Oqtay'", "O' - O'mir", "P - Parasat", "Q - Qala", "R - Respubli'ka", "S - Sezim", "S' - S'ana", "C' - C'emodan", "T - Tasbaqa", "U - Ulys", "U' - U'mit", "V - Vagon", "Y - Yrys", "Y' - Y'yldyryq", "Z - Zebra" };

    public static final int images[] = {R.drawable.l1, R.drawable.l2, R.drawable.l3, R.drawable.l4, R.drawable.l5, R.drawable.l6,
            R.drawable.l7, R.drawable.l8, R.drawable.l9, R.drawable.l10, R.drawable.l11, R.drawable.l12, R.drawable.l13,
            R.drawable.l14, R.drawable.l15, R.drawable.l16, R.drawable.l17, R.drawable.l18, R.drawable.l19, R.drawable.l20,
            R.drawable.l21, R.drawable.l22, R.drawable.l23, R.drawable.l24, R.drawable.l25, R.drawable.l26, R.drawable.l26, R.drawable.l26, R.drawable.l2, R.drawable.l2, R.drawable.l2, R.drawable.l2, R.drawable.l2, };

   public TextView textView, textViewWords;
   Button btnNext, btnLast;
   ImageView alphabetImageView;
   int index = 0;
   int intSize;
   String size;
   public static String textColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alphabetImageView = (ImageView) findViewById(R.id.alphabetImageView);
        alphabetImageView.setImageResource(R.drawable.l1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
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
                alphabetImageView.setImageResource(images[index]);
                textViewWords.setText(words[index]);
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0){
                    index--;
                    textView.setText(alphabet[index]);
                    alphabetImageView.setImageResource(images[index]);
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
