package alphabetapp.fit.enu.kz.alphabetapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTest extends AppCompatActivity {

    QuestionLibrary mQuestionLib = new QuestionLibrary();

    private TextView mScoreView, mQuestionView;
    private Button mChoice1, mChoice2, mChoice3, mChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    String textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Bundle extras = getIntent().getExtras();
        mScoreView = findViewById(R.id.text_score);
        mQuestionView = findViewById(R.id.text_question);
        mChoice1 = findViewById(R.id.choice1);
        mChoice2 = findViewById(R.id.choice2);
        mChoice3 = findViewById(R.id.choice3);
        mChoice4 = findViewById(R.id.choice4);
        if (extras != null) {
            textColor = getIntent().getStringExtra(MainActivity.textColor);
            if (textColor == null){
                textColor = "Қара";
            }
            if (textColor.equals("Қара")){
                mQuestionView.setTextColor(Color.BLACK);
                mChoice1.setTextColor(Color.BLACK);
                mChoice2.setTextColor(Color.BLACK);
                mChoice3.setTextColor(Color.BLACK);
                mChoice4.setTextColor(Color.BLACK);
            } else if (textColor.equals("Көк")){
                mQuestionView.setTextColor(Color.BLUE);
                mChoice1.setTextColor(Color.BLUE);
                mChoice2.setTextColor(Color.BLUE);
                mChoice3.setTextColor(Color.BLUE);
                mChoice4.setTextColor(Color.BLUE);
            }else if (textColor.equals("Қызыл")){
                mQuestionView.setTextColor(Color.RED);
                mChoice1.setTextColor(Color.RED);
                mChoice2.setTextColor(Color.RED);
                mChoice3.setTextColor(Color.RED);
                mChoice4.setTextColor(Color.RED);
            }else if (textColor.equals("Жасыл")){
                mQuestionView.setTextColor(Color.GREEN);
                mChoice1.setTextColor(Color.GREEN);
                mChoice2.setTextColor(Color.GREEN);
                mChoice3.setTextColor(Color.GREEN);
                mChoice4.setTextColor(Color.GREEN);
            }
        }
        updateQuestion();
        updateScore(mScore);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.choice1:
                        if (mQuestionNumber < mQuestionLib.getLength()){
                            if (mChoice1.getText() == mAnswer){
                                mScore = mScore + 1;
                                updateScore(mScore);
                                updateQuestion();
                            } else {
                                updateQuestion();
                            }
                        }
                        break;
                    case R.id.choice2:
                        if (mChoice2.getText() == mAnswer){
                            mScore = mScore + 1;
                            updateScore(mScore);
                            updateQuestion();
                        } else {
                            updateQuestion();
                        }
                        break;
                    case R.id.choice3:
                        if (mChoice3.getText() == mAnswer){
                            mScore = mScore + 1;
                            updateScore(mScore);
                            updateQuestion();
                        } else {
                            updateQuestion();
                        }
                        break;
                    case R.id.choice4:
                        if (mChoice4.getText() == mAnswer){
                            mScore = mScore + 1;
                            updateScore(mScore);
                            updateQuestion();
                        } else {
                            updateQuestion();
                        }
                        break;

                }
            }
        };
        mChoice1.setOnClickListener(onClickListener);
        mChoice2.setOnClickListener(onClickListener);
        mChoice3.setOnClickListener(onClickListener);
        mChoice4.setOnClickListener(onClickListener);
    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLib.getLength()){
            mQuestionView.setText(mQuestionLib.getQuestion(mQuestionNumber));
            mChoice1.setText(mQuestionLib.getChoice(mQuestionNumber, 1));
            mChoice2.setText(mQuestionLib.getChoice(mQuestionNumber, 2));
            mChoice3.setText(mQuestionLib.getChoice(mQuestionNumber, 3));
            mChoice4.setText(mQuestionLib.getChoice(mQuestionNumber, 4));

            mAnswer = mQuestionLib.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else  {
            Toast.makeText(this, "Бұл соңғы сұрақ болатын", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ActivityScore.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore(int mScore) {
        mScoreView.setText("" + mScore + "/" + mQuestionLib.getLength());
    }
}
