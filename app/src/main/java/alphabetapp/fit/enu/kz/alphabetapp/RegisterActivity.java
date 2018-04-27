package alphabetapp.fit.enu.kz.alphabetapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button = (Button) findViewById(R.id.register);
        button.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.editText);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.register){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            String nick = editText.getText().toString();
            if(nick != null && !nick.isEmpty()){
                editor.putString("nickname", null);
                editor.commit();
                Intent myIntent = new Intent(RegisterActivity.this, ActivityHome.class);
                startActivity(myIntent);
                finish();
            }
        }
    }
}
