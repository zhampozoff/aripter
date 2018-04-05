package alphabetapp.fit.enu.kz.alphabetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivitySettings extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView, progressRate;
    Button saveBtn;
    public static String PROGRESS;
    public static String COLOR;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textViewWords);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        saveBtn = findViewById(R.id.btnSave);
        spinner = findViewById(R.id.spinner);
        progressRate = findViewById(R.id.progressRate);
        progressRate.setText("5");

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Қара");
        spinnerArray.add("Қызыл");
        spinnerArray.add("Жасыл");
        spinnerArray.add("Көк");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySettings.this, MainActivity.class);
                int i = seekBar.getProgress();
                COLOR = sItems.getSelectedItem().toString();
                PROGRESS = String.valueOf(i);
                intent.putExtra(PROGRESS, PROGRESS);
                intent.putExtra(COLOR, COLOR);
                startActivity(intent);
            }
        });
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int i = seekBar.getProgress();
            progressRate.setText(String.valueOf(i));
        }
    };



}
