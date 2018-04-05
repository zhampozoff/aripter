package alphabetapp.fit.enu.kz.alphabetapp;

/**
 * Created by nurgh on 4/1/2018.
 */

public class QuestionLibrary {
    private String mQuestions [] = {
            "which part of the plant?",
            "which part of the plant?",
            "which part of the plant?",
            "which part of the plant?",
            "which part of the plant?",
            "which part of the plant?",
            "which part of the plant?",
            "which part of the plant?"
    };

    private String mChoices [][] = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
    };

    public int getLength(){
        return mQuestions.length;
    }

    private String mCorrectAnswers[] = {"1", "2", "3", "4", "1", "2", "3", "4"};

    public String getQuestion (int a){
        String question;
        if (!mQuestions[a].isEmpty() && mQuestions[a] != null){
            question = mQuestions[a];
        } else{
            question = "";
        }
        return question;
    }

    public String getChoice (int index, int num){
        String choice = mChoices[index][num-1];
        return choice;
    }

    public String getCorrectAnswer (int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
